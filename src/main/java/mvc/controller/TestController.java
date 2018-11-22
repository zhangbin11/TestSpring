package mvc.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		System.out.println("???");
		return "hello world";
	}
	
	@RequestMapping("/hellohtml")
	public String hello2() {
		return "hello";
	}
}
