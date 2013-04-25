package ShopItem;

import java.util.ArrayList;

public class ShopItem {
			
	 public enum ITEMSHOP//các loại item trong Shop
	 {
		MINE,
		STONE,
		DIAMOND,
		STRENG,
		TIME,
		LUCKY,
	 }
	 	 
	ITEMSHOP itembuy;
	int itemChoosed = 0;// Demo item được mua
	
	
	//mẫu hàm add item khi mua
	public ArrayList<ITEMSHOP> getItemBuy(ArrayList<ITEMSHOP> arrItemBuy)
    {      
		//ví dụ là diamond
        if(itemChoosed == 0)
        {
        	
        	arrItemBuy.add(ITEMSHOP.DIAMOND);
        	
        }
        else
        	arrItemBuy.add(ITEMSHOP.TIME);
        
        
        return arrItemBuy;//tra lại item mua cho Player
    }
}
