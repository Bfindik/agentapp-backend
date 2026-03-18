package com.example.agentapp.model.reservation;

import com.example.agentapp.model.PassengerFile;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "reservations")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "reservation_type")
public abstract class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Hangi küçük gruba (voucher/file) ait?
    @ManyToOne
    @JoinColumn(name = "passenger_file_id")
    private PassengerFile passengerFile;

    // Rezervasyonun oluşturulduğu tarih-saat (işlem zamanı)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reservation_date")
    private Date reservationDate;

    // Kaydın oluşturulma / güncellenme zamanları (audit)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private ReservationStatus status = ReservationStatus.DRAFT;

    @Column(name = "total_price", precision = 12, scale = 2)
    private BigDecimal totalPrice;

    @Column(name = "currency", length = 3)
    private String currency; // "TRY", "USD", "EUR"


    private String voucherNote;   // voucher’da gözükecek
    private boolean canceled;

    /* ================== LIFECYCLE ================== */

    @PrePersist
    protected void onCreate() {
        Date now = new Date();
        this.createdAt = now;
        this.updatedAt = now;
        if (this.reservationDate == null) {
            this.reservationDate = now;
        }
        if (this.status == null) {
            this.status = ReservationStatus.DRAFT;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }


    // GETTER–SETTER
    public Long getId() { return id; }

    public PassengerFile getPassengerFile() { return passengerFile; }
    public void setPassengerFile(PassengerFile passengerFile) { this.passengerFile = passengerFile; }


    public Date getReservationDate() { return reservationDate; }
    public void setReservationDate(Date reservationDate) { this.reservationDate = reservationDate; }

    public String getVoucherNote() { return voucherNote; }
    public void setVoucherNote(String voucherNote) { this.voucherNote = voucherNote; }

    public boolean isCanceled() { return canceled; }
    public void setCanceled(boolean canceled) { this.canceled = canceled; }
}

