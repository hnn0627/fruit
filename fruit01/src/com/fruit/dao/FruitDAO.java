package com.fruit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fruit.vo.BuyerVO;
import com.fruit.vo.SellerVO;

public class FruitDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private final String BUYER_INFO = "select * from buyer where id=?";
	private final String BUYER_MONEY_REG = "update buyer set money=money+? where id=?";
	private final String GET_APPLE_PRICE = "select apple_price from seller where id=?";
	private final String BUYER_BUY_FRUIT = 
	"update buyer set money=money-(?*?), apple_count=apple_count+? where id=?";
	private final String SELLER_SELL_FRUIT = 
	"update seller set money=money+(?*?), apple_count=apple_count-? where id=?";
	private final String SELLER_INFO = "select * from seller where id=?";
	private final String SELLER_APPLE_REG = "update seller set apple_count=apple_count+?, apple_price=? where id=?";

	private static FruitDAO dao = new FruitDAO();
	private FruitDAO() {};
	
	public static FruitDAO getInstance() {
		return dao;
	}
	
	public Connection connect() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newfruit", "root", "cs1234");
		} catch (Exception e) {
			System.out.println("오류발생 : " + e);
			// TODO: handle exception
		} 
		return conn;
	}
////////////////////////////////////////////////	
	public List<SellerVO> getSellerList() {
		String sql = "select * from seller";
		List<SellerVO> sellerList = new ArrayList<SellerVO>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SellerVO svo = new SellerVO();
				svo.setId(rs.getString("ID"));
				svo.setPass(rs.getString("PASSWD"));
				svo.setMoney(rs.getInt("MONEY"));
				svo.setApplePrice(rs.getInt("APPLE_PRICE"));
				svo.setAppleCount(rs.getInt("APPLE_COUNT"));
				sellerList.add(svo);

			}
		} catch (Exception e) {
			System.out.println("오류발생 : " + e);
		}
		close(conn, pstmt, rs);
		return sellerList;
	}
////////////////////////////////////////////////////////////////////////////	
	public List<BuyerVO> getBuyerList() {
		String sql = "select * from buyer";
		List<BuyerVO> buyerList = new ArrayList<BuyerVO>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BuyerVO bvo = new BuyerVO();
				bvo.setId(rs.getString("ID"));
				bvo.setPass(rs.getString("PASSWD"));
				bvo.setMoney(rs.getInt("MONEY"));
				bvo.setAppleCount(rs.getInt("APPLE_COUNT"));
				buyerList.add(bvo);

			}
		} catch (Exception e) {
			System.out.println("오류발생 : " + e);
		}
		close(conn, pstmt, rs);
		return buyerList;
	}
//////////////////////////////////////////////////////////////////////////////////////	
	public int price = 0;
	public int getApplePrice(String id) {
		try {
			conn = connect();
			pstmt = conn.prepareStatement(GET_APPLE_PRICE);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) price= rs.getInt("APPLE_PRICE");
		} catch (Exception e) {
			System.out.println("오류발생 : " + e);
		}
		close(conn, pstmt, rs);
		return price;
	}
//////////////////////////////////////////////////////////////////////////////////////	
	public void buyerBuyFruit(String id, int appleCount) {
		try {
			conn = connect();
			pstmt = conn.prepareStatement(BUYER_BUY_FRUIT);
			pstmt.setInt(1, appleCount);
			pstmt.setInt(2, price);
			pstmt.setInt(3, appleCount);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("오류발생 : " + e);
		}
		close(conn, pstmt);
	}
//////////////////////////////////////////////////////////////////////////////	
	public void sellerSellFruit(String id, int appleCount) {
		try {
			conn = connect();
			pstmt = conn.prepareStatement(SELLER_SELL_FRUIT);
			pstmt.setInt(1, price);
			pstmt.setInt(2, appleCount);
			pstmt.setInt(3, appleCount);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("오류발생 : " + e);
		}
		close(conn, pstmt);
	}
////////////////////////////////////////////////////////////////////////////	
	public SellerVO getSellerInfo(String id) {
		SellerVO svo = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement(SELLER_INFO);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				svo = new SellerVO();
				svo.setId(rs.getString(1));
				svo.setPass(rs.getString(2));
				svo.setMoney(rs.getInt(3));
				svo.setAppleCount(rs.getInt(4));
				svo.setApplePrice(rs.getInt("APPLEPRICE"));
			}
		} catch (SQLException e) {
			System.out.println("오류발생 : " + e);
		}
		close(conn, pstmt, rs);
		return svo;
	}
///////////////////////////////////////////////////////////////////////////////////////	
	public void regSellerApple(String id, int count, int money) {
		try {
			conn = connect();
			pstmt = conn.prepareStatement(SELLER_APPLE_REG);
			pstmt.setInt(1,  count);
			pstmt.setInt(2,  money);
			pstmt.setString(3,  id);
		} catch (Exception e) {
			System.out.println("오류발생 : " + e);
		}
		close(conn, pstmt);
	}
//////////////////////////////////////////////////////////////////////////////////////////////	
	public BuyerVO getBuyerInfo(String id) {
		BuyerVO bvo = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement(BUYER_INFO);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				bvo = new BuyerVO();
				bvo.setId(rs.getString(1));
				bvo.setPass(rs.getString(2));
				bvo.setMoney(rs.getInt(3));
				bvo.setAppleCount(rs.getInt(4));
			}
		} catch (SQLException e) {
			System.out.println("오류발생: " + e);
		}
		close(conn, pstmt, rs);
		return bvo;
	}
/////////////////////////////////////////////////////////////////////////////////////////////
	public void regBuyerMoney(String id, int money) {
		try {
			conn = connect();
			pstmt = conn.prepareStatement(BUYER_MONEY_REG);
			pstmt.setInt(1, money);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			close(conn, pstmt);
		} catch (SQLException e) {
			System.out.println("오류발생: " + e);
		}
		close(conn, pstmt);
	}
////////////////////////////////////////////////////////////////////////////////////////	
	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (Exception e) {
				System.out.println("오류발생: " + e);
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			} catch (Exception e) {
				System.out.println("오류발생: " + e);
			}
		}
		if(conn !=null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println("오류발생: " + e);
			}
		}
	}

	public void close(Connection conn, PreparedStatement ps) {
		if(ps!=null) {
			try {
				ps.close();
			} catch (Exception e) {
				System.out.println("오류발생: " + e);
			}
		}
		if(conn !=null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println("오류발생: " + e);
			}
		}
	}



}
