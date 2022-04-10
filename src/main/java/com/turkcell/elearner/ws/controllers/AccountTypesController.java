package com.turkcell.elearner.ws.controllers;

import com.turkcell.elearner.application.features.accountTypes.commands.create.CreateAccountTypeCommand;
import com.turkcell.elearner.application.features.accountTypes.commands.update.UpdateAccountTypeCommand;
import com.turkcell.elearner.ws.models.CreateAccountTypeModel;
import com.turkcell.elearner.ws.models.UpdateAccountTypeModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/accountTypesController")
public class AccountTypesController {

    private CommandGateway commandGateway;

    public AccountTypesController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/create")
    public void CreateAccountType(@RequestBody CreateAccountTypeModel createAccountTypeModel){

        CreateAccountTypeCommand createAccountTypeCommand = CreateAccountTypeCommand.builder()
                .price(createAccountTypeModel.getPrice())
                .accountName(createAccountTypeModel.getAccountName())
                .description(createAccountTypeModel.getDescription())
                .build();

        //createAccountTypeCommand.setAccountTypeId(UUID.randomUUID().toString().replace("-","").substring(0,4));

        this.commandGateway.sendAndWait(createAccountTypeCommand);
    }

    @PutMapping("/update")
    public void UpdateAccountType(@RequestBody UpdateAccountTypeModel updateAccountTypeModel){

        UpdateAccountTypeCommand updateAccountTypeCommand = UpdateAccountTypeCommand.builder()
                .price(updateAccountTypeModel.getPrice())
                .accountName(updateAccountTypeModel.getAccountName())
                .description(updateAccountTypeModel.getDescription())
                .build();
        updateAccountTypeCommand.setAccountTypeId(updateAccountTypeModel.getAccountTypeId());

        this.commandGateway.sendAndWait(updateAccountTypeCommand);
    }
}
