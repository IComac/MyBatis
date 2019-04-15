package icomac.chapter1;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import icomac.chapter1.dao2.ArticleDao;
import icomac.chapter1.dao2.AuthorDao;
import icomac.chapter1.model2.Article;
import icomac.chapter1.model2.Author;

/**
 * SpringWithMyBatisTest
 * 
 * @author IComac
 * @date 2019-04-13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:chapter1/application-mybatis.xml")
public class SpringWithMyBatisTest implements ApplicationContextAware {
	
	private ApplicationContext applicationContext;
	
	@Autowired
	private AuthorDao authorDao;
	
	@Autowired
	private ArticleDao articleDao;
	
	/**
	 * 为了证明我们的整合配置生效了，上面专门写了一个方法，用于输出ApplicationContext 中bean 的信息。
	 */
	@Before
	public void printBeanInfo() {
		ListableBeanFactory lbf = applicationContext;
		String[] beanNames = lbf.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		
		System.out.println();
		System.out.println("--------------☆ bean name ☆-------------");
		Arrays.asList(beanNames).subList(0, 5).forEach(System.out::println);
		System.out.println();
		
		AuthorDao authorDao = (AuthorDao) applicationContext.getBean("authorDao");
		ArticleDao articleDao = (ArticleDao) applicationContext.getBean("articleDao");
		
		System.out.println("--------------☆ bean class info ☆-------------");
		System.out.println("AuthorDao Class: " + authorDao.getClass());
		System.out.println("ArticleDao Class: " + articleDao.getClass());
		System.out.println("\n--------xxxx---------xxxx---------xxxx--------\n");
	}
	
	@Test
	public void testOne2One() {
		Article article = articleDao.findOne(1);
		
		Author author= article.getAuthor();
		article.setAuthor(null);
		
		System.out.println("\nauthor info");
		System.out.println(author);
		System.out.println("\narticles info:");
		System.out.println(article);
	}
	
	@Test
	public void testOne2Many() {
		Author author = authorDao.findOne(1);
		
		System.out.print("\nauthor info");
		System.out.println(author);
		System.out.println("\narticles info: ");
		author.getArticles().forEach(System.out::println);
	}
	
	@Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
