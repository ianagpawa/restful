package com.ianagpawa.restful.quote;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Quote {
    private @Id
    @GeneratedValue
    Long id;
    private String content;
    private String name;
    private String source;

    Quote() { }

    Quote(String content, String name, String source) {
        this.content = content;
        this.name = name;
        this.source = source;
    }

    public Long getId() { return this.id; }

    public void setId(Long id) { this.id = id; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSource() { return source; }

    public void setSource(String source) { this.source = source; }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Quote))
            return false;
        Quote quote = (Quote) o;
        return Objects.equals(this.id, quote.id) && Objects.equals(this.name, quote.name)
                && Objects.equals(this.content, quote.content) && Objects.equals(this.source, quote.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id,
                this.content,
                this.name,
                this.source);
    }

    @Override
    public String toString() {
        return "Quote{" + "id=" + this.id + ", content='" + this.content + '\'' + ", name='" + this.name + '\'' + ", source='" + this.source + '\'' + '}';
    }
}
