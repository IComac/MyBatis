package icomac.chapter1;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import icomac.chapter1.dao.ArticleDao;
import icomac.chapter1.model.Article;

/**
 * MyBatisTest
 * 
 * @author icomac
 * @date 2019-04-12
 */
public class MyBatisTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void prepare() throws IOException{
		String resource = "chapter1/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		inputStream.close();
	}
	
	@Test
	public void testMyBatis() throws IOException{
		SqlSession session = sqlSessionFactory.openSession();
		try {
			ArticleDao articleDao = session.getMapper(ArticleDao.class);
			List<Article> articles = articleDao.findByAuthorAndCreateTime("coolblog", "2018-1-18");
		} finally {
			// TODO: handle finally clause
			session.commit();
			session.close();
		}
	}
}
