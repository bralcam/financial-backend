package com.financial.incomingsource.specification;

import com.financial.incomingsource.enums.IncomingSourceType;
import com.financial.incomingsource.model.IncomingSourceEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.util.Objects.nonNull;

@AllArgsConstructor
public class IncomingSourceSpecification implements Specification<IncomingSourceEntity> {

    private Integer id;
    private String name;
    private String description;
    private IncomingSourceType type;

    @Override
    public Predicate toPredicate(Root<IncomingSourceEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (nonNull(id)) {
            predicates.add(criteriaBuilder.equal(root.get("id"), id));
        }
        if (!isNullOrEmpty(name)) {
            String nameLike = "%" + name + "%";
            predicates.add(criteriaBuilder.like(root.get("name"), nameLike));
        }
        if (!isNullOrEmpty(description)) {
            String descriptionLike = "%" + description + "%";
            predicates.add(criteriaBuilder.like(root.get("name"), descriptionLike));
        }
        if (nonNull(type)) {
            predicates.add(criteriaBuilder.equal(root.get("type"), type));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

}
