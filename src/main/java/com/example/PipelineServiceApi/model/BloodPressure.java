package com.example.PipelineServiceApi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class BloodPressure {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name="systolic")
    private int systolicValue;
    @Column(name="diastolic")
    private int diastolicValue;
    @Column(name="patient_id")
    private int patientId;
    private Date timestamp;
    public BloodPressure(int systolicValue,int diastolicValue,int patientId,Date timestamp) {
        super();
        this.systolicValue=systolicValue;
        this.diastolicValue=diastolicValue;
        this.timestamp=timestamp;
        this.patientId=patientId;
    }
}
