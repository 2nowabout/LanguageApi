package main.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Assignment", schema = "language")
public class Assignment {
    private int uniqueId;
    private String title;
    private Language languageId;
    private String pictureName;
    private String description;
    private List<Lesson> lessons;

    @Id
    @Column(name = "uniqueId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonBackReference
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "languageId", referencedColumnName = "uniqueId")
    public Language getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Language languageId) {
        this.languageId = languageId;
    }

    @Basic
    @Column(name = "pictureName")
    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "assignmentId")
    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
