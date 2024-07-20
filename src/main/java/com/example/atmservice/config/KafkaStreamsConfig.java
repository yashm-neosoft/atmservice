package com.example.atmservice.config;

import com.example.atmservice.events.EventProcessor;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.config.KafkaStreamsConfiguration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafkaStreams
public class KafkaStreamsConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean(name = "defaultKafkaStreamsConfig")
    public KafkaStreamsConfiguration defaultKafkaStreamsConfig() {
        Map<String, Object> props = new HashMap<>();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "atm-service");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        return new KafkaStreamsConfiguration(props);
    }

//    @Bean
//    public KafkaStreams kafkaStreams(StreamsBuilder builder, EventProcessor eventProcessor) {
//        KStream<String, String> transactionsStream = builder.stream("transactions");
//        eventProcessor.process(transactionsStream);
//        return new KafkaStreams(builder.build(), kStreamsConfig());
//    }

    @Bean
    public KStream<String, String> kStream(StreamsBuilder streamsBuilder, EventProcessor eventProcessor) {
        KStream<String, String> transactionsStream = streamsBuilder.stream("transactions");
        eventProcessor.process(transactionsStream);
        transactionsStream.to("balances");
        return transactionsStream;
    }


//    //@Bean(name = StreamsBuilderFactoryBean.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
//    public KStream<String, Double> kStream(StreamsBuilder streamsBuilder) {
//        KStream<String, Double> transactionsStream = streamsBuilder.stream("transactions");
//
//        e
//
//        return transactionsStream;
//    }
}



