package com.transportation.service;
import com.transportation.entity.WorkerOrder;

import java.util.List;
public interface WorkerOrderService {
    List<WorkerOrder> getAllWorkerOrders();
    WorkerOrder getWorkerOrderById(Long id);
    WorkerOrder createWorkerOrder(WorkerOrder workerOrder);
    WorkerOrder updateWorkerOrder(Long id, WorkerOrder workerOrder);
    void deleteWorkerOrder(Long id);
}
