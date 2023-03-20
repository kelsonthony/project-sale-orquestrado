package com.kelsonthony.orchestrator.application.ports.in;

import com.kelsonthony.orchestrator.application.core.domain.Sale;
import com.kelsonthony.orchestrator.application.core.domain.enums.SaleEvent;

public interface WorkFlowInputPort {
    void execute(Sale sale);

    boolean isCalledByTheEvent(SaleEvent saleEvent);
}
