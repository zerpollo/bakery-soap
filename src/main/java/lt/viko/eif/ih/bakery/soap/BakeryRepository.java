package lt.viko.eif.ih.bakery.soap;
import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lt.viko.eif.ih.bakery.soap.model.Bakery;
import lt.viko.eif.ih.bakery.soap.model.Cart;
import lt.viko.eif.ih.bakery.soap.model.Customer;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class BakeryRepository {
    private static final Map<String, Bakery> bakeries = new HashMap<>();
    @PostConstruct
    public void initData() {
        Bakery bakery1 = new Bakery("BestBakery", "Studentu 47");
        Customer customer1 = new Customer("Ihor", "Halytskyi", "+380675321902");
        Customer customer10 = new Customer("Albert", "Fontin", "+380675321903");
        Customer customer11 = new Customer("Ronald", "Canedo", "+380675321904");
        Customer customer12 = new Customer("Brian", "Olphert", "+380675321905");
        bakery1.addCustomer(customer1);
        bakery1.addCustomer(customer10);
        bakery1.addCustomer(customer11);
        bakery1.addCustomer(customer12);
        Cart cart1 = new Cart("Bread",12);
        customer1.addToCart(cart1);
        bakeries.put(bakery1.getName(), bakery1);


        Bakery bakery2 = new Bakery("Not the best bakery", "Studentu 49");
        Customer customer2 = new Customer("Joseph", "Joestar", "+380675321902");
        Customer customer13 = new Customer("Ronald", "Canedo", "+380675321904");
        Customer customer14 = new Customer("Brian", "Olphert", "+380675321905");
        Cart cart2 = new Cart("Bread",5);
        Cart cart5 = new Cart("Baguette",7);
        Cart cart6 = new Cart("Muffin",3);
        Cart cart7 = new Cart("Croissant",4);
        customer2.addToCart(cart2);
        customer2.addToCart(cart5);
        customer2.addToCart(cart6);
        customer2.addToCart(cart7);
        bakery2.addCustomer(customer2);
        bakery2.addCustomer(customer13);
        bakery2.addCustomer(customer14);


        bakeries.put(bakery2.getName(), bakery2);

        Bakery bakery3 = new Bakery("Popular bakery", "Studentu 50");
        Customer customer3 = new Customer("Lester", "Murphy", "+380675321902");
        Customer customer15 = new Customer("Ronald", "Canedo", "+380675321904");
        Customer customer16 = new Customer("Brian", "Olphert", "+380675321905");
        Cart cart3 = new Cart("Bread",12);
        customer3.addToCart(cart3);
        bakery3.addCustomer(customer3);
        bakery3.addCustomer(customer15);
        bakery3.addCustomer(customer16);

        bakeries.put(bakery3.getName(), bakery3);

    }

    public Bakery findBakery(String name) {
        Assert.notNull(name, "The country's name must not be null");
        return bakeries.get(name);
    }

    public Bakery findBakeryByCustomer(String firstName, String lastName) {
        Assert.notNull(firstName, "The customer's first name must not be null");
        Assert.notNull(lastName, "The customer's last name must not be null");

        for (Bakery bakery : bakeries.values()) {
            for (Customer customer : bakery.getCustomers()) {
                if (customer.getFirstName().equals(firstName) && customer.getLastName().equals(lastName)) {
                    return bakery;
                }
            }
        }

        return null; // customer not found in any bakery
    }
    public List<Cart> findCartByCustomer(String firstName, String lastName) {
        Assert.notNull(firstName, "The customer's first name must not be null");
        Assert.notNull(lastName, "The customer's last name must not be null");

        List<Cart> carts = new ArrayList<>();
        for (Bakery bakery : bakeries.values()) {
            for (Customer customer : bakery.getCustomers()) {
                if (customer.getFirstName().equals(firstName) && customer.getLastName().equals(lastName)) {
                    carts.addAll(customer.getCartList());
                }
            }
        }

        return carts;
    }
}
