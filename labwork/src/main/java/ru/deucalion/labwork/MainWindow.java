package ru.deucalion.labwork;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MainWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField textField_input;
	private JTextField textField_output;
	private JButton btnCalc;
	private JButton btnCancel;
	
	private Stack<MathExpCommand> commands;

	public MainWindow()
	{
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400, 100);
		
		commands = new Stack<MathExpCommand>();
		
		JPanel container = new JPanel(new GridLayout(3, 2));
		add(container);
		
		
		JLabel nameInputField = new JLabel("Input: ");
		container.add(nameInputField);
		
		textField_input = new JTextField();
		textField_input.setName("textField_input");
		textField_input.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				updateElementsState();				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateElementsState();	
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				updateElementsState();	
			}
		});
		container.add(textField_input);
		
		btnCalc = new JButton("Check");
		btnCalc.setName("btnCalc");
		btnCalc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String arg = textField_input.getText();
				MathExpCommand cmd = new MathExpCommand(arg);
				cmd.execute();
				textField_output.setText(cmd.getResult());
				commands.push(cmd);
				textField_input.setText("");
				updateElementsState();
			}
		});
		
		container.add(btnCalc);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setName("btnCancel");
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(commands.empty())
					return;
				
				MathExpCommand cmd = commands.pop();
				textField_input.setText(cmd.getArgument());
				textField_output.setText(cmd.getResult());
				updateElementsState();
			}
		});
		container.add(btnCancel);
		
		JLabel nameOutputField = new JLabel("Output: ");
		container.add(nameOutputField);
		
		textField_output = new JTextField();
		textField_output.setName("textField_output");
		textField_output.setEditable(false);
		container.add(textField_output);
		
		updateElementsState();
	}
	
	
	private void updateElementsState()
	{
		btnCancel.setEnabled(!commands.isEmpty());
		btnCalc.setEnabled(!textField_input.getText().isBlank());
	}
}
