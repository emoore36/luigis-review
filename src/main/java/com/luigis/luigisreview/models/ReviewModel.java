package com.luigis.luigisreview.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewModel {

    private String ID; // the review ID

    @Min(1)
    @Max(5)
    private int rating; // the review rating

    @DateTimeFormat
    private String datetime; // the date and time of the review

    @Size(min = 2, max = 1000)
    private String content; // the text content of the review

}
