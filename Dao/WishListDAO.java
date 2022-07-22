package libraryManagementSystem.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WishListDAO {

	public static void main(String[] args) {

	}

	public static boolean checkDuplicates(String userName, String BookName) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/Library";
			String uname = "root";
			String pass = "root";
			String query = "select * from Books_Table\r\n"
					+ "where BookName = ? ;";

			Connection con = DriverManager.getConnection(url, uname, pass);
			PreparedStatement st = con.prepareStatement(query);

			st.setString(1, BookName);

			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				return true;
			}
			

			st.close();
			con.close();

			return false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	
	public static boolean addBook(String userName, String BookName) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/Library";
			String uname = "root";
			String pass = "root";
			String query = "insert into Books_Table values (?, ?);";

			Connection con = DriverManager.getConnection(url, uname, pass);
			PreparedStatement st = con.prepareStatement(query);

			st.setString(1, userName);
			st.setString(2, BookName);

			st.executeUpdate();

			st.close();
			con.close();

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static ResultSet getBooks(String userName) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/Library";
			String uname = "root";
			String pass = "root";
			String query = "select BookName \r\n" + "from Books_Table \r\n" + "where Username = ?;";

			Connection con = DriverManager.getConnection(url, uname, pass);
			PreparedStatement st = con.prepareStatement(query);

			st.setString(1, userName);

			ResultSet rs = st.executeQuery();

//			rs.next();
//			st.close();
//			con.close();

			return rs;

		} catch (Exception e) {
			System.out.println(e);

			return null;
		}
	}

	public static int updateBook(String userName, String oldBookName, String newBookName) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/Library";
			String uname = "root";
			String pass = "root";
			String query = "update Books_Table " + "set BookName = ? " + "where BookName = ? ;";

			Connection con = DriverManager.getConnection(url, uname, pass);
			PreparedStatement st = con.prepareStatement(query);

			st.setString(1, newBookName);
			st.setString(2, oldBookName);

			int numberOfRows = st.executeUpdate();

			st.close();
			con.close();

			return numberOfRows;
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	public static int deleteBook(String userName, String BookName) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/Library";
			String uname = "root";
			String pass = "root";
			String query = "delete from Books_Table\r\n" + "where UserName = ? and BookName = ? ;";

			Connection con = DriverManager.getConnection(url, uname, pass);
			PreparedStatement st = con.prepareStatement(query);

			st.setString(1, userName);
			st.setString(2, BookName);

			int numberOfRows = st.executeUpdate();

			st.close();
			con.close();

			return numberOfRows;
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}

}
