package com.ianagpawa.restful.project;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {
    private final ProjectRepository repository;

    ProjectController(ProjectRepository repository) { this.repository = repository; }

    @GetMapping("/projects")
    List<Project> all() { return repository.findAll(); }

    @PostMapping("/projects")
    Project newProject(@RequestBody Project newProject) { return repository.save(newProject); }

    @GetMapping("/projects/{id}")
    Project one(@PathVariable Long id) {
        return repository
            .findById(id)
            .orElseThrow(() -> null );
    }

    @PutMapping("/projects/{id}")
    Project replaceProject(@RequestBody Project newProject, @PathVariable Long id) {
        return repository
            .findById(id)
            .map(project -> {
                if (newProject.getName() {

                return repository.save(project);
            })
            .orElseGet(() -> {
               newProject.setId(id);
               return repository.save(newProject);
            });
    }
}
