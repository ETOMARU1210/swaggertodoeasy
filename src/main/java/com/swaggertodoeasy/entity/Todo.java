package com.swaggertodoeasy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Todo {
	private String id;
	private String title;
	private String status;
	private String details;
}
