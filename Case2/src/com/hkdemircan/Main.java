package com.hkdemircan;

public class Main {

    public static void main(String[] args) {
        Category food = new Category("food");
        Product apple = new Product("Apple", 100.0, food);
        Product almond = new Product("Almonds", 150.0, food);

        ShoppingCart cart = new ShoppingCart();


        cart.addItem(apple,3);
        cart.addItem(almond,1);
        /* System.out.println(cart.getCart().get(0).getTitle());
        System.out.println(cart.getCart().get(3).getTitle()); */
        Campaign campaign1 = new Campaign(food,20.0,3,DiscountType.Rate);
        Campaign campaign2 = new Campaign(food,50.0,5,DiscountType.Rate);
        Campaign campaign3 = new Campaign(food,5.0,5,DiscountType.Amount);

        System.out.println("kampanyasız fiyat : " + cart.getTotalPrice());
        cart.applyDiscounts(campaign1, campaign2, campaign3);
        System.out.println("kampanyadan sonraki fiyat: " + cart.getTotalPrice());

        Coupon coupon = new Coupon(100,10, DiscountType.Rate);
        cart.applyCoupon(coupon);
        System.out.println("kupondan sonraki fiyat : " + cart.getTotalPrice());

        //her kategori için 10, her ürün için 4 tl teslimat ücreti belirledik.
        DeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculator(10, 4, 2.99);

        System.out.println("teslimat ücreti : " + deliveryCostCalculator.calculateFor(cart));
        System.out.println("kupondan uygulanan indirim : " + cart.getCouponDiscount());
        System.out.println("kampanyadan uygulanan indirim : " + cart.getCampaignDiscount());


    }
}
