package com.cheweek.appcheweekspace.utility.coreentity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class QueryBuilder {
    @PersistenceContext
    private EntityManager entityManager;

    public Query update(CoreEntity core){

        return null;

    }

}
