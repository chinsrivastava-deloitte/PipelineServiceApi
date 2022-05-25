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
public class BloodOxygenData {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name="Oxygen_Value")
    private int OxygenVal;
    @Column(name="machine_id")
    private int patientId;
    private Date timestamp;

    public BloodOxygenData(int OxygenVal,int patientId,Date timestamp) {
        super();
        this.timestamp=timestamp;
        this.OxygenVal=OxygenVal;
        this.patientId=patientId;

    }
}
