Camel Example IoT with MQTT Protocol
====================================
The Business case for the Internet of Things -- indeed for everything becoming network connected.
The example is demonstrating how to get real time and value from IoT Data

The camel application poll a Topic with mqtt and publish results in real time using web socket to a web page.

----------
To build this project use

mvn install

To run this example either embed the jar inside Spring
or to run the route from within Maven try

mvn camel:run

For more help see the Apache Camel documentation

    http://camel.apache.org/

![alt tag](https://cloud.githubusercontent.com/assets/1347006/7772386/187edfa4-009e-11e5-96fc-ad2f881dfd2b.png)    
    
There are four main tasks the GPS Application needs to take care of for this example:
- Publish GPS location via MQTT
- Listen for commands via MQTT

e.g;

| Command  | Latitude  | Longitude           |
| :------- | ---------:| :---------:         |
| ON       | 48.85837  | 2.294481000000019   |
| ON       | 51.5073509| -0.12775829999998223|
| ON       | 33.9715904| -6.849812899999961  |

After deploying the camel application and requesting the past page, the app returns history for both values read and commands sent.  
There is a separate Command model similar to the one above to request “field:lightmode” whatevers.
 
 
![alt tag](https://cloud.githubusercontent.com/assets/1347006/7772804/c23192a6-00a0-11e5-8f37-daba3d55ee1d.png)
 
 
 MQTT Client - Publish / Subscribe
 
 
>- **Conclusion:**

>Admittedly, this example is very simple.
>But I believe it is a good illustration of how I went from bare Arduino breadboard to retrieving sensor values from a cloud-hosted API in less than a day.  
>Good luck with your projects!
 
 
 
- **Tools:**
 
 Simple WebSocket Client -- Google Chrome Application
 
 MQTTLens -- Google Chrome Application
 
 - **Tags:**
 
 Camel, IoT, M2M, Integration
 
 - **Links**
 
 https://www.constellationr.com/content/iot-data-flow-management-science-getting-real-value-iot-data
 
 - **Article**
 The revolution of device and systems is allowing these parties to interact with each other via 
 Internet automatically, by year 2020, there will be more then 50 Billions of device and things 
 connecting to the internet. 
 And Within the vast majority of device there are many standard protocols for them to interact and connect. 
 MQTT is one of them. A-MQ supports MQTT[^MQTT], Message Queuing Telemetry Transport. 
 In this session we will give some basic background on AMQP and demo how A-MQ can connect via Apache Qpid. And discuss the value it brings to the Enterprise.
 
 [^MQTT]: [MQTT](http://mqtt.org/) is a machine-to-machine (M2M)/"Internet of Things" connectivity protocol. 
 It was designed as an extremely lightweight publish/subscribe messaging transport. 
 It is useful for connections with remote locations where a small code footprint is required and/or network bandwidth is at a premium.