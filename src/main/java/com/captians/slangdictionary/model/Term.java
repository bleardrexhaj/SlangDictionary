package com.captians.slangdictionary.model;

import com.captians.slangdictionary.validation.EmptyOrSize;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter @Setter
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @EmptyOrSize(message = "{User.name}", min = 1, max=512)
    private String word;

    @Lob
    @EmptyOrSize(message = "{User.name}", min = 1, max=512)
    @Column(length = 512)
    private String definition;

    @Lob
    @EmptyOrSize(message = "{User.name}", min = 1, max=512)
    @Column(length = 512)
    private String example;

    private Long thumbs_up;
    private Long thumbs_down;

    @NotNull
    @Temporal(value = TemporalType.DATE)
    Date written_on;

    String author;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;
}
