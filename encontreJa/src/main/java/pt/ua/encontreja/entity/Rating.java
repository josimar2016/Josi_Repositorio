/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ua.encontreja.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author arrais
 */
@Entity
@Table(name = "Rating")
public class Rating implements Serializable {

    private static final long serialVersionUID = 2445172041950251807L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ratng;
    private String comment;

    @Temporal(TemporalType.DATE)
    private Date date;

    @JsonIgnore
    @OneToOne
    private User user;

    @JsonIgnore
    @ManyToOne
    private Service service;

    public Rating() {
    }

    public int getRatng() {
        return ratng;
    }

    public void setRatng(int ratng) {
        this.ratng = ratng;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

}
