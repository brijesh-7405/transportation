package com.transportation.service;

import com.transportation.entity.Worker;

import java.util.List;

public interface WorkerService {
    List<Worker> getAllWorkers();
    Worker getWorkerById(Long id);
    Worker createWorker(Worker worker);
    Worker updateWorker(Long id, Worker worker);
    void deleteWorker(Long id);
}
