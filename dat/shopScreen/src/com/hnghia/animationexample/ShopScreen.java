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
import org.anddev.andengine.entity.text.ChangeableText;
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

public class ShopScreen extends BaseGameActivity {

	int money = 1000;
	private BitmapTextureAtlas mFontTexture;// Lưu font vào bộ nhớ
	private Font mFont;// Dùng để lưu lại font

	private Camera MyCamera;// Biến này thường để cấu hình màn hình
	private Scene MyScene;// Quản lý những gì bạn vẽ.

	private Shop_Item item_s1;
	private Shop_Item item_s2;
	private Shop_Item item_s3;
	private Shop_Item item_s4;

	private AnimationSprite spriteMoney;
	private AnimationSprite spriteNext;
	private AnimationSprite spriteBuy;
	private AnimationSprite spriteSeller1;
	private AnimationSprite spriteSeller2;

	private RepeatingSpriteBackground mGrassBackground;// Khai báo đối tượng

	private int WIDTH = 512;
	private int HEIGHT = 256;

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
		this.mGrassBackground = new RepeatingSpriteBackground(WIDTH, HEIGHT,
				this.mEngine.getTextureManager(),
				new AssetBitmapTextureAtlasSource(this, "shop_background.png"));

		MyScene = new Scene();

		this.spriteMoney = new AnimationSprite("money.png", this, mEngine, 110,
				210, MyScene, 256, 128, 1, 1);
		this.spriteBuy = new AnimationSprite("s_buy.png", this, mEngine, 300,
				200, MyScene, 256, 128, 1, 1);

		/*
		 * this.spriteBuy.setAnimatedSprite(new
		 * AnimatedSprite(this.spriteBuy.getX(), this.spriteBuy.getY(),
		 * this.spriteBuy.getTiledTextureRegion()) {
		 * 
		 * @Override public boolean onAreaTouched(final TouchEvent
		 * pSceneTouchEvent, final float pTouchAreaLocalX, final float
		 * pTouchAreaLocalY) { if (pSceneTouchEvent.getAction() ==
		 * TouchEvent.ACTION_DOWN) { if(spriteSeller1.isVisible) {
		 * spriteSeller1.setVisible(false); spriteSeller2.setVisible(true);
		 * 
		 * } else { spriteSeller1.setVisible(true);
		 * spriteSeller2.setVisible(false); } } return true; } });
		 */
		this.spriteNext = new AnimationSprite("s_next.png", this, mEngine, 420,
				205, MyScene, 256, 128, 1, 1);
		this.spriteSeller1 = new AnimationSprite("seller1.png", this, mEngine,
				300, 0, MyScene, 256, 256, 1, 1);
		this.spriteSeller2 = new AnimationSprite("seller2.png", this, mEngine,
				300, 0, MyScene, 256, 256, 1, 1);
		this.spriteSeller2.setVisible(false);

		this.mFontTexture = new BitmapTextureAtlas(256, 256,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		// Tạo font mạc định và style là chữ đậm, cỡ chứ 14 màu đen
		this.mFont = new Font(this.mFontTexture, Typeface.create(
				Typeface.DEFAULT, Typeface.BOLD), 14, true, Color.GREEN);
		// Load
		this.mEngine.getTextureManager().loadTexture(this.mFontTexture);
		this.mEngine.getFontManager().loadFont(this.mFont);

		this.item_s1 = new Shop_Item("s_1.png", this, 180, 150, 180, 190, 300,
				MyScene, this.mFont, this.mEngine);
		this.item_s2 = new Shop_Item("s_2.png", this, 100, 145, 100, 190, 100,
				MyScene, this.mFont, this.mEngine);
		this.item_s3 = new Shop_Item("s_3.png", this, 250, 150, 250, 190, 200,
				MyScene, this.mFont, this.mEngine);
		this.item_s4 = new Shop_Item("s_4.png", this, 20, 140, 20, 190, 150,
				MyScene, this.mFont, this.mEngine);

	}

	@Override
	public Scene onLoadScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());

		MyScene.setBackground(this.mGrassBackground);
		MyScene.setTouchAreaBindingEnabled(true);
		MyScene.setOnSceneTouchListener(new IOnSceneTouchListener() {
			public boolean onSceneTouchEvent(final Scene pScene,
					final TouchEvent pSceneTouchEvent) {
				if (pSceneTouchEvent.getAction() == TouchEvent.ACTION_DOWN) {
					if (spriteBuy.isTaped(pSceneTouchEvent.getX(),
							pSceneTouchEvent.getY())) {
						System.out
								.println("MyScene onSceneTouchEvent: chạm vào màn hình");
						System.out.println("Tọa độ X = "
								+ pSceneTouchEvent.getX());
						System.out.println("Tọa độ Y = "
								+ pSceneTouchEvent.getY());
						if (spriteSeller1.isVisible) {
							spriteSeller1.setVisible(false);
							spriteSeller2.setVisible(true);

						} else {
							spriteSeller1.setVisible(true);
							spriteSeller2.setVisible(false);
						}
					}
				}
				return true;
			}
		});
		/*
		 * this.MyScene.registerTouchArea(spriteBuy.getAnimatedSprite());
		 * this.spriteBuy.animatedSprite = new
		 * AnimatedSprite(spriteBuy.X,spriteBuy.Y,
		 * spriteBuy.getTiledTextureRegion()) {
		 * 
		 * @Override public boolean onAreaTouched(final TouchEvent
		 * pSceneTouchEvent, final float pTouchAreaLocalX, final float
		 * pTouchAreaLocalY) { if (pSceneTouchEvent.getAction() ==
		 * TouchEvent.ACTION_DOWN) { if(spriteSeller1.isVisible) {
		 * spriteSeller1.setVisible(false); spriteSeller2.setVisible(true);
		 * 
		 * } else { spriteSeller1.setVisible(true);
		 * spriteSeller2.setVisible(false); } } return true; } };
		 */
		// MyScene.attachChild(spriteBuy.getAnimatedSprite());
		// ======================================LẮNG NGHE SỰ KIỆN KHI CHẠM VÀO
		// ANIMATEDSPRITE=====================================================================

		final ChangeableText txtmoney = new ChangeableText(60, 215, this.mFont,
				"Money", 10);
		MyScene.attachChild(txtmoney);

		final ChangeableText money2 = new ChangeableText(115, 215, this.mFont,
				Integer.toString(money), 10);
		MyScene.attachChild(money2);

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
