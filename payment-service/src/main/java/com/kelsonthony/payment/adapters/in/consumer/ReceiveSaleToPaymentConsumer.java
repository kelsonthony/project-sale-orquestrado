package com.kelsonthony.payment.adapters.in.consumer;

import com.kelsonthony.payment.adapters.out.message.SaleMessage;
import com.kelsonthony.payment.application.core.domain.enums.SaleEvent;
import com.kelsonthony.payment.application.ports.in.SalePaymentInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToPaymentConsumer {

    @Autowired
    private SalePaymentInputPort salePaymentInputPort;

    @KafkaListener(topics = "tp-saga-payment", groupId = "payment")
    public void receive(SaleMessage saleMessage){
        if (SaleEvent.EXECUTE_PAYMENT.equals(saleMessage.getSaleEvent())) {
            log.info("Início do pagamento");
            salePaymentInputPort.payment(saleMessage.getSale());
            log.info("Fim do pagamento");
        }
    }
}
