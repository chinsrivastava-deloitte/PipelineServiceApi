package com.example.PipelineServiceApi.utils.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class ReturnDataDto {
    private int patientId;
    private List<Integer> heartValues;
}
