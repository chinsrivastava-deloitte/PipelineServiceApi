package com.example.PipelineServiceApi.utils.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;
@Getter@Setter
public class InputDto {
    private int patientId;
    private Date startTime;
    private Date endTime;

}
