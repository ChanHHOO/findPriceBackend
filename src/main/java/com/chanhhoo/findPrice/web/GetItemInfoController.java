package com.chanhhoo.findprice.web;

import com.chanhhoo.findprice.dto.DaangnDto;
import com.chanhhoo.findprice.dto.DaangnResponseDto;
import com.chanhhoo.findprice.service.DaangnService;
import java.util.List;

import java.io.IOException;

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

	// @Autowired
	// DaangnVO daangnData;
	// // proxy fix
	@CrossOrigin(origins="*", allowedHeaders = "*")
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST, value="/updateDaangnData")
	public DaangnResponseDto updateDaangnData(@RequestBody DaangnDto daangnDto) throws IOException{
		// requestbody에서 매핑해줌
		return daangnService.updateDaangnSearchedData(daangnDto.getArticle_title(), "null");
	}

	@CrossOrigin(origins="*", allowedHeaders = "*")
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST, value="/getDaangnData")
	public DaangnResponseDto getDaangnData(@RequestBody DaangnDto daangnDto) throws IOException{
		return daangnService.findByTitle(daangnDto.getArticle_title());
	}
}