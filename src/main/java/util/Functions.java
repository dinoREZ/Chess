package util;

import logic.Field;

import java.util.Optional;

public class Functions {

    public static Optional<Field> tryGetField(int x, int y, Field[][] fields) {
        try {
            return Optional.of(fields[x][y]);
        } catch (ArrayIndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }
}
