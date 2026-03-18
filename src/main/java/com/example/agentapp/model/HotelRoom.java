package com.example.agentapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "hotel_rooms")
public class HotelRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "child_discount_id")
    private ChildDiscount childDiscount;

    @OneToMany(mappedBy = "hotelRoom", cascade = CascadeType.ALL)
    private List<RoomPrice> roomPriceEntries;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public HotelRoom() {}
    public HotelRoom(String roomName, ChildDiscount childDiscount, List<RoomPrice> roomPriceEntries) {
        this.roomName = roomName;
        this.childDiscount = childDiscount;
        this.roomPriceEntries = roomPriceEntries;
    }
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public ChildDiscount getChildDiscount() {
        return childDiscount;
    }

    public void setChildDiscount(ChildDiscount childDiscount) {
        this.childDiscount = childDiscount;
    }

    public List<RoomPrice> getRoomPriceEntries() {
        return roomPriceEntries;
    }

    public void setRoomPriceEntries(List<RoomPrice> roomPriceEntries) {
        this.roomPriceEntries = roomPriceEntries;
    }
}
