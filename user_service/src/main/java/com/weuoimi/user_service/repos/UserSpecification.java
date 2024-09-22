package com.weuoimi.user_service.repos;

import java.util.ArrayList;
import java.util.List;
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
        

        List<Predicate> predicates = new ArrayList<>();
        // if GET /api/v1/profiles?username=example => WHERE username = 'example
        // if GET /api/v1/profiles?role=ADMIN&email=example@mail.com => WHERE role = 'ADMIN AND email = 'example@mail.com'

        criteria.forEach((param, value) -> {
            if (value != null && isFieldSupported(param)) { // Check if the field is supported
                // Create a predicate for the parameter and value
                predicates.add(arg2.equal(arg0.get(param), value));
            }
        });

        return arg2.and(predicates.toArray(new Predicate[0]));
    }

    private boolean isFieldSupported(String field) {
        return List.of("username", "role", "email").contains(field); // Supported fields
    }

    public static Specification<User> fitlerOutPasswordParam() {
        return (Root<User> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) -> {
            
            arg1.multiselect(
                arg0.get("id"),
                arg0.get("email"),
                arg0.get("role"),
                arg0.get("username")
            );

            return arg2.conjunction();
        };
    }
}
