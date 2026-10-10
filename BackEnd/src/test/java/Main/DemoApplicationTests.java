package Main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void projectKeepsDecimalCompletionTime() {
		ProjectRequest request = new ProjectRequest();
		request.setTimeTillCompletion(12.75);

		ProjectBoard project = new ProjectBoard(
				"Test Project",
				request.getTimeTillCompletion(),
				"Test description");

		assertEquals(12.75, project.getTimeTillCompletion());
		assertEquals("Test description", project.getDescription());
	}

}
