package ui;

import logic.Field;
import logic.Move;
import logic.pieces.Piece;
import logic.pieces.PieceInterface;
import util.GameColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Optional;

public class UIField extends JPanel implements MouseListener {

    Field field;
    GameColor color;
    Move move;
    boolean selected;

    public UIField(Field field) {
        this.field = field;
        this.color = (field.getX() + field.getY()) % 2 == 0? GameColor.White : GameColor.Black;
        this.move = null;
        this.selected = false;
        this.setBackground(color.color);
        this.addMouseListener(this);
    }

    public void update() {
        removePiece();
        Optional<Piece> pieceOpt = field.getPiece();
        if(pieceOpt.isPresent()) {
            PieceInterface piece = pieceOpt.get();
            BufferedImage image = piece.getPieceType().imageMap.get(piece.getColor());
            this.add(new JLabel(new ImageIcon(image.getScaledInstance(80, 80, Image.SCALE_FAST))));
        }
    }

    public void removePiece() {
        this.removeAll();
    }

    public void setMoveable(Move move) {
        selected = false;
        this.move = move;
        this.setBackground(color.selectedColor);
    }

    public void setUnMoveable() {
        selected = false;
        this.move = null;
        this.setBackground(color.color);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(getParent() instanceof UIBoard uiBoard) {
            if(selected) {
                selected = false;
                this.setBackground(color.color);
                uiBoard.resetPossibleMoves();
            }
            else if(move != null) {
                uiBoard.doMove(move);
            }
            else {
                this.field.getPiece().ifPresent(piece -> {
                    Move[] possibleMoves = piece.getPossibleMoves();
                    uiBoard.displayPossibleMoves(possibleMoves);
                    this.setBackground(color.selectedColor);
                    this.selected = true;
                });
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
