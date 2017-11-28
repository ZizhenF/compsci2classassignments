public class IntPoint2D implements IIntPoint2D {
	int x;
	int y;

	//constructor
	IntPoint2D(int x_value, int y_value) {
		this.x = x_value;
		this.y = y_value;
	}

	//returns x coordinate
	public int getX() {
		return x;
	}
	//returns y coordinate
	public int  getY() {
		return y;
	}

	//computes the manhattan distance betweent two points
	public int manhattanDistance(IIntPoint2D o) {
		IntPoint2D other = (IntPoint2D) o;
		return Math.abs(x - other.x) + Math.abs(y - other.y);
	}

	//computes the euclidean distance between two points
	public double distance(IIntPoint2D o) {
		IntPoint2D other = (IntPoint2D) o;
		double d1 = (double)x - (double)other.x;
		double d2 = (double)y - (double)other.y;
		double sqd1 = Math.pow(d1,2.0);
		double sqd2 = Math.pow(d2,2.0);
		double dis = Math.sqrt(sqd1+sqd2);
		return dis;
	}

	//returns the string (X,Y)
	public String toString() {
		String rep = "("+x+","+y+")";
		return rep;
	}

	//check if two points are same
	public boolean equals(IntPoint2D o) {
		if (x == o.x & y == o.y) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashcode() {
		return ((x<<16)+y);
	}
}