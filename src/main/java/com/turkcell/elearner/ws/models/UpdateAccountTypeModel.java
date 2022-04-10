package com.turkcell.elearner.ws.models;

import lombok.Data;
import org.axonframework.modelling.command.AggregateIdentifier;

@Data
public class UpdateAccountTypeModel {

    private Integer accountTypeId;
    private String accountName;
    private double price;
    private String description;
}
