//https://sundries-in-myidea.tistory.com/71
//https://ohjongsung.io/2020/07/18/spring-boot-with-react-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EB%A7%8C%EB%93%A4%EA%B8%B0
//https://goddaehee.tistory.com/203?category=367461
package project.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.Date;

@RestController
public class TestController {
    
    @RequestMapping("/")
	public String index() {
		return "aa";
	}

    @CrossOrigin(origins="*")
    @RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello() {
		return "안녕하세요. 현재 서버시간은 "+new Date() +"입니다. \n";
	}
}
