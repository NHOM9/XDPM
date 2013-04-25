package MapGame;

import java.util.ArrayList;

import org.anddev.andengine.engine.Engine;

import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.font.Font;


import android.content.Context;


import DataGame.DataProviderXML;
import GameEntity.GameEntity;
import Sprite2DGame.Sprite2D;


public class Map extends GameEntity{


    Font fontScore;
    
	public Map() {
		this.listSpritesEntity = new ArrayList<Sprite2D>();
		
		//this.listSpritesEntity = DataProviderXML.getBackground();
		
		onCreateVirtualDataMap();		
	}

    /**
     * create virtual data to test code
     */
    public void onCreateVirtualDataMap()
    {
    	Sprite2D tmp = new Sprite2D("gfx/","map/bg.png",512,128,0,0,480,60);
    	//tmp.set_PathDirectoryImage("gfx/");
    	//tmp.set_PathFileImage("map/bg.png");
    	listSpritesEntity.add(tmp);
    	
    	tmp = new Sprite2D("gfx/","map/bg1.png",512,512,0,60,480,260);
    	listSpritesEntity.add(tmp);
    	
    }
	
	
    @Override
	public void LoadResource(Context mContext, Engine mEngine)
	{		
		for (int i=0; i<listSpritesEntity.size();i++)
		{
			listSpritesEntity.get(i).LoadResource(mContext,mEngine);
		}		
	}
	
    
	/*public Scene LoadScene(Scene MyScene)
	{
		this.sprite = new Sprite(0, 0,480,60, this.textureRegion);
		MyScene.attachChild(sprite);
		return MyScene;
		//return 
	}*/
    
	ArrayList<Sprite> backgroundSprites ;
	public ArrayList<Sprite> LoadScene() {
		//for (int i=0; i<backgroundMap.size();i++)
		backgroundSprites = new ArrayList<Sprite>();
		for (int i=0; i<listSpritesEntity.size();i++)
		{
			backgroundSprites.add(listSpritesEntity.get(i).LoadScene());
		}
		return backgroundSprites;
	}
	
    
}
