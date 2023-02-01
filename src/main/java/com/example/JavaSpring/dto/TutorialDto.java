package com.example.JavaSpring.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@ApiModel(value = "TutorialModel" , description = "Model who represents a tutorial entity")
public class TutorialDto {
    @ApiModelProperty(value = "Tutorial's id")
    private Long id;

    @ApiModelProperty(value = "Tutorial's title", required = true)
    private String title;

    @ApiModelProperty(value = "Tutorial's description", required = true)
    private String description;

    @ApiModelProperty(value = "Is Tutorial published", required = true)
    private Boolean published;
}
