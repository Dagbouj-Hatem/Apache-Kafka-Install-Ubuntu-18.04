package com.scala.Kafka

import java.util.{Date, Properties}

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import java.io.FileNotFoundException
import java.io.IOException
import scala.io.Source

object Producer {
  
   def main(args: Array[String]): Unit = {
     
     // step 1:  Verifier que le topic est donne en argument
      if(args.length == 0){
         System.out.println("Entrer le nom du topic");
         return;
      }

      // step 2: Assigner topicName a une variable
      val  topicName = args(0)
      
     // step 3: Creer une instance de proprietes pour acceder aux configurations du producteur
      val  props = new Properties()
      
      // step 4:  configurations
      
       // Assigner l'identifiant du serveur kafka
      props.put("bootstrap.servers", "localhost:9092")

      // Definir un acquittement pour les requetes du producteur
      props.put("acks", "all")

      // Si la requete echoue, le producteur peut reessayer automatiquemt
      props.put("retries", "0")

      // Specifier la taille du buffer size dans la config
      props.put("batch.size", "16384");

      // buffer.memory controle le montant total de memoire disponible au producteur pour le buffering
      props.put("buffer.memory", "33554432");

       props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
       props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
      
       
       //step 5 : creation d'un KafkaProducer Object
       
       val producer = new KafkaProducer[String, String](props)
       
       // step 6 : envoie des données (Publish data) 
       
           // for loop execution with a range
          for( a <- 20 to 100){
            
             println( "Value of a: " + a ); // pour le test
             val record = new ProducerRecord(topicName, "key", s"$a") // create record
                   producer.send(record) //send record
          }
   }
}