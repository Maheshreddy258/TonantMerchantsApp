package ecoprice.in.tonantmerchant.Models;

import java.util.ArrayList;
import java.util.List;

public class NewModelCart {

    private static List<ModelProducts> cartProducts = new ArrayList<ModelProducts>();

    public static List<ModelProducts> getData() {
        return cartProducts;
    }

    public static void setData(List<ModelProducts> data) {
        NewModelCart.cartProducts = data;
    }




    public int getCartSize() {

        return cartProducts.size();

    }

    public boolean RemoveProduct(ModelProducts aProduct) {

        return cartProducts.remove(aProduct);



    }

    public boolean UpdateCart(ModelProducts aProduct,String wait) {
            aProduct.setProductWait(wait);
            return cartProducts.contains(aProduct);

    }


}
