package net.skhu.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;
    int year;
    String semaster;
    String room;

    @ManyToOne
    @JoinColumn(name = "professorId")
    Professor professor;

    @JsonIgnore
    @OneToMany(mappedBy="lecture")
    List<Sugang> sugangs;
}

