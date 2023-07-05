package logic.pieces;

import logic.Field;
import logic.Move;
import util.GameColor;
import util.PieceType;

public class King extends Piece {

    public King(GameColor pieceColor, Field[][] fields, Field field) {
        super(pieceColor, fields, field);
    }

    @Override
    public Move[] getPossibleMoves() {
        // TODO
        return new Move[0];
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.King;
    }

    @Override
    public String toString() {
        return "King(" + pieceColor + ')';
    }
}
