package com.transportation.service.impl;

import com.transportation.entity.WorkerSalary;
import com.transportation.repository.WorkerSalaryRepository;
import com.transportation.service.WorkerSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerSalaryServiceImpl implements WorkerSalaryService {

    @Autowired
    private WorkerSalaryRepository workerSalaryRepository;

    @Override
    public List<WorkerSalary> getAllWorkerSalaries() {
        return workerSalaryRepository.findAll();
    }

    @Override
    public WorkerSalary getWorkerSalaryById(Long id) {
        Optional<WorkerSalary> optionalWorkerSalary = workerSalaryRepository.findById(id);
        return optionalWorkerSalary.orElse(null);
    }

    @Override
    public WorkerSalary createWorkerSalary(WorkerSalary workerSalary) {
        return workerSalaryRepository.save(workerSalary);
    }

    @Override
    public WorkerSalary updateWorkerSalary(Long id, WorkerSalary workerSalary) {
        if (workerSalaryRepository.existsById(id)) {
            workerSalary.setId(id);
            return workerSalaryRepository.save(workerSalary);
        } else {
            return null; // or throw an exception
        }
    }

    @Override
    public void deleteWorkerSalary(Long id) {
        workerSalaryRepository.deleteById(id);
    }
}
