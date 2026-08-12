
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public static int[] getLastWeek() {
        return new int[] {0, 2, 5, 3, 7, 8, 4};
    }

    public int getToday() {
        return this.birdsPerDay[this.birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        this.birdsPerDay[this.birdsPerDay.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        for (int bird : this.birdsPerDay) {
            if (bird == 0) {
                return true;
            }
        }

        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int acc = 0;
        int minorIndex = numberOfDays < this.birdsPerDay.length ? numberOfDays : this.birdsPerDay.length;
        for (int i = 0; i < minorIndex; i++) {
            acc += this.birdsPerDay[i];
        }

        return acc;
    }

    public int getBusyDays() {
        int acc = 0;
        for (int bird: this.birdsPerDay) {
            if (bird >= 5){
                acc++;
            }
        }
        return acc;
    }
}
