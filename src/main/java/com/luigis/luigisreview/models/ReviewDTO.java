package com.luigis.luigisreview.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    private List<ReviewModel> data; // the data resulting from the transaction

    private String responseCode; // the response code

    private String message; // the message associated with the result

}
