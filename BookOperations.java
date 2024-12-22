package Dom.BookProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BookOperations {

	public static Connection cn = Connectivity.connection();
	static Scanner sc = new Scanner(System.in);

	public static void addBook(int Book_id, String Book_Name, String Author_Name, double Price, float rating) {
		try {
			PreparedStatement pstmt = cn.prepareStatement("insert into MyLibrary values(?,?,?,?,?)");
			pstmt.setInt(1, Book_id);
			pstmt.setString(2, Book_Name);
			pstmt.setString(3, Author_Name);
			pstmt.setDouble(4, Price);
			pstmt.setFloat(5, rating);

			int UpdateRowcount = pstmt.executeUpdate();
			System.out.println("Rows Affected " + UpdateRowcount);
			System.out.println();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void Display_Book() {
		try {
			Connection cn = Connectivity.connection();
			Statement stmt = cn.createStatement();
			ResultSet rset = stmt.executeQuery("select * from MyLibrary");
			while (rset.next()) {
				System.out.println("------------------------------------------");
				System.out.println("Book_id:" + rset.getInt(1));
				System.out.println("Book_Name:" + rset.getString(2));
				System.out.println("Author_Name:" + rset.getString(3));
				System.out.println("Book_Price:" + rset.getDouble(4));
				System.out.println("Book_Rating:" + rset.getFloat(5));
				System.out.println("------------------------------------------");
				System.out.println();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void DeleteBook(int bookid) {
		try {
			Connection cn = Connectivity.connection();
			PreparedStatement pstmt = cn.prepareStatement("delete from MyLibrary where Book_id=?");
			pstmt.setInt(1, bookid);
			int RowAffected = pstmt.executeUpdate();
			if (RowAffected >= 0) {
				System.out.println("book  with the book id " + bookid + "was delete Successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void SortBookByPrice() {
		Connection cn = Connectivity.connection();

		try {
			Statement stmt = cn.createStatement();
			ResultSet rset;
			System.out.println("press 1 (High to Low) : press 2(Low to Hign");
			int press = sc.nextInt();
			if (press != 1) {
				rset = stmt.executeQuery("select * from MyLibrary order by Book_Price  ");
			} else {

				rset = stmt.executeQuery("select * from MyLibrary order by Book_Price Desc ");
			}
			while (rset.next()) {
				System.out.println("*******************************************");
				System.out.println("Book_id " + rset.getInt(1));
				System.out.println("Book_Name " + rset.getString(2));
				System.out.println("Author_Name " + rset.getString(3));
				System.out.println("Book_Price " + rset.getDouble(4));
				System.out.println("Book_Rating " + rset.getFloat(5));
				System.out.println("*******************************************");
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void SortByrating() {
		Connection cn = Connectivity.connection();

		try {
			Statement stmt = cn.createStatement();
			ResultSet rset;
			System.out.println("press 1 (High to Low) : press 2(Low to Hign");
			int press = sc.nextInt();
			if (press != 1) {

				rset = stmt.executeQuery("select * from MyLibrary order by Book_rating  ");

			} else {
				rset = stmt.executeQuery("select * from MyLibrary order by Book_Rating Desc ");
			}
			while (rset.next()) {
				System.out.println("*******************************************");
				System.out.println("Book_id " + rset.getInt(1));
				System.out.println("Book_Name " + rset.getString(2));
				System.out.println("Author_Name " + rset.getString(3));
				System.out.println("Book_Price " + rset.getDouble(4));
				System.out.println("Book_Rating " + rset.getFloat(5));
				System.out.println("*******************************************");
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void SerchBook(int bid) {
		Connection cn = Connectivity.connection();

		try {

			PreparedStatement pstmt = cn.prepareStatement("select * from MyLibrary Where Book_id=?");
			pstmt.setInt(1, bid);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				System.out.println("*******************************************");
				System.out.println("Book_id " + rset.getInt(1));
				System.out.println("Book_Name " + rset.getString(2));
				System.out.println("Author_Name " + rset.getString(3));
				System.out.println("Book_Price " + rset.getDouble(4));
				System.out.println("Book_Rating " + rset.getFloat(5));
				System.out.println("*******************************************");
				System.out.println();
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void UpdateBook(int bid) {
		Connection cn = Connectivity.connection();
		System.out.println("press 1 to update price: Press 2 For ratings");
		int press = sc.nextInt();
		if (press == 1) {
			System.out.println("Enter new price ");
			double price = sc.nextDouble();
			try {
				PreparedStatement pstmt = cn.prepareStatement("update Mylibrary set Book_price=? where Book_id=?");
				pstmt.setDouble(1, price);
				pstmt.setInt(2, bid);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (press == 2) {
			System.out.println("Enter new Rating");
			float rating = sc.nextFloat();
			try {
				PreparedStatement pstmt = cn.prepareStatement("update MyLibrary set Book_Rating=? where Book_id=?");
				pstmt.setFloat(1, rating);
				pstmt.setInt(2, bid);
				pstmt.executeUpdate();

				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void connection() {
		try {
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
