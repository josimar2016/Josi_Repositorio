package pt.ua.encontreja.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pt.ua.encontreja.entity.Service;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-30T16:04:39")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, String> name;
    public static volatile ListAttribute<Category, Service> serviceList;
    public static volatile SingularAttribute<Category, Integer> id;

}