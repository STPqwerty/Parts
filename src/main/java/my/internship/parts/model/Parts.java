package my.internship.parts.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parts {

    public Parts(){}
    public Parts(int id, String name, boolean requared, int count) {
        this.id = id;
        this.requared = requared;
        this.count = count;
        this.name = name;
    }

    @Id
    @Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Column(name = "Name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Column(name = "Requared")
    private boolean requared;

    public boolean isRequared() {
        return requared;
    }

    public void setRequared(boolean requared) {
        this.requared = requared;
    }


    @Column(name = "Count")
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
