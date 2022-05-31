package com.example.PipelineServiceApi.service;

import com.example.PipelineServiceApi.model.BloodOxygenData;
import com.example.PipelineServiceApi.model.BloodPressure;
import com.example.PipelineServiceApi.model.HeartData;
import com.example.PipelineServiceApi.utils.dto.InputDto;
import com.example.PipelineServiceApi.utils.dto.Pair;
import com.example.PipelineServiceApi.utils.dto.ReturnDataDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface HeartMetricsService {
    public abstract List<HeartData> getAllHeartDataById(int patientId);
    public abstract List<BloodOxygenData> getAllBloodOxygenById(int patientId);
    public abstract List<Integer> getHeartDataByTime(InputDto inputDto);
    public abstract List<ReturnDataDto> getBloodOxygenData(InputDto inputDto);
    public abstract List<Integer> getBloodOxygenByTime(InputDto inputDto);
    public abstract List<ReturnDataDto> getHeartData(InputDto inputDto);
    public abstract List<BloodPressure> getAllBloodPressureById(int patientId);
    public abstract List<Pair> getBloodPressureByTime(InputDto inputDto);
    public abstract List<ReturnDataDto> getBloodPressure(InputDto inputDto);

}
