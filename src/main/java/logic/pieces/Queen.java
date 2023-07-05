package logic.pieces;

import logic.Field;
import logic.Move;
import util.GameColor;
import util.PieceType;

public class Queen extends Piece {

    public Queen(GameColor pieceColor, Field[][] fields, Field field) {
        super(pieceColor, fields, field);
    }

    @Override
    public Move[] getPossibleMoves() {
        // TODO
        return new Move[0];
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.Queen;
    }

    @Override
    public String toString() {
        return "Queen(" + pieceColor + ')';
    }
}
