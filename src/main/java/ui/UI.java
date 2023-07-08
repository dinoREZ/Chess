package ui;

import logic.Board;
import logic.Move;

import javax.swing.*;
import java.awt.*;

import static util.Constants.*;

public class UI {

    JFrame frame;
    UIBoard uiBoard;
    Board board;

    public UI(Board board) {
        this.board = board;
        frame = new JFrame();
        uiBoard = new UIBoard(this);

        uiBoard.setLayout(new GridLayout(boardSize, boardSize));

        for(int y = 0; y < boardSize; y++) {
            for(int x = 0; x < boardSize; x++) {
                UIField uiField = new UIField(board.getField(x, boardSize - y - 1));
                uiBoard.add(uiField);
            }
        }

        frame.add(uiBoard, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        //frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(800, 800);
    }

    public void update() {
        for(int x = 0; x < boardSize; x++) {
            for(int y = 0; y < boardSize; y++) {
                UIField field = (UIField) this.uiBoard.getComponent(x + y*boardSize);

                field.update();
            }
        }
        frame.validate();
        frame.repaint();
    }

    public void doMove(Move move) {
        board.doMove(move);
        update();
    }
}
