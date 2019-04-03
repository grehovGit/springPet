package com.reactive.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Date;

@Data
@RestResource(rel="tacos", path="tacos")
@Document
public class Taco {
    @Id
    private String id;
    private String name;
    private Date createdAt = new Date();
}