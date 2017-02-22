package capgemini.chessgame;

public class Board {

	public Field[][] fields;

	public Board() {
		fields = new Field[8][8];
		generateBoard();
	}

	public void generateBoard() {
		for (int x = 0; x < fields.length; x++) {

			System.out.print("X=" + x + " ");
		}
		System.out.println();
		for (int y = 0; y < fields.length; y++) {
			for (int x = 0; x < fields[y].length; x++) {
				Field field = new Field(y, x);
				fields[y][x] = field;
				System.out.print(field.toString());
			}
			System.out.println("Y=" + y);
		}

	}

	public Field[][] getFields() {
		return fields;
	}

	public void setFields(Field[][] fields) {
		this.fields = fields;
	}
	
	public Field getField(int y, int x){
		Field field=fields[y][x];
		return field;
	}

}
