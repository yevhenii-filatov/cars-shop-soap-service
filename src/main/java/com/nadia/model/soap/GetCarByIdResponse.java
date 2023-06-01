package com.nadia.model.soap;

import com.nadia.model.domain.Car;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Yevhenii Filatov
 * @since 6/1/23
 */

@Data
@AllArgsConstructor
public class GetCarByIdResponse {
    private Car car;
}
