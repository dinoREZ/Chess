package logic.pieces;

import logic.Field;
import logic.Move;
import util.GameColor;
import util.PieceType;

public class Knight extends Piece {

    public Knight(GameColor pieceColor, Field[][] fields, Field field) {
        super(pieceColor, fields, field);
    }

    @Override
    public Move[] getPossibleMoves() {
        // TODO
        return new Move[0];
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.Knight;
    }

    @Override
    public String toString() {
        return "Knight(" + pieceColor + ')';
    }
}
