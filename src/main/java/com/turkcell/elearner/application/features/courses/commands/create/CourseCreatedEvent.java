package com.turkcell.elearner.application.features.courses.commands.create;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class CourseCreatedEvent {

    @TargetAggregateIdentifier
    private String courseId;
    private String courseName;
    private double price;
    private String description;

}
