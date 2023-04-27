package lt.viko.eif.ih.bakery.soap.model;

/** This is like a branch of Bakery class, the cart consists of id, name, and price.
 * This class has id, name, and price variables. For each of the variables there is getter and setter initialised.
 * Also, constructor is created for cart without id so that this value can be assigned automatically for the database.
 * In this class toString() method is overriden for more comfortable viewing.
 */


public class Cart
{

    private int id;
    private String name;
    private int price;
    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public Cart()
    {

    }
    public Cart(String name, int price) {
    //    this.id = id;
        this.name = name;
        this.price = price;
    }
    public String toString() {
        return String.format("\tid = %d\n\tName of product = %s\n\tPrice = %s", this.id, this.name, this.price);
    }
}
