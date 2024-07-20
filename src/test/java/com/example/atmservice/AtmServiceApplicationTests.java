package com.example.atmservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = { "transactions", "balances" })
public class AtmServiceApplicationTests {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;

	@Test
	public void testDeposit() {
		kafkaTemplate.send("transactions", "123", "DEPOSIT,123,100.0");

		KafkaConsumer<String, Double> consumer = createConsumer();
		consumer.subscribe(Collections.singleton("balances"));
		ConsumerRecords<String, Double> records = consumer.poll(1000);

		for (var record : records) {
			assertEquals("123", record.key());
			assertEquals(100.0, record.value());
		}
	}

	private KafkaConsumer<String, Double> createConsumer() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, DoubleDeserializer.class);
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		return new KafkaConsumer<>(props);
	}
}
*/

