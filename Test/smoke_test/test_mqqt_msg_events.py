import pytest
import paho.mqtt.client as mqtt
from Utils.data import *
from Utils.connect import *

class TestMqttEventHandler:
    """Test case for the message handler"""
    @pytest.mark.smoke
    def test_happy_path(self):
        """Test the happy path"""
        rc, mid = publish_message(payload)
        assert rc == 0, "Message was not published"

    @pytest.mark.smoke
    def test_duplicate_message(self):
        """Test the duplicate message"""
        rc, mid = publish_message(payload)
        assert rc == 0, "Message was not published"
        rc, mid = publish_message(payload)
        assert rc == 0, "Message was not published"

    @pytest.mark.smoke
    def test_out_order(self):
        """Test the out order message"""
        payload["timestamp"] = "2026-03-09T15:57:00Z"
        publish_message(payload)

    @pytest.mark.smoke
    def test_invalid_payload(self):
        """Test the invalid payload"""
        bad_payload = {
            "fleetId": "FLEET001",
            "timestamp": time.strftime("%Y-%m-%dT%H:%M:%SZ", time.gmtime()),
            "speed": 60,
            "battery": 80
        }
        rc, mid = publish_message(bad_payload)

    def test_offline_brust(sel):
        """Test the offline brust"""
        disconnect_client()
        rc, mid = publish_message(payload)
        assert rc == 0, "Message was not published"

    def test_invalid_broker(sel):
        """Test the offline broker"""
        # TODO Prove the invalid broker
        pass




