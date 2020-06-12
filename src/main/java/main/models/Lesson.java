package main.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Lesson", schema = "language")
public class Lesson {
    private int uniqueId;
    private Assignment assignmentId;
    private boolean done;
    private List<Question> questions;

    @Id
    @Column(name = "uniqueId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "lessonId")
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @JsonBackReference
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "assignmentId", referencedColumnName = "uniqueId")
    public Assignment getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Assignment assignmentId) {
        this.assignmentId = assignmentId;
    }

    @Basic
    @Column(name = "done")
    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
