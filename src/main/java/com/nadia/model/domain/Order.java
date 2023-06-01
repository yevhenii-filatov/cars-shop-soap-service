package com.nadia.model.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author Yevhenii Filatov
 * @since 6/1/23
 */

@Data
@Builder
public class Order {
    private int id;
    private Car car;
    private Client client;
}
