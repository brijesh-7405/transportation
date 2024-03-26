package com.transportation.service;

import com.transportation.entity.WorkerSalary;

import java.util.List;

public interface WorkerSalaryService {
    List<WorkerSalary> getAllWorkerSalaries();
    WorkerSalary getWorkerSalaryById(Long id);
    WorkerSalary createWorkerSalary(WorkerSalary workerSalary);
    WorkerSalary updateWorkerSalary(Long id, WorkerSalary workerSalary);
    void deleteWorkerSalary(Long id);
}
