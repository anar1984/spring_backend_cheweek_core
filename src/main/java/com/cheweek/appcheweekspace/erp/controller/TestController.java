package com.cheweek.appcheweekspace.erp.controller;


import com.cheweek.appcheweekspace.erp.service.impl.TestServiceImpl;
import com.cheweek.appcheweekspace.erp.dto.TestDto;
import com.cheweek.appcheweekspace.utility.Carrier;
import com.cheweek.appcheweekspace.utility.QLogger;
import com.cheweek.appcheweekspace.utility.SessionManager;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class TestController {
    final QLogger logger = QLogger.getLogger(TestController.class);
    final TestServiceImpl testService;
    final SessionManager manager;

    @GetMapping("/test")
    public String getTestController() {
      logger.info(manager.getCurrentThreadId());
        logger.info(manager.getCurrentUserId());
        logger.info(manager.getCurrentUserName());
        logger.info(manager.getDomain());

        return "success11 "+manager.getCurrentUserName();
    }

    @PostMapping("/test1")
    public Carrier getTestControllerPost(@RequestBody Carrier carrier) throws IOException {

        return testService.run(carrier);

    }

    @PostMapping("/test_dto")
    public TestDto getTestControllerDto(@Valid  @RequestBody TestDto testDto) throws IOException {

        logger.info(testDto.toString());

        return null;

    }

    @PostMapping("/redistest")
    public Carrier getTestRedis(@RequestBody Carrier carrier) throws IOException {
//        String rd = testService.longRunnigMethod(carrier);
//        carrier.getKv().put("redistest",rd);
        return testService.longRunnigMethod(carrier);

    }

    @PostMapping("/classtest")
    public Carrier getTest(@RequestBody Carrier carrier) throws IOException {
//        String rd = testService.longRunnigMethod(carrier);
//        carrier.getKv().put("redistest",rd);
        return testService.run(carrier);

    }


}
