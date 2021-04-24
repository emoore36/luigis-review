package com.luigis.luigisreview.data.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("REVIEW_COLLECTION")
public class ReviewEntity {

    @Id
    private String ID; // the review ID

    @Field("RATING")
    private int rating; // the review rating

    @Field("DATETIME")
    private String datetime; // the review date and time

    @Field("CONTENT")
    private String content; // the text content of the review

}
