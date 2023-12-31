package ui;

import logic.Board;
import logic.Field;
import logic.Move;

import javax.swing.*;

import java.awt.*;

import static util.Constants.boardSize;

public class UIBoard extends JPanel {

    UI ui;

    public UIBoard(UI ui) {
        this.ui = ui;
    }

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
                if(component instanceof UIField uiField) {
                    if(move != null) {
                        uiField.setMoveable(move);
                    }
                    else {
                        uiField.setUnMoveable();
                    }
                }
            }
        }
    }

    public void resetPossibleMoves() {
        for(int y = 0; y < boardSize; y++) {
            for (int x = 0; x < boardSize; x++) {
                Component component = this.getComponent(x + y * boardSize);
                if(component instanceof UIField uiField) {
                    uiField.setUnMoveable();
                }
            }
        }
    }

    public void doMove(Move move) {
        System.out.println(move);
        ui.doMove(move);
        resetPossibleMoves();
    }
}
