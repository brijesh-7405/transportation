package com.transportation.entity;

import com.transportation.enums.UserOrderType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_history")
@Data
public class OrderHistory extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "user_ordered_id")
    private Long userOrderedId;

    @Column(name = "user_order_type")
    private UserOrderType userOrderType;
}
