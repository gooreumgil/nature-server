package com.rainyheaven.nature.core.domain.review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "select r from Review r join fetch r.item left join fetch r.reviewImages where r.user.id = :userId",
            countQuery = "select count (r) from Review r where r.user.id = :userId")
    Page<Review> findAllByUserIdWithItem(@Param("userId") Long userId, Pageable pageable);

    @Query(value = "select r from Review r join fetch r.item join fetch r.user left join fetch r.reviewImages where r.item.id = :itemId",
            countQuery = "select count (r) from Review r where r.item.id = :itemId")
    Page<Review> findAllByItemIdWithUser(@Param("itemId") Long itemId, Pageable pageable);

    int countAllByUserId(Long userId);
    int countAllByItemId(Long itemId);
}
