package logic;

import logic.pieces.*;
import util.GameColor;
import util.PieceType;

import java.util.AbstractMap;
import java.util.Optional;

import static util.Constants.boardSize;

public class Board {

    Field[][] fields = new Field[boardSize][boardSize];
    long[] pawnBoard = new long[2];
    long[] rookBoard = new long[2];
    long[] knightBoard = new long[2];
    long[] bishopBoard = new long[2];
    long[] queenBoard = new long[2];
    long[] kingBoard = new long[2];

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


        pawnBoard[0] = 0b11111111L << 8;
        pawnBoard[1] = 0b11111111L << 48;

        rookBoard[0] = 0b10000001L;
        rookBoard[1] = 0b10000001L << 56;

        knightBoard[0] = 0b01000010L;
        knightBoard[1] = 0b01000010L << 56;

        bishopBoard[0] = 0b00100100L;
        bishopBoard[1] = 0b00100100L << 56;

        queenBoard[0] = 0b00010000L;
        queenBoard[1] = 0b00010000L << 56;

        kingBoard[0] = 0b00001000L;
        kingBoard[1] = 0b00001000L << 56;
    }

    public Field getField(int x, int y) {
        return fields[x][y];
    }

    @Deprecated
    public Optional<AbstractMap.SimpleEntry<PieceType, Boolean>> getFieldPiece(int x, int y) {
        long mask = 1L << (x + y * boardSize);
        if(x == 0 && y == 1) {
            System.out.println(Long.toBinaryString(mask));
            System.out.println(Long.toBinaryString(pawnBoard[0]));
        }
        // Pawns white
        if(isSet(pawnBoard[0], mask)) {
            return Optional.of(new AbstractMap.SimpleEntry<>(PieceType.Pawn, true));
        }
        // Pawns black
        if(isSet(pawnBoard[1], mask)) {
            return Optional.of(new AbstractMap.SimpleEntry<>(PieceType.Pawn, false));
        }

        // Rooks white
        if(isSet(rookBoard[0], mask)) {
            return Optional.of(new AbstractMap.SimpleEntry<>(PieceType.Rook, true));
        }
        // Rooks black
        if(isSet(rookBoard[1], mask)) {
            return Optional.of(new AbstractMap.SimpleEntry<>(PieceType.Rook, false));
        }

        // Knights white
        if(isSet(knightBoard[0], mask)) {
            return Optional.of(new AbstractMap.SimpleEntry<>(PieceType.Knight, true));
        }
        // Knights black
        if(isSet(knightBoard[1], mask)) {
            return Optional.of(new AbstractMap.SimpleEntry<>(PieceType.Knight, false));
        }

        // Bishops white
        if(isSet(bishopBoard[0], mask)) {
            return Optional.of(new AbstractMap.SimpleEntry<>(PieceType.Bishop, true));
        }
        // Bishops black
        if(isSet(bishopBoard[1], mask)) {
            return Optional.of(new AbstractMap.SimpleEntry<>(PieceType.Bishop, false));
        }

        // Queens white
        if(isSet(queenBoard[0], mask)) {
            return Optional.of(new AbstractMap.SimpleEntry<>(PieceType.Queen, true));
        }
        // Queens black
        if(isSet(queenBoard[1], mask)) {
            return Optional.of(new AbstractMap.SimpleEntry<>(PieceType.Queen, false));
        }

        // King white
        if(isSet(kingBoard[0], mask)) {
            return Optional.of(new AbstractMap.SimpleEntry<>(PieceType.King, true));
        }
        // King black
        if(isSet(kingBoard[1], mask)) {
            return Optional.of(new AbstractMap.SimpleEntry<>(PieceType.King, false));
        }

        return Optional.empty();
    }

    private boolean isSet(long value, long mask) {
        return (value & mask) != 0;
    }
}
