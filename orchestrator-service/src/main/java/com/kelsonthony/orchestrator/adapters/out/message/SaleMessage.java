package com.kelsonthony.orchestrator.adapters.out.message;

import com.kelsonthony.orchestrator.application.core.domain.Sale;
import com.kelsonthony.orchestrator.application.core.domain.enums.SaleEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleMessage {
    private Sale sale;

    private SaleEvent saleEvent;


}
