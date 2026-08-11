public class CarsAssemble {

    private final int CARS_PRODUCED_PER_HOUR = 221;

    public double productionRatePerHour(int speed) {
        if (speed >= 1 && speed <= 4) {
            return speed * CARS_PRODUCED_PER_HOUR;
        } else if (speed >= 5 && speed <= 8) {
            return speed * CARS_PRODUCED_PER_HOUR * 0.9;
        } else if (speed == 9) {
            return speed * CARS_PRODUCED_PER_HOUR * 0.8;
        } else {
            return speed * CARS_PRODUCED_PER_HOUR * 0.77;
        }
    }

    public int workingItemsPerMinute(int speed) {
        return (int) productionRatePerHour(speed) / 60;
    }
}
