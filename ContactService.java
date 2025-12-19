package contact;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ContactService {
	private Map<String, Contact> contacts = new HashMap<>();
	
	public void addContact(String id, String fName, String lName, String phone, String address) {
		if (contacts.containsKey(id)) {
			throw new IllegalStateException("Duplicate Contact ID, Contact ID must be unique.");
		}
		Contact contact = new Contact(id, fName, lName, phone, address);
		contacts.put(id, contact);
	}
	
	public void removeContact(String id) {
		if (contacts.remove(id) == null) {
			throw new NoSuchElementException("Contact ID not found.");
		}
	}
	
	public void updateContact(String id, String fName, String lName, String phone, String address) {
		Contact contactToUpdate = contacts.get(id);
		
		if (contactToUpdate == null) {
			throw new NoSuchElementException("Contact ID is required to update information.");
		}
		
		if (fName != null && !fName.isBlank()) {
			contactToUpdate.setFirstName(fName);
		}
		if (lName != null && !lName.isBlank()) {
			contactToUpdate.setLastName(lName);;
		}
		if (phone != null && !phone.isBlank()) {
			contactToUpdate.setPhone(phone);;
		}
		if (address != null && !address.isBlank()) {
			contactToUpdate.setAddress(address);;
		}	
	}
	
	public Contact getContact(String contactId) {
		return contacts.get(contactId);
	}
}