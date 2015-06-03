Camel Example IoT with MQTT Protocol
====================================
The Business case for the Internet of Things -- indeed for everything becoming network connected.
The example is demonstrating how to get real time and value from IoT Data

The camel application poll a Topic with mqtt and publish results in real time using elasticsearch.

>- ** Implementation view: **

1. Add mqtt transport to A-MQ:

<transportConnector name="mqtt" uri="mqtt://0.0.0.0:1883"/>
    
2. Then install the Camel Route, we use MQTT Component in JBoss Fuse to poll in the message from broker. 
With the built-in component, it will save lots of code implementation time.

![alt tag](https://cloud.githubusercontent.com/assets/1347006/7936366/ac57435e-0938-11e5-831b-959188d8a84b.png)    
 
 3. Elasticsearch
 create a new index, with the following mapping:
 
 curl -XPUT 'http://localhost:9200/twitter/_mapping/tweet' -d '
{
    "tweet" : {
        "properties" : {
            "event_datetime" : {"type" : "date"},
      "pollution_degree" : {"type" : "integer"},
      "latitude" : {"type" : "double"},
      "longitude" : {"type" : "double"},
      "location" : {"type" : "geo_point"}
        }
    }
}
'

4. Kibana Dashboard: 

- Create a visualisation TileMap based on location field
- Create a visualisation metrics based on pollution degree
- Create a visualisation metrics based on pollution degree & event_datetime

You should obtain the following dashboard: 

 >- **Kibana Dashboard:**
 
![alt tag](https://cloud.githubusercontent.com/assets/1347006/7936097/c789bd20-0936-11e5-95dd-7496dae922b7.png)
  
   
 - **Article**
You can find the entire article here:
 
http://bushorn.com/flow-activity-monitoring-logging-analazying-and-monitoring-data-of-our-integration-flows-camel-using-elasticsearch-logstash-and-kibana/