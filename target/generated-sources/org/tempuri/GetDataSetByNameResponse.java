
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
 *         &lt;element name="GetDataSetByNameResult" type="{http://tempuri.org}ByNameDataSet"/&gt;
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
    "getDataSetByNameResult"
})
@XmlRootElement(name = "GetDataSetByNameResponse")
public class GetDataSetByNameResponse {

    @XmlElement(name = "GetDataSetByNameResult", required = true)
    protected ByNameDataSet getDataSetByNameResult;

    /**
     * Gets the value of the getDataSetByNameResult property.
     * 
     * @return
     *     possible object is
     *     {@link ByNameDataSet }
     *     
     */
    public ByNameDataSet getGetDataSetByNameResult() {
        return getDataSetByNameResult;
    }

    /**
     * Sets the value of the getDataSetByNameResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ByNameDataSet }
     *     
     */
    public void setGetDataSetByNameResult(ByNameDataSet value) {
        this.getDataSetByNameResult = value;
    }

    public GetDataSetByNameResponse withGetDataSetByNameResult(ByNameDataSet value) {
        setGetDataSetByNameResult(value);
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
