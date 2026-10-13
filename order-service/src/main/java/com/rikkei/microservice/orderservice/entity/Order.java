package com.rikkei.microservice.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Trong Microservices, Customer và Product nằm ở các database riêng biệt (customer_db và product_db).
     * Do đó, không thể dùng quan hệ khóa ngoại vật lý (@ManyToOne hay @JoinColumn) tại tầng Database/JPA.
     * Order chỉ lưu trữ các ID tham chiếu dạng số (Long).
     */
    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;
}
