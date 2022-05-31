package com.example.PipelineServiceApi.service;

import com.example.PipelineServiceApi.model.BloodOxygenData;
import com.example.PipelineServiceApi.model.BloodPressure;
import com.example.PipelineServiceApi.model.HeartData;
import com.example.PipelineServiceApi.repository.BloodOxygenRepository;
import com.example.PipelineServiceApi.repository.BloodPressureDataRepository;
import com.example.PipelineServiceApi.repository.HeartMonitorRepository;
import com.example.PipelineServiceApi.utils.dto.InputDto;
import com.example.PipelineServiceApi.utils.dto.Pair;
import com.example.PipelineServiceApi.utils.dto.ReturnDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HeartMetricsServiceImpl {
    @Autowired
    HeartMonitorRepository heartMonitorRepository;
    @Autowired
    BloodOxygenRepository bloodOxygenRepository;
    @Autowired
    BloodPressureDataRepository bloodPressureDataRepository;

    /**
     * method to get all heart data values by patient id
     * @param patientId is the patient id
     * @return list of heartData objects
     */
    public List<HeartData> getAllHeartDataById(int patientId) {
        return heartMonitorRepository.findByPatientId(patientId);
    }

    /**
     * method to get all blood oxygen data by patient id
     * @param patientId is the patient id
     * @return list of BloodOxygenData objects
     */
    public List<BloodOxygenData> getAllBloodOxygenById(int patientId){
        return bloodOxygenRepository.findByPatientId(patientId);
    }
    public List<Integer> getHeartDataByTime(InputDto inputDto){
        int patientId = inputDto.getPatientId();
        Date startTime = inputDto.getStartTime();
        Date endTime = inputDto.getEndTime();
        List<HeartData> heartDataList = heartMonitorRepository.findByPatientId(patientId);
        List<Integer> lists = new ArrayList<>();
        for(HeartData h :heartDataList){
            if(h.getTimestamp().after(startTime)==true && h.getTimestamp().before(endTime)==true) {
                System.out.println(h.getId());
                lists.add(h.getBeatsPerSecond());
            }
        }
        return lists;

    }
    public List<Integer> getBloodOxygenByTime(InputDto inputDto){
        int patientId = inputDto.getPatientId();
        Date startTime = inputDto.getStartTime();
        Date endTime = inputDto.getEndTime();
        List<BloodOxygenData> bloodOxygenDataList = bloodOxygenRepository.findByPatientId(patientId);
        List<Integer> lists = new ArrayList<>();
        for(BloodOxygenData b: bloodOxygenDataList){
            if(b.getTimestamp().after(startTime)==true && b.getTimestamp().before(endTime)==true) {
                System.out.println(b.getId());
                lists.add(b.getOxygenVal());
            }
        }
        return lists;
    }


    public List<ReturnDataDto> getBloodOxygenData(InputDto inputDto) {
        List<BloodOxygenData> lists= bloodOxygenRepository.findAll();
        Set<Integer> patientIdList = new HashSet<>();
        for(BloodOxygenData b:lists)
            patientIdList.add(b.getPatientId());
        List<ReturnDataDto> returnDataDtoList = new ArrayList<>();
        for(int id : patientIdList){
            ReturnDataDto returnDataDto = new ReturnDataDto();
            inputDto.setPatientId(id);
            returnDataDto.setHeartValues(getBloodOxygenByTime(inputDto));
            returnDataDto.setPatientId(id);
            returnDataDtoList.add(returnDataDto);
        }
        return returnDataDtoList;
    }
    public List<ReturnDataDto> getHeartData(InputDto inputDto){
        List<HeartData> lists = heartMonitorRepository.findAll();
        Set<Integer> patientIdList = new HashSet<>();
        for(HeartData h:lists)
            patientIdList.add(h.getPatientId());
        List<ReturnDataDto> returnDataDtoList = new ArrayList<>();
        for(int id : patientIdList){
            ReturnDataDto returnDataDto = new ReturnDataDto();
            inputDto.setPatientId(id);
            returnDataDto.setHeartValues(getHeartDataByTime(inputDto));
            returnDataDto.setPatientId(id);
            returnDataDtoList.add(returnDataDto);
        }
        return returnDataDtoList;
    }

    public List<BloodPressure> getAllBloodPressureById(int patientId){
        return bloodPressureDataRepository.findByPatientId(patientId);
    }

    public List<Pair> getBloodPressureByTime(InputDto inputDto){
        int patientId = inputDto.getPatientId();
        Date startTime = inputDto.getStartTime();
        Date endTime = inputDto.getEndTime();
        List<BloodPressure> bloodPressureList =bloodPressureDataRepository.findByPatientId(patientId);
        List<Pair> lists = new ArrayList<>();
        for(BloodPressure b: bloodPressureList){
            if(b.getTimestamp().after(startTime)==true && b.getTimestamp().before(endTime)==true) {
                System.out.println(b.getId());
                lists.add(new Pair(b.getDiastolicValue(),b.getSystolicValue()));
            }
        }
        return lists;
    }

}
