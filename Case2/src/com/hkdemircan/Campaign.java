package com.hkdemircan;

public class Campaign {
    private Category category;
    private double rate;
    private int quantity;
    private DiscountType discountType;

    public Campaign(Category category, double rate, int quantity, DiscountType discountType) {
        this.category = category;
        this.rate = rate;
        this.quantity = quantity;
        this.discountType = discountType;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }
}
