package com.turkcell.elearner.ws.models;

import lombok.Data;

@Data
public class CreateAccountTypeModel {

    private String accountName;
    private double price;
    private String description;
}
