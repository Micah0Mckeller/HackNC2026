package Main;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProjectService {
    private final Map<UUID, ProjectBoard> projects = new LinkedHashMap<>();

    public synchronized ProjectBoard create(ProjectRequest request) {
        ProjectBoard project = new ProjectBoard(
            request.getProjectName(),
            request.getDescription(),
            request.getLocation(),
            request.getScheduledTime()
        );

        projects.put(project.getProjectUUID(), project);
        return project;
    }

    public synchronized List<ProjectBoard> findAll() {
        return List.copyOf(projects.values());
    }

    public synchronized Optional<ProjectBoard> findById(UUID id) {
        return Optional.ofNullable(projects.get(id));
    }
}