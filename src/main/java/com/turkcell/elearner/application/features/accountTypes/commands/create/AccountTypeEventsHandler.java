package com.turkcell.elearner.application.features.accountTypes.commands.create;

import com.turkcell.elearner.application.features.accountTypes.commands.update.AccountTypeUpdatedEvent;
import com.turkcell.elearner.domain.AccountType;
import com.turkcell.elearner.persistence.AccountTypeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountTypeEventsHandler {

    private AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeEventsHandler(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @EventHandler
    public void create(AccountTypeCreatedEvent accountTypeCreatedEvent) {

        //database business codes(checkIf type methods)

        AccountType accountType = new AccountType();

        BeanUtils.copyProperties(accountTypeCreatedEvent,accountType);

        this.accountTypeRepository.save(accountType);
    }

    @EventHandler
    public void update(AccountTypeUpdatedEvent accountTypeUpdatedEvent) {

        AccountType accountType = new AccountType();


        accountType.setAccountTypeId(accountTypeUpdatedEvent.getAccountTypeId());
        accountType.setAccountName(accountTypeUpdatedEvent.getAccountName());
        accountType.setPrice(accountTypeUpdatedEvent.getPrice());
        accountType.setDescription(accountTypeUpdatedEvent.getDescription());

        this.accountTypeRepository.save(accountType);
    }
}
