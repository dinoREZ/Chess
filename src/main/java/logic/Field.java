package logic;

import logic.pieces.Piece;

import java.util.Optional;

public class Field {
    int x;
    int y;
    private Piece piece;

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Optional<Piece> getPiece() {
        return Optional.ofNullable(piece);
    }

    public void removePiece() {
        piece = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Field{"+ x + "-"+ y + ", " + (piece == null? "Empty" : piece) + '}';
    }
}
