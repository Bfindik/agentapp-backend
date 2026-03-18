package com.example.agentapp.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transfers")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nereden / Nereye (hotel, airport, restaurant, port vb.)
    @Column(name = "from_location", length = 150)
    private String fromLocation;

    @Column(name = "to_location", length = 150)
    private String toLocation;

    // Havaalanı transferiyse uçuş kodu
    @Column(name = "flight_code", length = 30)
    private String flightCode;

    // Tarih-saat (transfer zamanı)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "transfer_date_time")
    private Date transferDateTime;

    // Şirket içi mi? (kendi şoförünüz/kendi aracınız)
    @Column(name = "is_in_house", nullable = false)
    private boolean inHouse;

    // inHouse ise şoför bilgileri anlamlı
    @Column(name = "driver_name", length = 80)
    private String driverName;

    @Column(name = "driver_surname", length = 80)
    private String driverSurname;

    @Column(name = "driver_phone", length = 30)
    private String driverPhone;

    // Eğer outsource ise firma bilgisi tutmak için
    @Column(name = "vehicle_company", length = 120)
    private String vehicleCompany;

    // Voucher’da gözükecek açıklama (müşteri görür)
    @Column(name = "voucher_expl", length = 1000)
    private String voucherExpl;

    // Şirket içi açıklama/not (müşteri görmez)
    @Column(name = "internal_expl", length = 1000)
    private String internalExpl;

    // Silmek yerine iptal mantığı (soft cancel)
    @Column(name = "is_canceled", nullable = false)
    private boolean canceled = false;

    public Transfer() {}

    public Transfer(String fromLocation, String toLocation, Date transferDateTime, boolean inHouse) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.transferDateTime = transferDateTime;
        this.inHouse = inHouse;
    }

    public void setInHouseDriver(String name, String surname, String phone) {
        this.inHouse = true;
        this.driverName = name;
        this.driverSurname = surname;
        this.driverPhone = phone;
        this.vehicleCompany = null;
    }

    public void setOutsourceCompany(String companyName) {
        this.inHouse = false;
        this.vehicleCompany = companyName;
        this.driverName = null;
        this.driverSurname = null;
        this.driverPhone = null;
    }

    /* ========== Getters / Setters ========== */

    public Long getId() { return id; }

    public String getFromLocation() { return fromLocation; }
    public void setFromLocation(String fromLocation) { this.fromLocation = fromLocation; }

    public String getToLocation() { return toLocation; }
    public void setToLocation(String toLocation) { this.toLocation = toLocation; }

    public String getFlightCode() { return flightCode; }
    public void setFlightCode(String flightCode) { this.flightCode = flightCode; }

    public Date getTransferDateTime() { return transferDateTime; }
    public void setTransferDateTime(Date transferDateTime) { this.transferDateTime = transferDateTime; }

    public boolean isInHouse() { return inHouse; }
    public void setInHouse(boolean inHouse) { this.inHouse = inHouse; }

    public String getDriverName() { return driverName; }
    public void setDriverName(String driverName) { this.driverName = driverName; }

    public String getDriverSurname() { return driverSurname; }
    public void setDriverSurname(String driverSurname) { this.driverSurname = driverSurname; }

    public String getDriverPhone() { return driverPhone; }
    public void setDriverPhone(String driverPhone) { this.driverPhone = driverPhone; }

    public String getVehicleCompany() { return vehicleCompany; }
    public void setVehicleCompany(String vehicleCompany) { this.vehicleCompany = vehicleCompany; }

    public String getVoucherExpl() { return voucherExpl; }
    public void setVoucherExpl(String voucherExpl) { this.voucherExpl = voucherExpl; }

    public String getInternalExpl() { return internalExpl; }
    public void setInternalExpl(String internalExpl) { this.internalExpl = internalExpl; }

    public boolean isCanceled() { return canceled; }
    public void setCanceled(boolean canceled) { this.canceled = canceled; }
}
