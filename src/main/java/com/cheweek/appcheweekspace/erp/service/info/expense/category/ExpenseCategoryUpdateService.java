package com.cheweek.appcheweekspace.erp.service.info.expense.category;

import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseCategoryUpdateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.expense.ExpenseCategory;
import com.cheweek.appcheweekspace.erp.mapper.expense.ExpenseCategoryUpdateMapper;
import com.cheweek.appcheweekspace.erp.repository.info.expense.ExpenseCategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpenseCategoryUpdateService {

    final ExpenseCategoryRepository expenseCategoryRepository;
    final ExpenseCategoryUpdateMapper mapper;

    public void updateExpenseCategory(ExpenseCategoryUpdateDTO dto){

        ExpenseCategory expenseCategory = mapper.expenseCategoryUpdateDTOToEntity(dto);

        Optional<ExpenseCategory> defaultFields = expenseCategoryRepository.findById(expenseCategory.getId());
        expenseCategory.setCreatedBy(defaultFields.get().getCreatedBy());
        expenseCategory.setCreatedDate(defaultFields.get().getCreatedDate());
        expenseCategory.setCreatedTime(defaultFields.get().getCreatedTime());
        expenseCategory.setInsertDate(defaultFields.get().getInsertDate());
        expenseCategory.setStatus(defaultFields.get().getStatus());

        expenseCategoryRepository.save(expenseCategory);

    }
}
