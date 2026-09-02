import java.util.Arrays;

class ResistorColor {

    public static String[] resistorColors = {"black", "brown", "red", "orange", "yellow", "green",
                                             "blue", "violet", "grey", "white"};

    int colorCode(String color) {
        for (int i = 0; i < resistorColors.length; i++) {
            if (color.equals(resistorColors[i])) {
                return i;
            }
        }

        return -1;
    }

    String[] colors() {
        return resistorColors;
    }
}
