package com.vehicle.asset_telemetry.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Error {
    private String code;
    private String message;
}
