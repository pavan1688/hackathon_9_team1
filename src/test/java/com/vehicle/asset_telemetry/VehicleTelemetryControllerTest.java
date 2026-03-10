package com.vehicle.asset_telemetry;

import com.vehicle.asset_telemetry.controller.VehicleTelemetryController;
import com.vehicle.asset_telemetry.model.ResponseModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class VehicleTelemetryControllerTest {
    @InjectMocks
    private VehicleTelemetryController vehicleTelemetryController;

    @Test
    void greetingSuccess(){
        ResponseEntity<ResponseModel<String>> res = vehicleTelemetryController.dummyAPI("kunal");
        Assertions.assertNotNull(res);
        Assertions.assertNotNull(res.getBody());
        Assertions.assertEquals("Hi kunal",res.getBody().getData());
    }
}
