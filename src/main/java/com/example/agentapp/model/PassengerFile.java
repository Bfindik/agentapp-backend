package com.example.agentapp.model;

import com.example.agentapp.model.reservation.Reservation;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "passenger_files")
public class PassengerFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Örn: "Yılmaz Ailesi", "Ali & Ayşe"
    private String title;

    // Bu küçük grup hangi büyük gruba (Group) ait?
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToMany(mappedBy = "passengerFiles")
    private List<Passenger> passengers;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToMany(mappedBy = "passengerFile")
    private List<Reservation> reservations;


    // CONSTRUCTOR

    public PassengerFile() {}

    public PassengerFile(String title, Group group) {
        this.title = title;
        this.group = group;
    }

    // GETTER–SETTER

    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Group getGroup() { return group; }
    public void setGroup(Group group) { this.group = group; }

    public List<Passenger> getPassengers() { return passengers; }
    public void setPassengers(List<Passenger> passengers) { this.passengers = passengers; }

    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
