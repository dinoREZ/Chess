package logic.pieces;

import logic.Field;
import logic.Move;
import util.GameColor;
import util.PieceType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static util.Constants.boardSize;
import static util.Functions.tryGetField;

public class Bishop extends Piece {

    public Bishop(GameColor pieceColor, Field[][] fields, Field field) {
        super(pieceColor, fields, field);
    }

    @Override
    public Move[] getPossibleMoves() {
        int x = field.getX();
        int y = field.getY();

        List<Optional<Field>> toFields = new ArrayList<>();
        boolean plusPlusDirectionBlocked = false;
        boolean plusMinusDirectionBlocked = false;
        boolean minusPlusDirectionBlocked = false;
        boolean minusMinusDirectionBlocked = false;
        for(int delta = 1; delta < boardSize; delta++) {
            if(!plusPlusDirectionBlocked) {
                Optional<Field> plusPlusField = tryGetField(x + delta, y + delta, fields);
                plusPlusDirectionBlocked = plusPlusField.flatMap(Field::getPiece).isPresent();
                toFields.add(plusPlusField);
            }

            if(!plusMinusDirectionBlocked) {
                Optional<Field> plusMinusField = tryGetField(x + delta, y - delta, fields);
                plusMinusDirectionBlocked = plusMinusField.flatMap(Field::getPiece).isPresent();
                toFields.add(plusMinusField);
            }

            if(!minusPlusDirectionBlocked) {
                Optional<Field> minusPlusField = tryGetField(x - delta, y + delta, fields);
                minusPlusDirectionBlocked = minusPlusField.flatMap(Field::getPiece).isPresent();
                toFields.add(minusPlusField);
            }

            if(!minusMinusDirectionBlocked) {
                Optional<Field> minusMinusField = tryGetField(x - delta, y - delta, fields);
                minusMinusDirectionBlocked = minusMinusField.flatMap(Field::getPiece).isPresent();
                toFields.add(minusMinusField);
            }
        }

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
        return PieceType.Bishop;
    }

    @Override
    public String toString() {
        return "Bishop(" + pieceColor + ')';
    }
}
