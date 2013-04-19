package com.hnghia.animationexample;

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
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.AssetBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.ui.activity.BaseGameActivity;
import org.anddev.andengine.util.HorizontalAlign;

import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Menu;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.scene.background.RepeatingSpriteBackground;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.AssetBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.ui.activity.BaseGameActivity;
import org.anddev.andengine.util.HorizontalAlign;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Menu;

public class Shop_Item {
	private BitmapTextureAtlas bitmapTextureAtlas;// Lưu ảnh trong bộ nhớ
	private TiledTextureRegion tiledTextureRegion;// Lưu khi load ảnh
	private AnimatedSprite animatedSprite;
	private Scene scene;
	private float X;
	private float Y;
	private float Xcost;
	private float Ycost;
	private boolean choosed = false;
	int cost;
	Font font;

	public Shop_Item(String texture, Context con, float X, float Y,
			float Xcost, float Ycost, int cost, Scene scene, Font font,
			Engine engine) {
		this.bitmapTextureAtlas = new BitmapTextureAtlas(128, 128,
				TextureOptions.BILINEAR);
		this.tiledTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(this.bitmapTextureAtlas, con, texture, 0,
						0, 2, 1);
		this.font = font;
		this.X = X;
		this.Y = Y;
		this.Xcost = Xcost;
		this.Ycost = Ycost;
		this.cost = cost;
		this.scene = scene;

		final Text s1Cost = new Text(this.Xcost, this.Ycost, this.font, "$"
				+ Integer.toString(cost), HorizontalAlign.CENTER);
		this.scene.attachChild(s1Cost);
		this.animatedSprite = new AnimatedSprite(this.X, this.Y,
				this.tiledTextureRegion) {
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {

				if (pSceneTouchEvent.getAction() == TouchEvent.ACTION_DOWN) {
					System.out
							.println("MyScene onSceneTouchEvent: chạm vào shopItem");
					System.out.println("Tọa độ X = " + pSceneTouchEvent.getX());
					System.out.println("Tọa độ Y = " + pSceneTouchEvent.getY());
					if (animatedSprite.getCurrentTileIndex() == 0) {
						choosed = true;
						animatedSprite.setCurrentTileIndex(1, 0);
					} else {
						choosed = false;
						animatedSprite.setCurrentTileIndex(0, 0);
					}
				}
				return true;
			}
		};
		engine.getTextureManager().loadTexture(this.GetbitmapTextureAtlas());
		scene.attachChild(animatedSprite);// Add vào MyScene
		scene.registerTouchArea(animatedSprite);
	}

	public boolean isChoosed() {
		return choosed;
	}

	public BitmapTextureAtlas GetbitmapTextureAtlas() {
		return this.bitmapTextureAtlas;

	}

	public int getCost() {
		return cost;
	}

}
