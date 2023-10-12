package com.cheweek.appcheweekspace.erp.service.info.expense.item;

import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseItemCreateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.expense.ExpenseItem;
import com.cheweek.appcheweekspace.erp.mapper.expense.ExpenseItemCreateMapper;
import com.cheweek.appcheweekspace.erp.repository.info.expense.ExpenseItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class ExpenseItemCreateService {
    final ExpenseItemRepository expenseItemRepository;
    final ExpenseItemCreateMapper mapper;

    public void createExpenseItem(ExpenseItemCreateDTO dto){

        ExpenseItem expenseItem = mapper.expenseItemCreateDTOToEntity(dto);
        expenseItemRepository.save(expenseItem);
    }
}
