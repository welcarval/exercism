class ResistorColorTrio {

    public static String[] resistorColors = {"black", "brown", "red", "orange", "yellow", "green",
                                             "blue", "violet", "grey", "white"};
    String label(String[] colors) {

        int sum = 0;
        long multiply = 1;

        for (int i = 0; i < resistorColors.length; i++) {
            if (colors[0].equals(resistorColors[i])) {
                sum += 10 * i;
            }

            if (colors[1].equals(resistorColors[i])) {
                sum += i;
            }

            if (colors[2].equals(resistorColors[i])) {
                multiply = Math.powExact(10, i);
            }
        }

        long total = sum * multiply;
        multiply = 0;

        while (total / 1000 > 1) {
            total /= 1000;
            multiply++;
        }

        String s = switch ((int) multiply) {
            case 0 -> "";
            case 1 -> "kilo";
            case 2 -> "mega";
            case 3 -> "giga";
            case 4 -> "tera";
            default -> "peta";
        };

        return total + " " + s + "ohms";
    }
}
