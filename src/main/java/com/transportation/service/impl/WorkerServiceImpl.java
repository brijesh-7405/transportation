package com.transportation.service.impl;

import com.transportation.entity.Worker;
import com.transportation.repository.WorkerRepository;
import com.transportation.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    @Override
    public Worker getWorkerById(Long id) {
        Optional<Worker> optionalWorker = workerRepository.findById(id);
        return optionalWorker.orElse(null);
    }

    @Override
    public Worker createWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public Worker updateWorker(Long id, Worker worker) {
        if (workerRepository.existsById(id)) {
            worker.setWorkerId(id);
            return workerRepository.save(worker);
        } else {
            return null; // or throw an exception
        }
    }

    @Override
    public void deleteWorker(Long id) {
        workerRepository.deleteById(id);
    }
}
