package com.luigis.luigisreview.data;

import java.util.List;

import com.luigis.luigisreview.data.entities.ReviewEntity;
import com.luigis.luigisreview.data.repositories.ReviewRepo;
import com.luigis.luigisreview.util.DatabaseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewDAO implements ReviewDataInterface {

    @Autowired
    private ReviewRepo repo; // the Review Repository

    @Override
    public ReviewEntity create(ReviewEntity entity) {

        try {
            return repo.insert(entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<ReviewEntity> findAll() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseException(e);
        }
    }

}
