package main.models;


import javax.persistence.*;

@Entity
@Table(name = "CommunityFeedback", schema = "languages")
public class CommunityFeedback {
    private int uniqueId;

    @Id
    @Column(name = "uniqueId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

}
