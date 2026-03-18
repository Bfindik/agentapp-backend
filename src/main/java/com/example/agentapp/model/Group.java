package com.example.agentapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Örn: "Kapadokya 29 Ekim Grubu"
    private String name;

    // Bu grup hangi tura ait?
    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    // Bir grupta birden çok PassengerFile (2+2+4+5+6 gibi küçük gruplar)
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<PassengerFile> passengerFiles;

    public Group() {
    }

    public Group(Long id, String name, Tour tour, List<PassengerFile> passengerFiles) {
        this.id = id;
        this.name = name;
        this.tour = tour;
        this.passengerFiles = passengerFiles;
    }
// GETTER–SETTER

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Tour getTour() { return tour; }
    public void setTour(Tour tour) { this.tour = tour; }

    public List<PassengerFile> getPassengerFiles() { return passengerFiles; }
    public void setPassengerFiles(List<PassengerFile> passengerFiles) {
        this.passengerFiles = passengerFiles;
    }
}

