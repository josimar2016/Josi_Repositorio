package pt.ua.encontreja.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "User")
public class User implements Serializable {
    private static final long serialVersionUID = 2405172041950251807L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private String userImg;

    private String type;
    private int phone;
    private String location;

    @OneToMany(mappedBy = "User", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Service> serviceList;

    @OneToMany(mappedBy = "User", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<ContactService> contactServiceList;

    @OneToOne(mappedBy = "User")
    private Rating rating;

    public User() {
        this.serviceList = new ArrayList<>();
        this.contactServiceList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    @JsonIgnore
    public String getPassWord() {
        return password;
    }

    public void setPassWord(String passWord) {
        this.password = passWord;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    @XmlTransient
    @JsonIgnore
    public List<ContactService> getContactServiceList() {
        return contactServiceList;
    }

    public void setContactServiceList(List<ContactService> contactServiceList) {
        this.contactServiceList = contactServiceList;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void addService(Service service) {
        serviceList.add(service);
    }

    public void removeService(Service service) {
        serviceList.remove(service);
    }

}
