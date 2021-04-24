package com.luigis.luigisreview.data;

import java.util.List;

public interface DataAccessInterface<T> {

    /**
     * Inserts the given entity as a new document into the collection
     * 
     * @param entity the entity to insert
     * @return the entity inserted, or null if unsuccessful
     */
    public T create(T entity);

    /**
     * Retrieves all documents from the collection
     * 
     * @return a list of documents
     */
    public List<T> findAll();

}
