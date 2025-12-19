package appointment;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

class AppointmentService {
    private Map<String, Appointment> appointments = new HashMap<>();

    public void addAppointment(String id, Date date, String description) {
        if (appointments.containsKey(id)) {
            throw new IllegalStateException("Duplicate Appointment ID, Appointment ID must be unique.");
        }
        Appointment appointment = new Appointment(id, date, description);
        appointments.put(id, appointment);
    }

    public void removeAppointment(String id){
        if (appointments.remove(id) == null) {
            throw new NoSuchElementException("Appointment ID not found.");
        }
    }

    public Appointment getAppointment(String id) {
        return appointments.get(id);
    }
}
