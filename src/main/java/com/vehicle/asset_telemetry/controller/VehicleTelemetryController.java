package com.vehicle.asset_telemetry.controller;

import com.vehicle.asset_telemetry.model.ResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("telemetry/")
@Slf4j
public class VehicleTelemetryController {

    @GetMapping("dummy")
    public ResponseEntity<ResponseModel<String>> dummyAPI(@RequestParam(name = "name") String name) {
        ResponseModel<String> res = new ResponseModel<>();
        res.setData("Hi " + name);
        log.info("dummy API hitting.");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    /*@PostMapping("publish")
    public void publishMessage(@RequestBody MqttPublishModel messagePublishModel) throws org.eclipse.paho.client.mqttv3.MqttException {
        Gson gson = new Gson();
        String jsonPayload = gson.toJson(messagePublishModel);
        MqttMessage mqttMessage = new MqttMessage(jsonPayload.getBytes());
        Mqtt.getInstance().publish(messagePublishModel.getTopic(), mqttMessage);
    }*/

}


