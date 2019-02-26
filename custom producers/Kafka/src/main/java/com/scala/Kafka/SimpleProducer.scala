package com.scala.Kafka

import java.util.{Date, Properties}

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import java.io.FileNotFoundException
import java.io.IOException
import scala.io.Source 

object SimpleProducer {
  
  def main(args: Array[String]): Unit = {
     // 1.0 Disable the logger 
        //Logger.getLogger("org").setLevel(Level.OFF)
        //Logger.getLogger("akka").setLevel(Level.OFF)
        
      // 2.0 Test arguments 
            if(args.length < 4 )
            {
              //System.err.println(" Usage :  <Hostname> <Port>");
              System.err.println("Usage: SimpleProducer <TopicName> <FileName> <LineNumber> <SleepDuration>")
              System.exit(1)
            }  
            // If valid arguments 
             val TOPIC=args(0)
             val filename = args(1)
             val numberOfLinePerWindow= args(2).toInt;
             val durationWindow = args(3).toInt;
             
       // 3.0 create Properties object
       val  props = new Properties()
       
       // 4.0 add configurations to Properties object
       props.put("bootstrap.servers", "localhost:9092")
       props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
       props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
      
       // 5.0 create the KafkaProducer object
       val producer = new KafkaProducer[String, String](props)
         
       
       // 6.0 let's go 
       var nbline=numberOfLinePerWindow;
       
       try {
               for (line <- Source.fromFile(filename).getLines()) 
               {
                   //println(line)
                   val record = new ProducerRecord(TOPIC, "key", s"$line") // cast line to string
                   producer.send(record)
                   // test 
                   nbline-=1;
                   if(nbline==0)
                   {
                      Thread.sleep(durationWindow)
                      nbline= numberOfLinePerWindow
                   }
               }
               
               
           } catch {
              case ex: FileNotFoundException => println("Couldn't find that file.")
              case ex: IOException => println("Had an IOException trying to read that file")
            }
    
       println(" End OF File with Success ")
       producer.close()

  } 

} 