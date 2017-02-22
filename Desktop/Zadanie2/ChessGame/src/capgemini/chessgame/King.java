package capgemini.chessgame;

public class King extends Figure {

	public King(Board board, Type type, FigureColor color, Field field) {
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
			if (Math.abs(fromX - toX) > 1 || Math.abs(fromY - toY) > 1) {
				moveAvailable = false;
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
			if (isMovementShapeCorrectForFigure(fieldFrom, fieldTo)) {
				isMovementAllowed = true;
			}
		} else if (isMovementShapeCorrectForFigure(fieldFrom, fieldTo) && isTakePossible(fieldFrom, fieldTo)) {
			isMovementAllowed = true;
		}
		return isMovementAllowed;
	}

	@Override
	public boolean isTakePossible(Field fieldFrom, Field fieldTo) {
		boolean isTakePossible = false;
		if (fieldTo.getFigure() != null) {
			if (isMovementShapeCorrectForFigure(fieldFrom, fieldTo)
					&& isAnotherColor(fieldFrom.getFigure(), fieldTo.getFigure())
					&& fieldTo.getFigure().isAvailbleInGame()) {
				isTakePossible = true;
			}
		}
		return isTakePossible;
	}

}
