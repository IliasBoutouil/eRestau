package com.example.eRestaurant.repos;

import com.example.eRestaurant.entities.Dish;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

@Repository
public class DishCriteriaRepository {

    EntityManager entityManager;
    CriteriaBuilder cb;

    public DishCriteriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.cb = entityManager.getCriteriaBuilder();
    }

    public List<Dish> findAllWithFilters(String name, double price, String category)
    {
        CriteriaQuery<Dish> cq = cb.createQuery(Dish.class);
        Root<Dish> root = cq.from(Dish.class);
        Predicate p = cb.conjunction();
        if(Objects.nonNull(name)) {
            p = cb.and(p, cb.like(root.get("name"), "%"+name+"%"));
        }
        if(Objects.nonNull(category))
            p=cb.and(p,cb.like(root.get("category").get("name"),"%"+category+"%"));
        if(price>0)
            p=cb.and(p,cb.ge(root.get("price"),price));
       cq.where(p);
       cq.orderBy(cb.asc(root.get("price")),cb.asc(root.get("name")));
       TypedQuery<Dish> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

}
