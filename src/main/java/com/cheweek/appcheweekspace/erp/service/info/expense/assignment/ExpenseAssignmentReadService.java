package com.cheweek.appcheweekspace.erp.service.info.expense.assignment;

import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseAssignmentReadDTO;
import com.cheweek.appcheweekspace.erp.mapper.expense.ExpenseAssignmentReadMapper;
import com.cheweek.appcheweekspace.erp.repository.info.expense.ExpenseAssignmentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpenseAssignmentReadService {

    final ExpenseAssignmentRepository expenseAssignmentRepository;
    final ExpenseAssignmentReadMapper mapper;
    public List<ExpenseAssignmentReadDTO> getExpenseAssignmentList(){
        return expenseAssignmentRepository.findAll().stream()
                .map(mapper::expenseAssignmentReadEntityToDTO)
                .collect(Collectors.toList());
    }
}
