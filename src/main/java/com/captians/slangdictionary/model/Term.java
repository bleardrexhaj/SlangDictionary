package com.captians.slangdictionary.model;

import com.captians.slangdictionary.validation.EmptyOrSize;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @EmptyOrSize(message = "{User.name}", min = 1, max=512)
    String word;

    @Lob
    @EmptyOrSize(message = "{User.name}", min = 1, max=512)
    @Column(length = 512)
    String definition;

    @Lob
    @EmptyOrSize(message = "{User.name}", min = 1, max=512)
    @Column(length = 512)
    String example;

    Long thumbs_up;
    Long thumbs_down;

    @NotNull
    @Temporal(value = TemporalType.DATE)
    Date written_on;

    String author;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
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

    public String dateToString(){
        return written_on.getDate() + "/" + written_on.getMonth() + "/" + this.written_on.getYear();
    }
}
