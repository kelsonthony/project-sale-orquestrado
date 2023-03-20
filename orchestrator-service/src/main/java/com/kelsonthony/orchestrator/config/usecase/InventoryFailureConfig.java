package com.kelsonthony.orchestrator.config.usecase;

import com.kelsonthony.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.kelsonthony.orchestrator.application.core.usecase.InventoryFailureUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryFailureConfig {

    @Bean
    public InventoryFailureUseCase invetonryFailureUseCase(
            SendSaleToTopicAdapter sendSaleToTopicAdapter) {
        return new InventoryFailureUseCase(sendSaleToTopicAdapter);
    }
}
