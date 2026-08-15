import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class AppointmentScheduler {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy HH:mm:ss");

    public LocalDateTime schedule(String appointmentDateDescription) {
        return LocalDateTime.parse(appointmentDateDescription, formatter);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return appointmentDate.isBefore(LocalDateTime.now());
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        int hour = appointmentDate.getHour();
        return hour >= 12 && hour < 18;
    }

    public String getDescription(LocalDateTime appointmentDate) {
        return "You have an appointment on "
                + DateTimeFormatter.ofPattern("EEEE',' MMMM d',' yyyy', at' h:mm a'.'").format(appointmentDate);
    }

    public LocalDate getAnniversaryDate() {
        return LocalDate.of(LocalDate.now().getYear(), 9, 15);
    }
}
