package Main;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class logic {
    private final ProjectService projectService;

    public logic(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public List<ProjectBoard> getProjects() {
        return projectService.findAll().stream().limit(10).toList();
    }

    @PostMapping("/projects")
    public ProjectBoard createProject(@RequestBody ProjectRequest request) {
        return projectService.create(request);
    }
}
