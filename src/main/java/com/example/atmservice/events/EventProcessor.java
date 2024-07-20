package com.example.atmservice.events;


import com.example.atmservice.service.AccountService;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.stereotype.Component;

@Component
public class EventProcessor {

    @Autowired
    private AccountService accountService;

    public synchronized void process(KStream<String, String> transactionsStream) {
        transactionsStream
                .foreach((key, value) -> {
                    String[] parts = value.split(",");
                    String type = parts[0];
                    Long accountId = Long.valueOf(parts[1]);
                    double amount = Double.parseDouble(parts[2]);

                    if ("DEPOSIT".equals(type)) {
                        accountService.deposit(accountId, amount);
                    } else if ("WITHDRAW".equals(type)) {
                        accountService.withdraw(accountId, amount);
                    }
                });
    }


}

