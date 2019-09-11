package com.ssm.dao;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lijinghua
 * @Description:
 * @date
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:mybatis/mybatis-config.xml", "classpath:spring/applicationContext-dao.xml" })
public class BaseTest {
}
