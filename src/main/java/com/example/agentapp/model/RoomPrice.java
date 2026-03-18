package com.example.agentapp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "room_prices")
public class RoomPrice {
    public enum RoomType {
        SINGLE,
        DOUBLE,
        TRIPLE
    }

    public enum MealPlan {
        ALL_INCLUSIVE,
        HALF_BOARD,
        FULL_BOARD,
        BED_AND_BREAKFAST,
        ROOM_ONLY
    }
    public enum Currency {
        USD,    // Amerikan Doları
        EUR,    // Euro
        CAD,    // Kanada Doları
        GBP,    // İngiliz Sterlini
        TRY     // Türk Lirası
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @Enumerated(EnumType.STRING)
    private MealPlan mealPlan;
    private LocalDate startDate;
    private LocalDate endDate;
    private double singlePrice;
    private double doublePrice;
    private double triplePrice;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_room_id")
    private HotelRoom hotelRoom;

    public RoomPrice() {
    }

    public RoomPrice(RoomType roomType, MealPlan mealPlan, LocalDate startDate, LocalDate endDate, double singlePrice, double doublePrice, double triplePrice, Currency currency, HotelRoom hotelRoom) {
        this.roomType = roomType;
        this.mealPlan = mealPlan;
        this.startDate = startDate;
        this.endDate = endDate;
        this.singlePrice = singlePrice;
        this.doublePrice = doublePrice;
        this.triplePrice = triplePrice;
        this.currency = currency;
        this.hotelRoom = hotelRoom;
    }

    public HotelRoom getHotelRoom() {
        return hotelRoom;
    }

    public void setHotelRoom(HotelRoom hotelRoom) {
        this.hotelRoom = hotelRoom;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public MealPlan getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(double singlePrice) {
        this.singlePrice = singlePrice;
    }

    public double getDoublePrice() {
        return doublePrice;
    }

    public void setDoublePrice(double doublePrice) {
        this.doublePrice = doublePrice;
    }

    public double getTriplePrice() {
        return triplePrice;
    }

    public void setTriplePrice(double triplePrice) {
        this.triplePrice = triplePrice;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
