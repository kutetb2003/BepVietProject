package com.bepviet.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ReviewDto {
    private LocalDate reviewDate;
    private String comment;
    private Integer rating;
}
