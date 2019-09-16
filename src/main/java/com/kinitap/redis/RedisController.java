package com.kinitap.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kinitap.redis.service.ProductService;

@RestController
@RequestMapping("/cache")
public class RedisController {
	@Autowired
	ProductService service;
	
	@GetMapping("/test")
	public String testURL() {
		return "All Good !!";
	}
	
	@GetMapping("/populateCache")
	public String populateCache() throws Exception {
		service.cacheProductDetails(true);
		return "Successfully inserted in Cache";
	}

}
