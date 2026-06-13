package com.wipro.appverse.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class AppDTO {

    private Long id;

    @NotBlank(message = "App name is required")
    private String name;

    @NotBlank(message = "Category is required")
    private String category;

    @Size(max = 100, message = "Description must be less than 100 characters")
    private String description;
}
