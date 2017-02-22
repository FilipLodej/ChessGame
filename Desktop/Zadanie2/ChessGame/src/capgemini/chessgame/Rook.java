package capgemini.chessgame;

public class Rook extends Figure {

	public Rook(Board board, Type type, FigureColor color, Field field) {
		super(board, type, color, field);

	}

	@Override
	public boolean isMovementShapeCorrectForFigure(Field fieldFrom, Field fieldTo) {
		boolean moveAvailable = true;
		boolean possibleForBoard = this.boardMoveValidation(fieldFrom, fieldTo);
		if (possibleForBoard) {
			int fromX = fieldFrom.getCordinateX();
			int fromY = fieldFrom.getCordinateY();
			int toX = fieldTo.getCordinateX();
			int toY = fieldTo.getCordinateY();
			if (toX != fromX && toY != fromY) {
				moveAvailable = false;
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
		boolean isMovementAllowed = false;
		if (fieldTo.getFigure() == null) {
			if (isMovementShapeCorrectForFigure(fieldFrom, fieldTo)
					&& !isAnyFigureOnTheWayStraight(fieldFrom, fieldTo)) {
				isMovementAllowed = true;
			}
		} else if (isMovementShapeCorrectForFigure(fieldFrom, fieldTo)
				&& !isAnyFigureOnTheWayStraight(fieldFrom, fieldTo) && isTakePossible(fieldFrom, fieldTo)) {
			isMovementAllowed = true;

		}
		return isMovementAllowed;
	}

	@Override
	public boolean isTakePossible(Field fieldFrom, Field fieldTo) {
		boolean isTakePossible = false;
		if (fieldTo.getFigure() != null) {
			if (isMovementShapeCorrectForFigure(fieldFrom, fieldTo) && !isAnyFigureOnTheWayStraight(fieldFrom, fieldTo)
					&& isAnotherColor(fieldFrom.getFigure(), fieldTo.getFigure())
					&& fieldTo.getFigure().isAvailbleInGame()) {
				isTakePossible = true;
			}
		}
		return isTakePossible;
	}
}
