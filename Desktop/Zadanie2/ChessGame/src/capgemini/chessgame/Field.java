package capgemini.chessgame;

public class Field {
	
	private int cordinateX;
	private int cordinateY;
	private Figure figure;

	
	public Field(int cordinateX, int cordinateY) {
		this.cordinateX = cordinateX;
		this.cordinateY = cordinateY;
	}
	
	
	public Figure getFigure() {
		return figure;
	}


	public void setFigure(Figure figure) {
		this.figure = figure;
	}


	public String toString(){
		String string="[  ]";
		return string;
	}


	public int getCordinateX() {
		return cordinateX;
	}


	public void setCordinateX(int cordinateX) {
		this.cordinateX = cordinateX;
	}


	public int getCordinateY() {
		return cordinateY;
	}


	public void setCordinateY(int cordinateY) {
		this.cordinateY = cordinateY;
	}
	
}
