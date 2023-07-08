package logic.pieces;

import logic.Field;
import logic.Move;
import util.Functions;
import util.GameColor;
import util.PieceType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Knight extends Piece {

    public Knight(GameColor pieceColor, Field[][] fields, Field field) {
        super(pieceColor, fields, field);
    }

    @Override
    public Move[] getPossibleMoves() {
        int x = field.getX();
        int y = field.getY();

        List<Optional<Field>> toFields = new ArrayList<>();

        toFields.add(Functions.tryGetField(x + 2, y + 1, fields));
        toFields.add(Functions.tryGetField(x - 2, y + 1, fields));
        toFields.add(Functions.tryGetField(x + 2, y - 1, fields));
        toFields.add(Functions.tryGetField(x - 2, y - 1, fields));

        toFields.add(Functions.tryGetField(x + 1, y + 2, fields));
        toFields.add(Functions.tryGetField(x - 1, y + 2, fields));
        toFields.add(Functions.tryGetField(x + 1, y - 2, fields));
        toFields.add(Functions.tryGetField(x - 1, y - 2, fields));

        return toFields
                .stream()
                .flatMap(Optional::stream)
                .filter(a -> a
                        .getPiece()
                        .map(Piece::getColor)
                        .map(color -> color != this.getColor())
                        .orElse(true))
                .map(a -> new Move(field, a))
                .toArray(Move[]::new);
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
