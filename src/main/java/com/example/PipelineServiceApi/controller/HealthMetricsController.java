package com.example.PipelineServiceApi.controller;

import com.example.PipelineServiceApi.service.HeartMetricsServiceImpl;
import com.example.PipelineServiceApi.utils.dto.InputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthMetricsController {
    @Autowired
    HeartMetricsServiceImpl heartMetricsService;

    @GetMapping("/getAllHeartData/{patientId}")
    public ResponseEntity<Object> getAllHeartData(@PathVariable int patientId){
        return new ResponseEntity<>(heartMetricsService.getAllHeartDataById(patientId), HttpStatus.OK);
    }
    @GetMapping("/getAllBloodOxygen/{patientId}")
    public ResponseEntity<Object> getAllBloodOxygen(@PathVariable int patientId){
        return new ResponseEntity<>(heartMetricsService.getAllBloodOxygenById(patientId),HttpStatus.OK);
    }
    @GetMapping("/getHeartDataInTime")
    public ResponseEntity<Object> getHeartDataTime(@RequestBody InputDto inputDto){
        return new ResponseEntity<>(heartMetricsService.getHeartDataByTime(inputDto),HttpStatus.OK);
    }
    @GetMapping("/getBloodOxygenDataForAllPatients")
    public ResponseEntity<Object> getBloodOxygenData(@RequestBody InputDto inputDto){
        return new ResponseEntity<>(heartMetricsService.getBloodOxygenData(inputDto),HttpStatus.OK);
    }
    @GetMapping("/getHeartDataForAllPatients")
    public ResponseEntity<Object> getHeartData(@RequestBody InputDto inputDto){
        return new ResponseEntity<>(heartMetricsService.getHeartData(inputDto),HttpStatus.OK);
    }
    @GetMapping("/getBloodOxygenDataInTime")
    public ResponseEntity<Object> getBloodOxygenDataTime(@RequestBody InputDto inputDto){
        return new ResponseEntity<>(heartMetricsService.getBloodOxygenByTime(inputDto),HttpStatus.OK);
    }
}
