package logic;

import logic.pieces.Pawn;
import ui.UI;
import util.GameColor;

public class Game {

    public Board board;
    public UI uiBoard;
    public Game() {
        this.board = new Board();
        this.uiBoard = new UI(board);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.uiBoard.update();
    }
}
