package pt.ua.encontreja.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pt.ua.encontreja.entity.Contact;
import pt.ua.encontreja.entity.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-30T16:04:39")
@StaticMetamodel(ContactService.class)
public class ContactService_ { 

    public static volatile SingularAttribute<ContactService, Date> date;
    public static volatile SingularAttribute<ContactService, Double> hours;
    public static volatile SingularAttribute<ContactService, Contact> contact;
    public static volatile SingularAttribute<ContactService, String> description;
    public static volatile SingularAttribute<ContactService, User> user;

}