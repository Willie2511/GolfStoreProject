package com.golfstore;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Stateless
public abstract class Repository<T> {

    @PersistenceContext
    protected EntityManager entityManager;


    public List<T> getAllEntities() {
        String entityClass = getEntityClass().getSimpleName();
        String queryString = "SELECT ent from " + entityClass + " ent";
        TypedQuery<T> query = entityManager.createQuery(queryString, getEntityClass());
        return query.getResultList();
    }

    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void saveAll(List<T> entities) {
        for (T entity : entities) {
            save(entity);
        }
    }

    public boolean delete(T t){
        entityManager.remove(t);
        return true;
    }

    public boolean contains(T t){
        return entityManager.contains(t);
    }

    public T update(T t){
        return entityManager.merge(t);
    }


    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected abstract Class<T> getEntityClass();

    public T get(Object id) {
        return entityManager.find(getEntityClass(), id);
    }
}
