package com.kelsonthony.inventory.application.core.usecase;

import com.kelsonthony.inventory.application.core.domain.Sale;
import com.kelsonthony.inventory.application.ports.in.CreditInventoryInputPort;
import com.kelsonthony.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.kelsonthony.inventory.application.ports.out.UpdateInventoryOutputPort;

public class CreditInventoryUseCase implements CreditInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;

    private final UpdateInventoryOutputPort updateInventoryOutputPort;



    public CreditInventoryUseCase(
            FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
            UpdateInventoryOutputPort updateInventoryOutputPort
            ) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;

    }

    @Override
    public void credit(Sale sale) {
        var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
        inventory.creditQuanity(sale.getQuantity());
        updateInventoryOutputPort.update(inventory);


    }
}
