package contact;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testContactClass() {
		Contact contact = new Contact("1234", "Tony", "Stark", "1234567890", "New york, New York");
		assertTrue(contact.getContactId().equals("1234"));
		assertTrue(contact.getFirstName().equals("Tony"));
		assertTrue(contact.getLastName().equals("Stark"));
		assertTrue(contact.getPhone().equals("1234567890"));
		assertTrue(contact.getAddress().equals("New york, New York"));
	}
	
	@Test
	void testContactClassTooLong() {		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"123456789012", 
					"Tony123456789", 
					"Stark123456789", 
					"1234567890123", 
					"New york, New York New york, New York New york, New York New york, New York New york, New York"
					);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"12345", 
					"Tony123456789", 
					"Stark123456789", 
					"1234567890123", 
					"New york, New York New york, New York New york, New York New york, New York New york, New York"
					);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"12345", 
					"Tony", 
					"Stark123456789", 
					"1234567890123", 
					"New york, New York New york, New York New york, New York New york, New York New york, New York"
					);
		});
	}
	
	@Test
	void testContactClassExactValue() {
		Contact contact = new Contact("12345ABCde", "TonyTony12", "Stark12345", "1234567890", "NewYork,NewYork,NewYork,New123");
		assertTrue(contact.getContactId().equals("12345ABCde"));
		assertTrue(contact.getFirstName().equals("TonyTony12"));
		assertTrue(contact.getLastName().equals("Stark12345"));
		assertTrue(contact.getPhone().equals("1234567890"));
		assertTrue(contact.getAddress().equals("NewYork,NewYork,NewYork,New123"));
	}
	
	@Test
	void testContactClassNullValue() {		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					null, 
					"Tony123456789", 
					"Stark123456789", 
					"1234567890123", 
					"New york, New York"
					);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"1234567890", 
					null, 
					"Stark", 
					"1234567890", 
					"New york, New York"
					);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"1234567890", 
					"Tony", 
					null, 
					"1234567890", 
					"New york, New York"
					);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"1234567890", 
					"Tony", 
					"Stark", 
					null, 
					"New york, New York"
					);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"1234567890", 
					"Tony", 
					"Stark", 
					"1234567890", 
					null
					);
		});
	}
	
	@Test
	void testContactClassPhoneTooShort() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"1234567890", 
					"Tony", 
					"Stark", 
					"123456789", 
					"New york, New York"
					);
		});
	}
	
	@Test 
	void testContactClassSetters() {
		Contact contact = new Contact("1234", "Tony", "Stark", "1234567890", "New york, New York");
		contact.setFirstName("Bruce");
		contact.setLastName("Banner");
		contact.setPhone("7778889999");
		contact.setAddress("Tampa, Florida");
		
		assertTrue(contact.getContactId().equals("1234"));
		assertTrue(contact.getFirstName().equals("Bruce"));
		assertTrue(contact.getLastName().equals("Banner"));
		assertTrue(contact.getPhone().equals("7778889999"));
		assertTrue(contact.getAddress().equals("Tampa, Florida"));
		
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("BruceBanner");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("BruceBanner");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("777888999");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("Tampa,Florida,Tampa,Florida,Tampa,Florida");
		});
	}
}
