/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamgenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 *
 * @author root
 */
public class StreamGeneratorFM {

    public static final long LONGSTART = 2000000000;
    public static final int NUMDISCTELEMENTS = 1500000;
    public static final int MAXRANDOM = 1000000;
    public static final int RANDOMLIMIT = 1500000;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String topicName = "LuisTopic";
        String anyKey = "key1";

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.LongSerializer");

        Producer<String, Long> producer;
        producer = new org.apache.kafka.clients.producer.KafkaProducer<>(props);
        List<Long> list = new ArrayList<>();
        ProducerRecord<String, Long> record;

        for (long i = LONGSTART; i <= LONGSTART + NUMDISCTELEMENTS; i++) {
            record = new ProducerRecord<>(topicName, anyKey, i);
            list.add(i);
            producer.send(record);
        }

        int countRandom = 0;
        long tem;
        Random rand = new Random();
        System.out.println("Distinct elements ends. Starting random elements...");
        while (countRandom < MAXRANDOM) {
            tem = LONGSTART + (rand.nextInt(RANDOMLIMIT) + 1);
            record = new ProducerRecord<>(topicName, anyKey, tem);
            producer.send(record);
            countRandom++;
            
        }

        producer.close();

        System.out.println("Producer for Flajolet Martin Completed. List size: " + list.size());
    }

}
