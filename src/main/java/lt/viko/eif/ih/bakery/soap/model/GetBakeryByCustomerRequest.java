package lt.viko.eif.ih.bakery.soap.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="empty" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "firstName",
        "lastName"
})
@XmlRootElement(name = "getBakeryByCustomerRequest")
public class GetBakeryByCustomerRequest {

    protected String firstName;
    protected String lastName;
    /**
     * Gets the value of the empty property.
     *
     * @return possible object is
     * {@link Object }
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the empty property.
     *
     * @param value allowed object is
     *              {@link Object }
     */
    public void setFirstName(String value) { this.firstName = value; }

    public String getLastName() { return lastName; }
    public void setLastName(String value) {this.lastName = value;}

}
