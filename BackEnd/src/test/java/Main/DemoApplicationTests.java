package Main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void projectKeepsDescriptionLocationAndScheduledTime() {
		ProjectRequest request = new ProjectRequest();
		request.setDescription("Test description");
		request.setLocation("Greenhouse");
		request.setScheduledTime(LocalDateTime.of(2026, 10, 10, 20, 0));

		ProjectBoard project = new ProjectBoard(
				"Test Project",
				request.getDescription(),
				request.getLocation(),
				request.getScheduledTime());

		assertEquals("Test description", project.getDescription());
		assertEquals("Greenhouse", project.getLocation());
		assertEquals(LocalDateTime.of(2026, 10, 10, 20, 0), project.getScheduledTime());
	}

}
