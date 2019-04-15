package icomac.chapter1;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;

import org.junit.Test;

import icomac.chapter1.model.Article;

import java.sql.Connection;

/**
 * JdbcTest
 * 
 * @author IComac
 * @date 2019-04-13
 */
public class JdbcTest {
	
	@Test
	public void testJdbc() {
		String url = "jdbc:mysql://localhost:3306/mysql?user=root&password=123456&useUnicode=true&useSSL=false&characterEncoding=utf8";
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			
			String author = "coolblog";
			String date = "2018.06.10";
			String sql = "SELECT id, title, author, content, create_time FROM article WHERE author = '" + author + "' AND create_time > '" + date + "'";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			List<Article> articles = new ArrayList<>(rs.getRow());
			while(rs.next()) {
				Article article = new Article();
				article.setId(rs.getInt("id"));
				article.setTitle(rs.getString("title"));
				article.setAuthor(rs.getString("author"));
				article.setContent(rs.getString("content"));
				article.setCreateTime(rs.getDate("create_time"));
				articles.add(article);
			}
			System.out.println("Query SQL ==> " + sql);
			System.out.println("Query Result: ");
			articles.forEach(System.out::println);
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
