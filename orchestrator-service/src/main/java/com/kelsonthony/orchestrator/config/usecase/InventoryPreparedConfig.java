package com.kelsonthony.orchestrator.config.usecase;

import com.kelsonthony.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.kelsonthony.orchestrator.application.core.usecase.InventoryFailureUseCase;
import com.kelsonthony.orchestrator.application.core.usecase.InventoryPreparedUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryPreparedConfig {

    @Bean
    public InventoryPreparedUseCase inventoryFailureUseCase(
            SendSaleToTopicAdapter sendSaleToTopicAdapter) {
        return new InventoryPreparedUseCase(sendSaleToTopicAdapter);
    }
}
