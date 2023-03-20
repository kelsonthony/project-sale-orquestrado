package com.kelsonthony.orchestrator.config.usecase;

import com.kelsonthony.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.kelsonthony.orchestrator.application.core.usecase.CreatedSaleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreatedSaleConfig {

    @Bean
    public CreatedSaleUseCase createdSaleUseCase(
            SendSaleToTopicAdapter sendSaleToTopicAdapter) {
        return new CreatedSaleUseCase(sendSaleToTopicAdapter);
    }
}
