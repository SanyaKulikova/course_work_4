package ru.kulikova.common;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_mountains")
public class Mountain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mountain_id")
    private int id;
    @Column(name = "name", length = 100, unique = true, nullable = false)
    private String mountainName;
    @Column(length = 100, nullable = false)
    private String country;
    @Column(nullable = false)
    private double height;

    @OneToOne(mappedBy = "mountain")
    private Group group;

//    public Mountain(String mountainName, String country, double height) {
//        setMountainName(mountainName);
//        setCountry(country);
//        setHeight(height);
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setMountainName(String mountainName){
        if (mountainName == null || mountainName.length() < 4) {
            throw new IllegalArgumentException("Название горы не может быть короче 4 символов");
        }
        this.mountainName = mountainName;
    }
    public void setCountry(String country){
        if (country == null || country.length() < 4) {
            throw new IllegalArgumentException("Страна не может быть короче 4 символов");
        }
        this.country = country;
    }
    public void setHeight(double height){
        if (height < 100) {
            throw new IllegalArgumentException("Высота горы не может быть меньше 100 метров"); // примитивы на null не проверяем
        }
        this.height = height;
    }

    public String getMountainName(){
        return mountainName;
    }
    public String getCountry(){
        return country;
    }
    public double getHeight(){
        return height;
    }


    @Override
    public String toString() {
        return "Mountain{" +
                "mountainName='" + mountainName + '\'' +
                ", country='" + country + '\'' +
                ", height=" + height +
                ", group=" + group +
                '}';
    }
}
