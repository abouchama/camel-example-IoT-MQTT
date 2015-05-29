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

Add mqtt transport to A-MQ:

<transportConnector name="mqtt" uri="mqtt://0.0.0.0:1883"/>

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
 MQTT is one of them. A-MQ supports MQTT, Message Queuing Telemetry Transport. 
 In this session we will give some basic background on AMQP and demo how A-MQ can connect via Apache Qpid. And discuss the value it brings to the Enterprise.
 
 1. What's Internet of Things ?
Billions of interconnected smart devices and machines measuring, collecting, analyzing
and sharing useful information:
- Intelligent systems 
- Industrialized internet
- Machine-to-Macine (M2M)

Collect IoT Information --> Agregate IoT data reliably (A-MQ) and Real-time notification (FUSE)
Analyze IoT Information --> IoT Data --> A-MQ --> Fuse
 
 
 [MQTT](http://mqtt.org/) is a machine-to-machine (M2M)/"Internet of Things" connectivity protocol. 
 It was designed as an extremely lightweight publish/subscribe messaging transport. 
 It is useful for connections with remote locations where a small code footprint is required and/or network bandwidth is at a premium.
 
 Companies are already making MQTT enabled things:
 -SCADA monitors/controller
 -Utility metering devices
 -GPS/GSM tracking devices
 
 OASIS standard
 
 
The Internet of Things (IoT) will include 25 billion installed units by 2020 and will impact all major vertical industries. 
IoT will create new business models, facilitate digital business and radically alter the way we understand the delivery of "IT" services today. 
This webinar explores how should you prepare for this opportunity, and how this will impact you, your customers and the overall market.

What IoT is and why it is happening now
Which industries will be most affected by this upcoming change, and where the opportunities will be
How to prepare for this change and how Apache Camel can helps us accomplish that in practice. 
http://java.dzone.com/articles/make-your-iot-gateway-wifi

An Internet of Things
"In the next century, planet earth will don an electronic skin. 
It will use the Internet as a scaffold to support and transmit its sensations." - Neil Gross 1999


Degradation of air quality in cities is the result of a complex interaction between natural and anthropogenic environmental conditions. 
With the increase in urbanization and industrialization and due to poor control on emissions and little use of catalytic converters, 
a great amount of particulate and toxic gases are produced [1]. 
The objective of this paper is to monitor air pollution on roads and track vehicles which cause pollution over a specified limit. 
Increasing number of automobiles is a serious problem that has been around for a very long time. 
This paper proposes use of Internet of Things(IoT)[2] to address this problem. 
Here, combination of Wireless Sensor Network and Electrochemical Toxic Gas Sensors and the use of a 
Radio Frequency Identification (RFID) tagging system to monitor car pollution records anytime anywhere 
