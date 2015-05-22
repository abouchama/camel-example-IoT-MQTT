package com.abouchama;

import java.net.URISyntaxException;
import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class only publish MQTT messages to a define topic with a certain frequency.
 * 

 */
public class MQTT_Producer implements Runnable {
    
    private static final Logger LOG = LoggerFactory.getLogger(MQTT_Producer.class);
    
    private String m_clientID;
    
    public MQTT_Producer(String clientID) {
        m_clientID = clientID;
    }

    public void run() {
        MQTT mqtt = new MQTT();
        try {
            mqtt.setHost("localhost", 1883);
            mqtt.setUserName("admin");
            mqtt.setPassword("admin");
        } catch (URISyntaxException ex) {
            LOG.error(null, ex);
            return;
        }
        
        mqtt.setClientId(m_clientID);
        BlockingConnection connection = mqtt.blockingConnection();
        try {
            connection.connect();
        } catch (Exception ex) {
            LOG.error("Cant't CONNECT to the server", ex);
            return;
        }
        
        //TODO loop
        try {
            LOG.info("Publishing");
            connection.publish("iot-mqtt", "Command=ON,Latitude=48.85837,Longitude=2.294481000000019".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "Command=ON,Latitude=51.5073509,Longitude=-0.12775829999998223".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "Command=ON,Latitude=33.9715904,Longitude=-6.849812899999961".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "Command=ON,Latitude=46.818188,Longitude=8.227511999999933".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "Command=ON,Latitude=49.815273,Longitude=6.129583000000025".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "Command=ON,Latitude=53.5510846,Longitude=9.99368179999999".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "Command=ON,Latitude=48.85837,Longitude=2.294481000000019".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "Command=ON,Latitude=51.5073509,Longitude=-0.12775829999998223".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "Command=ON,Latitude=33.9715904,Longitude=-6.849812899999961".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "Command=ON,Latitude=33.9715904,Longitude=-6.849812899999961".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "Command=ON,Latitude=33.9715904,Longitude=-6.849812899999961".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "Command=ON,Latitude=33.9715904,Longitude=-6.849812899999961".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "Command=ON,Latitude=46.818188,Longitude=8.227511999999933".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "Command=ON,Latitude=49.815273,Longitude=6.129583000000025".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "Command=ON,Latitude=53.5510846,Longitude=9.99368179999999".getBytes(), QoS.AT_MOST_ONCE, false);            
             
        } catch (Exception ex) {
            LOG.error("Cant't PUSBLISH to the server", ex);
            return;
        }
        try {
            LOG.info("Disconneting");
            connection.disconnect();
            LOG.info("Disconnected");
        } catch (Exception ex) {
            LOG.error("Cant't DISCONNECT to the server", ex);
        }
    }
    
}