package ecoprice.in.tonantmerchant.dummy;

import java.util.ArrayList;
import java.util.List;

import ecoprice.in.tonantmerchant.Models.Cart;


public class ModelCart{

    private static List<Cart> data = new ArrayList<Cart>();

    public static List<Cart> getData() {
        return data;
    }

    public static void setData(List<Cart> data) {
        ModelCart.data = data;
    }


    public int getCartSize() {

        return data.size();

    }


}
