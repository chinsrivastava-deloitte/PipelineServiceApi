package com.example.PipelineServiceApi.repository;


import com.example.PipelineServiceApi.model.BloodPressure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodPressureDataRepository extends JpaRepository<BloodPressure,Integer> {
    List<BloodPressure> findByPatientId(int patientId);
}