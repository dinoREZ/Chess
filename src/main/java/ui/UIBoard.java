package ui;

import logic.Board;
import util.PieceType;

import javax.swing.*;
import java.awt.*;
import java.util.AbstractMap;
import java.util.Optional;

import static util.Constants.*;

public class UIBoard {

    JFrame frame;
    JPanel board;

    public UIBoard() {
        frame = new JFrame();
        board = new JPanel();

        board.setLayout(new GridLayout(boardSize, boardSize));

        for(int x = 0; x < boardSize; x++) {
            for(int y = 0; y < boardSize; y++) {
                JField field = new JField(x, y);
                board.add(field);
            }
        }

        frame.add(board, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        //frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(800, 800);
    }

    public void update(Board board) {
        for(int x = 0; x < boardSize; x++) {
            for(int y = 0; y < boardSize; y++) {
                JField field = (JField) this.board.getComponent(x + y*boardSize);

                Optional<AbstractMap.SimpleEntry<PieceType, Boolean>> fieldPieceOpt = board.getFieldPiece(x, boardSize - y - 1);
                fieldPieceOpt.ifPresent(fieldPiece -> field.setPiece(fieldPiece.getKey(), fieldPiece.getValue()));
            }
        }
        frame.validate();
        frame.repaint();
    }
}
