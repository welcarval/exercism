class Darts {
    int score(double xOfDart, double yOfDart) {
        Double radius = Math.sqrt(Math.pow(xOfDart, 2) + Math.pow(yOfDart, 2));

        return switch (radius) {
            case Double r when r <= 1 -> 10;
            case Double r when r <= 5 -> 5;
            case Double r when r <= 10 -> 1;
            default -> 0;
        };
    }
}
