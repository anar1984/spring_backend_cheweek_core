package com.cheweek.spring_backend_cheweek_core.utility.coreentity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;


import java.util.*;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CoreSpecification <T>{

    private Map<String,String> andSpecification = new HashMap<>();
    private Map<String,List<String>> inSpecification =new HashMap<>();
    private Map<String ,String > orSpecification= new HashMap<>();
    private Map<String,String> andLike = new HashMap<>();
    private Map<String,String> orLike = new HashMap<>();
    private Specification<T> specification = Specification.where(null);


    public void setAnd(String  key,String value){
        if(key!=null&&!key.isBlank() && value!=null&&!value.isBlank()){
            this.andSpecification.put(key,value);
        }
    }
    public void setAndLike(String  key,String value){
        if(key!=null&&!key.isBlank() && value!=null&&!value.isBlank()){
            this.andLike.put(key,value);
        }
    }
    public void setOrLike(String  key,String value){
        if(key!=null&&!key.isBlank() && value!=null&&!value.isBlank()){
            this.orLike.put(key,value);
        }
    }
    public void setIn(String  key,List<String> list){
        if(key!=null&&!key.isBlank() && list!=null&& !list.isEmpty()){
            this.inSpecification.put(key,list);
        }
    }
    public void setOr(String  key,String value){
        if(key!=null&&!key.isBlank() && value!=null&&!value.isBlank()){
            this.orSpecification.put(key,value);
        }
    }




    private void setAnd(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Root root){
        if (!andSpecification.keySet().isEmpty()) {
            for (String key : andSpecification.keySet()) {
                if (andSpecification.get(key) != null) {
                    predicates.add(criteriaBuilder.equal(root.get(key), andSpecification.get(key)));
                }
            }
        }
    }

    private void setOr(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Root root){
        if (!orSpecification.keySet().isEmpty()) {
            List<Predicate> orPredicates = new ArrayList<>();
            for (String key : orSpecification.keySet()) {
                if (orSpecification.get(key) != null) {
                    orPredicates.add(criteriaBuilder.equal(root.get(key), orSpecification.get(key)));
                }
            }
            predicates.add(criteriaBuilder.or(orPredicates.toArray(new Predicate[0])));
        }
    }
    private void setIn(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Root root){
        if (!inSpecification.keySet().isEmpty()) {
            for (String key : inSpecification.keySet()) {
                if (inSpecification.get(key) != null) {
                    Expression<String> expression = root.get(key);
                    CriteriaBuilder.In<String> inPredicate = criteriaBuilder.in(expression);
                    Collection<String> inValues = inSpecification.get(key);
                    for (String inValue : inValues) {
                        inPredicate.value(inValue);
                    }
                    predicates.add(inPredicate);
                }
            }
        }
    }

    private void setAndLike(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Root root) {
        if (!andLike.keySet().isEmpty()) {
            for (String key : andLike.keySet()) {
                if (andLike.get(key) != null) {
                    predicates.add(criteriaBuilder.like(root.get(key), "%" + andLike.get(key) + "%"));
                }
            }
        }
    }

    private void setOrLike(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Root root) {
        if (!orLike.keySet().isEmpty()) {
            List<Predicate> orPredicates = new ArrayList<>();
            for (String key : orLike.keySet()) {
                if (orLike.get(key) != null) {
                    orPredicates.add(criteriaBuilder.like(root.get(key), "%" + orLike.get(key) + "%"));
                }
            }
            predicates.add(criteriaBuilder.or(orPredicates.toArray(new Predicate[0])));
        }
    }
    private Specification<T> getSpecificationBuilder() {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            setAnd(predicates,criteriaBuilder,root);
            setIn(predicates,criteriaBuilder,root);
            setOr(predicates,criteriaBuilder,root);
            setAndLike(predicates, criteriaBuilder, root);
            setOrLike(predicates, criteriaBuilder, root);

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public Specification  getSpecification(){
        this.specification = getSpecificationBuilder();
        return this.specification;
    }


}

