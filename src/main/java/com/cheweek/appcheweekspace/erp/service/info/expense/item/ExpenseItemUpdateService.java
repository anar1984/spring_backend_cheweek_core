package com.cheweek.appcheweekspace.erp.service.info.expense.item;

import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseItemUpdateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.expense.ExpenseItem;
import com.cheweek.appcheweekspace.erp.mapper.expense.ExpenseItemUpdateMapper;
import com.cheweek.appcheweekspace.erp.repository.info.expense.ExpenseItemRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpenseItemUpdateService {

    final ExpenseItemRepository expenseItemRepository;
    final ExpenseItemUpdateMapper mapper;

    public void updateExpenseItem(ExpenseItemUpdateDTO dto){

        ExpenseItem expenseItem = mapper.expenseItemUpdateDTOToEntity(dto);

        Optional<ExpenseItem> defaultFields = expenseItemRepository.findById(expenseItem.getId());
        expenseItem.setCreatedBy(defaultFields.get().getCreatedBy());
        expenseItem.setCreatedDate(defaultFields.get().getCreatedDate());
        expenseItem.setCreatedTime(defaultFields.get().getCreatedTime());
        expenseItem.setInsertDate(defaultFields.get().getInsertDate());
        expenseItem.setStatus(defaultFields.get().getStatus());

        expenseItemRepository.save(expenseItem);
    }
}
