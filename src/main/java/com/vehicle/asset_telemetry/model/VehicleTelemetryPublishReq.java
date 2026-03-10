package com.vehicle.asset_telemetry.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VehicleTelemetryPublishReq {
    private Integer schemaVersion;
    private Integer speed;
    private Integer battery;
}
