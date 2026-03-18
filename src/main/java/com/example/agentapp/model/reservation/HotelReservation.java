package com.example.agentapp.model.reservation;

import com.example.agentapp.model.Hotel;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@DiscriminatorValue("HOTEL")
public class HotelReservation extends Reservation {

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Temporal(TemporalType.DATE)
    private Date checkIn;

    @Temporal(TemporalType.DATE)
    private Date checkOut;

    private int roomCount;
    private int adultCount;
    private int childCount;

    // Örn: "Standard", "Family", "Suite"
    private String roomType;

    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    // Örn: "Non-smoking", "Sea view", "Late check-in"
    private String specialRequest;

    // --- getters/setters ---
    public Hotel getHotel() { return hotel; }
    public void setHotel(Hotel hotel) { this.hotel = hotel; }

    public Date getCheckIn() { return checkIn; }
    public void setCheckIn(Date checkIn) { this.checkIn = checkIn; }

    public Date getCheckOut() { return checkOut; }
    public void setCheckOut(Date checkOut) { this.checkOut = checkOut; }

    public int getRoomCount() { return roomCount; }
    public void setRoomCount(int roomCount) { this.roomCount = roomCount; }

    public int getAdultCount() { return adultCount; }
    public void setAdultCount(int adultCount) { this.adultCount = adultCount; }

    public int getChildCount() { return childCount; }
    public void setChildCount(int childCount) { this.childCount = childCount; }

    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }

    public BoardType getBoardType() { return boardType; }
    public void setBoardType(BoardType boardType) { this.boardType = boardType; }

    public String getSpecialRequest() { return specialRequest; }
    public void setSpecialRequest(String specialRequest) { this.specialRequest = specialRequest; }
}