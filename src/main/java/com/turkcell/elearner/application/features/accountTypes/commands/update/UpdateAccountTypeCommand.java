package com.turkcell.elearner.application.features.accountTypes.commands.update;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class UpdateAccountTypeCommand {

    @TargetAggregateIdentifier
    private Integer accountTypeId;
    private String accountName;
    private double price;
    private String description;
}
