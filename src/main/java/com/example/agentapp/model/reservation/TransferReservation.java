package com.example.agentapp.model.reservation;

import com.example.agentapp.model.Transfer;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("TRANSFER")
public class TransferReservation extends Reservation {

    /**
     * Bu rezervasyon hangi transfer hizmetine ait?
     * (Transfer: inHouse, driver info, transferDate, voucherExpl, inHouseExpl, flightNo vb.)
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transfer_id", nullable = false)
    private Transfer transfer;

    /**
     * İsteğe bağlı: Bu rezervasyonda kaç kişi var?
     * Eğer kimin bineceğini ayrıca tutmuyorsan paxCount kullanışlıdır.
     */
    @Column(name = "pax_count")
    private Integer paxCount;

    /**
     * Opsiyonel: Transfer rezervasyonuna özel bir operasyon notu (müşteriye gitmez).
     * Transfer entity’sinde de not var ama bazı notlar “rezervasyona özel” olabilir.
     */
    @Column(name = "operation_note", length = 1000)
    private String operationNote;

    // --- Constructors ---
    public TransferReservation() {}

    public TransferReservation(Transfer transfer) {
        this.transfer = transfer;
    }

    public TransferReservation(Transfer transfer, Integer paxCount) {
        this.transfer = transfer;
        this.paxCount = paxCount;
    }

    // --- Getters/Setters ---
    public Transfer getTransfer() { return transfer; }
    public void setTransfer(Transfer transfer) { this.transfer = transfer; }

    public Integer getPaxCount() { return paxCount; }
    public void setPaxCount(Integer paxCount) { this.paxCount = paxCount; }

    public String getOperationNote() { return operationNote; }
    public void setOperationNote(String operationNote) { this.operationNote = operationNote; }
}
