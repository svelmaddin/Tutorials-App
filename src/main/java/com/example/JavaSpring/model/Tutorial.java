package com.example.JavaSpring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tutorial {
    private Long id;
    private String title;
    private String description;
    private Boolean published;
}
