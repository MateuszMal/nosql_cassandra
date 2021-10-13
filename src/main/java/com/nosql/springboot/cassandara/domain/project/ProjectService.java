package com.nosql.springboot.cassandara.domain.project;

import com.nosql.springboot.common.EntityNotFoundException;
import com.nosql.springboot.common.Validator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> fetchAllProjects() {
        return projectRepository.findAll();
    }

    public Project fecthProjectById(Long id) {
        Validator.checkIdIsNull(id);
        return projectRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project [" + id + "] not found."));

    }

    public Project createNewProject(Project project) {
        return projectRepository.save(project);
    }
}
