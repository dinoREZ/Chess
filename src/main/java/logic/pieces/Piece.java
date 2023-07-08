package logic.pieces;

import logic.Field;
import util.GameColor;

public abstract class Piece implements PieceInterface {
    GameColor pieceColor;
    Field[][] fields;
    Field field;

    public Piece(GameColor pieceColor, Field[][] fields, Field field) {
        this.pieceColor = pieceColor;
        this.fields = fields;
        this.field = field;
    }

    @Override
    public GameColor getColor() {
        return pieceColor;
    }

    public void setField(Field field) {
        this.field = field;
    }
}
