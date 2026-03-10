package com.vehicle.asset_telemetry.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseModel<T> {
    private String message;
    private T data;
    private Error error;
}
