import pytest
import paho.mqtt.client as mqtt
from Utils.data import payload
from Utils.connect import publish_message

class TestMqttEndToEnd:
    """Test case for the message handler"""
    @pytest.mark.e2e
    def test_end_to_end(self):
        """Test EndToEnd message
        Testing Steps:
        connect via mqqt client using broker ,port, topic.and with correct payload.
        Authorization (certificates and fingerprints)
        Set QoS ( 1 ) for considering stale.
        check for the ack (0 , 1 )
        if 0 data will be storing in DB
        else Listener mqtt there we check the issue and fix and send the DLQ and again this will send back to queu
        """

        rc, mid = publish_message(payload)
        assert rc == 0, "Message was not published"


