package com.cheweek.appcheweekspace.erp.service.info.expense.item;

import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseItemReadDTO;
import com.cheweek.appcheweekspace.erp.mapper.expense.ExpenseItemReadMapper;
import com.cheweek.appcheweekspace.erp.repository.info.expense.ExpenseItemRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpenseItemReadService {

    final ExpenseItemRepository expenseItemRepository;
    final ExpenseItemReadMapper expenseItemReadMapper;

    public List<ExpenseItemReadDTO> getExpenceItemList(){
        return expenseItemRepository.findAll().stream()
                .map(expenseItemReadMapper::expenseItemReadEntityToDTO)
                .collect(Collectors.toList());
    }
}
