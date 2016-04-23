/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author arrais
 */

@Entity
@Table(name="Contact")
public class Contact implements Serializable {

    public Contact() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

 
    
    private String description;
    private double estimatedHours;
    
    @Temporal(TemporalType.DATE)
    private Date date;
    
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Service service ;
   

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(double estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

  
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.description);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.estimatedHours) ^ (Double.doubleToLongBits(this.estimatedHours) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.date);
        hash = 59 * hash + Objects.hashCode(this.user);
        hash = 59 * hash + Objects.hashCode(this.service);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contact other = (Contact) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (Double.doubleToLongBits(this.estimatedHours) != Double.doubleToLongBits(other.estimatedHours)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.service, other.service)) {
            return false;
        }
    
        return true;
    }
    
    
    
    
    
}
