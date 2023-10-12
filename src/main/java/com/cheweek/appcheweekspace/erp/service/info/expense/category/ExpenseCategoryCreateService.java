package com.cheweek.appcheweekspace.erp.service.info.expense.category;

import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseCategoryCreateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.expense.ExpenseCategory;
import com.cheweek.appcheweekspace.erp.mapper.expense.ExpenseCategoryCreateMapper;
import com.cheweek.appcheweekspace.erp.repository.info.expense.ExpenseCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class ExpenseCategoryCreateService {

    final ExpenseCategoryRepository expenseCategoryRepository;
    final ExpenseCategoryCreateMapper mapper;

    public void createExpenseCategory(ExpenseCategoryCreateDTO dto){
        ExpenseCategory expenseCategory = mapper.expenseCategoryCreateDTOToEntity(dto);
        expenseCategoryRepository.save(expenseCategory);;
    }
}
