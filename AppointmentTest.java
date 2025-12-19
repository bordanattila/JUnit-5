package appointment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

class AppointmentTest {

    Date failDate = new Date();
    Date passDate = new Date(failDate.getTime() + 24*60*60*1000);

    @Test
    void testAppointmentClass() {
        Appointment appointment = new Appointment("12345", passDate, "Testing appointment calss.");
        System.out.println(passDate);
            assertTrue(appointment.getAppointmentID().equals("12345"));
            assertTrue(appointment.getAppointmentDate().equals(passDate));
            assertTrue(appointment.getAppointmentDescription().equals("Testing appointment calss."));
    }

    @Test
    void testAppointmentClassTooLonID() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(
                    "12334567890AB",
                    passDate,
                    "Testing appointment class with long ID."
            );
        });
    }

    @Test
    void testAppointmentClassTooLonDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(
                    "123345",
                    passDate,
                    "Testing appointment class with correct value in the ID and too long in description fields."
            );
        });
    }

    @Test
    void testAppointmentClassPastDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(
                    "123345",
                    failDate,
                    "Testing appointment class with long ID."
            );
        });
    }
}
