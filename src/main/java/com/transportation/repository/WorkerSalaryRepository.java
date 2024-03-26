package com.transportation.repository;

import com.transportation.entity.WorkerSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerSalaryRepository extends JpaRepository<WorkerSalary,Long> {
}
