package com.cheweek.appcheweekspace.erp.controller.info.expense;

import com.cheweek.appcheweekspace.erp.service.info.expense.category.ExpenseCategoryCreateService;
import com.cheweek.appcheweekspace.erp.service.info.expense.category.ExpenseCategoryReadService;
import com.cheweek.appcheweekspace.erp.service.info.expense.category.ExpenseCategoryUpdateService;
import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseCategoryCreateDTO;
import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseCategoryReadDTO;
import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseCategoryUpdateDTO;
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
@RequestMapping("/info/expense-category")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpenseCategoryController {

    final ExpenseCategoryReadService expenseCategoryReadService;
    final ExpenseCategoryCreateService expenseCategoryCreateService;
    final ExpenseCategoryUpdateService expenseCategoryUpdateService;

    @PostMapping("/read")
    public List<ExpenseCategoryReadDTO> getExpenseCategoryList(){
        return expenseCategoryReadService.getExpenseCategoryList();
    }

    @PostMapping("/create")
    public ResponseEntity createExpenseCategory(@RequestBody ExpenseCategoryCreateDTO dto){
        expenseCategoryCreateService.createExpenseCategory(dto);
        return  ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity updateExpenseCategory(@RequestBody ExpenseCategoryUpdateDTO dto){
        expenseCategoryUpdateService.updateExpenseCategory(dto);
        return ResponseEntity.ok((HttpStatus.OK));

    }
}
