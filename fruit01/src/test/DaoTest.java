package test;

import com.fruit.dao.FruitDAO;
import com.fruit.vo.BuyerVO;
import com.fruit.vo.SellerVO;

public class DaoTest {

	public static void main(String[] args) {
		String bid = "b01";
		String sid = "s01";

		FruitDAO dao = FruitDAO.getInstance();

		BuyerVO bvo = null;
		SellerVO svo = null;

		
//		bvo = dao.getBuyerInfo(bid);
//		System.out.println("id:" + bvo.getId());
//		System.out.println("pass:" + bvo.getPass());
//		System.out.println("money:" + bvo.getMoney());
//		System.out.println("apple:" + bvo.getAppleCount());
//		
//		int money = 101010;
//		dao.regBuyerMoney(bid, money);
//		bvo = dao.getBuyerInfo(bid);
//		System.out.println("id:" + bvo.getId());
//		System.out.println("pass:" + bvo.getPass());
//		System.out.println("money:" + bvo.getMoney());
//		System.out.println("apple:" + bvo.getAppleCount());
		
		int aa = dao.getApplePrice(sid);
		
		int appleCount = 5;
		dao.buyerBuyFruit(bid, appleCount);
		
		dao.sellerSellFruit(sid, appleCount);

	}

}
