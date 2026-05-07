package com.example.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record MobileDto(
        Long id,
        @NotBlank(message = "Brand must be supplied")
 String brand,
@NotBlank(message = "model must be supplied")
 String model,
@Min(value = 100,message = "price must be greater than 100")
Double price,
@Min(value = 100,message = "stock must be greater than 1")
Integer stock
)
{
 }

