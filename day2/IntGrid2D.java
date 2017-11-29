public class IntGrid2D implements IIntGrid2D{

	int ulx;
	int uly;
	int lrx;
	int lry;
	char fill;
	char[][] grid;

	//constructor taking in upper left coords, lower right coords and the fiiling
	public IntGrid2D(int _ulx, int _uly, int _lrx, int _lry, char _fill) {
		this.ulx = _ulx;
		this.uly = _uly;
		this.lrx = _lrx;
		this.lry = _lry;
		this.fill = _fill;

		//create a 2D array of input size
		grid = new char[(lrx-ulx+1)][(uly-lry+1)];

		for (int i = 0; i <= lrx-ulx; i++) {
			for (int j = 0; j <= uly-lry; j++ ) {
				grid[i][j] = fill;
			}
		}
	}

	//take coords from the IntPoint2D object and change the fill
	public void setPoint(IIntPoint2D p, char v) {
		grid[p.getX()+(0-ulx)][p.getY()+(0-lry)] = v;
	}

	//take coords from the IntPoint2D object and return the fill
	public char getPoint(IIntPoint2D p) {
		return grid[p.getX()+(0-ulx)][p.getY()+(0-lry)];
	}

	//return a Intpoint2D object constructed with upper leter coords
	public IIntPoint2D getUpperLeftCorner() {
		IIntPoint2D upperLeftP = new IntPoint2D(ulx,uly);
		return upperLeftP;
	}

	//return a Intpoint2D object constructed with lower right coords
	public IIntPoint2D getLowerRightCorner() {
		IIntPoint2D lowerRightP = new IntPoint2D(lrx,lry);
		return lowerRightP;
	}
}