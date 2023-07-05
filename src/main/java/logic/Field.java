package logic;

import java.util.Optional;

public class Field {
    int x;
    int y;
    private Piece piece;

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Optional<Piece> getPiece() {
        return Optional.ofNullable(piece);
    }

    public void removePiece() {
        piece = null;
    }
}
