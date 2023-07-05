package logic;

import util.PieceColor;
import util.PieceType;

public interface Piece {
    Move[] getPossibleMoves(Field[][] fields);

    PieceColor getColor();
    PieceType getPieceType();
}
