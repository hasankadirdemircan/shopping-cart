package com.hkdemircan;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> cart = new ArrayList<Product>();
    private double totalPrice = 0;
    private double couponPrice = 0;
    private double campaignPrice = 0;

    public double getCampaignPrice() {
        return campaignPrice;
    }

    public void setCampaignPrice(double campaignPrice) {
        this.campaignPrice = campaignPrice;
    }

    public double getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(double couponPrice) {
        this.couponPrice = couponPrice;
    }

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * <summary> ürünleri sepete ekleyen ve indirimsiz ödenecek tutarı hesaplayan method </summary>
     * @param product
     * @param quantity
     */
    public void addItem(Product product, int quantity){
        for(int i=0; i<quantity; i++){
            //3 elma varsa tek tek ekler. Her birini ayrı ekliyoruz.
            //Çünkü her biri için ayrı indirim uygulayacağız.
            Product prd = new Product(product.getTitle(),product.getPrice(), product.getCategory());
            cart.add(prd);
            //sepete eklerken indirimsiz toplam ücreti hesaplıyoruz.
            totalPrice += prd.getPrice();
        }
    }



    /**
     *  <summary> gelen kampanyalara göre ürünlere ayrı ayrı indirim uygulayan method </summary>
     * @param campaigns
     */
    public void applyDiscounts(Campaign ...campaigns){
        for(Campaign campaign : campaigns) { //tüm kampanyaları gez.
            if(cart.size() > campaign.getQuantity()){ //sepetimizdeki ürünlerin sayısı kampanyada belirtilen sayıdan büyükse indirim uygularız.
                for (Product product : cart){
                    if(product.getCategory().equals(campaign.getCategory())){ //ürün kategorisi ile kampanya kategorisi aynıysa indirim uygularız.
                        if(campaign.getDiscountType().equals(DiscountType.Rate)){
                            product.setPrice(product.getPrice() - (product.getPrice() * campaign.getRate() / 100));
                        }else{
                            product.setPrice(product.getPrice() - campaign.getRate());
                        }

                    }
                }
            }
        }
        //indirimsiz ödenecek tutardan indirimli ödenecek tutar çıkarılıp nekadar indirim ücreti olduğu yazılır.
        campaignPrice = totalPrice - getTotalAmountAfterDiscounts();
        //indirimden sonra ödenecek tutar.
        totalPrice = getTotalAmountAfterDiscounts();
    }

    /**
     * <summary> sepete kupon indirimi uygulayan ve kupon indirim miktarını hesaplayan method </summary>
     * @param coupons
     */
    public void applyCoupon(Coupon ...coupons){
        double temp = totalPrice;
        for (Coupon coupon : coupons){
            if(totalPrice >= coupon.getThreshold()){
                if(coupon.getDiscountType().equals(DiscountType.Rate)){
                    totalPrice = totalPrice - (totalPrice * coupon.getRate()/100);
                }else{
                    totalPrice -= coupon.getRate();
                }
            }
        }
        //kupon indirim miktarını hesaplar.
        couponPrice = temp - totalPrice;
    }

    public double getCouponDiscount(){
        return getCouponPrice();
    }

    public double getCampaignDiscount(){
        return getCampaignPrice();
    }

    /**
     * <summary> kampanyalardaki indirimleri uyguladıktan sonra ürünlerin
     *  güncel fiyatını hesaplayan method </summary>
     * @return
     */
    public double getTotalAmountAfterDiscounts(){
        double cartTotalPrice = 0;
        for(Product product : cart){
            cartTotalPrice += product.getPrice();
        }
        return cartTotalPrice;
    }
}
