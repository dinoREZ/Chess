package logic.pieces;

import logic.Move;
import util.GameColor;
import util.PieceType;

public interface PieceInterface {
    Move[] getPossibleMoves();

    GameColor getColor();
    PieceType getPieceType();
}
