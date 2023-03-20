package com.kelsonthony.orchestrator.application.core.usecase;

import com.kelsonthony.orchestrator.application.core.domain.Sale;
import com.kelsonthony.orchestrator.application.core.domain.enums.SaleEvent;
import com.kelsonthony.orchestrator.application.ports.in.WorkFlowInputPort;
import com.kelsonthony.orchestrator.application.ports.out.SendSaleToTopicOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InventoryPreparedUseCase implements WorkFlowInputPort {

    private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    public InventoryPreparedUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
    }

    @Override
    public void execute(Sale sale) {
        log.info("Inicio do pagamento da venda");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.EXECUTE_PAYMENT, "tp-saga-payment");
        log.info("Pagamento enviado para a fila");
    }

    @Override
    public boolean isCalledByTheEvent(SaleEvent saleEvent) {
        return SaleEvent.INVENTORY_PREPARED.equals(saleEvent);
    }
}
