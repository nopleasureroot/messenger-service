package com.messenger.service.messengerservice.model;

import lombok.Builder;

public record DataConsumerEvent(
        DataConsumerEvent.Product product
) {

    @Builder
    public DataConsumerEvent {
    }

    public record Product(
        String name,
        String imageUrl,
        String link,
        Long price
    ) {
        @Builder
        public Product {
        }
    }
}