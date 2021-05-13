package com.luigis.luigisreview.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.luigis.luigisreview.business.ReviewBusinessInterface;
import com.luigis.luigisreview.models.ReviewDTO;
import com.luigis.luigisreview.models.ReviewModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewRestController {

    @Autowired
    private ReviewBusinessInterface service;

    /**
     * Handles the (POST) publishing of a review.
     * 
     * @param model         the review to post
     * @param bindingResult the data validation result
     * @return The resulting JSON payload
     */
    @PostMapping("/publish")
    public ResponseEntity<?> handlePublishReview(@Valid @RequestBody ReviewModel model, BindingResult bindingResult) {

        try {

            // return a 400 if data validation fails
            if (bindingResult.hasErrors())
                return new ResponseEntity<ReviewDTO>(new ReviewDTO(null, "400", "Review data invalid."), HttpStatus.OK);

            // otherwise, publish the review
            ReviewModel result = service.publishReview(model);

            // create a list and the resulting review to it
            List<ReviewModel> reviews = new ArrayList<ReviewModel>();
            reviews.add(result);

            // return 200 DTO with published review
            return new ResponseEntity<ReviewDTO>(new ReviewDTO(reviews, "200", "Review published successfully!"),
                    HttpStatus.OK);

        } catch (Exception e) {

            // inform the gateway the request failed due to an internal error
            return new ResponseEntity<ReviewDTO>(new ReviewDTO(null, "500", "Internal error"), HttpStatus.OK);

        }

    }

    /**
     * Handles the (GET) retrieving of all the reviews
     * 
     * @return the resulting JSON payload of reviews
     */
    @GetMapping("/")
    public ResponseEntity<?> handleGetAllReviews() {

        try {

            // otherwise, publish the review
            List<ReviewModel> result = service.retrieveAllReviews();

            // return 200 DTO with published review
            return new ResponseEntity<ReviewDTO>(new ReviewDTO(result, "200", "Reviews retrieved successfully!"),
                    HttpStatus.OK);

        } catch (Exception e) {

            // inform the gateway the request failed due to an internal error
            return new ResponseEntity<ReviewDTO>(new ReviewDTO(null, "500", "Internal error"), HttpStatus.OK);
        }

    }

}
