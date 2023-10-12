package com.cheweek.appcheweekspace.erp.repository;

import com.cheweek.appcheweekspace.erp.entity.TestSpring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestSpringRepo extends JpaRepository<TestSpring,String> {

    TestSpring findByIdAndStatus(String id, String a);
}
