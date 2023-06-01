package com.nadia.model.repository;

import com.nadia.model.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Yevhenii Filatov
 * @since 6/1/23
 */

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
