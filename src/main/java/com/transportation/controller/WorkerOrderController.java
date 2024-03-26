package com.transportation.controller;
import com.transportation.entity.WorkerOrder;
import com.transportation.service.WorkerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/worker-orders")
public class WorkerOrderController {

    @Autowired
    private WorkerOrderService workerOrderService;

    @GetMapping
    public ResponseEntity<List<WorkerOrder>> getAllWorkerOrders() {
        List<WorkerOrder> workerOrders = workerOrderService.getAllWorkerOrders();
        return new ResponseEntity<>(workerOrders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkerOrder> getWorkerOrderById(@PathVariable("id") Long id) {
        WorkerOrder workerOrder = workerOrderService.getWorkerOrderById(id);
        return new ResponseEntity<>(workerOrder, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WorkerOrder> createWorkerOrder(@RequestBody WorkerOrder workerOrder) {
        WorkerOrder createdWorkerOrder = workerOrderService.createWorkerOrder(workerOrder);
        return new ResponseEntity<>(createdWorkerOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkerOrder> updateWorkerOrder(@PathVariable("id") Long id, @RequestBody WorkerOrder workerOrder) {
        WorkerOrder updatedWorkerOrder = workerOrderService.updateWorkerOrder(id, workerOrder);
        return new ResponseEntity<>(updatedWorkerOrder, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkerOrder(@PathVariable("id") Long id) {
        workerOrderService.deleteWorkerOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
