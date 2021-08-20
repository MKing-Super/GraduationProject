package com.mkinfo.carhouse;

import com.mkinfo.carhouse.utils.security.CommonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CarhouseApplicationTests {

    @Autowired
    CommonUtil commonUtil;

    @Test
    void contextLoads() {
    }

    @Test
    void sendSimpleMailTest(){
        commonUtil.sendSimpleMail("makun5201@163.com","666");
    }

}
