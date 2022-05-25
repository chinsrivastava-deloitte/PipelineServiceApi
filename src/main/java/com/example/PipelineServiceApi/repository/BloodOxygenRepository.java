package com.example.PipelineServiceApi.repository;

import com.example.PipelineServiceApi.model.BloodOxygenData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodOxygenRepository extends JpaRepository<BloodOxygenData,Integer> {
    List<BloodOxygenData> findByPatientId(int patientId);

}
