package Algorithm;

public class PathStraight {
	float S0;
	int Angle_A;		// goc lech cua hook so vs Ox
	float S;
	float V0;			// Van toc ban dau
	int V;				// Van toc tuc thoi
	double Pi = Math.PI / 180;
	public PathStraight()
	{
		S = 0;
		V = 0;
	}
	
	// 
	public void SetPath(float S0, float A, int angleA, float V0)
	{
		this.S0 = S0;

		this.Angle_A = angleA;
		this.V0 = V0;
		S = S0;
		V = 0;
	}
	public float S()
	{
		V += V0;
		S += V;
		return S;
	}
	
	// get Position X
	public float getX()
	{
		return (float)(S* Math.cos(Angle_A * Pi));
		
	}
	
	// Get Position Y
	public float getY()
	{
		return (float)(S* Math.sin(Angle_A * Pi));
	}

}
