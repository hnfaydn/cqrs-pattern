package com.turkcell.elearner.ws.controllers;

import com.turkcell.elearner.application.features.courses.commands.create.CreateCourseCommand;
import com.turkcell.elearner.ws.models.CreateCourseModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/coursesController")
public class CoursesController {

    private CommandGateway commandGateway;

    @Autowired
    public CoursesController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/create")
    public void CreateCourseType(@RequestBody CreateCourseModel createCourseModel){

        CreateCourseCommand createCourseCommand = CreateCourseCommand.builder()
                .courseName(createCourseModel.getCourseName())
                .price(createCourseModel.getPrice())
                .description(createCourseModel.getDescription())
                .build();
        createCourseCommand.setCourseId(UUID.randomUUID().toString());

        this.commandGateway.sendAndWait(createCourseCommand);
    }
}
