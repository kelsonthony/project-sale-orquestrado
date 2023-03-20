package com.kelsonthony.orchestrator.config.usecase;

import com.kelsonthony.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.kelsonthony.orchestrator.application.core.usecase.PaymentExecutedUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentExecutedConfig {

    @Bean
    public PaymentExecutedUseCase paymentExecutedUseCase(
            SendSaleToTopicAdapter sendSaleToTopicAdapter) {
        return new PaymentExecutedUseCase(sendSaleToTopicAdapter);
    }
}
