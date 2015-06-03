Camel Example IoT with MQTT Protocol
====================================
The Business case for the Internet of Things -- indeed for everything becoming network connected.
The example is demonstrating how to get real time and value from IoT Data

The camel application poll a Topic with mqtt and publish results in real time using elasticsearch.

Add mqtt transport to A-MQ:

<transportConnector name="mqtt" uri="mqtt://0.0.0.0:1883"/>
    
Then install the Camel Route, we use MQTT Component in JBoss Fuse to poll in the message from broker. 
With the built-in component, it will save lots of code implementation time.

![alt tag](https://cloud.githubusercontent.com/assets/1347006/7936366/ac57435e-0938-11e5-831b-959188d8a84b.png)    
 
 >- **Kibana Dashboard:**
 
![alt tag](https://cloud.githubusercontent.com/assets/1347006/7936097/c789bd20-0936-11e5-95dd-7496dae922b7.png)
 
![alt tag](https://cloud.githubusercontent.com/assets/1347006/7772804/c23192a6-00a0-11e5-8f37-daba3d55ee1d.png)
  
   
 - **Article**
You can find the entire article here:
 
http://java.dzone.com/articles/make-your-iot-gateway-wifi

----------
To build this project use

mvn install

To run this example either embed the jar inside Spring
or to run the route from within Maven try

mvn camel:run
-------------

- **Tags:**
  Camel, IoT, M2M, Integration 