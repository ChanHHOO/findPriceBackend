//https://sundries-in-myidea.tistory.com/71

package project.controller;

import project.vo.*;
import project.service.DaangnService;
import java.util.List;
import java.util.HashMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api")
public class GetItemInfoController {

	@Autowired
	DaangnService daangnService;
	// proxy fix
	@CrossOrigin(origins="*", allowedHeaders = "*")
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST, value="/getDaangnData")
	public List<DaangnVO> daangnRequest(@RequestBody DaangnVO daangnObj){

		List<DaangnVO> testList = daangnService.searchItemPrice();
		return testList;
	}
}