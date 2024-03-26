package com.transportation.service.impl;

import com.transportation.entity.WorkerOrder;
import com.transportation.repository.WorkerOrderRepository;
import com.transportation.service.WorkerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerOrderServiceImpl implements WorkerOrderService {

    @Autowired
    private WorkerOrderRepository workerOrderRepository;

    @Override
    public List<WorkerOrder> getAllWorkerOrders() {
        return workerOrderRepository.findAll();
    }

    @Override
    public WorkerOrder getWorkerOrderById(Long id) {
        Optional<WorkerOrder> optionalWorkerOrder = workerOrderRepository.findById(id);
        return optionalWorkerOrder.orElse(null);
    }

    @Override
    public WorkerOrder createWorkerOrder(WorkerOrder workerOrder) {
        return workerOrderRepository.save(workerOrder);
    }

    @Override
    public WorkerOrder updateWorkerOrder(Long id, WorkerOrder workerOrder) {
        if (workerOrderRepository.existsById(id)) {
            workerOrder.setId(id);
            return workerOrderRepository.save(workerOrder);
        } else {
            return null; // or throw an exception
        }
    }

    @Override
    public void deleteWorkerOrder(Long id) {
        workerOrderRepository.deleteById(id);
    }
}
