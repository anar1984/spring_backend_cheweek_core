package com.cheweek.appcheweekspace.erp.service.info.expense.category;

import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseCategoryReadDTO;
import com.cheweek.appcheweekspace.erp.mapper.expense.ExpenseCategoryReadMapper;
import com.cheweek.appcheweekspace.erp.repository.info.expense.ExpenseCategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpenseCategoryReadService {

    final ExpenseCategoryRepository expenseCategoryRepository;
    final ExpenseCategoryReadMapper mapper;

    public List<ExpenseCategoryReadDTO> getExpenseCategoryList(){
        return expenseCategoryRepository.findAll().stream()
                .map(mapper::expenseCategoryReadEntityToDTO)
                .collect(Collectors.toList());
    }
}
