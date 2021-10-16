package com.nosql.springboot.cassandara.domain.project;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> fetchProjects() {
        List<Project> projectList = projectService.fetchAllProjects();
        return ResponseEntity.status(HttpStatus.OK).body(projectList);
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> fetchProjectById(@PathVariable Integer id) {
        Project project = projectService.fecthProjectById(id);
        return ResponseEntity.status(HttpStatus.OK).body(project);
    }

    @PostMapping("/projects")
    public ResponseEntity<Project> createProject(@RequestBody Project project){
        Project projectDto = projectService.createNewProject(project);
        return ResponseEntity.status(HttpStatus.OK).body(projectDto);
    }
}
