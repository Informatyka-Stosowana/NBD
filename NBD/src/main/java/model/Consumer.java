package model;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Consumer {

    private final List<KafkaConsumer<Integer, String>> consumerGroup = new ArrayList<>();
    private KafkaConsumer consumer;

    public Consumer() {

    }

    public Properties consumerInit() {
        Properties consumerConfig = new Properties();
        consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class.getName());
        consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        consumerConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "consumerGroup");
        consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka1:9192,kafka2:9292,kafka3:9392");

        return consumerConfig;
    }

    public void createConsumerGroup() {
        Properties consumerConfig = consumerInit();

        for (int i = 0; i < 2; i++) {
            KafkaConsumer<Integer, String> kafkaConsumer = new KafkaConsumer(consumerConfig);
            kafkaConsumer.subscribe(List.of("temat"));
            consumerGroup.add(kafkaConsumer);
        }
    }
}
