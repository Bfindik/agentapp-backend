package com.example.agentapp.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tours")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int nights;
    private String fromCity;
    private String startCity;
    private String fromCountry;
    private String startCountry;
    @ManyToOne
    @JoinColumn(name = "category_id") // Category ile ilişkilendirilecek
    private TourCategory category;
    private Date startDate;// depar dates
    private Date endDate;
    private String highlight;
    private String inboundTransfer;
    @ManyToOne
    @JoinColumn(name = "child_discount_id")
    private ChildDiscount childDiscount;
    private String tourPicturePath;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Meal> meals;
    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<TourItinerary> tourdays;
    private Date releaseDate;
    private String discountType;
    private String mainPicturePath;
    private String mapPath;
    private boolean transferIncluded;

    public Tour() {
    }

    public ChildDiscount getChildDiscount() {
        return childDiscount;
    }

    public void setChildDiscount(ChildDiscount childDiscount) {
        this.childDiscount = childDiscount;
    }

    // highlight(slogan), tour included(string) note uygulması gibi checkboxlı,  aynısının not included,
    // meals(sabah, öğle, akşam)
    // inbound transfer(transfer buluşma noktaları)
    // children discount
    // allotment type(limit pax(insan) veya room sayısı)
    // relase date( turdan önce ilanın kaldırılma günü) istenince açılabilecek veya değiştirilebilecek
    // price( single,double triple, chd1,chd2 discount
    // discount tipleri percentage veya money üzerinden ya da 2. kişiye indirim
    // main image, map
    // transfer included/not included
}
