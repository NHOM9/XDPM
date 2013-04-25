package ObjectGame;

import Algorithm.PathStraight;
import Sprite2DGame.Sprite2D;


public abstract class AbstractObject {

	public float Position_X_Object;
	public float Position_Y_Object;
	
	protected Sprite2D  	spriteObject;	
	protected PathStraight _pathStraightObject;
		
	
	
	public void UpdatePosition()
	{		
	}
}
