package com.weuoimi.user_service.repos;

import java.util.Map;

import org.springframework.data.jpa.domain.Specification;

import com.weuoimi.user_service.entity.User;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserSpecification implements Specification<User> {

    private final Map<String, Object> criteria;

    @Override
    public Predicate toPredicate(Root<User> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) {
        
        Predicate predicate = arg2.conjunction();

        criteria.forEach((field, value) -> {
            if (arg0.get(field) != null && value != null) {
                predicate.getExpressions().add(arg2.equal(arg0.get(field), value));
            }
        });

        return predicate;
    }

    public static Specification<User> fitlerOutPasswordParam() {
        return (Root<User> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) -> {
            
            arg1.multiselect(
                arg0.get("id"),
                arg0.get("email"),
                arg0.get("role"),
                arg0.get("username")
            );

            return null;
        };
    }

}
