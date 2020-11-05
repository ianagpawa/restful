package com.ianagpawa.restful.projects;

import com.ianagpawa.restful.quote.Quote;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Project {
    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private String shortName;
    private String description;
    private String github;
    private String link;
    private String url;

    Project() { }

    Project(String name,
            String shortName,
            String description,
            String github) {
        this.name = name;
        this.shortName = shortName;
        this.description = description;
        this.github = github;
    }

    Project(String name,
            String shortName,
            String description,
            String github,
            String url) {
        this.name = name;
        this.shortName = shortName;
        this.description = description;
        this.github = github;
        this.url = url;
    }

    public Long getId() { return this.id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    public String getShortName() { return this.shortName; }

    public void setShortName(String shortName) { this.shortName = shortName; }

    public String getDescription() { return this.description; }

    public void setDescription(String description) { this.description = description; }

    public String getGithub() { return this.github; }

    public void setGithub(String github) { this.github = github; }

    public String getUrl() { return this.url; }

    public void setUrl(String url) { this.url = url; }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Project))
            return false;
        Project project = (Project) o;
        return Objects.equals(this.id, project.id)
                && Objects.equals(this.name, project.name)
                && Objects.equals(this.shortName, project.shortName)
                && Objects.equals(this.description, project.description)
                && Objects.equals(this.github, project.github)
                && Objects.equals(this.url, project.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id,
                this.name,
                this.shortName,
                this.description,
                this.github,
                this.url);
    }

    @Override
    public String toString() {
        return "Project{" + "id=" + this.id + ", name='" + this.name + '\'' + ", shortName='" + this.shortName + '\''
                + ", description='" + this.description + '\'' + ", github='" + this.github + '\''
                + ", url='" + this.url + '\'' + '}';
    }
}
