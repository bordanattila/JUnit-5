package contact;
import java.lang.String;

public class Contact {
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		this.contactId = validateContactId(contactId);
		this.firstName = validateName(firstName, "First Name", 10);
		this.lastName = validateName(lastName, "Last Name", 10);
		this.phone = validatePhone(phone);
		this.address = validateAddress(address);
	}
	
	public String getContactId() { return contactId; }
	
	public String getFirstName() { return firstName; }
	
	public String getLastName() { return lastName; }
	
	public String getPhone() { return phone; }
	
	public String getAddress() { return address; }
	
	public void setFirstName( String firstName ) { this.firstName = validateName(firstName, "First Name", 10); }
	
	public void setLastName( String lastName ) { this.lastName = validateName(lastName, "Last Name", 10); }
	
	public void setPhone ( String phone ) { this.phone = validatePhone(phone); }
	
	public void setAddress ( String address ) { this.address = validateAddress(address); }
	
	private static String validateContactId( String contactId ) { 
		if (contactId == null || contactId.isBlank()) {
			throw new IllegalArgumentException("Contact ID is required.");
		}
		contactId = contactId.trim();
		if (contactId.length() > 10) {
			throw new IllegalArgumentException("Contact ID cannot be more than 10 characters.");
		}
		return contactId; 
		}
	
	private static String validateName(String name, String label, int maxLen) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException(label + " is required.");
		}
		name = name.trim();
		if (name.length() > maxLen) {
			throw new IllegalArgumentException(label + " cannot be more than " + maxLen + " characters.");
		}
		return name;
	}
	
	private static String validatePhone(String phone) {
		if (phone == null || phone.isBlank()) {
			throw new IllegalArgumentException("Phone number is required.");
		}
		phone = phone.trim();
		if (phone.length() != 10) {
			throw new IllegalArgumentException("Phone number must be 10 digits.");
		}
		return phone;
	}
	
	private static String validateAddress(String address) {
		if (address == null || address.isBlank()) {
			throw new IllegalArgumentException("Address is required.");
		}
		address = address.trim();
		if (address.length() > 30) {
			throw new IllegalArgumentException("Address cannot be more than 30 characters.");
		}
		return address;
	}
}