package Main;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class logic {

    private ProjectBoard currentProjectBoard = new ProjectBoard(
        "Test Project",
        0.0,
        "This is a test project"
    );

    @GetMapping("/project")
    public ProjectBoard getProject() {
        return currentProjectBoard;
    }

    @PostMapping("/project")
    public ProjectBoard createProject(@RequestBody ProjectRequest request) {
        currentProjectBoard = new ProjectBoard(
            request.getProjectName(),
            request.getTimeTillCompletion(),
            request.getDescription()
        );

        return currentProjectBoard;
    }
}
