### Install and Configure Apache Kafka on Ubuntu 18.04

## Introduction
Apache Kafka is an open-source scalable and high-throughput messaging system developed by the Apache Software Foundation written in Scala. Apache Kafka is specially designed to allow a single cluster to serve as the central data backbone for a large environment. It has a much higher throughput compared to other message brokers systems like ActiveMQ and RabbitMQ. It is capable of handling large volumes of real-time data efficiently. You can deploy Kafka on single Apache server or in a distributed clustered environment.

## Requirements

    A Ubuntu 18.04 Desktop. 
    Oracle JDK 8.
    net-tools ( using : $sudo apt install net-tools) to install it. 

### 1.0 Install ZooKeeper

Before installing Apache Kafka, you will need to have zookeeper available and running. ZooKeeper is an open source service for maintaining configuration information, providing distributed synchronization, naming and providing group services.

By default ZooKeeper package is available in Ubuntu's default repository, you can install it by running the following command:

    sudo apt-get install zookeeperd

Once installation is finished, it will be started as a daemon automatically. By default ZooKeeper will run on port 2181.

You can test it by running the following command:

    netstat -ant | grep :2181

If everything's fine, you should see the following Output:

    tcp6       0      0 :::2181                 :::*                    LISTEN

Link : https://devops.ionos.com/tutorials/install-and-configure-apache-kafka-on-ubuntu-1604-1/

### 2.0 Install and Start Kafka Server

please visit this link to  more informations : https://kafka.apache.org/quickstart






