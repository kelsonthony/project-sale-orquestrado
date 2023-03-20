package com.kelsonthony.inventory.config.usecase;

import com.kelsonthony.inventory.adapters.out.UpdateInventoryAdapter;
import com.kelsonthony.inventory.application.core.usecase.CreditInventoryUseCase;
import com.kelsonthony.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditInventoryConfig {

    @Bean
    public CreditInventoryUseCase creditInventoryUseCase(
            FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
            UpdateInventoryAdapter updateInventoryAdapter

    ) {
    return new CreditInventoryUseCase(findInventoryByProductIdUseCase,
            updateInventoryAdapter);
    }

}
