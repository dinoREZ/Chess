package ui;

import logic.Field;
import logic.Move;

import javax.swing.*;

import java.awt.*;

import static util.Constants.boardSize;

public class UIBoard extends JPanel {

    public void displayPossibleMoves(Move[] moves) {
        Move[][] moveableTo = new Move[boardSize][boardSize];
        for (Move move : moves) {
            Field to = move.getTo();
            moveableTo[to.getX()][to.getY()] = move;
        }
        for(int y = 0; y < boardSize; y++) {
            for (int x = 0; x < boardSize; x++) {
                Component component = this.getComponent(x + y * boardSize);
                Move move = moveableTo[x][boardSize - y - 1];
                if(move != null && component instanceof UIField uiField) {
                    uiField.setMoveable(move);
                }
            }
        }
    }

    public void doMove(Move move) {
        System.out.println(move);
    }
}
