package com.kelsonthony.orchestrator.application.core.usecase;

import com.kelsonthony.orchestrator.application.core.domain.Sale;
import com.kelsonthony.orchestrator.application.core.domain.enums.SaleEvent;
import com.kelsonthony.orchestrator.application.ports.in.WorkFlowInputPort;
import com.kelsonthony.orchestrator.application.ports.out.SendSaleToTopicOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreatedSaleUseCase implements WorkFlowInputPort {

    private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    public CreatedSaleUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
    }

    @Override
    public void execute(Sale sale) {
        log.info("Inicio da separação do estoque");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.PREPARE_INVENTORY, "tp-saga-inventory");
        log.info("Enviado para a fila da separação de estoque");
    }

    @Override
    public boolean isCalledByTheEvent(SaleEvent saleEvent) {
        return SaleEvent.CREATED_SALE.equals(saleEvent);
    }
}
