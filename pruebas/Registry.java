import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Registry;

class RegistryTest {

	private Registry registry;
	

	void scenary1() {
		registry = new Registry();
	}
	
	@Test
	void testAddRegistry() {
		
	}
	
	@Test
	void testRegistry() {
		scenary1();
		assertTrue(registry.getOrdersNotBilled().size() == 12);
	}

}
