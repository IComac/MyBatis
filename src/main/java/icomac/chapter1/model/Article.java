package icomac.chapter1.model;

import java.io.Serializable;
import java.sql.Date;
import org.apache.ibatis.annotations.Param;

/*
 * Article
 * 
 * @author icomac
 * @date 2019-04-12
 */
public class Article implements Serializable {
	
	private Integer id;
	
	private String title;
	
	private String author;
	
	private String content;
	
	private Date createTime;
	
	public Article() {
		
	}
	
	public Article(@Param("title") String title) {
		this.title = title;
	}
	
	public Article(@Param("id") Integer id, @Param("title") String title, @Param("content") String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Override
	public String toString() {
		return "Article{" +
			"id=" + id +
			", title='" + title + '\'' +
			", author='" + author + '\'' +
			", content='" + content + '\'' +
			", createTime='" + createTime +
			'}';
	}
}
