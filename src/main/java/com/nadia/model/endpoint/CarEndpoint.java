package com.nadia.model.endpoint;

import com.nadia.model.service.CarService;
import com.nadia.model.soap.GetAllCarsResponse;
import com.nadia.model.soap.GetByIdRequest;
import com.nadia.model.soap.GetCarByIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * @author Yevhenii Filatov
 * @since 6/1/23
 */

@Endpoint
@RequiredArgsConstructor
public class CarEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/carsshop";

    private final CarService carService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetCarByIdRequest")
    @ResponsePayload
    public GetCarByIdResponse getCarById(@RequestPayload GetByIdRequest request) {
        return new GetCarByIdResponse(carService.getById(request.getId()));
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllCars")
    @ResponsePayload
    public GetAllCarsResponse getAllCars() {
        return new GetAllCarsResponse(carService.getAll());
    }
}
