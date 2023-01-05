package ru.kulikova;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ru.kulikova.common.Group;
import ru.kulikova.common.Mountain;
import ru.kulikova.common.Mountaineer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("coursework");
        EntityManager manager = factory.createEntityManager();

        Mountaineer mountaineer01 = new Mountaineer();
        Mountaineer mountaineer02 = new Mountaineer();
        Mountaineer mountaineer03 = new Mountaineer();
        mountaineer01.setName("Василий");
        mountaineer01.setAddress("Россия");
        mountaineer01.setAge(20);
        mountaineer02.setName("Джек");
        mountaineer02.setAddress("Канада");
        mountaineer02.setAge(30);
        mountaineer03.setName("Анастасия");
        mountaineer03.setAddress("Российская империя");
        mountaineer03.setAge(21);


        Mountain mountain01 = new Mountain();
        Mountain mountain02 = new Mountain();
        Mountain mountain03 = new Mountain();
        mountain01.setMountainName("Эверест");
        mountain01.setCountry("Китай");
        mountain01.setHeight(8_848_000);
        mountain02.setMountainName("Ключевская сопка");
        mountain02.setCountry("Россия");
        mountain02.setHeight(4_750_000);
        mountain03.setMountainName("Фудзияма");
        mountain03.setCountry("Япония");
        mountain03.setHeight(3_776_000);

        Group group01 = new Group();
        group01.setMountaineerCount(3);
        group01.setMountain(mountain01);
        group01.addMountaineer(mountaineer01);
        group01.addMountaineer(mountaineer03);
        group01.addMountaineer(mountaineer02);

        List<Group> groups01= new ArrayList<>();
        List<Group> groups02= new ArrayList<>();
        List<Group> groups03= new ArrayList<>();
        mountaineer01.setGroups(groups01);
        mountaineer02.setGroups(groups02);
        mountaineer03.setGroups(groups03);

        mountaineer01.getGroups().add(group01);
        mountaineer02.getGroups().add(group01);
        mountaineer03.getGroups().add(group01);

        List<Group> mountainGroup = new ArrayList<>();
        mountain01.setGroups(mountainGroup);
        mountain01.getGroups().add(group01);

        group01.setDateOfClimbing(LocalDateTime.now());

        manager.getTransaction().begin();
        manager.persist(mountain01);
        manager.persist(mountaineer01);
        manager.persist(mountaineer02);
        manager.persist(mountaineer03);
        manager.persist(group01);
        manager.getTransaction().commit();




    }
}
