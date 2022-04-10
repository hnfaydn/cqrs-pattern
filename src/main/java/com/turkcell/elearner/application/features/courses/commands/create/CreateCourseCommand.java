package com.turkcell.elearner.application.features.courses.commands.create;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateCourseCommand {

    @TargetAggregateIdentifier
    private String courseId;
    private String courseName;
    private double price;
    private String description;
}
