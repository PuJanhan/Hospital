package cn.njupt.hospital.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class TestDemo {
   public void mybatis() throws IOException{
	   SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
   
	   InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
   
	   SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
	   
	   SqlSession sqlSession = sqlSessionFactory.openSession();
   
	   //Users  user = sqlSession.
   }
}
