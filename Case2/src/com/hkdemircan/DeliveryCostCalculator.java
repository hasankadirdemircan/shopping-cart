package com.hkdemircan;

import java.util.ArrayList;
import java.util.List;

public class DeliveryCostCalculator {
    private double costPerDelivery;
    private double costPerProduct;
    private double fixedCost;

    public DeliveryCostCalculator(double costPerDelivery, double costPerProduct, double fixedCost) {
        this.costPerDelivery = costPerDelivery;
        this.costPerProduct = costPerProduct;
        this.fixedCost = fixedCost;
    }

    /**
     * <summary> teslimat ücretini hesaplayıp dönen method </summary>
     * @param cart
     * @return
     */
    public double calculateFor(ShoppingCart cart){
        //sepetteki farklı kategori sayısı.
        int numberOfDeliveries = getNumberOfDeliveries(cart);
        //sepetteki farklı ürün sayısı
        int numberOfProducts = getNumberOfProducts(cart);
        //verilen formül'e göre işlemleri yaparak teslimat ücretini döndürür.
        return  (costPerDelivery * numberOfDeliveries) + (costPerProduct * numberOfProducts) + fixedCost;
    }

    /**
     * <summary> sepetteki farklı kategori sayısını döndüren method </summary>
     * @param cart
     * @return
     */
    public int getNumberOfDeliveries(ShoppingCart cart){
        List<Category> categoryList = new ArrayList<Category>();
        for(Product product : cart.getCart()){
            if(!categoryList.contains(product.getCategory())){
                categoryList.add(product.getCategory());
            }
        }
        return  categoryList.size();
    }

    /**
     * <summary> sepetteki farklı ürün sayısını döndürüren method </summary>
     * @param cart
     * @return
     */
    public int getNumberOfProducts(ShoppingCart cart){
        List<String> productList = new ArrayList<String>();
        for(Product product : cart.getCart()){
            if(!productList.contains(product.getTitle())){
                productList.add(product.getTitle());
            }
        }
        return  productList.size();
    }

    public double getCostPerDelivery() {
        return costPerDelivery;
    }

    public void setCostPerDelivery(double costPerDelivery) {
        this.costPerDelivery = costPerDelivery;
    }

    public double getCostPerProduct() {
        return costPerProduct;
    }

    public void setCostPerProduct(double costPerProduct) {
        this.costPerProduct = costPerProduct;
    }

    public double getFixedCost() {
        return fixedCost;
    }

    public void setFixedCost(double fixedCost) {
        this.fixedCost = fixedCost;
    }
}
