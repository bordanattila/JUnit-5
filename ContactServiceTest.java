package contact;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	private ContactService newContact;
	
	@BeforeEach
	void beforeEachTest() {
		newContact = new ContactService();
		newContact.addContact("1234", "Tony", "Stark", "1234567890", "New york, New York");		
	}

	@Test
	void testContactServiceClassAddContact() {
		newContact.addContact("123456", "Bruce", "Banner", "7778889999", "Tampa, Florida");
		Contact retrievedContact = newContact.getContact("123456");
		assertTrue(retrievedContact.getContactId().equals("123456"));
		assertTrue(retrievedContact.getFirstName().equals("Bruce"));
		assertTrue(retrievedContact.getLastName().equals("Banner"));
		assertTrue(retrievedContact.getPhone().equals("7778889999"));
		assertTrue(retrievedContact.getAddress().equals("Tampa, Florida"));
	}
	
	@Test
	void testContactServiceClassDuplicateId() {
		newContact.addContact("12", "Bruce", "Banner", "7778889999", "Tampa, Florida");
		assertThrows(IllegalStateException.class, () -> {
			newContact.addContact("12", "Bruce", "Banner", "7778889999", "Tampa, Florida");
		});
	}
	
	@Test
	void testContactServiceClassRemoveContactSuccess() {
		newContact.addContact("12", "Bruce", "Banner", "7778889999", "Tampa, Florida");
		assertDoesNotThrow(()-> {
			newContact.removeContact("12");
		});
	}
	
	@Test
	void testContactServiceClassRemoveContactNotFound() {
		assertThrows(NoSuchElementException.class, () -> {
			newContact.removeContact("12");
		});
	}
	
	@Test
	void testContactServiceClassUpdateContactAllFields() {
		newContact.updateContact("1234", "Tony", "Stark", "1234567890", "New york, New York");
		Contact updated = newContact.getContact("1234");
		assertTrue(updated.getFirstName().equals("Tony"));
		assertTrue(updated.getLastName().equals("Stark"));
		assertTrue(updated.getPhone().equals("1234567890"));
		assertTrue(updated.getAddress().equals("New york, New York"));
	}
	
	@Test
	void testContactServiceClassUpdateFirstName() {
		newContact.updateContact("1234", "Anthony", null, null, null);
		Contact updated = newContact.getContact("1234");
		assertTrue(updated.getFirstName().equals("Anthony"));
		assertTrue(updated.getLastName().equals("Stark"));
		assertTrue(updated.getPhone().equals("1234567890"));
		assertTrue(updated.getAddress().equals("New york, New York"));
	}
	
	@Test
	void testContactServiceClassUpdateLastName() {
		newContact.updateContact("1234", null, "Stark Jr", null, null);
		Contact updated = newContact.getContact("1234");
		assertTrue(updated.getFirstName().equals("Tony"));
		assertTrue(updated.getLastName().equals("Stark Jr"));
		assertTrue(updated.getPhone().equals("1234567890"));
		assertTrue(updated.getAddress().equals("New york, New York"));
	}
	
	@Test
	void testContactServiceClassUpdatePhone() {
		newContact.updateContact("1234", null, null, "1112223333", null);
		Contact updated = newContact.getContact("1234");
		assertTrue(updated.getFirstName().equals("Tony"));
		assertTrue(updated.getLastName().equals("Stark"));
		assertTrue(updated.getPhone().equals("1112223333"));
		assertTrue(updated.getAddress().equals("New york, New York"));
	}
	
	@Test
	void testContactServiceClassUpdateAddress() {
		newContact.updateContact("1234", null, null, null, "Undisclosed");
		Contact updated = newContact.getContact("1234");
		assertTrue(updated.getFirstName().equals("Tony"));
		assertTrue(updated.getLastName().equals("Stark"));
		assertTrue(updated.getPhone().equals("1234567890"));
		assertTrue(updated.getAddress().equals("Undisclosed"));
	}
	
	@Test
	void testContactServiceClassUpdateContactIdNull() {
		assertThrows(NoSuchElementException.class, () -> {
			newContact.updateContact(null, "Tony", "Stark", "1234567890", "New york, New York");
		});
	}
	
	@Test
	void testContactServiceClassUpdateAllNull() {
		newContact.updateContact("1234", null, null, null, null);
		Contact updated = newContact.getContact("1234");
		assertTrue(updated.getFirstName().equals("Tony"));
		assertTrue(updated.getLastName().equals("Stark"));
		assertTrue(updated.getPhone().equals("1234567890"));
		assertTrue(updated.getAddress().equals("New york, New York"));
	}
	
	@Test
	void testContactServiceClassContactExists() {
		newContact.addContact("12", "Bruce", "Banner", "7778889999", "Tampa, Florida");
		Contact contact = newContact.getContact("12");
		assertTrue(contact.getContactId().equals("12"));
		assertTrue(contact.getFirstName().equals("Bruce"));
		assertTrue(contact.getLastName().equals("Banner"));
		assertTrue(contact.getPhone().equals("7778889999"));
		assertTrue(contact.getAddress().equals("Tampa, Florida"));
	}
	
	@Test
	void testContactServiceClassContactNotfound() {
		Contact contact = newContact.getContact("999");
		assertNull(contact);
	}
}
