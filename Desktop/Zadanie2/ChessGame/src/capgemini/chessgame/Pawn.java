package capgemini.chessgame;

public class Pawn extends Figure {

	public Pawn(Board board, Type type, FigureColor color, Field field) {
		super(board, type, color, field);
	}

	@Override
	public boolean isMovementShapeCorrectForFigure(Field fieldFrom, Field fieldTo) {
		boolean moveAvailable = true;
		boolean possibleForBoard = this.boardMoveValidation(fieldFrom, fieldTo);
		if (possibleForBoard) {
			int fromY = fieldFrom.getCordinateY();
			int toY = fieldTo.getCordinateY();
			int fromX = fieldFrom.getCordinateX();
			int toX = fieldTo.getCordinateX();
			if (fieldFrom.getFigure().getColor() == FigureColor.WHITE && fromY > toY) {
				moveAvailable = false;
			} else if (fieldFrom.getFigure().getColor() == FigureColor.BLACK && fromY < toY) {
				moveAvailable = false;
			} else if (Math.abs(fromY - toY) > 1 && fieldFrom.getFigure().isFirstPosition == false) {
				moveAvailable = false;
			} else if (Math.abs(fromY - toY) > 2 && fieldFrom.getFigure().isFirstPosition == true) {
				moveAvailable = false;
			} else if (Math.abs(fieldFrom.getCordinateX() - fieldTo.getCordinateX()) > 1) {
				moveAvailable = false; // Ruch niemozliwy na skos powyzej
										// jednego pola (przy biciu figury)
			} else if (Math.abs(fieldFrom.getCordinateX() - fieldTo.getCordinateX()) == 1
					&& fieldTo.getFigure() == null) {
				moveAvailable = false; // Ruch niemozliwy jesli nie ma figury do
										// zbicia

			} else if (Math.abs(fieldFrom.getCordinateX() - fieldTo.getCordinateX()) == 1
					&& fieldTo.getFigure().getColor() != fieldFrom.getFigure().getColor()) {
				moveAvailable = false; // Ruch niemozliwy jesli nie mozna zbic
										// figury
			} else if (toX == fromX && toY == fromY) {
				moveAvailable = false;
				System.out.println("No movement!");// Ruch niemozliwy jesli nie
													// ma ruchu
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
					&& !isAnyFigureOnTheWayDiagonal(fieldFrom, fieldTo)) {
				isMovementAllowed = true;
			}
		} else if (isMovementShapeCorrectForFigure(fieldFrom, fieldTo)
				&& !isAnyFigureOnTheWayDiagonal(fieldFrom, fieldTo) && isTakePossible(fieldFrom, fieldTo)) {
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
