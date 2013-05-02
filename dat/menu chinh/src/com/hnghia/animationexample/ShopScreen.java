package com.hnghia.animationexample;

import java.util.ArrayList;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.scene.background.RepeatingSpriteBackground;
import org.anddev.andengine.entity.text.ChangeableText;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.AssetBitmapTextureAtlasSource;
import org.anddev.andengine.ui.activity.BaseGameActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;

public class ShopScreen extends BaseGameActivity {


	private boolean b = true;
	private Camera MyCamera;// Biến này thường để cấu hình màn hình
	private Scene MyScene;// Quản lý những gì bạn vẽ.

	private AnimationSprite background;
	private AnimationSprite btn_Batdau;
	private AnimationSprite btn_HuongDan;
	private AnimationSprite btn_CaiDat;
	private AnimationSprite btn_DiemCao;

	private RepeatingSpriteBackground mGrassBackground;// Khai báo đối tượng

	private int WIDTH = 480;
	private int HEIGHT = 320;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_animation);
	}

	@Override
	public Engine onLoadEngine() {
		this.MyCamera = new Camera(0, 0, WIDTH, HEIGHT);
		Engine engine = new Engine(new EngineOptions(true,
				ScreenOrientation.LANDSCAPE, new RatioResolutionPolicy(WIDTH,
						HEIGHT), this.MyCamera));
		
		return engine;
	}

	@Override
	public void onLoadResources() {
		MyScene = new Scene();
		MyScene.setBackground(new ColorBackground(0.09804f, 0.6274f, 0.8784f)); 
		this.background = new AnimationSprite("background_menu.png", this, mEngine, 0,
				0, MyScene, 512, 512, 1, 1);
		this.btn_Batdau = new AnimationSprite("btn_begin.png", this, mEngine, 20,
				180, MyScene, 512, 512, 2, 1);
		this.btn_CaiDat = new AnimationSprite("btn_setting.png", this, mEngine, 50,
				110, MyScene, 512, 512, 2, 1);
		this.btn_HuongDan = new AnimationSprite("btn_help.png", this, mEngine, 160,
				150, MyScene, 512, 512, 2, 1);
		this.btn_DiemCao = new AnimationSprite("btn_score.png", this, mEngine, 180,
				230, MyScene, 512, 512, 2, 1);


	}

	@Override
	public Scene onLoadScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());
		
		MyScene.setTouchAreaBindingEnabled(true);
		MyScene.setOnSceneTouchListener(new IOnSceneTouchListener() {
			public boolean onSceneTouchEvent(final Scene pScene,
					final TouchEvent pSceneTouchEvent) {
				if (pSceneTouchEvent.getAction() == TouchEvent.ACTION_DOWN) {
					if (btn_Batdau.isTaped(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY())) {
						if(b)
						{
							btn_Batdau.setCurrentTileIndex(1, 0);
							b=!b;
						}
						else
						{
							btn_Batdau.setCurrentTileIndex(0, 0);
							b=!b;
						}
						
					}
					if (btn_CaiDat.isTaped(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY())) {
						btn_CaiDat.setCurrentTileIndex(1, 0);
					}
					if (btn_DiemCao.isTaped(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY())) {
						btn_DiemCao.setCurrentTileIndex(1, 0);
					}
					if (btn_HuongDan.isTaped(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY())) {
						btn_HuongDan.setCurrentTileIndex(1, 0);
						
					}
					
				}
				return true;
			}
		});


		// ===========================================================================================================
		// Cập nhật (coi như vòn lặp hoạt cảnh)
		MyScene.registerUpdateHandler(new IUpdateHandler() {
			@Override
			public void reset() {
				// TODO Auto-generated method stub
			}

			// Muốn cập nhật cái gì thì cho vào đây
			@Override
			public void onUpdate(float pSecondsElapsed) {
				try {
					// Tạm dừng cập nhật trong 10 ms
					Thread.sleep(10);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		return MyScene;
	}

	@Override
	public void onLoadComplete() {
		// TODO Auto-generated method stub

	}
}
