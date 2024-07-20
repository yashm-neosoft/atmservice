/**
 * 
 */
package com.example.atmservice;

/**
 * 
 */
/*
@SpringBootTest
public class AtmTransactionServiceTests {
    @Autowired
    private KafkaTemplate<String, BalanceChangeEvent> kafkaTemplate;
    @Autowired
    private KafkaStreamsConfig streamsConfig;

    @Test
    public void testDeposit() {
    	BalanceChangeEvent depositEvent = new BalanceChangeEvent(123L, "DEPOSIT", 500.00);
        kafkaTemplate.send("balances", depositEvent);
        // Verify balance update
    }

    @Test
    public void testWithdrawal() {
    	BalanceChangeEvent withdrawEvent = new BalanceChangeEvent(123L, "WITHDRAW", 300.00);
        kafkaTemplate.send("balances", withdrawEvent);
        // Verify balance update and no overdraft
    }

    @Test
    public void testSimultaneousAccess() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        BalanceChangeEvent withdrawalEvent1 = new BalanceChangeEvent(1234L, "WITHDRAW", 50.00);
        BalanceChangeEvent withdrawalEvent2 = new BalanceChangeEvent(1234L, "WITHDRAW", 70.00);

        executorService.submit(() -> kafkaTemplate.send("balances", withdrawalEvent1));
        executorService.submit(() -> kafkaTemplate.send("balances", withdrawalEvent2));

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        // Verify balance update and no overdraft
    }
}
*/

