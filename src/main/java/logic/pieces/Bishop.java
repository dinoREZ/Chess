package logic.pieces;

import logic.Field;
import logic.Move;
import util.GameColor;
import util.PieceType;

public class Bishop extends Piece {

    public Bishop(GameColor pieceColor, Field[][] fields, Field field) {
        super(pieceColor, fields, field);
    }

    @Override
    public Move[] getPossibleMoves() {
        // TODO
        return new Move[0];
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.Bishop;
    }

    @Override
    public String toString() {
        return "Bishop(" + pieceColor + ')';
    }
}
