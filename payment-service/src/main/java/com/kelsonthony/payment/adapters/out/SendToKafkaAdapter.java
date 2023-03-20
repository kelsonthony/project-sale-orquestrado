package com.kelsonthony.payment.adapters.out;

import com.kelsonthony.payment.adapters.out.message.SaleMessage;
import com.kelsonthony.payment.application.core.domain.Sale;
import com.kelsonthony.payment.application.core.domain.enums.SaleEvent;
import com.kelsonthony.payment.application.ports.out.SendToKafkaOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendToKafkaAdapter implements SendToKafkaOutputPort {

    @Autowired
    private KafkaTemplate<String, SaleMessage> kafkaTemplate;
    @Override
    public void send(Sale sale, SaleEvent saleEvent) {
        var saleMessage = new SaleMessage(sale, saleEvent);
        kafkaTemplate.send("tp-saga-orchestrator", saleMessage);
    }
}
