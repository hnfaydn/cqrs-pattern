package com.turkcell.elearner.application.features.accountTypes.commands.create;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class AccountTypeCreatedEvent {

    @TargetAggregateIdentifier
    private Integer accountTypeId;
    private String accountName;
    private double price;
    private String description;
}
