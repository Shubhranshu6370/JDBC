package com.jdbc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//DTO
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

	//define the properties like id,name,email as private
	private String id;
	private String name;
	private String email;
	
}
