package ru.deucalion.labwork.rest;

import java.util.Stack;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.deucalion.labwork.MathExpCommand;

@RestController
@RequestMapping("/rest")
public class ParseRestController {
	
	Stack<MathExpCommand> oldCommands = new Stack<MathExpCommand>();
	
	public ParseRestController() {
		oldCommands = new Stack<MathExpCommand>();
	}

	@RequestMapping(value = "/calc", method = RequestMethod.PUT)
	public ResponseEntity<Object> parse(@RequestParam(name = "expr", required = true) String inExpr){

		MathExpCommand cmd = new MathExpCommand(inExpr);
		cmd.execute();
		
		oldCommands.push(cmd);

		return new ResponseEntity<Object>(cmd, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cancel", method = RequestMethod.PUT)
	public ResponseEntity<Object> cancel(){
		if(oldCommands.empty())
		{
			MathExpCommand cmd = new MathExpCommand();
			return new ResponseEntity<Object>(cmd, HttpStatus.BAD_REQUEST);
		}
		else
		{
			MathExpCommand cmd = oldCommands.pop();
			return new ResponseEntity<Object>(cmd, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/stack", method = RequestMethod.GET)
	public ResponseEntity<Object> getStackInfo(){
		String out = "{\"size\": " + oldCommands.size() + "}";
		return new ResponseEntity<Object>(out, HttpStatus.OK);
	
	}
}
