package com.example.springbootswagger2.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.example.springbootswagger2.model.SearchResult;
import com.google.common.io.Files;
@Service
public class SearchService {
	@Autowired
	private ResourcePatternResolver resourcePatternResolver;
	
	public List<SearchResult> searchFile(String searchText){
		List<SearchResult> searchResults = new ArrayList<SearchResult>();
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
		    URL url = loader.getResource("docs");
		    String path = url.getPath();
		    File[] files = new File(path).listFiles();
		    for(File fileOj : files) {
		    	String fileName = fileOj.getName();
		    	  Resource resource = new ClassPathResource("docs/"+fileName);
					InputStream input = resource.getInputStream();
					 byte[] bdata = FileCopyUtils.copyToByteArray(input);
			         String data = new String(bdata, StandardCharsets.UTF_8);
			         System.out.println(data);
			         if(data.contains(searchText)) {
			        	 SearchResult searchResult = SearchResult.builder().fileName(fileName).fileTitle("test").fileText(data).filePath(fileOj.getCanonicalPath()).build();
			        	 searchResults.add(searchResult);
			         }
		    }
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return searchResults;
	}

}
