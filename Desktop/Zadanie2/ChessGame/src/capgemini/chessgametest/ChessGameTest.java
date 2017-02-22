package capgemini.chessgametest;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import capgemini.chessgame.Bishop;
import capgemini.chessgame.Board;
import capgemini.chessgame.Field;
import capgemini.chessgame.Figure;
import capgemini.chessgame.FigureColor;
import capgemini.chessgame.King;
import capgemini.chessgame.Knight;
import capgemini.chessgame.Pawn;
import capgemini.chessgame.Queen;
import capgemini.chessgame.Rook;
import capgemini.chessgame.Type;

public class ChessGameTest {
	Board board;

	@Before
	public void setUp() {
		board = new Board();
	}

	@Test
	public void shouldBoardMoveValidationFalseWhenMoveIsOutOfBoard() {
		//given
		Figure pawn=new Pawn(board, Type.PAWN,FigureColor.BLACK,board.fields[0][0]);
		//when
		Field fieldTo=new Field(1, 9);
		//then
		assertFalse(pawn.boardMoveValidation(pawn.getField(), fieldTo));
	}
	@Test
	public void shouldPawnMoveValidationFalseWhenPawnMoveIsImpossibleNotFirstMove() {
		//given
		Field fieldFrom=board.fields[0][0];
		Figure pawn=new Pawn(board, Type.PAWN,FigureColor.WHITE,fieldFrom);
		fieldFrom.setFigure(pawn);
		//when
		Field fieldTo=new Field(0, 2);
		pawn.setFirstPosition(false);
		//then
		assertFalse(pawn.isMovementShapeCorrectForFigure(board.fields[0][0], fieldTo));
	}
	@Test
	public void shouldPawnMoveValidationTrueWhenPawnMoveIsPossibleFirstMove() {
		//given
		Field fieldFrom=board.fields[0][0];
		Figure pawn=new Pawn(board, Type.PAWN,FigureColor.WHITE,fieldFrom);
		fieldFrom.setFigure(pawn);
		//when
		Field fieldTo=new Field(0, 2);
		pawn.setFirstPosition(true);
		//then
		assertTrue(pawn.isMovementShapeCorrectForFigure(board.fields[0][0], fieldTo));
	}
	@Test
	public void shouldKnightMoveValidationFalseWhenKnightMoveIsImpossibleForFigure() {
		//given
		Field fieldFrom=board.fields[3][3];
		Figure knight=new Knight(board, Type.KNIGHT, FigureColor.WHITE, fieldFrom);
		fieldFrom.setFigure(knight);
		//when
		Field fieldTo=new Field(3, 6);
		//then
		assertFalse(knight.isMovementShapeCorrectForFigure(fieldFrom, fieldTo));
	}
	@Test
	public void shouldKnightMoveValidationTrueWhenKnightMoveIsPossibleForFigure() {
		//given
		Field fieldFrom=board.fields[3][3];
		Figure knight=new Knight(board, Type.KNIGHT, FigureColor.WHITE, fieldFrom);
		fieldFrom.setFigure(knight);
		//when
		Field fieldTo=new Field(4, 5);
		//then
		assertTrue(knight.isMovementShapeCorrectForFigure(fieldFrom, fieldTo));
	}
	@Test
	public void shouldKnightMoveValidationTrueWhenKnightMoveIsPossibleForFigureX() {
		//given
		Field fieldFrom=board.fields[3][3];
		Figure knight=new Knight(board, Type.KNIGHT, FigureColor.WHITE, fieldFrom);
		fieldFrom.setFigure(knight);
		//when
		Field fieldTo=new Field(1, 2);
		//then
		assertTrue(knight.isMovementShapeCorrectForFigure(fieldFrom, fieldTo));
	}
	@Test
	public void shouldKnightMoveValidationFalseWhenKnightMoveIsImpossibleForFigure2() {
		//given
		Field fieldFrom=board.fields[3][3];
		Figure knight=new Knight(board, Type.KNIGHT, FigureColor.WHITE, fieldFrom);
		fieldFrom.setFigure(knight);
		//when
		Field fieldTo=new Field(4, 2);
		//then
		assertFalse(knight.isMovementShapeCorrectForFigure(fieldFrom, fieldTo));
	}
	@Test
	public void shouldRookMoveValidationFalseWhenRookMoveIsImpossibleForFigure() {
		//given
		Field fieldFrom=board.fields[3][3];
		Figure rook=new Rook(board, Type.ROOK, FigureColor.WHITE, fieldFrom);
		fieldFrom.setFigure(rook);
		//when
		Field fieldTo=new Field(4, 2);
		//then
		assertFalse(rook.isMovementShapeCorrectForFigure(fieldFrom, fieldTo));
	}
	@Test
	public void shouldRookMoveValidationFalseWhenRookMoveIsImpossibleForFigure2() {
		//given
		Field fieldFrom=board.fields[3][3];
		Figure rook=new Rook(board, Type.ROOK, FigureColor.WHITE, fieldFrom);
		fieldFrom.setFigure(rook);
		//when
		Field fieldTo=new Field(6, 7);
		//then
		assertFalse(rook.isMovementShapeCorrectForFigure(fieldFrom, fieldTo));
	}
	@Test
	public void shouldRookMoveValidationTrueWhenRookMoveIsPossibleForFigure() {
		//given
		Field fieldFrom=board.fields[3][3];
		Figure rook=new Rook(board, Type.ROOK, FigureColor.WHITE, fieldFrom);
		fieldFrom.setFigure(rook);
		//when
		Field fieldTo=new Field(3, 1);
		//then
		assertTrue(rook.isMovementShapeCorrectForFigure(fieldFrom, fieldTo));
	}
	@Test
	public void shouldRookMoveValidationTrueWhenRookMoveIsPossibleForFigure2() {
		//given
		Field fieldFrom=board.fields[3][3];
		Figure rook=new Rook(board, Type.ROOK, FigureColor.WHITE, fieldFrom);
		fieldFrom.setFigure(rook);
		//when
		Field fieldTo=new Field(0, 3);
		//then
		assertTrue(rook.isMovementShapeCorrectForFigure(fieldFrom, fieldTo));
	}
	@Test
	public void shouldBishopMoveValidationFalseWhenBishopMoveIsImpossibleForFigure() {
		//given
		Field fieldFrom=board.fields[3][3];
		Figure bishop=new Bishop(board, Type.BISHOP, FigureColor.WHITE, fieldFrom);
		fieldFrom.setFigure(bishop);
		//when
		Field fieldTo=new Field(3, 2);
		//then
		assertFalse(bishop.isMovementShapeCorrectForFigure(fieldFrom, fieldTo));
	}
	@Test
	public void shouldBishopMoveValidationFalseWhenBishopMoveIsImpossibleForFigure2() {
		//given
		Field fieldFrom=board.fields[3][3];
		Figure bishop=new Bishop(board, Type.BISHOP, FigureColor.WHITE, fieldFrom);
		fieldFrom.setFigure(bishop);
		//when
		Field fieldTo=new Field(2, 7);
		//then
		assertFalse(bishop.isMovementShapeCorrectForFigure(fieldFrom, fieldTo));
	}
	@Test
	public void shouldBishopMoveValidationTrueWhenBishopMoveIsPossibleForFigure() {
		//given
		Field fieldFrom=board.fields[3][3];
		Figure bishop=new Bishop(board, Type.BISHOP, FigureColor.WHITE, fieldFrom);
		fieldFrom.setFigure(bishop);
		//when
		Field fieldTo=new Field(6, 0);
		//then
		assertTrue(bishop.isMovementShapeCorrectForFigure(fieldFrom, fieldTo));
	}
	@Test
	public void shouldBishopMoveValidationTrueWhenBishopMoveIsPossibleForFigure2() {
		//given
		Field fieldFrom=board.fields[3][3];
		Figure bishop=new Bishop(board, Type.BISHOP, FigureColor.WHITE, fieldFrom);
		fieldFrom.setFigure(bishop);
		//when
		Field fieldTo=new Field(5, 1);
		//then
		assertTrue(bishop.isMovementShapeCorrectForFigure(fieldFrom, fieldTo));
	}
	@Test
	public void shouldBishopMoveValidationFalseWhenBishopNoMovement() {
		//given
		Field fieldFrom=board.fields[3][3];
		Figure bishop=new Bishop(board, Type.BISHOP, FigureColor.WHITE, fieldFrom);
		fieldFrom.setFigure(bishop);
		//when
		Field fieldTo=new Field(3, 3);
		//then
		assertFalse(bishop.isMovementShapeCorrectForFigure(fieldFrom, fieldTo));
	}
	@Test
	public void shouldQueenMoveValidationTrueWhenQueenMoveIsPossibleForFigure() {
		//given
		Field fieldFrom=board.fields[3][3];
		Figure queen=new Queen(board, Type.QUEEN, FigureColor.WHITE, fieldFrom);
		fieldFrom.setFigure(queen);
		//when
		Field fieldTo=new Field(4, 2);
		//then
		assertTrue(queen.isMovementShapeCorrectForFigure(fieldFrom, fieldTo));
	}
	@Test
	public void shouldQueenMoveValidationTrueWhenQueenMoveIsPossibleForFigure2() {
		//given
		Field fieldFrom=board.fields[3][3];
		Figure queen=new Queen(board, Type.QUEEN, FigureColor.WHITE, fieldFrom);
		fieldFrom.setFigure(queen);
		//when
		Field fieldTo=new Field(3, 7);
		//then
		assertTrue(queen.isMovementShapeCorrectForFigure(fieldFrom, fieldTo));
	}
	@Test
	public void shouldQueenMoveValidationFalseWhenQueenMoveIsImpossibleForFigure() {
		//given
		Field fieldFrom=board.fields[3][3];
		Figure queen=new Queen(board, Type.QUEEN, FigureColor.WHITE, fieldFrom);
		fieldFrom.setFigure(queen);
		//when
		Field fieldTo=new Field(4, 1);
		//then
		assertFalse(queen.isMovementShapeCorrectForFigure(fieldFrom, fieldTo));
	}
	@Test
	public void shouldQueenMoveValidationFalseWhenQueenMoveIsImpossibleForFigure2() {
		//given
		Field fieldFrom=board.fields[3][3];
		Figure queen=new Queen(board, Type.QUEEN, FigureColor.WHITE, fieldFrom);
		fieldFrom.setFigure(queen);
		//when
		Field fieldTo=new Field(7, 6);
		//then
		assertFalse(queen.isMovementShapeCorrectForFigure(fieldFrom, fieldTo));
	}
	@Test
	public void shouldQueenMoveValidationFalseWhenQueenMoveIsImpossibleForFigure3() {
		//given
		Field fieldFrom=board.fields[3][3];
		Figure queen=new Queen(board, Type.QUEEN, FigureColor.WHITE, fieldFrom);
		fieldFrom.setFigure(queen);
		//when
		Field fieldTo=new Field(7, 4);
		//then
		assertFalse(queen.isMovementShapeCorrectForFigure(fieldFrom, fieldTo));
	}
	@Test
	public void shouldKingMoveValidationFalseWhenKingMoveIsImpossibleForFigure() {
		//given
		Field fieldFrom=board.fields[3][3];
		Figure king=new King(board, Type.KING, FigureColor.WHITE, fieldFrom);
		fieldFrom.setFigure(king);
		//when
		Field fieldTo=new Field(3, 1);
		//then
		assertFalse(king.isMovementShapeCorrectForFigure(fieldFrom, fieldTo));
	}
	@Test
	public void shouldKingMoveValidationFalseWhenKingMoveIsImpossibleForFigure2() {
		//given
		Field fieldFrom=board.fields[3][3];
		Figure king=new King(board, Type.KING, FigureColor.WHITE, fieldFrom);
		fieldFrom.setFigure(king);
		//when
		Field fieldTo=new Field(2, 5);
		//then
		assertFalse(king.isMovementShapeCorrectForFigure(fieldFrom, fieldTo));
	}
	@Test
	public void shouldKingnMoveValidationTrueWhenKingMoveIsPossibleForFigure() {
		//given
		Field fieldFrom=board.fields[3][3];
		Figure king=new King(board, Type.KING, FigureColor.WHITE, fieldFrom);
		fieldFrom.setFigure(king);
		//when
		Field fieldTo=new Field(4, 2);
		//then
		assertTrue(king.isMovementShapeCorrectForFigure(fieldFrom, fieldTo));
	}
	@Test
	public void shouldKingnMoveValidationTrueWhenKingMoveIsPossibleForFigure2() {
		//given
		Field fieldFrom=board.fields[3][3];
		Figure king=new King(board, Type.KING, FigureColor.WHITE, fieldFrom);
		fieldFrom.setFigure(king);
		//when
		Field fieldTo=new Field(3, 2);
		//then
		assertTrue(king.isMovementShapeCorrectForFigure(fieldFrom, fieldTo));
	}
	@Test
	public void shouldKingnMoveValidationTrueWhenKingMoveIsPossibleForFigure3() {
		//given
		Field fieldFrom=board.fields[3][3];
		Figure king=new King(board, Type.KING, FigureColor.WHITE, fieldFrom);
		fieldFrom.setFigure(king);
		//when
		Field fieldTo=new Field(4, 3);
		//then
		assertTrue(king.isMovementShapeCorrectForFigure(fieldFrom, fieldTo));
	}
	@Test
	public void shouldTrueWhenIsAnyFigureOnTheWayStraight() {
		//given
		Field pawnField=board.fields[3][3];
		Figure pawn=new Pawn(board, Type.PAWN,FigureColor.WHITE,pawnField);
		pawnField.setFigure(pawn);
		Field rookField=board.fields[3][5];
		Figure rook=new Rook(board, Type.ROOK,FigureColor.WHITE,rookField);
		rookField.setFigure(rook);
		//when
		Field rookFieldTo=new Field(3, 1);
		//then
		assertTrue(rook.isAnyFigureOnTheWayStraight(rookField, rookFieldTo));
	}
	@Test
	public void shouldTrueWhenIsAnyFigureOnTheWayStraight2() {
		//given
		Field pawnField=board.fields[3][4];
		Figure pawn=new Pawn(board, Type.PAWN,FigureColor.WHITE,pawnField);
		pawnField.setFigure(pawn);
		Field rookField=board.fields[5][4];
		Figure rook=new Rook(board, Type.ROOK,FigureColor.WHITE,rookField);
		rookField.setFigure(rook);
		//when
		Field rookFieldTo=new Field(1, 4);
		//then
		assertTrue(rook.isAnyFigureOnTheWayStraight(rookField, rookFieldTo));
	}
	@Test
	public void shouldFalseWhenIsNotAnyFigureOnTheWayStraight() {
		//given
		Field rookField=board.fields[3][4];
		Figure rook=new Rook(board, Type.ROOK,FigureColor.WHITE,rookField);
		rookField.setFigure(rook);
		//when
		Field rookFieldTo=new Field(3, 1);
		//then
		assertFalse(rook.isAnyFigureOnTheWayStraight(rookField, rookFieldTo));
	}
	@Test
	public void shouldTrueWhenIsAnyFigureOnTheWayDiagonal() {
		//given
		Field pawnField=board.fields[3][3];
		Figure pawn=new Pawn(board, Type.PAWN,FigureColor.WHITE,pawnField);
		pawnField.setFigure(pawn);
		Field bishopField=board.fields[4][2];
		Figure bishop=new Bishop(board, Type.BISHOP,FigureColor.WHITE,bishopField);
		bishopField.setFigure(bishop);
		//when
		Field bishopFieldTo=new Field(0, 6);
		//then
		assertTrue(bishop.isAnyFigureOnTheWayDiagonal(bishopField, bishopFieldTo));
	}
	@Test
	public void shouldTrueWhenIsAnyFigureOnTheWayDiagonal2() {
		//given
		Field pawnField=board.fields[3][3];
		Figure pawn=new Pawn(board, Type.PAWN,FigureColor.WHITE,pawnField);
		pawnField.setFigure(pawn);
		Field bishopField=board.fields[0][0];
		Figure bishop=new Bishop(board, Type.BISHOP,FigureColor.WHITE,bishopField);
		bishopField.setFigure(bishop);
		//when
		Field bishopFieldTo=new Field(7, 7);
		//then
		assertTrue(bishop.isAnyFigureOnTheWayDiagonal(bishopField, bishopFieldTo));
	}
	@Test
	public void shouldFalseWhenIsNotAnyFigureOnTheWayDiagonal() {
		//given
		Field bishopField=board.fields[3][3];
		Figure bishop=new Bishop(board, Type.ROOK,FigureColor.WHITE,bishopField);
		bishopField.setFigure(bishop);
		//when
		Field bishopFieldTo=new Field(0, 0);
		//then
		assertFalse(bishop.isAnyFigureOnTheWayDiagonal(bishopField, bishopFieldTo));
	}
}
