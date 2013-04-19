package GameManager;

import org.anddev.andengine.engine.Engine;

import android.content.Context;
import GameEntity.GameEntity;
import MapGame.Map;
import ObjectGame.Bounder;

public class GameManagerEntity {

	GameEntity MapEntity;
	GameEntity BounderEntity;
	//GameEntity HookEntity;
	
	public GameManagerEntity()
	{
		MapEntity = new Map();
		BounderEntity = new Bounder();
		//HookEntity = new Hook();
	}
	
	public void LoadResource(Context mContext, Engine mEngine)
	{
		MapEntity.LoadResource(mContext, mEngine);
		BounderEntity.LoadResource(mContext, mEngine);
	}
	
	// LoadScene()
	
}
