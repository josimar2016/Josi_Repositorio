package pt.ua.encontreja.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pt.ua.encontreja.entity.Service;
import pt.ua.encontreja.entity.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-30T16:04:39")
@StaticMetamodel(Contact.class)
public class Contact_ { 

    public static volatile SingularAttribute<Contact, Date> date;
    public static volatile SingularAttribute<Contact, Service> service;
    public static volatile SingularAttribute<Contact, String> description;
    public static volatile SingularAttribute<Contact, Double> estimatedHours;
    public static volatile SingularAttribute<Contact, Integer> id;
    public static volatile SingularAttribute<Contact, User> user;

}