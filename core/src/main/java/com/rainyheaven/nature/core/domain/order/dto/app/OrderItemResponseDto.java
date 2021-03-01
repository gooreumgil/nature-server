package com.rainyheaven.nature.core.domain.order.dto.app;

import com.rainyheaven.nature.core.domain.orderitem.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponseDto {

    private Long id;
    private Long itemId;
    private String itemNameKor;
    private String itemNameEng;
    private Integer itemPrice;
    private Integer itemDiscountPrice;
    private Integer itemQuantity;

    public OrderItemResponseDto(OrderItem orderItem) {
        this.id = orderItem.getId();
        this.itemId = orderItem.getId();
        this.itemNameKor = orderItem.getItem().getNameKor();
        this.itemNameEng = orderItem.getItem().getNameEng();
        this.itemPrice = orderItem.getItemPrice();
        this.itemDiscountPrice = orderItem.getItemDiscountPrice();
        this.itemQuantity = orderItem.getItemQuantity();
    }
}
