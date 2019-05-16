package com.hkdemircan;

public class Coupon {
    private int threshold;
    private int rate;
    private DiscountType discountType;

    public Coupon(int threshold, int rate, DiscountType discountType) {
        this.threshold = threshold;
        this.rate = rate;
        this.discountType = discountType;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }
}
