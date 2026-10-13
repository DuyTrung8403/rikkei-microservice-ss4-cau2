package com.rikkei.microservice.orderservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequestDTO {

    @NotNull(message = "Mã khách hàng (customerId) không được để trống")
    private Long customerId;

    @NotNull(message = "Mã sản phẩm (productId) không được để trống")
    private Long productId;

    @NotNull(message = "Số lượng (quantity) không được để trống")
    @Min(value = 1, message = "Số lượng (quantity) phải lớn hơn 0")
    private Integer quantity;
}
