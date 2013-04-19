package ObjectGame;

import java.util.ArrayList;



import DataGame.DataProviderXML;
import GameEntity.GameEntity;
import Sprite2DGame.Sprite2D;

public class Bounder extends GameEntity{

	
	enum StateBounder
	{
		NONE,
		IS_CATCH,
	};
	
	public Bounder()
	{		
		listSpritesEntity = new ArrayList<Sprite2D>();
		//listSpritesEntity = DataProviderXML.getBounder();
		onCreateVirtualBounder();
	}
	
	public void onCreateVirtualBounder()
	{
		// bag 22x26
		Sprite2D tmp = new Sprite2D("gfx/","bounder/bone0.png",128,128,100,100,28,19);
		listSpritesEntity.add(tmp);
	}
	
	/*
	@Override
	public void LoadResource(Context mContext, Engine mEngine)
	{
		
	}
	
	@Override
	public ArrayList<Sprite> LoadScene()
	{		
		return null;
	}
	*/
}
