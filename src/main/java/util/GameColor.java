package util;

import java.awt.*;

import static util.Constants.*;

public enum GameColor {
    Black(blackBoardColor, blackBoardColorSelect), White(whiteBoardColor, whiteBoardColorSelect);
    public final Color color;
    public final Color selectedColor;

    GameColor(Color color, Color selectedColor) {
        this.color = color;
        this.selectedColor = selectedColor;
    }
}
