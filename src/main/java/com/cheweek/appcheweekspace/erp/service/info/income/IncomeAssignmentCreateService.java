package com.cheweek.appcheweekspace.erp.service.info.income;

import com.cheweek.appcheweekspace.erp.repository.info.income.IncomeAssignmentRepository;
import com.cheweek.appcheweekspace.erp.dto.info.income.IncomeAssignmentCreateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.income.IncomeAssignment;
import com.cheweek.appcheweekspace.erp.mapper.income.IncomeAssignmentCreateMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class IncomeAssignmentCreateService {

    final IncomeAssignmentRepository incomeAssignmentRepository;
    final IncomeAssignmentCreateMapper mapper;

    public void createIncomeAssignment(IncomeAssignmentCreateDTO dto){
        IncomeAssignment incomeAssignment = mapper.incomeAssignmentCreateDTOToEntity(dto);
        incomeAssignmentRepository.save(incomeAssignment);
    }
}
