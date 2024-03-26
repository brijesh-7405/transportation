package com.transportation.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "worker_order")
@Data
public class WorkerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
