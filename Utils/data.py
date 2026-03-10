import time

payload = {
        "schemaVersion": "1.0",
        "vin": "TESTVIN123",
        "fleetId": "FLEET001",
        "timestamp": time.strftime("%Y-%m-%dT%H:%M:%SZ", time.gmtime()),
        "speed": 65,
        "battery": 78
    }

invalid_payload = {
        "invalid_schemaVersion": "1.0",
        "invalid_vin": "TESTVIN123",
        "invalid_fleetId": "FLEET001",
        "invalid_timestamp": time.strftime("%Y-%m-%dT%H:%M:%SZ", time.gmtime()),
        "invalid_speed": 65,
        "invalid_battery": 789
}