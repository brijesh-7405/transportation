package com.transportation.controller;

import com.transportation.entity.WorkerSalary;
import com.transportation.service.WorkerSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/worker-salaries")
public class WorkerSalaryController {

    @Autowired
    private WorkerSalaryService workerSalaryService;

    @GetMapping
    public ResponseEntity<List<WorkerSalary>> getAllWorkerSalaries() {
        List<WorkerSalary> workerSalaries = workerSalaryService.getAllWorkerSalaries();
        return new ResponseEntity<>(workerSalaries, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkerSalary> getWorkerSalaryById(@PathVariable("id") Long id) {
        WorkerSalary workerSalary = workerSalaryService.getWorkerSalaryById(id);
        return new ResponseEntity<>(workerSalary, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WorkerSalary> createWorkerSalary(@RequestBody WorkerSalary workerSalary) {
        WorkerSalary createdWorkerSalary = workerSalaryService.createWorkerSalary(workerSalary);
        return new ResponseEntity<>(createdWorkerSalary, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkerSalary> updateWorkerSalary(@PathVariable("id") Long id, @RequestBody WorkerSalary workerSalary) {
        WorkerSalary updatedWorkerSalary = workerSalaryService.updateWorkerSalary(id, workerSalary);
        return new ResponseEntity<>(updatedWorkerSalary, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkerSalary(@PathVariable("id") Long id) {
        workerSalaryService.deleteWorkerSalary(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
