package main.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Language", schema = "language")
public class Language {
    private int uniqueId;
    private String name;
    private String pictureName;
    private List<Assignment> assignments;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "pictureName")
    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "languageId")
    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }
}
