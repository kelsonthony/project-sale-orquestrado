package com.kelsonthony.inventory.adapters.in.consumer;

import com.kelsonthony.inventory.adapters.out.message.SaleMessage;
import com.kelsonthony.inventory.application.core.domain.enums.SaleEvent;
import com.kelsonthony.inventory.application.ports.in.DebitInventoryInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToDebitInventoryConsumer {

    @Autowired
    private DebitInventoryInputPort debitInventoryInputPort;

    @KafkaListener(topics = "tp-saga-inventory", groupId = "inventory-debit")
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.PREPARE_INVENTORY.equals(saleMessage.getSaleEvent())) {
            log.info("Início da separação da mercadoria");
            debitInventoryInputPort.debit(saleMessage.getSale());
            log.info("Fim da separação da mercadoria");
        }
    }
}
