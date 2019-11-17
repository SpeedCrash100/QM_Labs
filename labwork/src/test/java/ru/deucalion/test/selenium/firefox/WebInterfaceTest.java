package ru.deucalion.test.selenium.firefox;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Objects;

import ru.deucalion.labwork.App;


/**
 * 
 * @author Deucalion
 *  Testing root page
 */
public class WebInterfaceTest {
	
	WebDriver driver;
	String prefix;
	long timeout;
	
	WebElement textInput;
	WebElement textOutput;
	WebElement cancelBtn;
	WebElement calcBtn;
	
	@Before
	public void setUp() throws FileNotFoundException, IOException
	{
		Properties driverProps = new Properties();
		InputStream inputCfg = App.class.getClassLoader().getResourceAsStream("driverexec.properties");
		driverProps.load(inputCfg);
		
		
		String driverexec = driverProps.getProperty("driverexec");
		String browserexec = driverProps.getProperty("browserexec");
	
		GeckoDriverService serv = new GeckoDriverService.Builder().usingDriverExecutable(new File(driverexec)).build();
		FirefoxOptions opts = new FirefoxOptions();
		opts.setBinary(browserexec);
		
		driver = new FirefoxDriver(serv, opts);
		prefix = "http://localhost:8080/";
		timeout = 5;
		
		
		//Set up elements
		driver.navigate().to(prefix);
		
		textInput = driver.findElement(By.id("textInput"));
		textOutput = driver.findElement(By.id("textOutput"));
		cancelBtn = driver.findElement(By.id("cancelBtn"));
		calcBtn = driver.findElement(By.id("calcBtn"));
	}
	
	@After
	public void tearDown()
	{
		if(!Objects.equal(driver, null))
		{
			driver.close();
			driver = null;
		}
	}
	
	public ExpectedCondition<Boolean> isPageAtBegin()
	{
		return new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d)
			{
				return textInput.getAttribute("value").isEmpty() && textOutput.getAttribute("value").isEmpty() && !calcBtn.isEnabled() && !cancelBtn.isEnabled();
			}
		};
		
		
	}
	
	public ExpectedCondition<Boolean> isOutputChanged(String oldValue)
	{
		return new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d)
			{
				return textOutput.getAttribute("value") != oldValue;
			}
		};
	}
	
	public ExpectedCondition<Boolean> isInputValueHas(WebElement input, String text)
	{
		return new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d)
			{
				String inputText = input.getAttribute("value");
				return inputText.contains(text);
			}
		};
	} 
	
	@Test
	public void CalcProduceAOutput()
	{
		new WebDriverWait(driver, timeout).until(isPageAtBegin());
		
		
		textInput.sendKeys("5+3");
		String oldVal = textOutput.getAttribute("value");
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(calcBtn));
		calcBtn.click();
		
		new WebDriverWait(driver, timeout).until(isOutputChanged(oldVal));
		
		//Reset
		cancelBtn.click();
	}
	
	@Test
	public void CannotCalcWhileInputBlank()
	{
		new WebDriverWait(driver, timeout).until(isPageAtBegin());
		
		textInput.clear();
		//Require disabled calcBtn
		new WebDriverWait(driver, timeout).until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(calcBtn)));
		
		
		textInput.clear();
		textInput.sendKeys("5");
		//Require enabled calcBtn
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(calcBtn));
	}
	
	@Test
	public void CannotCancelIfNoActions()
	{
		new WebDriverWait(driver, timeout).until(isPageAtBegin());
		
		new WebDriverWait(driver, timeout).until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(cancelBtn)));
		
		textInput.sendKeys("5+3");
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(calcBtn));
		calcBtn.click();
		
		
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(cancelBtn));
		cancelBtn.click();
		new WebDriverWait(driver, timeout).until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(cancelBtn)));
	}

	@Test
	public void CancelActuallyRevert()
	{
		new WebDriverWait(driver, timeout).until(isPageAtBegin());
		
		textInput.clear();
		textInput.sendKeys("5+3");
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(calcBtn));
		String oldVal = textOutput.getAttribute("value");
		calcBtn.click();
		new WebDriverWait(driver, timeout).until(isOutputChanged(oldVal));
		
		textInput.clear();
		textInput.sendKeys("5+3)");
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(calcBtn));
		oldVal = textOutput.getAttribute("value");
		calcBtn.click();
		new WebDriverWait(driver, timeout).until(isOutputChanged(oldVal));
		
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(cancelBtn));
		
		cancelBtn.click();
		new WebDriverWait(driver, timeout).until(isInputValueHas(textInput, "5+3)"));
		
		cancelBtn.click();
		new WebDriverWait(driver, timeout).until(isInputValueHas(textInput, "5+3"));
		new WebDriverWait(driver, timeout).until(isInputValueHas(textOutput, "Valid math expression!"));
	}


}
