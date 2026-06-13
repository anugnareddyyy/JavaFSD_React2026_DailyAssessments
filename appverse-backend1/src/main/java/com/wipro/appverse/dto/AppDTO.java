package com.wipro.appverse.dto;

 /* Data Transfer Object for App
 */
import lombok.Data;

@Data
public class AppDTO {
    private Long id;
    private String name;
    private String category;
    private String description;
}

