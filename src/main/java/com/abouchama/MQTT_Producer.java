package com.abouchama;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
            //java.util.Date date= new java.util.Date();
            Map<String, String> map = new HashMap<String, String>();
            //Map<String, Double> map = new HashMap<String, Double>();
            Date dNow = new Date( );
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd'T'HH:mm:ss.SSS");
            System.out.println("Current Date: " + ft.format(dNow));
            map.put("event_datetime", ft.format(dNow));
            map.put("pollution_degree",""+new Integer(0));
            map.put("latitude", ""+new Double(48.86670000000001));
            map.put("longitude", ""+new Double(2.3333000000000084));
            /*// Nantes 
            map.put("location", "47.2183710, -1.5536210");
            map.put("pollution_degree",""+new Integer(0));*/

            // Le Havre 
            map.put("location", "49.4943700, 0.1079290");
            map.put("pollution_degree",""+new Integer(1));

            
            /*// Paris 
            map.put("location", "48.8566140, 2.3522219");
            map.put("pollution_degree",""+new Integer(9));*/
            
            /*// Lyon
            map.put("location", "45.7640430, 4.8356590");
            map.put("pollution_degree",""+new Integer(5));*/
            
            /*// Lille
            map.put("location", "50.6292500, 3.0572560");
            map.put("pollution_degree",""+new Integer(5));*/
            
            /*// Monaco
            map.put("location", "43.7384176, 7.4246158");
            map.put("pollution_degree",""+new Integer(2));*/
            
            /*// Marseille
            map.put("location", "43.2964820, 5.3697800");
            map.put("pollution_degree",""+new Integer(3));*/
            
           /* // Toulouse
            map.put("location", "43.6046520, 1.4442090");
            map.put("pollution_degree",""+new Integer(1));*/
            
            /*// Brest
            map.put("location", "48.3903940, -4.4860760");
            map.put("pollution_degree",""+new Integer(7));*/
            
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            ObjectOutputStream o=new ObjectOutputStream(b);
            o.writeObject(map);
            o.close();
            byte bytes[]=b.toByteArray();
            LOG.info("Publishing");
            connection.publish("iot-mqtt", bytes, QoS.AT_MOST_ONCE, false);

            //connection.publish("iot-mqtt", obj.toString().getBytes("utf-8"), QoS.AT_MOST_ONCE, false);
            /*connection.publish("iot-mqtt", "pollutionDegree=4,Latitude=48.85837,Longitude=2.294481000000019".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "pollutionDegree=4,Latitude=51.5073509,Longitude=-0.12775829999998223".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "pollutionDegree=4,Latitude=33.9715904,Longitude=-6.849812899999961".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "pollutionDegree=4,Latitude=46.818188,Longitude=8.227511999999933".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "pollutionDegree=4,Latitude=49.815273,Longitude=6.129583000000025".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "pollutionDegree=4,Latitude=53.5510846,Longitude=9.99368179999999".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "pollutionDegree=9,Latitude=48.85837,Longitude=2.294481000000019".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "pollutionDegree=4,Latitude=51.5073509,Longitude=-0.12775829999998223".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "pollutionDegree=4,Latitude=33.9715904,Longitude=-6.849812899999961".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "pollutionDegree=4,Latitude=33.9715904,Longitude=-6.849812899999961".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "pollutionDegree=4,Latitude=33.9715904,Longitude=-6.849812899999961".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "pollutionDegree=6,Latitude=33.9715904,Longitude=-6.849812899999961".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "pollutionDegree=4,Latitude=46.818188,Longitude=8.227511999999933".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "pollutionDegree=4,Latitude=49.815273,Longitude=6.129583000000025".getBytes(), QoS.AT_MOST_ONCE, false);
            connection.publish("iot-mqtt", "pollutionDegree=4,Latitude=53.5510846,Longitude=9.99368179999999".getBytes(), QoS.AT_MOST_ONCE, false);*/            
             
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