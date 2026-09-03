class ResistorColorDuo {

    public static String[] resistorColors = {"black", "brown", "red", "orange", "yellow", "green",
                                             "blue", "violet", "grey", "white"};
    int value(String[] colors) {
        int sum = 0;

        if (colors.length < 2) {
            return sum;
        }

        for (int i = 0; i < resistorColors.length; i++) {
            if (colors[0].equals(resistorColors[i])) {
                sum += 10 * i;
            }

            if (colors[1].equals(resistorColors[i])) {
                sum += i;
            }
        }

        return sum;
    }
}
