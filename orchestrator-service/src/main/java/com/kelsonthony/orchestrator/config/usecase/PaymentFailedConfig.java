package com.kelsonthony.orchestrator.config.usecase;

import com.kelsonthony.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.kelsonthony.orchestrator.application.core.usecase.PaymentFailedUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentFailedConfig {

    @Bean
    public PaymentFailedUseCase paymentFailedUseCase(
            SendSaleToTopicAdapter sendSaleToTopicAdapter) {
        return new PaymentFailedUseCase(sendSaleToTopicAdapter);
    }
}
