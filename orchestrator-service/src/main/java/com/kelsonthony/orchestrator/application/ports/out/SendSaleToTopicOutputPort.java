package com.kelsonthony.orchestrator.application.ports.out;

import com.kelsonthony.orchestrator.application.core.domain.Sale;
import com.kelsonthony.orchestrator.application.core.domain.enums.SaleEvent;

public interface SendSaleToTopicOutputPort {
    void send(Sale sale, SaleEvent saleEvent, String topic);
}
