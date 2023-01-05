package ru.kulikova.common;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_mountaineers")
public class Mountaineer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mountaineer_id")
    private int id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 100, nullable = false)
    private String address;
    @Column(nullable = false)
    private int age;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Group> groups;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age == 0 || age < 18){
            throw new IllegalArgumentException("Только для совершеннолетних!");
        }
        this.age = age;
    }

    public void setName(String name){
        if (name == null || name.length() < 3 ) { // добавила проверку на null!!!!!
            throw new IllegalArgumentException("Имя должно быть строкой, не короче 3 символов");
        }
        this.name = name;
    }
    public void setAddress(String address) {
        if (address == null || address.length() < 5) {
            throw new IllegalArgumentException("Адрес должно быть строкой, не короче 5 символов");
        }
        this.address = address;
    }
    public String getName(){
        return name;
    }

    public String getAddress() {
        return address;
    }


    @Override
    public String toString() {
        return "Mountaineer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", groups=" + groups +
                '}';
    }
}
