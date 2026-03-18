package com.example.agentapp.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "tour_itineraries")
public class TourItinerary {
    // Title, gün numarası(day1 vs), description, otel, meals, notlar, city
    // image ya da map lazımsa
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    private int dayNumber;
    private String description;
    @OneToMany
    @JoinTable(
            name = "itinerary_hotels",
            joinColumns = @JoinColumn(name = "itinerary_id"),
            inverseJoinColumns = @JoinColumn(name = "hotel_id")
    )
    private List<Hotel> hotels;
    private String notes;
    private String city;
    private String country;
    private String dayPicturePath;
    private String mapPath;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Meal> meals;
    @ManyToOne
    @JoinColumn(name = "tour_id") // Tour ile ilişkilendirilecek
    private Tour tour;
    public TourItinerary() {}
    public TourItinerary(String title, int dayNumber, String desc, List<Hotel> hotels, String notes, String city, String country, String dayPicturePath, String mapPath, List<Meal> meals, Tour tour) {
        this.title = title;
        this.dayNumber = dayNumber;
        this.description = desc;
        this.hotels = hotels;
        this.notes = notes;
        this.city = city;
        this.country = country;
        this.dayPicturePath = dayPicturePath;
        this.mapPath = mapPath;
        this.meals = meals;
        this.tour = tour;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDayPicturePath() {
        return dayPicturePath;
    }

    public void setDayPicturePath(String dayPicturePath) {
        this.dayPicturePath = dayPicturePath;
    }

    public String getMapPath() {
        return mapPath;
    }

    public void setMapPath(String mapPath) {
        this.mapPath = mapPath;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
}
