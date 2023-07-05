package logic.pieces;

import logic.Field;
import logic.Move;
import util.GameColor;
import util.PieceType;

import java.util.ArrayList;
import java.util.List;

import static util.Constants.boardSize;

public class Pawn extends Piece {

    boolean canDoubleMove;

    public Pawn(GameColor pieceColor, Field[][] fields, Field field) {
        super(pieceColor, fields, field);
        canDoubleMove = true;
    }

    @Override
    public Move[] getPossibleMoves() {
        int x = field.getX();
        int y = field.getY();
        List<Move> moves = new ArrayList<>();
        int playDirection = getColor() == GameColor.White ? 1 : -1;

        int y2Forward = y + 2 * playDirection;
        if(0 <= y2Forward && y2Forward < boardSize) {
            Field field2Forward = fields[x][y2Forward];
            if (canDoubleMove && field2Forward.getPiece().isEmpty()) {
                moves.add(new Move(field, field2Forward));
            }
        }

        int yForward = y + playDirection;
        if(0 <= yForward && yForward < boardSize) {
            Field fieldForward = fields[x][yForward];
            if (fieldForward.getPiece().isEmpty()) {
                moves.add(new Move(field, fieldForward));
            }
        }

        int xLeft = x - 1;
        if(0 <= xLeft && 0 <= yForward && yForward < boardSize) {
            Field fieldLeftForward = fields[xLeft][yForward];
            fieldLeftForward.getPiece()
                    .map(PieceInterface::getColor)
                    .filter(color -> color != getColor())
                    .ifPresent(a -> moves.add(new Move(field, fieldLeftForward)));
        }

        int xRight = x + 1;
        if(xRight < boardSize && 0 <= yForward && yForward < boardSize) {
            Field fieldRightForward = fields[xRight][yForward];
            fieldRightForward.getPiece()
                    .map(PieceInterface::getColor)
                    .filter(color -> color != getColor())
                    .ifPresent(a -> moves.add(new Move(field, fieldRightForward)));
        }

        return moves.toArray(new Move[0]);
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.Pawn;
    }

    @Override
    public String toString() {
        return "Pawn(" + pieceColor + ')';
    }
}
