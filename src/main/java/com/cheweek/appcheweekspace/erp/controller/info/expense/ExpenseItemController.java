package com.cheweek.appcheweekspace.erp.controller.info.expense;

import com.cheweek.appcheweekspace.erp.service.info.expense.item.ExpenseItemCreateService;
import com.cheweek.appcheweekspace.erp.service.info.expense.item.ExpenseItemReadService;
import com.cheweek.appcheweekspace.erp.service.info.expense.item.ExpenseItemUpdateService;
import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseItemCreateDTO;
import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseItemReadDTO;
import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseItemUpdateDTO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/info/expense-item")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpenseItemController {

    final ExpenseItemReadService expenseItemReadService;
    final ExpenseItemCreateService expenseItemCreateService;
    final ExpenseItemUpdateService expenseItemUpdateService;

    @PostMapping("/read")
    public List<ExpenseItemReadDTO> getExpenseItemList(){
        return expenseItemReadService.getExpenceItemList();
    }
    @PostMapping("/create")
    public ResponseEntity createExpenseItem(@RequestBody ExpenseItemCreateDTO dto){
        expenseItemCreateService.createExpenseItem(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity updateExpenseItem(@RequestBody ExpenseItemUpdateDTO dto){
        expenseItemUpdateService.updateExpenseItem(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
