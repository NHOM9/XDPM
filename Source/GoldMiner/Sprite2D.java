package Sprite2DGame;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

import android.content.Context;

public class Sprite2D {
	//private Scene MyScene;
	
	/**
	 * Texture Image
	 */	
	private BitmapTextureAtlas bitmapTextureAtlas;// Buffer Image
	private TextureRegion textureRegion;// Frame Image
	private Sprite sprite;// Image 
	
	/**
	 * Position Image in Screen
	 */
	private float _PositionX;
	private float _PositionY;
	
	/**
	 * Path file Image from resource
	 */
	private String _PathFileImage = null;
	private String _PathDirectoryImage = null;

	/**
	 * rectangle to draw in Scene
	 */
	private int RectangleWidth;
	private int RectangleHeight;
	
	/**
	 *  Buffer size to load Image to frame
	 */
	private int _BufferSizeWidth;
	private int _BufferSizeHeight;
	
	/**
	 * 
	 * @param _PathFileImage
	 * this method to set Path File Image from resource
	 */
	public void set_PathFileImage(String _PathFileImage) {
		this._PathFileImage = _PathFileImage;
	}	

	/**
	 * this method to set path directory Image from resource
	 * @param _PathDirectoryImage
	 */
	public void set_PathDirectoryImage(String _PathDirectoryImage) {
		this._PathDirectoryImage = _PathDirectoryImage;
	}

	/**
	 * this method to constructor Sprite2D with bufferSizeWidth, bufferSizeHeight, positionX, positionY
	 * @param bufferSizeWidth
	 * @param bufferSizeHeight
	 * @param positionX
	 * @param positionY
	 */
	public Sprite2D(int bufferSizeWidth, int bufferSizeHeight, 
			float positionX, float positionY)
	{
		_BufferSizeWidth = bufferSizeWidth;
		_BufferSizeHeight = bufferSizeHeight;
		_PositionX = positionX;
		_PositionY = positionY;

	}
		
	/**
	 * this method to load Resource with parameter Context, Engine
	 * @param mContext
	 * @param mEngine
	 */
	public void LoadResource (Context mContext,Engine mEngine)
	{
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath(_PathDirectoryImage);
		this.bitmapTextureAtlas = new BitmapTextureAtlas(_BufferSizeWidth, _BufferSizeHeight, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		textureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.bitmapTextureAtlas, mContext, _PathFileImage,(int)_PositionX, (int)_PositionY);		
	
		mEngine.getTextureManager().loadTextures(this.bitmapTextureAtlas);
	}
	
	/**
	 * this method to LoadScene 
	 * @param RextangleWidth
	 * @param RectangleHeight
	 * @return Sprite to add child Scene
	 */
	
	public Sprite LoadScene()
	{
		sprite = new Sprite(_PositionX, _PositionY, this.RectangleWidth,this.RectangleHeight, this.textureRegion);
		return sprite;
	}


}
