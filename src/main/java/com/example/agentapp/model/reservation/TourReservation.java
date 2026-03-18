package com.example.agentapp.model.reservation;

import com.example.agentapp.model.Tour;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@DiscriminatorValue("TOUR")
public class TourReservation extends Reservation {

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @Temporal(TemporalType.TIMESTAMP)
    private Date tourDate;

    private int adultCount;
    private int childCount;

    // Örn: "EN", "TR"
    private String language;

    private boolean guideIncluded;

    // Örn: "Hotel Lobby", "Airport Gate 3"
    private String pickupPoint;

    // --- getters/setters ---
    public Tour getTour() { return tour; }
    public void setTour(Tour tour) { this.tour = tour; }

    public Date getTourDate() { return tourDate; }
    public void setTourDate(Date tourDate) { this.tourDate = tourDate; }

    public int getAdultCount() { return adultCount; }
    public void setAdultCount(int adultCount) { this.adultCount = adultCount; }

    public int getChildCount() { return childCount; }
    public void setChildCount(int childCount) { this.childCount = childCount; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public boolean isGuideIncluded() { return guideIncluded; }
    public void setGuideIncluded(boolean guideIncluded) { this.guideIncluded = guideIncluded; }

    public String getPickupPoint() { return pickupPoint; }
    public void setPickupPoint(String pickupPoint) { this.pickupPoint = pickupPoint; }
}
