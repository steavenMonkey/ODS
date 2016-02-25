package example.uuid;

import java.util.UUID;

public class UUUIDTestCase {
	
	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
		System.out.println(uuid.toString().length());
	}
}
