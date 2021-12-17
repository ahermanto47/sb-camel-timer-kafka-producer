package org.southforestlab.integration;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class TimerToKafkaRouter extends RouteBuilder {
  
	
    @Override
    public void configure() throws Exception {


    	from("timer:foo?period={{period}}").routeId("timer")
    	    .setBody().simple("Hello")
      	    .to("kafka:{{producer.topic}}?brokers={{kafka.host}}:{{kafka.port}}");

    }

}

