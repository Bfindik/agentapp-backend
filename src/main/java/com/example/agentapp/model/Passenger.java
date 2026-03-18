package com.example.agentapp.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String passportNumber;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private LocalDate passportExpiryDate;

    private String phone;

    private String email;

    @ManyToMany
    @JoinTable(
            name = "passenger_passengerfile",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "file_id")
    )
    private List<PassengerFile> passengerFiles;


    public Passenger(String passportNumber, String firstName, String lastName, LocalDate dateOfBirth, LocalDate passportExpiryDate, String phone, String email) {
        this.passportNumber = passportNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.passportExpiryDate = passportExpiryDate;
        this.phone = phone;
        this.email = email;
    }
    // Getter and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public LocalDate getPassportExpiryDate() { return passportExpiryDate; }
    public void setPassportExpiryDate(LocalDate passportExpiryDate) { this.passportExpiryDate = passportExpiryDate; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
