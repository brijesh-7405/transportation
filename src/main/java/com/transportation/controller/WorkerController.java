package com.transportation.controller;

import com.transportation.entity.Worker;
import com.transportation.security.service.UserInfoDetails;
import com.transportation.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping
    public ResponseEntity<List<Worker>> getAllWorkers() {
        List<Worker> workers = workerService.getAllWorkers();
        return new ResponseEntity<>(workers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> getWorkerById(@PathVariable("id") Long id) {
        Worker worker = workerService.getWorkerById(id);
        return new ResponseEntity<>(worker, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Worker> createWorker(@RequestBody Worker worker) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfoDetails userDetailsDTO = (UserInfoDetails) authentication.getPrincipal();
        worker.setCreatedBy(userDetailsDTO.getId());
        worker.setUpdatedBy(userDetailsDTO.getId());
        Worker createdWorker = workerService.createWorker(worker);
        return new ResponseEntity<>(createdWorker, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Worker> updateWorker(@PathVariable("id") Long id, @RequestBody Worker worker) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfoDetails userDetailsDTO = (UserInfoDetails) authentication.getPrincipal();
        worker.setUpdatedBy(userDetailsDTO.getId());
        Worker updatedWorker = workerService.updateWorker(id, worker);
        return new ResponseEntity<>(updatedWorker, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorker(@PathVariable("id") Long id) {
        workerService.deleteWorker(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
