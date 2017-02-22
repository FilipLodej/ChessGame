package capgemini.chessgame;

public class Knight extends Figure {

	public Knight(Board board, Type type, FigureColor color, Field field) {
		super(board, type, color, field);
	}

	@Override
	public boolean isMovementShapeCorrectForFigure(Field fieldFrom, Field fieldTo) {
		boolean moveAvailable = true;
		boolean possibleForBoard = this.boardMoveValidation(fieldFrom, fieldTo);
		if (possibleForBoard) {
			int fromY = fieldFrom.getCordinateY();
			int toY = fieldTo.getCordinateY();
			int fromX = fieldFrom.getCordinateY();
			int toX = fieldTo.getCordinateX();
			if (Math.abs(fromY - toY) > 2 || Math.abs(fromX - toX) > 2) {
				moveAvailable = false; // ruch poza zakres
			} else if (Math.abs(fromY - toY) < 1 || Math.abs(fromX - toX) < 1) {
				moveAvailable = false; // warunek braku ruchu
				System.out.println("No movement!");
			} else if (Math.abs(fromY - toY) == 1 && Math.abs(fromX - toX) == 1) {
				moveAvailable = false;
			} else if (Math.abs(fromY - toY) == 2 && Math.abs(fromX - toX) == 2) {
				moveAvailable = false;
			}
		} else {
			moveAvailable = false;
		}
		return moveAvailable;

	}

	public boolean isMovePossible(Field fieldFrom, Field fieldTo) {
		boolean movePossible = true;
		return movePossible;
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
				isTakePossible=true;
			}
		}
		return isTakePossible;
	}

}
