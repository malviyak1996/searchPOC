package com.example.springbootswagger2.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootswagger2.model.SearchResult;
import com.example.springbootswagger2.service.SearchService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value = "Swagger2DemoRestController", description = "REST Apis related to Student Entity!!!!")
@RestController
public class Swagger2DemoRestController {
	
	@Autowired
	private SearchService searchService;

	@ApiOperation(value = "search file system ", response = SearchResult.class, tags = "getStudent")
	@GetMapping(value = "/search/{searchText}")
	public List<SearchResult> searchFile(@PathVariable(value = "searchText") String searchText) {
		
	        return searchService.searchFile(searchText);
	}


}
