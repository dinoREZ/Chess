package logic;

import ui.UIBoard;

public class Game {

    public Board board;
    public UIBoard uiBoard;
    public Game() {
        this.board = new Board();
        this.uiBoard = new UIBoard();
    }

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game.board.getFieldPiece(0, 1));
        game.uiBoard.update(game.board);
    }
}
