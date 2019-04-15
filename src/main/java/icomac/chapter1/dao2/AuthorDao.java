package icomac.chapter1.dao2;

import org.apache.ibatis.annotations.Param;

import icomac.chapter1.model2.Author;

/**
 * AuthorDao
 * 
 * @author IComac
 * @date 2019-04-13
 */
public interface AuthorDao {
	Author findOne(@Param("id") int id);
}
