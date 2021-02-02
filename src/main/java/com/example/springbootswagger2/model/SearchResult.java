package com.example.springbootswagger2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchResult {
	
	private String fileTitle;
	private String fileName;
	private String fileText;
	private String filePath;

}
