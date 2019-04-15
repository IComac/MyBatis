package icomac.chapter1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import icomac.chapter1.model.Article;

/**
 * ArticleDao
 * 
 * @author icomac
 * @data 2019-04-12
 */
public interface ArticleDao {
	List<Article> findByAuthorAndCreateTime(@Param("author") String author, @Param("createTime") String createTime);
}
