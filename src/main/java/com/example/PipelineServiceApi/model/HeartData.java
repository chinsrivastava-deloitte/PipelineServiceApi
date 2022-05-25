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
public class HeartData {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name="Bps")
    private int beatsPerSecond;
    @Column(name="patient_id")
    private int patientId;
    private Date timestamp;
    public HeartData(int bps,int patientId,Date timestamp) {
        super();
        this.beatsPerSecond=bps;
        this.timestamp=timestamp;
        this.patientId=patientId;
    }
}
