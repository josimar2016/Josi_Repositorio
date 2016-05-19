
package pt.ua.encontreja.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "ContactService")
public class ContactService implements Serializable {

    public ContactService() {
    }

    //nome incorreto é preciso mudar...
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double hours;

    @Temporal(TemporalType.DATE)
    private Date date;
    private String description;

    @ManyToOne
    private User user;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @OneToOne
    private Contact contact;

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
