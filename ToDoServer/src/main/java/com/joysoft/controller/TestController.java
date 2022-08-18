package com.joysoft.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joysoft.service.ToDoService;

@RestController
//@RequestMapping("todo")
public class TestController {
	@Autowired
	private ToDoService service;

	@GetMapping("/")
	public List<Map> 
	
		returnMap(){
		
		Map<String, Object> map1 = new HashMap<>();
		map1.put("name", "joy");
		map1.put("age", "34");
		
		Map<String, Object> map2 = new HashMap<>();
		map2.put("name", "lucky");
		map2.put("age", "35");
		
		List<Map> list=new ArrayList<>();
		list.add(map1);
		list.add(map2);
		
		return list;
	}
	
	
}



























