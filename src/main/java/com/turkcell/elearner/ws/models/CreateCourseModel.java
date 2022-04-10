package com.turkcell.elearner.ws.models;

import lombok.Data;

@Data
public class CreateCourseModel {

    private String courseName;
    private double price;
    private String description;
}
