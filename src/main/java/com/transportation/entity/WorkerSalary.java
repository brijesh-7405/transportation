package com.transportation.entity;

import com.transportation.enums.SalaryStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "worker_salary")
@Data
public class WorkerSalary extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "worker_id")
    private Long workerId;

    @Column(name = "salary_status")
    private SalaryStatus salaryStatus;
    @Column(name = "paid_by")
    private Long paidBy;
    @Column(name = "paidDate")
    private Date paidDate;
    @Column(name = "ofMonth")
    private String ofMonth;

}
