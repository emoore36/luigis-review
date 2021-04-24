package com.luigis.luigisreview.business;

import java.util.List;

import com.luigis.luigisreview.models.ReviewModel;

public interface ReviewBusinessInterface {

    /**
     * Publishes a review of the restaurant.
     * 
     * @param review the review to publish
     * @return the review published
     */
    public ReviewModel publishReview(ReviewModel model);

    /**
     * Retrieves all reviews of the restaurant.
     * 
     * @return a list of restaurant reviews
     */
    public List<ReviewModel> retrieveAllReviews();

}
