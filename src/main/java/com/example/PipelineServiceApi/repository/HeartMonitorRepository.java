package com.example.PipelineServiceApi.repository;

import com.example.PipelineServiceApi.model.HeartData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeartMonitorRepository extends JpaRepository<HeartData,Integer> {
    List<HeartData> findByPatientId(int patientId);

}
