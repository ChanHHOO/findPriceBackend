//https://sundries-in-myidea.tistory.com/71

package project.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.Date;

@RestController
public class TestController {

    @CrossOrigin(origins="*")
    @RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello() {
		return "안녕하세요. 현재 서버시간은 "+new Date() +"입니다. \n";
	}
}
