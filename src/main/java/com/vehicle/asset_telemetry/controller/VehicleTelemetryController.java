package com.vehicle.asset_telemetry.controller;

import com.google.gson.Gson;
import com.vehicle.asset_telemetry.config.Mqtt;
import com.vehicle.asset_telemetry.model.ResponseModel;
import com.vehicle.asset_telemetry.model.VehicleTelemetryPublishEvent;
import com.vehicle.asset_telemetry.model.VehicleTelemetryPublishReq;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class VehicleTelemetryController {

    @GetMapping("dummy")
    public ResponseEntity<ResponseModel<String>> dummyAPI(@RequestParam(name = "name") String name) {
        ResponseModel<String> res = new ResponseModel<>();
        res.setData("Hi " + name);
        log.info("dummy API hitting.");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("fleet/{fleetId}/vehicle/{vin}/telemetry")
    public void publishMessage(@RequestBody VehicleTelemetryPublishReq messagePublishModel, @PathVariable String fleetId,
                               @PathVariable String vin) throws MqttException {
        // Map VehicleTelemetryPublishReq to VehicleTelemetryPublishEvent
        VehicleTelemetryPublishReq vehicleTelemetryPublishReq = new VehicleTelemetryPublishReq();
        Gson gson = new Gson();
        String jsonPayload = gson.toJson(vehicleTelemetryPublishReq);

        MqttMessage mqttMessage = new MqttMessage(jsonPayload.getBytes());
        mqttMessage.setQos(1);
        String topicName = "fleetId/" + fleetId + "/vehicle/" + vin + "/telemetry";
        Mqtt.getInstance().publish(topicName, mqttMessage);
    }

}


