package Happlication.microserviceOpdracht.core.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "tafel")
public class Table {

    @Id
    @GeneratedValue
    private Long tableId;
    private int tableNumber;
    @OneToOne
    private ShoppingCart shoppingCart;
    @OneToMany
    private List<Order> orders;


    public Table() {}

    public Table(Long tableId, int tableNumber, ShoppingCart shoppingCart, List<Order> orders) {
        this.tableId = tableId;
        this.tableNumber = tableNumber;
        this.shoppingCart = shoppingCart;
        this.orders = orders;
    }

    public void placeOrders(){
        List<String> productNames = new ArrayList<>();
        for (Product product:shoppingCart.getProducts()){
            productNames.add(product.getProductName());
        }

        Order order = new Order(this.tableNumber, productNames);
        addOrders(order);
        shoppingCart.clearShoppingCart();
    }

    public void addOrders(Order order){
        orders.add(order);
    }

}
