package icomac.chapter1.dao2;

import org.apache.ibatis.annotations.Param;

import icomac.chapter1.model2.Article;

/**
 * ArticleDao
 * 
 * @author IComac
 * @date 2019-04-19
 */
public interface ArticleDao {
	Article findOne(@Param("id") int id);
}
