package com.scala.Kafka

import java.util.Properties
import org.apache.kafka.clients.consumer.KafkaConsumer

object SimpleConsumer {
  def main(args: Array[String]): Unit = {
    
    // step 1.0 : agruments test
         if(args.length == 0){
           System.out.println("Entrer le nom du topic");
           return;
        }
        val topicName = args(0);
    
    // step 2.0 : create a Properties object
        val props = new Properties()
    
    // 3.0 add configurations to Properties object
        props.put("bootstrap.servers", "localhost:9092")
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
        props.put("group.id", "something")
     
    // 4.0 create the KafkaProducer object
       val consumer = new KafkaConsumer[String, String](props)
        // 4.1 subscribe to single TOPIC
         consumer.subscribe(java.util.Collections.singletonList(topicName)) 
       
    // 5.0 let's go  

          while (true) {
            val records = consumer.poll(100)
            val iterator = records.iterator()
            
            while(iterator.hasNext())
            { 
              println(iterator.next())
            } 
            
          }
          
  }
}