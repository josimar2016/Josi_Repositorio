package pt.ua.encontreja.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pt.ua.encontreja.entity.Category;
import pt.ua.encontreja.entity.Contact;
import pt.ua.encontreja.entity.Rating;
import pt.ua.encontreja.entity.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-30T16:04:39")
@StaticMetamodel(Service.class)
public class Service_ { 

    public static volatile SingularAttribute<Service, Double> feePrice;
    public static volatile ListAttribute<Service, Contact> contactList;
    public static volatile ListAttribute<Service, Rating> ratingList;
    public static volatile SingularAttribute<Service, Double> hourPrice;
    public static volatile SingularAttribute<Service, String> description;
    public static volatile SingularAttribute<Service, Integer> id;
    public static volatile SingularAttribute<Service, String> title;
    public static volatile SingularAttribute<Service, Category> category;
    public static volatile SingularAttribute<Service, User> user;

}