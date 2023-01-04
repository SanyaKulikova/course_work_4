package ru.kulikova.common;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "tb_groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private int id;

    @Column(name = "is_recruited")
    private boolean isRecruited;

    @OneToMany(mappedBy = "group")
    private List<Mountaineer> mountaineers;
    @OneToOne
    private Mountain mountain;
    @Column(name = "number_of_mountaineers")
    private int mountaineerCount;

    @Column(name = "date_of_climbing")
    private LocalDateTime dateOfClimbing;


    public Group() {
        setMountaineers(new ArrayList<>());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRecruited() {
        return isRecruited;
    }

    public void setRecruited(boolean recruited) {
        isRecruited = recruited;
    }

    public List<Mountaineer> getMountaineers() {
        return mountaineers;
    }

    public void setMountaineers(List<Mountaineer> mountaineers) {
        this.mountaineers = mountaineers;
    }

    public Mountain getMountain() {
        return mountain;
    }

    public int getMountaineerCount() {
        return mountaineerCount;
    }

    public LocalDateTime getDateOfClimbing() {
        return dateOfClimbing;
    }

    public void setDateOfClimbing(LocalDateTime dateOfClimbing) {
        this.dateOfClimbing = dateOfClimbing;
    }

    public void setMountain(Mountain mountain) {
        if (mountain == null) {
            throw new IllegalArgumentException("гора не может быть null");
        }
        this.mountain = mountain;
    }

    public void setMountaineerCount(int mountaineerCount) {
        if (mountaineerCount < 0) {
            throw new IllegalArgumentException("Число альпинистов в группе не может быть меньше 0");
        }
        this.mountaineerCount = mountaineerCount;
    }
    public void setMountaineersLarge(int mountaineerCount){
        if (mountaineerCount < this.mountaineerCount ) {
            isRecruited = true;
        } else {
            isRecruited = false;
            System.out.println("Рзамер группы " + this.mountaineerCount);
        }
    }
    public void addMountaineer(Mountaineer mountaineer) {
        if (this.mountaineers.size() > this.mountaineerCount ){
            isRecruited = false;
            System.out.println("Набор в данную группу закрыт");
        } else this.mountaineers.add(mountaineer);
//        for (int j = 0; j < mountaineers.length; j++) {
//            if (mountaineers[j] == null) {
//                mountaineers[j] = mountaineer;
//                return;
//            }
//        }
//        isRecruited = false;
//        System.out.println("Набор в данную группу закрыт");
    }

    @Override
    public String toString() {
        return "Group{" +
                ", isRecruited=" + isRecruited +
                ", mountaineers=" + mountaineers +
                ", mountain=" + mountain +
                ", mountaineerCount=" + mountaineerCount +
                ", dateOfClimbing=" + dateOfClimbing +
                '}';
    }
}
