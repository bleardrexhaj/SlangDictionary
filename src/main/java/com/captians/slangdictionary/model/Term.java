package com.captians.slangdictionary.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Term {
    @Id
    @GeneratedValue
    private Long id;
}
