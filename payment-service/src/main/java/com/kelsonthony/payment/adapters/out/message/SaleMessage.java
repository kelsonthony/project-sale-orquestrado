package com.kelsonthony.payment.adapters.out.message;

import com.kelsonthony.payment.application.core.domain.Sale;
import com.kelsonthony.payment.application.core.domain.enums.SaleEvent;
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
