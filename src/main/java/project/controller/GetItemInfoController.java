//https://sundries-in-myidea.tistory.com/71

package project.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class GetItemInfoController {
	
	//proxy fix
	@CrossOrigin(origins="*")
    
	@RequestMapping(method=RequestMethod.POST, path="/getDaangnData")
	public String getDanngnData(@RequestBody String itemName) {
		System.out.println(itemName);
		return "bb";
	}

}