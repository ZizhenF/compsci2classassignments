public class IntGrid2D implements IIntGrid2D{

	int ulx;
	int uly;
	int lrx;
	int lry;
	char fill;
	char[][] grid;

	public IntGrid2D(int _ulx, int _uly, int _lrx, int _lry, char _fill) {
		this.ulx = _ulx;
		this.uly = _uly;
		this.lrx = _lrx;
		this.lry = _lry;
		this.fill = _fill;
		grid = new char[(lrx-ulx+1)][(uly-lry+1)];

		for (int i = 0; i <= lrx-ulx; i++) {
			for (int j = 0; j <= uly-lry; j++ ) {
				grid[i][j] = fill;
			}
		}
	}

	public void setPoint(IIntPoint2D p, char v) {
		grid[p.getX()+(0-ulx)][p.getY()+(0-lry)] = v;
	}

	public char getPoint(IIntPoint2D p) {
		return grid[p.getX()+(0-ulx)][p.getY()+(0-lry)];
	}

	public IIntPoint2D getUpperLeftCorner() {
		IIntPoint2D upperLeftP = new IntPoint2D(ulx,uly);
		return upperLeftP;
	}

	public IIntPoint2D getLowerRightCorner() {
		IIntPoint2D lowerRightP = new IntPoint2D(lrx,lry);
		return lowerRightP;
	}
}