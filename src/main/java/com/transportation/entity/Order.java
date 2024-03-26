package com.transportation.entity;

import com.transportation.enums.OrderStatus;
import com.transportation.enums.UserOrderType;
import com.transportation.enums.VehicleType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "orders")
@Data
public class Order extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "number_of_vehicles")
    private Integer numberOfVehicles;

    @Column(name = "user_ordered_id")
    private Long userOrderedId;

    @Column(name = "order_by")
    private UserOrderType OrderBy;
    @Column(name = "weight_per_items")
    private Float weightPerItems;
    @Column(name = "number_of_items")
    private Integer numberOfItems;
    @Column(name = "number_of_trips")
    private Integer numberOfTrips;
    @Column(name = "from_location")
    private String fromLocation;
    @Column(name = "to_location")
    private String toLocation;
    @Column(name = "distance")
    private Float distance;
    @Column(name = "vehicle_type")
    private VehicleType vehicleType;
    @Column(name = "number_of_labours")
    private Integer numberOfLabours;
    @Column(name = "name_of_receiver")
    private String nameOfReceiver;
    @Column(name = "total_price")
    private Double totalPrice;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "status")
    private OrderStatus status;
    @Column(name = "pickup_time")
    private Date pickupTime;
    @Column(name = "delivered_time")
    private Date deliveredTime;
}
