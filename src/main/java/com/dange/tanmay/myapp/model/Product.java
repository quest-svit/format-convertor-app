package com.dange.tanmay.myapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class Product {

	String id;
	String description;
	String imageUrl;
	double price;
	Author author;
}
