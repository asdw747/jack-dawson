package com.jack.jackdawson;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JackDawsonApplicationTests {

	@Autowired
	DataSourceProperties dataSourceProperties;

	@Autowired
	ApplicationContext applicationContext;

	@Resource(name = "myDataSource1")
	private DataSource myDataSource1;

	@Resource(name = "myDataSource2")
	private DataSource myDataSource2;

//	@Autowired
//	VelocityEngine velocityEngine;

	@Autowired
	Jedis jedis;

	/*
	获取默认的数据源配置
	 */
	@Test
	public void queryDefaultDataSource() {

//		// 获取配置的数据源
//		DataSource dataSource = applicationContext.getBean(DataSource.class);
//		// 查看配置数据源信息
//		System.out.println(dataSource);
//		System.out.println(dataSource.getClass().getName());
//		System.out.println(dataSourceProperties);
//		//执行SQL,输出查到的数据
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		List<?> resultList = jdbcTemplate.queryForList("select * from contract");
//		System.out.println("===>>>>>>>>>>>" + String.valueOf(resultList));

	}


	/*
	多个数据源配置
 	*/
	@Test
	public void queryDataSource() {
		JdbcTemplate jdbcTemplate1 = new JdbcTemplate(myDataSource1);
		List<?> resultList1 = jdbcTemplate1.queryForList("select * from contract");
		System.out.println("===>>>>>>>>>>>" + JSON.toJSONString(resultList1));

		JdbcTemplate jdbcTemplate2 = new JdbcTemplate(myDataSource2);
		List<?> resultList2 = jdbcTemplate2.queryForList("select * from user");
		System.out.println("===>>>>>>>>>>>" + JSON.toJSONString(resultList2));
	}

	@Test
	public void checkVelocity() {
//
//		VelocityContext context=new VelocityContext();
//		context.put("toUserName", "y");
//		context.put("message", "test");
//		context.put("fromUserName", "zhangyingsong");
//		context.put("time", "2018");
//
//		StringWriter sw = new StringWriter();
//		velocityEngine.mergeTemplate("templates/index.vm", "UTF-8", context, sw);
//
//		System.out.println(sw.toString());

	}

	@Test
	public void checkJedis() {
		String key = "zhangys";
		jedis.setex(key, 60, "1");
		System.out.println(jedis.get("zhangys"));
	}

}
