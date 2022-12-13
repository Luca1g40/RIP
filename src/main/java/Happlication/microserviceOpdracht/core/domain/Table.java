package Happlication.microserviceOpdracht.core.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "tafel")
public class Table {

    @Id
    @GeneratedValue
    private Long tableId;
    private int tableNumber;
    @OneToOne(cascade = CascadeType.ALL)
    private ShoppingCart shoppingCart;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orders;


    public Table() {}

    public Table(Long tableId, int tableNumber, List<Order> orders) {
        this.tableId = tableId;
        this.tableNumber = tableNumber;
        this.shoppingCart = new ShoppingCart();
        this.orders = orders;
    }

    public void placeOrder(){
        Order order = new Order(this.tableNumber, new ArrayList<>());

        for (String product : shoppingCart.getProducts()){
            order.addProducts(product);
        }

        addOrders(order);

        shoppingCart.clearShoppingCart();
    }

    public void addToShoppingCart(String product){
        this.shoppingCart.addProductToShoppingCart(product);
    }

    public void addOrders(Order order){
        orders.add(order);
    }

    public Long getTableId() {
        return tableId;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableId=" + tableId +
                ", tableNumber=" + tableNumber +
                ", shoppingCart=" + shoppingCart +
                ", orders=" + orders +
                '}';
    }
}
