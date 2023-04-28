package com.example.demo.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DreamDto extends BaseDto<Long>{
    private Long id;
    private Long duration;//in minutes
    private Long energyLevel;
    private Long stress;
}
