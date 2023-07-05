package util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public enum PieceType {
    Pawn("pawn.png"),
    Rook("rook.png"),
    Knight("knight.png"),
    Bishop("bishop.png"),
    Queen("queen.png"),
    King("king.png");
    public final Map<Boolean, BufferedImage> imageMap;

    private PieceType(String imagePath) {
        imageMap = new HashMap<>();
        try {
            imageMap.put(true, ImageIO.read(new File("src/main/images/white/" + imagePath)));
            imageMap.put(false, ImageIO.read(new File("src/main/images/black/" + imagePath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
