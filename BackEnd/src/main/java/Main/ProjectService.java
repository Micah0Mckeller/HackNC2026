package Main;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ProjectService {
    private final Map<UUID, ProjectBoard> projects = new ConcurrentHashMap<>();

    public ProjectBoard create(ProjectRequest request) {
        ProjectBoard project = new ProjectBoard(
            request.getProjectName(),
            request.getTimeTillCompletion(),
            request.getDescription()
        );

        projects.put(project.getProjectUUID(), project);
        return project;
    }

    public Collection<ProjectBoard> findAll() {
        return projects.values();
    }

    public Optional<ProjectBoard> findById(UUID id) {
        return Optional.ofNullable(projects.get(id));
    }
}