
package org.tempuri;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LookupCityResult" type="{http://tempuri.org}Address"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "lookupCityResult"
})
@XmlRootElement(name = "LookupCityResponse")
public class LookupCityResponse {

    @XmlElement(name = "LookupCityResult", required = true)
    protected Address lookupCityResult;

    /**
     * Gets the value of the lookupCityResult property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getLookupCityResult() {
        return lookupCityResult;
    }

    /**
     * Sets the value of the lookupCityResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setLookupCityResult(Address value) {
        this.lookupCityResult = value;
    }

    public LookupCityResponse withLookupCityResult(Address value) {
        setLookupCityResult(value);
        return this;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }

}
