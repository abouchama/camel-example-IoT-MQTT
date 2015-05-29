package com.abouchama;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

/**
 * A processor that transform the body from Bytes to Json.
 */

public class ByteToJson implements Processor {

  @Override
  public void process(Exchange exchange) throws IOException, ClassNotFoundException {
    Message inMessage = exchange.getIn();
    if (inMessage != null) {
      byte[] bytes = inMessage.getBody(byte[].class);

      ByteArrayInputStream b = new ByteArrayInputStream(bytes);
      ObjectInputStream o = new ObjectInputStream(b);
      Map<String, String> map = (Map<String, String>) o.readObject();
      o.close();
      exchange.getIn().setBody(map);
    }
  }
}
