package appointment;

import java.util.Calendar;
import java.util.Date;

class Appointment {
    private final String appointmentID;
    private Date appointmentDate;
    private String appointmentDescription;

    Appointment(String appointmentID, Date appointmentDate, String appointmentDescription){
        this.appointmentID = validateAppointmentID(appointmentID);
        this.appointmentDate = validateAppointmentDate(appointmentDate);
        this.appointmentDescription = validateAppointmentDescription(appointmentDescription);
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentDescription() {
        return appointmentDescription;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = validateAppointmentDate(appointmentDate);
    }

    public void setAppointmentDescription(String appointmentDescription) {
        this.appointmentDescription = validateAppointmentDescription(appointmentDescription);
    }

    public static String validateAppointmentID(String appointmentID) {
        if (appointmentID == null || appointmentID.isBlank()) {
            throw new IllegalArgumentException("Appointment ID is required.");
        }
        appointmentID = appointmentID.trim();
        if (appointmentID.length() > 10) {
            throw new IllegalArgumentException("Appointment ID cannot be longer than 10 characters.");
        }
        return appointmentID;
    }

    public static Date validateAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null) {
            throw new IllegalArgumentException("Appointment Date is required.");
        }
        if (appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment Date is in the past.");
        }
        return appointmentDate;
    }

    public static String validateAppointmentDescription(String appointmentDescription) {
        if (appointmentDescription == null || appointmentDescription.isBlank()) {
            throw new IllegalArgumentException("Appointment Name is required.");
        }
        appointmentDescription = appointmentDescription.trim();
        if (appointmentDescription.length() > 50) {
            throw new IllegalArgumentException("Appointment description cannot be longer than 50 characters.");
        }
        return appointmentDescription;
    }
}
