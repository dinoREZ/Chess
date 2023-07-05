package ui;

import util.PieceType;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static util.Constants.blackBoardColor;
import static util.Constants.whiteBoardColor;

public class JField extends JPanel {

    public JField(int x, int y) {
        this.setBackground((x + y) % 2 == 0? whiteBoardColor : blackBoardColor);
    }

    public void setPiece(PieceType piece, boolean white) {
        removePiece();
        BufferedImage image = piece.imageMap.get(white);
        this.add(new JLabel(new ImageIcon(image.getScaledInstance(80, 80, Image.SCALE_FAST))));
    }

    public void removePiece() {
        this.removeAll();
    }

}
