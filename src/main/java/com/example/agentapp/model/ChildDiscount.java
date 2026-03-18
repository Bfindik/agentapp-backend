package com.example.agentapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "child_discounts")
public class ChildDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double child1Discount;
    private double child2Discount;
    private int child1AgeLimit;
    private int child2AgeLimit;

    public ChildDiscount() {}

    // Constructor
    public ChildDiscount(double child1Discount, double child2Discount, int child1AgeLimit, int child2AgeLimit) {
        this.child1Discount = child1Discount;
        this.child2Discount = child2Discount;
        this.child1AgeLimit = child1AgeLimit;
        this.child2AgeLimit = child2AgeLimit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter ve Setter methods
    public double getChild1Discount() {
        return child1Discount;
    }

    public void setChild1Discount(double child1Discount) {
        this.child1Discount = child1Discount;
    }

    public double getChild2Discount() {
        return child2Discount;
    }

    public void setChild2Discount(double child2Discount) {
        this.child2Discount = child2Discount;
    }

    public int getChild1AgeLimit() {
        return child1AgeLimit;
    }

    public void setChild1AgeLimit(int child1AgeLimit) {
        this.child1AgeLimit = child1AgeLimit;
    }

    public int getChild2AgeLimit() {
        return child2AgeLimit;
    }

    public void setChild2AgeLimit(int child2AgeLimit) {
        this.child2AgeLimit = child2AgeLimit;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "child1Discount=" + child1Discount +
                ", child2Discount=" + child2Discount +
                ", child1AgeLimit=" + child1AgeLimit +
                ", child2AgeLimit=" + child2AgeLimit +
                '}';
    }
}