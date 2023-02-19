package com.messenger.service.messengerservice.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record MessageEvent(
    @NotBlank String name,
    @NotBlank String message,
    @NotBlank String imageUrl,
    @NotNull BigDecimal price,
    @NotBlank String link) {
}
