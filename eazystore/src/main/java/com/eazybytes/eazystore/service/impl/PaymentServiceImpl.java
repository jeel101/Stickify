package com.eazybytes.eazystore.service.impl;

import com.eazybytes.eazystore.dto.PaymentIntentRequestDto;
import com.eazybytes.eazystore.dto.PaymentIntentResponseDto;
import com.eazybytes.eazystore.service.IPaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements IPaymentService {
    @Override
    public PaymentIntentResponseDto createPaymentIntent(PaymentIntentRequestDto paymentIntentRequestDto) {
        try {
            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                    .setAmount(paymentIntentRequestDto.amount())
                    .setCurrency(paymentIntentRequestDto.currency())
                    .addPaymentMethodType("card").build();
            PaymentIntent paymentIntent = PaymentIntent.create(params);
            return new PaymentIntentResponseDto(paymentIntent.getClientSecret());
        }catch (StripeException e){
            throw new RuntimeException("Failed to create payment intent", e);
        }
    }
}
