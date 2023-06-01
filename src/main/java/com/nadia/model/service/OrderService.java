package com.nadia.model.service;

import com.nadia.model.domain.Car;
import com.nadia.model.domain.Client;
import com.nadia.model.domain.Mark;
import com.nadia.model.domain.Order;
import com.nadia.model.entity.CarEntity;
import com.nadia.model.entity.ClientEntity;
import com.nadia.model.entity.MarkEntity;
import com.nadia.model.entity.OrderEntity;
import com.nadia.model.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Yevhenii Filatov
 * @since 6/1/23
 */

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order getById(Long id) {
        return toOrder(orderRepository.findById(id));
    }

    public List<Order> getAll() {
        return orderRepository.findAll()
           .stream()
           .map(Optional::ofNullable)
           .map(this::toOrder)
           .toList();
    }

    private Order toOrder(Optional<OrderEntity> entity) {
        return entity.map(orderEntity -> Order.builder()
           .id(orderEntity.getId())
           .car(toCar(orderEntity.getCar()))
           .client(toClient(orderEntity.getClient()))
           .build()).orElse(null);
    }

    private Client toClient(ClientEntity clientEntity) {
        return Client.builder()
           .id(clientEntity.getId())
           .age(clientEntity.getAge())
           .phone(clientEntity.getPhone())
           .name(clientEntity.getName())
           .build();
    }

    private Car toCar(CarEntity carEntity) {
        return Car.builder()
           .id(carEntity.getId())
           .price(carEntity.getPrice())
           .model(carEntity.getModel())
           .mark(toMark(carEntity.getMark()))
           .build();
    }

    private Mark toMark(MarkEntity markEntity) {
        return Mark.builder()
           .id(markEntity.getId())
           .mark(markEntity.getMark())
           .build();
    }
}
