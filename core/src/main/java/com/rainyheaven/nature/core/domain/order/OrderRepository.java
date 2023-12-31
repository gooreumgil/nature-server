package com.rainyheaven.nature.core.domain.order;

import com.rainyheaven.nature.core.domain.delivery.DeliveryStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o join fetch o.orderItems oi join fetch oi.item join fetch o.delivery where o.id = :id")
    Optional<Order> findByIdWithOrderItemsAndDelivery(@Param("id") Long id);

    @Query("select o from Order o join fetch o.user join fetch o.delivery where o.id = :id")
    Optional<Order> findByIdWithUserAndDelivery(@Param("id") Long id);

    @Query("select o from Order o join fetch o.user join fetch o.delivery join fetch o.orderItems oi join fetch oi.item where o.id = :id")
    Optional<Order> findByIdWithUserAndDeliveryAndOrderItems(@Param("id") Long id);

    @Query(value = "select o from Order o join fetch o.orderItems oi join fetch oi.item join fetch o.delivery where o.user.id = :userId",
            countQuery = "select count (o) from Order o where o.user.id = :userId")
    Page<Order> findByUserIdWithOrderItemsAndDelivery(@Param("userId") Long userId, Pageable pageable);

    int countAllByUserIdAndDeliveryDeliveryStatus(Long userId, DeliveryStatus deliveryStatus);

    @Modifying
    void deleteByIdAndUserId(Long id, Long userId);

}
