
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
 *         &lt;element name="GetListByNameResult" type="{http://tempuri.org}ArrayOfPersonIdentificationPersonIdentification"/&gt;
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
    "getListByNameResult"
})
@XmlRootElement(name = "GetListByNameResponse")
public class GetListByNameResponse {

    @XmlElement(name = "GetListByNameResult", required = true)
    protected ArrayOfPersonIdentificationPersonIdentification getListByNameResult;

    /**
     * Gets the value of the getListByNameResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPersonIdentificationPersonIdentification }
     *     
     */
    public ArrayOfPersonIdentificationPersonIdentification getGetListByNameResult() {
        return getListByNameResult;
    }

    /**
     * Sets the value of the getListByNameResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPersonIdentificationPersonIdentification }
     *     
     */
    public void setGetListByNameResult(ArrayOfPersonIdentificationPersonIdentification value) {
        this.getListByNameResult = value;
    }

    public GetListByNameResponse withGetListByNameResult(ArrayOfPersonIdentificationPersonIdentification value) {
        setGetListByNameResult(value);
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
