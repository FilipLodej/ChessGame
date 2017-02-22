package capgemini.chessgame;

public abstract class Figure {

	Type type;
	FigureColor color;
	boolean isAvailbleInGame;
	boolean isFirstPosition;
	public Field field;
	Board board;

	public Figure(Type type, FigureColor color, Field field) {
		this.field = field;
		this.type = type;
		this.color = color;
		isAvailbleInGame = true;
		isFirstPosition = true;
	}

	public Figure(Board board, Type type, FigureColor color, Field field) {
		this(type, color, field);
		this.board = board;			//Konstruktor z tablica do testow
	}

	/**
	 * Czy ruch jest dozwolony dla danej figury?
	 * 
	 * @param fieldFrom
	 * @param fieldTo
	 * @return
	 */
	public abstract boolean isMovementShapeCorrectForFigure(Field fieldFrom, Field fieldTo);

	/**
	 * Czy ruch jest mozliwy do wykonania?
	 * 
	 * @param fieldFrom
	 * @param fieldTo
	 * @return
	 */
	public abstract boolean isMovementAllowed(Field fieldFrom, Field fieldTo);

	/**
	 * Metoda ogolna Final laczaca wszystkie pozostałe walidacje a) czy ruch
	 * jest dozwolony dla danej figury b) czy ruch jest możliwy do wykonania c)
	 * czy ruch nie spowoduje zrobienia sobie samemu szacha
	 * 
	 * @param fieldFrom
	 * @param fieldTo
	 * @return
	 */
	public boolean isMoveValidFinal(Field fieldFrom, Field fieldTo) {
		boolean ownCheckmate = this.isOwnCheck(fieldFrom, fieldTo);
		boolean movementShapeCorrect = this.isMovementShapeCorrectForFigure(fieldFrom, fieldTo);
		boolean isMovementAllowed = this.isMovementAllowed(fieldFrom, fieldTo);
		return movementShapeCorrect && isMovementAllowed && !ownCheckmate;
	}

	/**
	 * Sprawdzenie czy jest mozliwe bicie zaimplementowane w kazdej figurze
	 * 
	 * @param field
	 * @param kingField
	 * @return
	 */
	public abstract boolean isTakePossible(Field fieldFrom, Field fieldTo);

	public boolean boardMoveValidation(Field fieldFrom, Field fieldTo) {
		boolean moveIsPossible = true;
		if (fieldTo.getCordinateY() > this.board.fields.length || fieldTo.getCordinateX() > this.board.fields.length
				|| fieldTo.getCordinateY() < 0 || fieldTo.getCordinateX() < 0) {
			System.out.println("Incorect cordinates to move");
			moveIsPossible = false;
		}
		return moveIsPossible;
	}

	public boolean isAnotherColor(Figure firstFigure, Figure secondFigure) {
		boolean isAnotherColor = false;
		if (firstFigure.getColor() != secondFigure.getColor()) {
			isAnotherColor = true;
		}
		return isAnotherColor;
	}

	public boolean isOwnCheck(Field fieldFrom, Field fieldTo) { // Sprawdzenie
																// wlasnego
																// szacha
		Figure from = fieldFrom.getFigure();
		fieldFrom.setFigure(null);
		boolean isOwnCheck = false;
		Field kingField = getKingField(fieldFrom.getFigure().getColor());
		for (int y = 0; y < this.board.fields.length; y++) {
			for (int x = 0; x < this.board.fields[y].length; x++) {
				Field field = this.board.fields[y][x];
				Figure figure = this.board.fields[y][x].getFigure();
				if (figure != null && figure.isAvailbleInGame()) {
					isOwnCheck = figure.isTakePossible(field, kingField);
				}
			}
		}
		fieldFrom.setFigure(from);
		return isOwnCheck;
	}

