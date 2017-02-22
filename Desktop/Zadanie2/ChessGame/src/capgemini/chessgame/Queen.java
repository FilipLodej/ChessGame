package capgemini.chessgame;

public class Queen extends Figure {

	public Queen(Board board, Type type, FigureColor color, Field field) {
		super(board, type, color, field);

	}

	@Override
	public boolean isMovementShapeCorrectForFigure(Field fieldFrom, Field fieldTo) {
		boolean moveAvailable = true;
		boolean availableForBoard = this.boardMoveValidation(fieldFrom, fieldTo);
		if (availableForBoard) {
			int fromX = fieldFrom.getCordinateX();
			int fromY = fieldFrom.getCordinateY();
			int toX = fieldTo.getCordinateX();
			int toY = fieldTo.getCordinateY();
			if (toX != fromX && toY != fromY) {
				if (Math.abs(fromX - toX) != Math.abs(fromY - toY)) {
					moveAvailable = false;
				}
			} else if (toX == fromX && toY == fromY) {
				moveAvailable = false;
				System.out.println("No movement!");
			}
		} else {
			moveAvailable = false;
		}
		return moveAvailable;
	}

	@Override
	public boolean isMovementAllowed(Field fieldFrom, Field fieldTo) {
		// TODO do zaimplementowania problem z odroznieniem ruchu prostego od
		// diagonalnego i sprawdzeniem czy cos stoi na przeszkodzie
		return false;
	}

	@Override
	public boolean isTakePossible(Field fieldFrom, Field fieldTo) {
		// TODO do zaimplementowania problem z odroznieniem ruchu prostego od
		// diagonalnego i sprawdzeniem czy cos stoi na przeszkodzie
		return false;
	}

}
