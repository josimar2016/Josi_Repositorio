package pt.ua.encontreja.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pt.ua.encontreja.entity.Contact;
import pt.ua.encontreja.entity.ContactService;
import pt.ua.encontreja.entity.Rating;
import pt.ua.encontreja.entity.Service;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-30T16:04:39")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> userImg;
    public static volatile ListAttribute<User, Contact> contactList;
    public static volatile SingularAttribute<User, Integer> phone;
    public static volatile ListAttribute<User, ContactService> contactServiceList;
    public static volatile SingularAttribute<User, String> name;
    public static volatile ListAttribute<User, Service> serviceList;
    public static volatile SingularAttribute<User, Rating> rating;
    public static volatile SingularAttribute<User, String> location;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> type;
    public static volatile SingularAttribute<User, String> email;

}