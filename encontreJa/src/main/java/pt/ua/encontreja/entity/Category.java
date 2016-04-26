/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ua.encontreja.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author arrais
 */
@Entity
@Table(name = "Category")
public class Category implements Serializable {

    public Category() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "Category", cascade={CascadeType.ALL}, orphanRemoval=true)
    private List<Service> serviceList;

    public Category(List<Service> serviceList) {
        this.serviceList =new ArrayList<>();
    }

    
    @XmlTransient
    @JsonIgnore
    public List<Service> getServiceList() {
        return serviceList;
    }
    
  

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }
    
    public void addService(Service service){
        serviceList.add(service);
    }
    
    public void removeService(Service service){
        serviceList.remove(service);
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  
    
    
    
    
    
    
}