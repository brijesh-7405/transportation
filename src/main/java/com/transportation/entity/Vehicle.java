package com.transportation.entity;


import com.transportation.enums.VehicleType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vehicle")
@Data
public class Vehicle extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Long vehicleId;
    @Column(name = "vehicle_name")
    private String vehicleName;
    @Column(name = "health_condition")
    private String healthCondition;
    @Column(name = "vehicle_type")
    private VehicleType vehicleType;
    @Column(name = "model")
    private String model;
    @Column(name = "capacity")
    private Float capacity;
    @Column(name = "rate")
    private Double rate;
    @Column(name = "best_for_sending")
    private String bestForSending;
    @Column(name = "length")
    private Float length;
    @Column(name = "width")
    private Float width;
    @Column(name = "depth")
    private Float depth;
    @Column(name = "created_by")
    private Long createdBy;
    @Column(name = "updated_by")
    private Long updatedBy;
}
