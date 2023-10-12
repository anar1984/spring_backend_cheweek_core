package com.cheweek.appcheweekspace.erp.service.impl;

import com.cheweek.appcheweekspace.erp.dto.info.test.TestDto;
import com.cheweek.appcheweekspace.erp.dto.info.test.TestDtoOne;
import com.cheweek.appcheweekspace.erp.dto.info.test.TestDtoThree;
import com.cheweek.appcheweekspace.erp.dto.info.test.TestDtoTwo;
import com.cheweek.appcheweekspace.erp.repository.TestSpringRepo;
import com.cheweek.appcheweekspace.erp.service.ApiService;
import com.cheweek.appcheweekspace.utility.sqlgenerator.SQLFormatter;
import com.cheweek.appcheweekspace.utility.sqlgenerator.SQLGenerator;
import com.cheweek.appcheweekspace.erp.entity.TestSpring;
import com.cheweek.appcheweekspace.utility.Carrier;
import com.cheweek.appcheweekspace.utility.QLogger;
import com.cheweek.appcheweekspace.utility.SessionManager;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import lombok.experimental.FieldDefaults;


import org.springframework.data.redis.core.RedisTemplate;


import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestServiceImpl implements ApiService {
    final RedisTemplate<String,String> redis;
    final QLogger logger = QLogger.getLogger(TestServiceImpl.class);
    final TestSpringRepo repo;
    final SQLFormatter formatter;
    final RedisTemplate<String,String> redisTemplate;
    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    final SQLGenerator generator;
    final SessionManager sessionManager;




    @Override
    public Carrier run(Carrier carrier) {

        logger.info(carrier.toString());
        logger.info("tst"+carrier.get("test"));
        logger.info("id"+carrier.get("id"));
        logger.info("sesion"+sessionManager.getCurrentUserId());
        logger.info("name "+sessionManager.getCurrentUserName());
        logger.info("name "+sessionManager.getLang());

//        TestSpring  spring = repo.findByIdAndStatus(carrier.get("id"),"A");
        TestSpring spring = new TestSpring();
        spring.setTest(carrier.get("test"));
        spring.setCreatedBy(carrier.get("createdBy"));
        repo.save(spring);

        return carrier;
    }

    //    @Cacheable(cacheNames = "mySpecialCache")
    public Carrier longRunnigMethod(Carrier carrier) {

//        HashOperations<String,String,String> ln = redis.opsForHash();
//       String  sql = ln.get("elcom_sql","AAgetInfoForKontragentQaliqFromKontragentDovriyye.sql")   ;
//      carrier = generator.selectToCarrier(carrier,"AAgetInfoForKontragentQaliqFromKontragentDovriyye");
        String tn = "22092916065105318419";
        Map<String ,String > fil = new HashMap<>();
        fil.put("fkTaskId","23082410122400145985");
        List<Map<String,String>> t = generator.selectSql(fil,tn,"fk_request_id,fk_task_type_id,fk_action_id,year,month");
        logger.info(t.get(0).get("fkTaskTypeId"));
        logger.info(t.get(0).get("month"));
        logger.info(t.get(0).get("fkRequestId"));
        logger.info(t.get(0).get("year"));
        logger.info(t.get(0).get("fkActionId"));

//        Carrier tt = generator.selectToCarrier(fil,tn,new TestDto());
//        logger.info(tt.toString());


        return carrier ;
    }


    public void clearCache() {
        System.out.println("cache temizledi");
    }


    public TestDto testService(TestDto testDtoOneList) {
        List<TestDtoOne> list = new ArrayList<>();
        List<TestDtoTwo> list1 = new ArrayList<>();
        List<TestDtoThree> list2 = new ArrayList<>();

        TestDtoOne testDtoOne = new TestDtoOne();
        TestDtoTwo testDtoTwo = new TestDtoTwo();
        TestDtoThree testDtoThree = new TestDtoThree();
        list2.add(testDtoThree);
        testDtoTwo.setRawMaterialList(list2);
        list1.add(testDtoTwo);

        testDtoOne.setOperationList(list1);
        list.add(testDtoOne);

        TestDto testDto = new TestDto();
        testDto.setProducts(list);

        return testDtoOneList;
    }
}
