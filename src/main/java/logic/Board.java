package logic;

import logic.pieces.*;
import util.GameColor;

import static util.Constants.boardSize;

public class Board {

    Field[][] fields = new Field[boardSize][boardSize];

    public Board() {
        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < 8; y++) {
                Field field = new Field(x, y);
                fields[x][y] = field;
                if(y == 1) {
                    field.setPiece(new Pawn(GameColor.White, this.fields, field));
                }
                if(y == 6) {
                    field.setPiece(new Pawn(GameColor.Black, this.fields, field));
                }

                if(y == 7) {
                    switch (x) {
                        case 0, 7   -> field.setPiece(new Rook(GameColor.Black, this.fields, field));
                        case 1, 6   -> field.setPiece(new Knight(GameColor.Black, this.fields, field));
                        case 2, 5   -> field.setPiece(new Bishop(GameColor.Black, this.fields, field));
                        case 3      -> field.setPiece(new Queen(GameColor.Black, this.fields, field));
                        case 4      -> field.setPiece(new King(GameColor.Black, this.fields, field));
                    }
                }

                if(y == 0) {
                    switch (x) {
                        case 0, 7   -> field.setPiece(new Rook(GameColor.White, this.fields, field));
                        case 1, 6   -> field.setPiece(new Knight(GameColor.White, this.fields, field));
                        case 2, 5   -> field.setPiece(new Bishop(GameColor.White, this.fields, field));
                        case 3      -> field.setPiece(new Queen(GameColor.White, this.fields, field));
                        case 4      -> field.setPiece(new King(GameColor.White, this.fields, field));
                    }
                }
            }
        }
    }

    public Field getField(int x, int y) {
        return fields[x][y];
    }
}
