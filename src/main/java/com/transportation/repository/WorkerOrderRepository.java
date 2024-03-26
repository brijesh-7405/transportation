package com.transportation.repository;

import com.transportation.entity.WorkerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerOrderRepository extends JpaRepository<WorkerOrder,Long> {
}
