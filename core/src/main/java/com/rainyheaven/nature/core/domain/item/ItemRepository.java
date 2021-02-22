package com.rainyheaven.nature.core.domain.item;

import com.rainyheaven.nature.core.domain.itemsrc.ImgType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query(value = "select i from Item i join fetch i.itemSrcs", countQuery = "select count (i) from Item i")
    Page<Item> findAllWithItemSrc(Pageable pageable);

    @Query(value = "select i from Item i join fetch i.itemSrcs isrc left join i.categoryItems ci where ci.categoryName = :categoryName and isrc.imgType = com.rainyheaven.nature.core.domain.itemsrc.ImgType.MAIN",
            countQuery = "select count (i) from Item i left join i.categoryItems ci where ci.categoryName = :categoryName")
    Page<Item> findAllByCategory(Pageable pageable, @Param("categoryName") String category);


}
