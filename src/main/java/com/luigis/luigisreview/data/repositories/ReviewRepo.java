package com.luigis.luigisreview.data.repositories;

import com.luigis.luigisreview.data.entities.ReviewEntity;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepo extends MongoRepository<ReviewEntity, String> {

}
