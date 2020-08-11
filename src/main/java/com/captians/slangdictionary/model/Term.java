package com.captians.slangdictionary.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Term {
    @Id
    @GeneratedValue
    private Long id;

    String word;
    String definition;

    Long thumbs_up;
    Long thumbs_down;

    Date written_on;
    String author;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Long getThumbs_up() {
        return thumbs_up;
    }

    public void setThumbs_up(Long thumbs_up) {
        this.thumbs_up = thumbs_up;
    }

    public Long getThumbs_down() {
        return thumbs_down;
    }

    public void setThumbs_down(Long thumbs_down) {
        this.thumbs_down = thumbs_down;
    }

    public Date getWritten_on() {
        return written_on;
    }

    public void setWritten_on(Date written_on) {
        this.written_on = written_on;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
