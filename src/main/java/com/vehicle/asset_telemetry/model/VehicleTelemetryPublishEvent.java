package com.vehicle.asset_telemetry.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VehicleTelemetryPublishEvent {
    private Integer schemaVersion;
    private Integer vin;
    private Integer fleetId;
    private Integer speed;
    private Integer battery;
}
