package Main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ProjectService projectService;

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

	@Test
	void rsvpEndpointIncrementsProjectCount() throws Exception {
		ProjectRequest request = new ProjectRequest();
		request.setProjectName("Test Project");
		ProjectBoard project = projectService.create(request);

		mockMvc.perform(post("/api/projects/{projectId}/rsvp", project.getProjectUUID()))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.RSVPs").value(1));
		assertEquals(1, project.getRSVPs());
	}

}
