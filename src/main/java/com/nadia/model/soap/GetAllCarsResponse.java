package com.nadia.model.soap;

import com.nadia.model.domain.Car;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Yevhenii Filatov
 * @since 6/1/23
 */

@Data
@AllArgsConstructor
public class GetAllCarsResponse {
    private List<Car> cars;
}
