package lt.viko.eif.ih.bakery.soap.model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "cart"
})
@XmlRootElement(name = "getCartByCustomerResponse")
public class GetCartByCustomerResponse {

    @XmlElement(required = true)
    protected List<Cart> cart;

    /**
     * Gets the value of the cart property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore, any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cart property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCart().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Cart }
     *
     *
     */
    public List<Cart> getCart() {
        if (this.cart == null) {
            this.cart = new ArrayList<Cart>();
        }
        return this.cart;
    }

    public void setCart(List <Cart> cart) { this.cart = cart; }

}

