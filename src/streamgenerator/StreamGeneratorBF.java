
package streamgenerator;

import java.util.Properties;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 *
 * @author Luis Gonzalez
 */
public class StreamGeneratorBF {

    
    public static final int STARTNUM = 1000000000;
    public static final int ELEMENTSNUM = 100000;

    public static void main(String[] args) {
        String topicName = "BloomFilterTopic";
        String anyKey = "key1";

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.LongSerializer");

        Producer<String, Long> producer;
        producer = new org.apache.kafka.clients.producer.KafkaProducer<>(props);

        ProducerRecord<String, Long> record;
        //Elements in S
        for (long i = STARTNUM; i < STARTNUM + ELEMENTSNUM ; i++) {
            record = new ProducerRecord<>(topicName, anyKey, i);
            producer.send(record);
        }

        //Elements not in S
        for (long i = STARTNUM * 2; i < STARTNUM * 2 + ELEMENTSNUM * 4; i++) {
            record = new ProducerRecord<>(topicName, anyKey, i);
            producer.send(record);
        }

        producer.close();

        System.out.println("Producer for Bloom Filter Completed.");
    }

}
