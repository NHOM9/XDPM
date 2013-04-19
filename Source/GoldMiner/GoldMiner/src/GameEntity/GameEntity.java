package GameEntity;


import java.util.ArrayList;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.entity.sprite.Sprite;

import android.content.Context;

import Sprite2DGame.Sprite2D;

public class GameEntity {

	protected ArrayList<Sprite2D> listSpritesEntity = null;
	protected String tpyeEntity;
	protected String nameEntity;
		
	protected enum StateEntity
	{
		
	};
		
	
	public void LoadResource(Context mContext, Engine mEngine)
	{		
		if (listSpritesEntity != null)
		{
			for (int i=0; i<listSpritesEntity.size(); i++)
			{
				listSpritesEntity.get(i).LoadResource(mContext, mEngine);
			}
		}
	}	
	
	public ArrayList<Sprite> LoadScene()
	{
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		if (listSpritesEntity != null)
		{
			for (int i=0; i<listSpritesEntity.size(); i++)
			{
				sprites.add(listSpritesEntity.get(i).LoadScene());
			}
		}
		return sprites;
	}
	
	
}
