package com.kelsonthony.orchestrator.adapters.out;

import com.kelsonthony.orchestrator.adapters.out.message.SaleMessage;
import com.kelsonthony.orchestrator.application.core.domain.Sale;
import com.kelsonthony.orchestrator.application.core.domain.enums.SaleEvent;
import com.kelsonthony.orchestrator.application.ports.out.SendSaleToTopicOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendSaleToTopicAdapter implements SendSaleToTopicOutputPort {

    @Autowired
    private KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent saleEvent, String topic) {
        var saleMessage = new SaleMessage(sale, saleEvent);
        kafkaTemplate.send(topic, saleMessage);
    }
}
