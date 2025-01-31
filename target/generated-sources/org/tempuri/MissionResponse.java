
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
 *         &lt;element name="MissionResult" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "missionResult"
})
@XmlRootElement(name = "MissionResponse")
public class MissionResponse {

    @XmlElement(name = "MissionResult", required = true)
    protected String missionResult;

    /**
     * Gets the value of the missionResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMissionResult() {
        return missionResult;
    }

    /**
     * Sets the value of the missionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMissionResult(String value) {
        this.missionResult = value;
    }

    public MissionResponse withMissionResult(String value) {
        setMissionResult(value);
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
