package logic;

import util.PieceColor;
import util.PieceType;

public class Pawn implements Piece {

    PieceColor color;

    public Pawn(PieceColor color) {
        this.color = color;
    }

    @Override
    public Move[] getPossibleMoves(Field[][] fields) {
        // TODO
        return new Move[0];
    }

    @Override
    public PieceColor getColor() {
        return color;
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.Pawn;
    }
}
