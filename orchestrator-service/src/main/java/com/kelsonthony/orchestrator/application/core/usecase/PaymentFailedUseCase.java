package com.kelsonthony.orchestrator.application.core.usecase;

import com.kelsonthony.orchestrator.application.core.domain.Sale;
import com.kelsonthony.orchestrator.application.core.domain.enums.SaleEvent;
import com.kelsonthony.orchestrator.application.ports.in.WorkFlowInputPort;
import com.kelsonthony.orchestrator.application.ports.out.SendSaleToTopicOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaymentFailedUseCase implements WorkFlowInputPort {

    private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    public PaymentFailedUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
    }

    @Override
    public void execute(Sale sale) {
        log.info("Erro no pagamento.");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.EXECUTE_ROLLBACK, "tp-saga-inventory");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.CANCEL_SALE, "tp-saga-sale");
        log.info("Roolback do estoque e cancelamento da venda postados na fila.");

    }

    @Override
    public boolean isCalledByTheEvent(SaleEvent saleEvent) {
        return SaleEvent.PAYMENT_FAILED.equals(saleEvent);
    }
}
