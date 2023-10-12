package com.cheweek.appcheweekspace.erp.repository.info;

import com.cheweek.appcheweekspace.erp.entity.info.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UnitRepository extends JpaRepository<Unit,String> {
}
