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
                    if (!newProject.getName().isEmpty()) { project.setName(newProject.getName()); }
                    if (!newProject.getShortName().isEmpty()) { project.setShortName(newProject.getShortName()); }
                    if (!newProject.getDescription().isEmpty()) { project.setDescription(newProject.getDescription()); }
                    if (!newProject.getGithub().isEmpty()) { project.setGithub(newProject.getGithub()); }
                    if (!newProject.getUrl().isEmpty()) { project.setUrl(newProject.getUrl()); }
                    return repository.save(project);
                })
                .orElseGet(() -> {
                   newProject.setId(id);
                   return repository.save(newProject);
                });
    }

    @DeleteMapping("/projects/{id}")
    void deleteProject(@PathVariable Long id) { repository.deleteById(id); }
}
