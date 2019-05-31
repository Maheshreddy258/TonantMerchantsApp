package ecoprice.in.tonantmerchant.dummy;

import android.app.Application;

import java.util.ArrayList;

import ecoprice.in.tonantmerchant.Models.Cart;


public class Controller extends Application{

    private  ArrayList<Cart> myProducts = new ArrayList<Cart>();
    private  ModelCart myCart = new ModelCart();


    public Cart getProducts(int pPosition) {

        return myProducts.get(pPosition);
    }

    public void setProducts(Cart Products) {

        myProducts.add(Products);

    }

    public ModelCart getCart() {

        return myCart;

    }

    public int getProductsArraylistSize() {

        return myProducts.size();
    }

}

















/*
        C:.
        ├───androidTest
        │   └───java
        │       └───in
        │           └───ecoprice
        │               └───tonant
        ├───java
        ├───main
        │   ├───assets
        │   │   └───fonts
        │   ├───java
        │   │   ├───fonts
        │   │   └───in
        │   │       └───ecoprice
        │   │           └───tonant
        │   │               ├───Adapters
        │   │               ├───dummy
        │   │               ├───Models
        │   │               ├───newChanges
        │   │               ├───Pending
        │   │               ├───Remainders
        │   │               ├───Reports
        │   │               ├───Retrofit
        │   │               │   ├───network
        │   │               │   └───Responce
        │   │               ├───Targets
        │   │               ├───User
        │   │               ├───Visits
        │   │               └───VisitsReports
        │   └───res
        │       ├───anim
        │       ├───drawable
        │       ├───drawable-v24
        │       ├───layout
        │       ├───menu
        │       ├───mipmap-anydpi-v26
        │       ├───mipmap-hdpi
        │       ├───mipmap-mdpi
        │       ├───mipmap-xhdpi
        │       ├───mipmap-xxhdpi
        │       ├───mipmap-xxxhdpi
        │       ├───values
        │       └───values-w820dp
        └───test
        └───java
        └───in
        └───ecoprice
        └───tonant

*/







