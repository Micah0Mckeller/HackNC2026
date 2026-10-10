package BackEnd.src.main.java.Main.App.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

	@GetMapping("/api/health")
	public HealthResponse health() {
		return new HealthResponse("ok", "");
	}

	public record HealthResponse(String status, String application) {
	}
}
