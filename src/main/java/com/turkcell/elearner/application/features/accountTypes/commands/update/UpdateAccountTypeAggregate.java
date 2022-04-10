package com.turkcell.elearner.application.features.accountTypes.commands.update;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateCreationPolicy;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.CreationPolicy;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class UpdateAccountTypeAggregate {

    @AggregateIdentifier
    private Integer accountTypeId;
    private String accountName;
    private double price;
    private String description;

    public UpdateAccountTypeAggregate() {
    }

    @CommandHandler
    public UpdateAccountTypeAggregate(UpdateAccountTypeCommand updateAccountTypeCommand){

        AccountTypeUpdatedEvent accountTypeUpdatedEvent = new AccountTypeUpdatedEvent();

        BeanUtils.copyProperties(updateAccountTypeCommand, accountTypeUpdatedEvent);

        AggregateLifecycle.apply(accountTypeUpdatedEvent);
    }

    @EventSourcingHandler
    public void on(AccountTypeUpdatedEvent accountTypeUpdatedEvent){
        this.accountTypeId = accountTypeUpdatedEvent.getAccountTypeId();
        this.accountName = accountTypeUpdatedEvent.getAccountName();
        this.price = accountTypeUpdatedEvent.getPrice();
        this.description = accountTypeUpdatedEvent.getDescription();
    }
}
