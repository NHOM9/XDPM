package Player;

import java.util.ArrayList;

import ShopItem.ShopItem;
import ShopItem.ShopItem.ITEMSHOP;


public class Player {
		
//	public enum ITEMSHOP
//	{
//		MINE,
//		STONE,
//		DIAMOND,
//		STRENG,
//		TIME,
//		LUCKY,
//	}
//	
	private int markfirst;//điểm ban đầu
	private int finishMark;//điểm để qua màn
	
	//item
	private int valueStreng; //mua sức mạnh tăng tốc độ
	private int valueDiamond;//tăng tiền cho kim cuong
	private boolean valueMine;
	private int valueTime;
	private int valueStone;	
	private boolean valueLucky;	
		
	//Mảng chứa Item đã mua
	private ArrayList<ITEMSHOP> ArrItemBuy = new ArrayList<ITEMSHOP>();
	private ArrayList<ITEMSHOP> temp = new ArrayList<ITEMSHOP>();
	
	public Player()
	{
		finishMark = 0;
		markfirst = 0;
		this.valueStreng = 0;
		this.valueDiamond = 0;
		this.valueMine = false;
		this.valueTime = 0;
		this.valueStone = 0;	
		this.valueLucky = false;
	}
	
	//trả giá trị điểm màn chơi trước cho Main game
	public int getMarkfirst()
	{
		return markfirst;
	}
	//nhận giá trị điểm màn chơi trước từ Main game
	public void setMarkfirst(int firstmark)
	{
		this.markfirst = firstmark;
	}
	
	//trả giá trị điểm qua màn cho Main game vẽ ra màn hình
	public int getfinishMark()
	{
		return finishMark;
	}
	//nhận điểm qua màn từ DataGame
	public void setfinishMark(int finishmark)
	{
		this.finishMark = finishmark;
	}
			
	//get các giá trị sau khi mua cho Main game
	public int getStreng()
	{
		return valueStreng;
	} 
	
	public int getvalueDiamond()
	{
		return valueDiamond;
	} 
	
	public boolean getvalueMine()
	{
		return valueMine;
	} 
	
	public int getvalueStone()
	{
		return valueStone;
	} 
	
	public int getvalueTime()
	{
		return valueTime;
	} 
	
	public boolean getvalueLucky()
	{
		return valueLucky;
	} 
	
	//kiểm tra có qua màn 
	public boolean isPlayerOver()
	{
		if (markfirst >= finishMark) //qua màn
		{
			return true;
		}
		
		return false;
	}
	
	public void getItemfromShop()
	{
		
		ShopItem shopItem = new ShopItem();
		//lấy item được mua từ ShopItem		
		ArrItemBuy = shopItem.getItemBuy(temp);
		this.choosedItem(ArrItemBuy);
		
	}
	
	//xử lý từng Item 
	//public void choosedItem(ShopItem.ITEMSHOP itembuy)
	public void choosedItem(ArrayList<ITEMSHOP> arrayList)
	{
		for(ITEMSHOP itembuy : arrayList)
		{
			switch (itembuy)
			{
				case DIAMOND:
					this.valueDiamond = 300;//diamond + thêm 300đ
					this.markfirst -= 250;//trừ 350 điểm				
					ArrItemBuy.add(ITEMSHOP.DIAMOND);//add vào List
					break;
					
				case MINE:
					this.valueMine = true;//tăng 1 cuc mìn Main Game vẽ mine ra màn hình
					this.markfirst -= 150;
					ArrItemBuy.add(ITEMSHOP.MINE);
					break;
					
				case STRENG:
					this.valueStreng = 150;//tăng sức manh lên 150
					this.markfirst -= 250;
					ArrItemBuy.add(ITEMSHOP.STRENG);
					break;
					
				case STONE:
					this.valueStone = 4;// thêm 4 cục đá vào map Main Game vẽ 4 Stone ra màn hình
					this.markfirst -= 90;
					ArrItemBuy.add(ITEMSHOP.STONE);
					break;
					
				case TIME:
					this.valueTime = 5;//thêm 5s cho người chơi
					this.markfirst -= 200;
					ArrItemBuy.add(ITEMSHOP.TIME);
					break;
					
				case LUCKY:
					this.valueLucky = true; 
					this.markfirst -= 150;
					ArrItemBuy.add(ITEMSHOP.LUCKY);
					break;				
			}
		}
	}
	
	//nhận vào EmtyArr rỗng từ Main Game
	//add các item mua vào vào EmtyArr
	//trả lại cho Main Game
	public ArrayList<ITEMSHOP> itemBuy(ArrayList<ITEMSHOP> EmtyArr)
	{
		if(!EmtyArr.isEmpty())
		{
			EmtyArr.clear();
		}
		
		EmtyArr = ArrItemBuy;
		ArrItemBuy.clear();//làm rỗng cho lần add sau
		return EmtyArr;
	}
}

