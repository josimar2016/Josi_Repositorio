 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.ua.encontreja.entity.Contact;
import pt.ua.encontreja.entity.Service;
import pt.ua.encontreja.entity.User;

/**
 *
 * @author josimar
 */
public class EntityTest {

    User client;
    User prof;
    Contact contact;
    List<Service> serviceList;
    int idUser = 1;
    String nameUser = "Joel Matos";
    String emailUser = "joel.matos@gamil.com";
    String passwordUser = "j@a@_¶T";
    String userImgUser = "http://icons.iconseeker.com/png/fullsize/application-interface/user-5.png";
    String typeUser = "Client";
    int phoneUser = 935245685;
    String locationUser = "Porto";

    int idProf = 1;
    String nameProf = "Joana Almeida";
    String emailProf = "joana.almeida@mail.ua.pt";
    String passwordProf = "zezinha";
    String userImgProf = "www.photos.org/joana.jpg";
    String typeProf = "Profissional";
    int phoneProf = 926365478;
    String locationProf = "Coimbra";

    public EntityTest() {
    }

    @Before
    public void setUp() {
        client = new User();
        prof = new User();
        contact = new Contact();
        serviceList = new ArrayList<>();

    }

    
    @Test
    public void addUser() {
        client.setId(idUser);
        client.setName(nameUser);
        client.setEmail(emailUser);
        client.setPassWord(passwordUser);
        client.setUserImg(userImgUser);
        client.setType(typeUser);
        client.setPhone(phoneUser);
        client.setLocation(locationUser);
        assertEquals("Id não corresponde", client.getId(), idUser);
        assertEquals("Nome não corresponde", client.getName(), nameUser);
        assertEquals("E-mail não corresponde", client.getEmail(), emailUser);
        assertEquals("Password não corresponde", client.getPassWord(), passwordUser);
        assertEquals("Imagem não corresponde", client.getUserImg(), userImgUser);
        assertEquals("Tipo de utilizador não corresponde", client.getType(), typeUser);
        assertEquals("Phone não corresponde", client.getPhone(), phoneUser);
        assertEquals("Location não corresponde", client.getLocation(), locationUser);
    }

    @Test
    public void addProfissional() {
        prof.setId(idProf);
        prof.setName(nameProf);
        prof.setEmail(emailProf);
        prof.setPassWord(passwordProf);
        prof.setUserImg(userImgProf);
        prof.setType(typeProf);
        prof.setPhone(phoneProf);
        prof.setLocation(locationProf);
        assertEquals("Id não corresponde", prof.getId(), idProf);
        assertEquals("Nome não corresponde", prof.getName(), nameProf);
        assertEquals("E-mail não corresponde", prof.getEmail(), emailProf);
        assertEquals("Password não corresponde", prof.getPassWord(), passwordProf);
        assertEquals("Imagem não corresponde", prof.getUserImg(), userImgProf);
        assertEquals("Tipo de utilizador não corresponde", prof.getType(), typeProf);
        assertEquals("Phone não corresponde", prof.getPhone(), phoneProf);
        assertEquals("Location não corresponde", prof.getLocation(), locationProf);
    }

    @Test
    public void addContact() {
        contact.setClient(client);
        contact.setProfessional(prof);
        Date d = new Date();
        contact.setDate(d);
        contact.setDescription("Olá estou a precisar dos seus serviços.");
        contact.setEstimatedHours(5);
        assertNotNull("Cliente Null", client);
        assertNotNull("Profissional Null", prof);
    }

    @Test
    public void addService() {
        int id = 1;
        String title = "Empregada Dómestica";
        String description = "Limpeza completa do seu imovel.";
        double hourPrice = 5;
        double feePrice = 3;
        Service service = new Service();
        service.setId(id);
        service.setTitle(title);
        service.setDescription(description);
        service.setHourPrice(hourPrice);
        service.setFeePrice(feePrice);
        serviceList.add(service);
        assertEquals("O serviço criado não corresponde com o esperado", serviceList.get(0), service);
    }

    
    @After
    public void tearDown() {
        client = null;
        contact = null;
        serviceList = null;
        assertEquals("O utilizador não está vázio!", null, client);
        assertEquals("Existem serviços na lista!", null, serviceList);
    }
}
