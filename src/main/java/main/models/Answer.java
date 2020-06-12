package main.models;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Table(name = "Answer", schema = "language")
public class Answer {
    private int uniqueId;
    private String answer;
    private Question questionId;

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
    @Column(name = "answer")
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "questionId", referencedColumnName = "uniqueId")
    public Question getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
    }
}
