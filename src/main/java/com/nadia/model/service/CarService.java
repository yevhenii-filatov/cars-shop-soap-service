package com.nadia.model.service;

import com.nadia.model.domain.Car;
import com.nadia.model.domain.Mark;
import com.nadia.model.entity.CarEntity;
import com.nadia.model.entity.MarkEntity;
import com.nadia.model.repository.CarRepository;
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
public class CarService {
    private final CarRepository carRepository;

    public Car getById(Long id) {
        return toCar(carRepository.findById(id));
    }

    public List<Car> getAll() {
        return carRepository.findAll()
           .stream()
           .map(Optional::ofNullable)
           .map(this::toCar)
           .toList();
    }

    private Car toCar(Optional<CarEntity> entity) {
        return entity.map(carEntity -> Car.builder()
           .id(carEntity.getId())
           .price(carEntity.getPrice())
           .model(carEntity.getModel())
           .mark(toMark(carEntity.getMark()))
           .build()).orElse(null);
    }

    private Mark toMark(MarkEntity markEntity) {
        return Mark.builder()
           .id(markEntity.getId())
           .mark(markEntity.getMark())
           .build();
    }
}
