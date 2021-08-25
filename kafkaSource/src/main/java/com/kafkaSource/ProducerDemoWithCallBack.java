package com.kafkaSource;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemoWithCallBack {
    static Logger logger = LoggerFactory.getLogger(ProducerDemoWithCallBack.class);
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        KafkaProducer<String,String> producer = new KafkaProducer<String, String>(properties);

        for(int i=0;i<10;i++){

            ProducerRecord<String,String> record = new ProducerRecord<>("first_topic","My name is Nilesh :"+i);
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if(e== null){
                        logger.info("Topic :"+recordMetadata.topic() +"/n"
                                +"Partition : "+recordMetadata.partition() + "/n"
                                +"offset : "+recordMetadata.hasOffset()+"/n"
                                +"TimeStamp : "+ recordMetadata.timestamp());
                    }else{
                        logger.error("error while procudicing "+e);
                    }
                }
            });
        }
        producer.flush();
        producer.close();
    }
}