	private Field getKingField(FigureColor color) {
		Field kingField = null;
		for (int y = 0; y < this.board.fields.length; y++) {
			for (int x = 0; x < this.board.fields[y].length; x++) {
				Field field = this.board.fields[y][x];
				Figure figure = this.board.fields[y][x].getFigure();
				if (figure != null && figure.isAvailbleInGame() == true && figure.getColor() == color) {
					if (figure instanceof King) {
						kingField = field;
					}
				}
			}
		}
		return kingField;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public boolean isAnyFigureOnTheWayStraight(Field fieldFrom, Field fieldTo) {
		boolean isFigureOnStraightWay = false;
		int fromY = fieldFrom.getCordinateY();
		int fromX = fieldFrom.getCordinateX();
		int toY = fieldTo.getCordinateY();
		int toX = fieldTo.getCordinateX();
		if (fromY == toY) {
			if (fromX - toX > 0) {
				for (int x = fromX - 1; x > toX; x--) {
					Figure figure = this.board.fields[x][toY].getFigure();
					if (figure != null) {
						isFigureOnStraightWay = true;
					}
				}
			} else if (fromX - toX < 0) {
				for (int x = fromX + 1; x < toX; x++) {
					Figure figure = this.board.fields[x][toY].getFigure();
					if (figure != null) {
						isFigureOnStraightWay = true;
					}
				}
			}
		}
		if (fromX == toX) {
			if (fromY - toY > 0) {
				for (int y = fromY - 1; y > toY; y--) {
					Figure figure = this.board.fields[toX][y].getFigure();
					if (figure != null) {
						isFigureOnStraightWay = true;
					}
				}
			} else if (fromY - toY < 0) {
				for (int y = fromY + 1; y < toY; y++) {
					Figure figure = this.board.fields[toX][y].getFigure();
					if (figure != null) {
						isFigureOnStraightWay = true;
					}
				}
			}
		}
		return isFigureOnStraightWay;
	}

	public boolean isAnyFigureOnTheWayDiagonal(Field fieldFrom, Field fieldTo) {
		boolean isFigureOnDiagonalWay = false;
		int fromY = fieldFrom.getCordinateY();
		int fromX = fieldFrom.getCordinateX();
		int toY = fieldTo.getCordinateY();
		int toX = fieldTo.getCordinateX();
		if (fromY > toY && fromX < toX) {
			int y = fromY - 1;
			for (int x = fromX + 1; x < toX; x++) {
				Figure figure = this.board.fields[x][y].getFigure();
				if (figure != null) {
					isFigureOnDiagonalWay = true;
				}
				y--;
			}
		} else if (fromY > toY && fromX > toX) {
			int y = fromY - 1;
			for (int x = fromX - 1; x > toX; x--) {
				Figure figure = this.board.fields[x][y].getFigure();
				if (figure != null) {
					isFigureOnDiagonalWay = true;
				}
				y--;

			}
		} else if (fromY < toY && fromX > toX) {
			int y = fromY + 1;
			for (int x = fromX - 1; x > toX; x--) {
				Figure figure = this.board.fields[x][y].getFigure();
				if (figure != null) {
					isFigureOnDiagonalWay = true;
				}
				y++;
			}
		} else if (fromY < toY && fromX < toX) {
			int y = fromY + 1;
			for (int x = fromX + 1; x < toX; x++) {
				Figure figure = this.board.fields[x][y].getFigure();
				if (figure != null) {
					isFigureOnDiagonalWay = true;
				}
				y++;
			}
		}
		return isFigureOnDiagonalWay;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public FigureColor getColor() {
		return color;
	}

	public void setFigureColor(FigureColor color) {
		this.color = color;
	}

	public boolean isAvailbleInGame() {
		return isAvailbleInGame;
	}

	public void setAvailbleInGame(boolean isAvailbleInGame) {
		this.isAvailbleInGame = isAvailbleInGame;
	}

	public boolean isFirstPosition() {
		return isFirstPosition;
	}

	public void setFirstPosition(boolean isFirstPosition) {
		this.isFirstPosition = isFirstPosition;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

}
