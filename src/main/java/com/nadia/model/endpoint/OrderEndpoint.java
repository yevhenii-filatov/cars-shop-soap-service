package com.nadia.model.endpoint;

import com.nadia.model.service.OrderService;
import com.nadia.model.soap.GetAllOrdersResponse;
import com.nadia.model.soap.GetByIdRequest;
import com.nadia.model.soap.GetOrderByIdResponse;
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
public class OrderEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/carsshop";

    private final OrderService orderService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetOrderByIdRequest")
    @ResponsePayload
    public GetOrderByIdResponse getCarById(@RequestPayload GetByIdRequest request) {
        return new GetOrderByIdResponse(orderService.getById(request.getId()));
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllOrders")
    @ResponsePayload
    public GetAllOrdersResponse getAllOrders() {
        return new GetAllOrdersResponse(orderService.getAll());
    }
}
