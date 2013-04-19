package com.example.goldminer;

import java.util.ArrayList;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.handler.timer.ITimerCallback;
import org.anddev.andengine.engine.handler.timer.TimerHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;


import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.util.FPSLogger;

import org.anddev.andengine.ui.activity.BaseGameActivity;

import GameEntity.GameEntity;
import MapGame.Map;
import ObjectGame.Bounder;


public class MainActivity extends BaseGameActivity {
	
	
	private Camera MyCamera;
	private Scene MyScene;
	
	GameEntity MapEntity;
	GameEntity BounderEntity;
	//GameEntity HookEntity;
	
	private int WIDTH = 480;
    private int HEIGHT = 320;
    
    //private BitmapTextureAtlas bitmapTextureAtlas;
    //private TextureRegion textureRegion;
    //private Sprite sprite;
	

    
	public Engine onLoadEngine() {
		this.MyCamera = new Camera(0, 0, WIDTH, HEIGHT);

		MapEntity = new Map();
		BounderEntity = new Bounder();
		Engine engine = new Engine(new EngineOptions(true,
				ScreenOrientation.LANDSCAPE, new RatioResolutionPolicy(WIDTH,
						HEIGHT), this.MyCamera));
		return engine;
	}

	public void onLoadResources() {
		// TODO Auto-generated method stub
		MapEntity.LoadResource(this, mEngine);
		BounderEntity.LoadResource(this, mEngine);
	}
	private ArrayList<Sprite> mapSprites;
	private ArrayList<Sprite> bounderSprites;
	public Scene onLoadScene() {		
		this.mEngine.registerUpdateHandler(new FPSLogger());
		MyScene = new Scene();
		MyScene.setBackground(new ColorBackground(0.09804f, 0.6274f, 0.8784f));
		
		mapSprites = MapEntity.LoadScene();
		for (int i=0; i<mapSprites.size(); i++)
			MyScene.attachChild((mapSprites.get(i)));
		
		bounderSprites = BounderEntity.LoadScene();
		for (int i=0; i<bounderSprites.size(); i++)
			MyScene.attachChild((bounderSprites.get(i)));
			
		 
			/*MyScene.setOnAreaTouchTraversalFrontToBack();
			 MyScene.setOnSceneTouchListener(new IOnSceneTouchListener() {                 
		        	public boolean onSceneTouchEvent(final Scene pScene, final TouchEvent pSceneTouchEvent) { 
			          
			           return true; 
		                   }		
		             });
			MyScene.setTouchAreaBindingEnabled(true);
			MyScene.registerUpdateHandler(UpdateHandler);*/
			return MyScene;
	}

	public void onLoadComplete() {
		// TODO Auto-generated method stub
		mEngine.registerUpdateHandler(new TimerHandler(0.01f, new ITimerCallback() {			
			public void onTimePassed(TimerHandler pTimerHandler) {
				 mEngine.unregisterUpdateHandler(pTimerHandler);
                 mEngine.setScene(MyScene);	//Khi load xong thì ta chờ cho load phần MyScene
                 //Khi MyScene load xong ta cho hiện thị lên màn hình
			}
		}));
	}

	IUpdateHandler UpdateHandler = new IUpdateHandler(){
		public void reset() {
		}
		public void onUpdate(float pSecondsElapsed) {

		}
	};

    
}
