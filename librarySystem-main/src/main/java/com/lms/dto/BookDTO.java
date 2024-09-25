package com.lms.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookDTO {
	
	private Long id;
    private String title;
    private String author;
    private boolean borrowed;
    
    private String category;


}
