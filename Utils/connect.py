import json
import time
import random
import paho.mqtt.client as mqtt

BROKER = "mqtt.example.com"
PORT = 1883
TOPIC = "fleet/FLEET001/vehicle/{vin}/telemetry"
# TODO
# username and password needed for client connections.
#


client = mqtt.Client()

def publish_message(payload, vin="TESTVIN123"):
    # Use authorize the certificates
    topic = TOPIC.format(vin=vin)
    (rc, mid) = client.publish(topic, json.dumps(payload), qos=1)
    return rc, mid

def disconnect_client():
    """Disconnect client"""
    client.disconnect()

def offline_broker():
    """Test the offline brust"""
    # TODO connect the client with the invalid broker.
    pass