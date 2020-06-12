package main.models;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Question", schema = "language")
public class Question {
    private int uniqueId;
    private Lesson lessonId;
    private String question;
    private Collection<Answer> answers;

    @Id
    @Column(name = "uniqueId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "lessonId", referencedColumnName = "uniqueId")
    public Lesson getLessonId() {
        return lessonId;
    }

    public void setLessonId(Lesson lessonId) {
        this.lessonId = lessonId;
    }

    @Basic
    @Column(name = "question")
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @OneToMany(mappedBy = "questionId")
    public Collection<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Collection<Answer> answers) {
        this.answers = answers;
    }
}
