package pt.ua.encontreja.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "Service")
public class Service implements Serializable {

    private static final long serialVersionUID = 2405172041950251807L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private double hourPrice;
    private double feePrice;
    //falta adicionar a imagem

    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "Service", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Contact> contactList;

    @OneToMany(mappedBy = "Service", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Rating> ratingList;

    public Service() {
        this.contactList = new ArrayList<>();
        this.ratingList = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getHourPrice() {
        return hourPrice;
    }

    public void setHourPrice(double hourPrice) {
        this.hourPrice = hourPrice;
    }

    public double getFeePrice() {
        return feePrice;
    }

    public void setFeePrice(double feePrice) {
        this.feePrice = feePrice;
    }

    @XmlTransient
    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @XmlTransient
    @JsonIgnore
    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public void addContactList(Contact contact) {
        contactList.add(contact);
    }

    public void removeContactList(Contact contact) {
        contactList.remove(contact);
    }

    public void addRating(Rating rating) {
        ratingList.add(rating);
    }

    public void removeRating(Rating rating) {
        ratingList.remove(rating);
    }

}
