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
import android.text.style.LineHeightSpan.WithDensity;
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

public class AnimationSprite {
	private BitmapTextureAtlas bitmapTextureAtlas;// Lưu ảnh trong bộ nhớ
	private TiledTextureRegion tiledTextureRegion;// Lưu khi load ảnh
	public AnimatedSprite animatedSprite;
	private Scene scene;
	public float X;
	public float Y;
	private float width;
	private float height;
	private int col;
	private int row;
	boolean isVisible = true;;

	private boolean choosed = false;

	public AnimationSprite(String texture, Context con, Engine engine, float X,
			float Y, Scene scene, int width, int height, int col, int row) {
		this.bitmapTextureAtlas = new BitmapTextureAtlas(width, height,
				TextureOptions.BILINEAR);
		this.setTiledTextureRegion(BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(this.bitmapTextureAtlas, con, texture, 0,
						0, col, row));
		
		this.col = col;
		this.row = row;
		this.X = X;
		this.Y = Y;
		this.scene = scene;

		this.setAnimatedSprite(new AnimatedSprite(this.X, this.Y, this
				.getTiledTextureRegion()) {
		});
		engine.getTextureManager().loadTexture(this.GetbitmapTextureAtlas());
		this.scene.attachChild(getAnimatedSprite());// Add vào MyScene
		this.scene.registerTouchArea(getAnimatedSprite());
		this.width = animatedSprite.getWidth();
		this.height = animatedSprite.getHeight();
	}

	public boolean isTaped(float x, float y) {
		if (x >= this.X && x <= (this.width / this.col + this.X) && y >= this.Y
				&& y <= (this.height / this.row + this.Y))
			return true;
		return false;

	}

	public boolean isChoosed() {
		return choosed;
	}

	public BitmapTextureAtlas GetbitmapTextureAtlas() {
		return this.bitmapTextureAtlas;

	}

	public void setVisible(boolean b) {
		this.isVisible = b;
		this.getAnimatedSprite().setVisible(b);
	}

	public void setCurrentTileIndex(int col, int row) {
		getAnimatedSprite().setCurrentTileIndex(0, 0);
	}

	AnimatedSprite getAnimatedSprite() {
		return animatedSprite;
	}

	private void setAnimatedSprite(AnimatedSprite animatedSprite) {
		this.animatedSprite = animatedSprite;
	}

	public TiledTextureRegion getTiledTextureRegion() {
		return tiledTextureRegion;
	}

	private void setTiledTextureRegion(TiledTextureRegion tiledTextureRegion) {
		this.tiledTextureRegion = tiledTextureRegion;
	}
}
