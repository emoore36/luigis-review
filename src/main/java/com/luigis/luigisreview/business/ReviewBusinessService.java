package com.luigis.luigisreview.business;

import java.util.ArrayList;
import java.util.List;

import com.luigis.luigisreview.data.ReviewDataInterface;
import com.luigis.luigisreview.data.entities.ReviewEntity;
import com.luigis.luigisreview.models.ReviewModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewBusinessService implements ReviewBusinessInterface {

    @Autowired
    private ReviewDataInterface service;

    @Override
    public ReviewModel publishReview(ReviewModel model) {

        // create an entity of the model
        ReviewEntity entity = new ReviewEntity(model.getID(), model.getRating(), model.getDatetime(),
                model.getContent());

        // persist the entity
        ReviewEntity result = service.create(entity);

        // if successful (returned entity not null)
        if (result != null) {

            // create and return a model of the entity
            return new ReviewModel(result.getID(), result.getRating(), result.getDatetime(), result.getContent());
        }

        // else, return null
        return null;
    }

    @Override
    public List<ReviewModel> retrieveAllReviews() {

        List<ReviewModel> models = new ArrayList<ReviewModel>();

        // retrieve list of entities
        List<ReviewEntity> entities = service.findAll();

        // for each entity, add to modelList
        for (ReviewEntity entity : entities)
            models.add(new ReviewModel(entity.getID(), entity.getRating(), entity.getDatetime(), entity.getContent()));

        // return modelList
        return models;

    }

}
