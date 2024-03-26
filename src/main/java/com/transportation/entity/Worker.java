package com.transportation.entity;

import com.transportation.enums.IdentityProofType;
import com.transportation.enums.WorkerType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "worker")
@Data
public class Worker extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "worker_id")
    private Long workerId;
    @Column(name = "worker_name")
    private String workerName;
    @Column(name = "worker_type")
    private WorkerType workerType;
    @Column(name = "worker_age")
    private Integer workerAge;
    @Column(name = "identity_proof_type")
    private IdentityProofType identityProofType;
    @Column(name = "identity_number")
    private String identityNumber;
    @Column(name = "created_by")
    private Long createdBy;
    @Column(name = "updated_by")
    private Long updatedBy;
    @Column(name = "salary")
    private Double salary;
}
