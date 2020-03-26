package com.example.mybatisplus1;

import com.example.mybatisplus1.api.dao.entity.BrokerMessageEntity;
import com.example.mybatisplus1.api.service.BrokerMessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatisplus1ApplicationTests {
    @Autowired
    private BrokerMessageService brokerMessageService;
    @Test
    void contextLoads() {
    }

    @Test
    void testQueryAll() {
        List<BrokerMessageEntity> messageEntities = brokerMessageService.list();
        for (BrokerMessageEntity entity: messageEntities) {
            System.out.println(entity.getMessage());
        }
    }

}
