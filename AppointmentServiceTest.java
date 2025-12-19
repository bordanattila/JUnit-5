package appointment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

import java.util.Date;

class AppointmentServiceTest {
    private AppointmentService newAppt;

    Date failDate = new Date();
    Date passDate = new Date(failDate.getTime() + 24*60*60*1000);

    @BeforeEach
    void beforeEachTest() {
        newAppt = new AppointmentService();
        newAppt.addAppointment("12345", passDate, "This is a new Appointment.");
    }

    @Test
    void testAppointmentServiceClassAddAppointment() {
        Appointment retrievedAppt = newAppt.getAppointment("12345");
        assertTrue(retrievedAppt.getAppointmentID().equals("12345"));
        assertTrue(retrievedAppt.getAppointmentDate().equals(passDate));
        assertTrue(retrievedAppt.getAppointmentDescription().equals("This is a new Appointment."));
    }

    @Test
    void testAppointmentServiceClassDuplicateId() {
        assertThrows(IllegalStateException.class, () -> {
            newAppt.addAppointment("12345", passDate, "This is another new Appointment.");
        });
    }

    @Test
    void testAppointmentServiceClassRemoveTask() {
        assertDoesNotThrow(() -> {
            newAppt.removeAppointment("12345");
        });
    }

    @Test
    void testAppointmentServiceClassRemoveTaskNotFound() {
        assertThrows(NoSuchElementException.class, () -> {
            newAppt.removeAppointment("123");
        });
    }

    @Test
    void testAppointmentServiceClassAppointmentIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            newAppt.addAppointment(null, passDate, "This is with null ID.");
        });
    }

    @Test
    void testAppointmentServiceClassAppointmentNotFoud() {
        Appointment appointment = newAppt.getAppointment("999");
        assertNull(appointment);
    }

    @Test
    void testAppointmentServiceClassAppointmentExists() {
        Appointment appointment = newAppt.getAppointment("12345");
        assertTrue(appointment.getAppointmentID().equals("12345"));
        assertTrue(appointment.getAppointmentDate().equals(passDate));
        assertTrue(appointment.getAppointmentDescription().equals("This is a new Appointment."));
    }
}
