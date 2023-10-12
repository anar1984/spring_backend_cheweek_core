package com.cheweek.appcheweekspace.erp.controller.info.expense;

import com.cheweek.appcheweekspace.erp.service.info.expense.assignment.ExpenseAssignmentCreateService;
import com.cheweek.appcheweekspace.erp.service.info.expense.assignment.ExpenseAssignmentReadService;
import com.cheweek.appcheweekspace.erp.service.info.expense.assignment.ExpenseAssignmentUpdateService;
import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseAssignmentCreateDTO;
import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseAssignmentReadDTO;
import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseAssignmentUpdateDTO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/info/expense-assignment")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ExpenseAssignmentController {

    final ExpenseAssignmentReadService expenseAssignmentReadService;
    final ExpenseAssignmentCreateService expenseAssignmentCreateService;
    final ExpenseAssignmentUpdateService expenseAssignmentUpdateService;


    @PostMapping("/read")
    public List<ExpenseAssignmentReadDTO> getExpenseAssignmentList() {
        return expenseAssignmentReadService.getExpenseAssignmentList();
    }

    @PostMapping("/create")
    public ResponseEntity createExpenseAssignment(@RequestBody ExpenseAssignmentCreateDTO dto) {
        expenseAssignmentCreateService.createExpenseAssignment(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity updateExpenseAssignment(@RequestBody ExpenseAssignmentUpdateDTO dto) {
        expenseAssignmentUpdateService.updateExpenseAssignment(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
