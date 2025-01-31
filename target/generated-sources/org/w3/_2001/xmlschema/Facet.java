
package org.w3._2001.xmlschema;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * <p>Java class for facet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="facet"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.w3.org/2001/XMLSchema}annotated"&gt;
 *       &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="fixed" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "facet")
@XmlSeeAlso({
    NoFixedFacet.class,
    WhiteSpace.class,
    NumFacet.class
})
public class Facet
    extends Annotated
{

    @XmlAttribute(name = "value", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String value;
    @XmlAttribute(name = "fixed")
    protected Boolean fixed;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the fixed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isFixed() {
        if (fixed == null) {
            return false;
        } else {
            return fixed;
        }
    }

    /**
     * Sets the value of the fixed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFixed(Boolean value) {
        this.fixed = value;
    }

    public Facet withValue(String value) {
        setValue(value);
        return this;
    }

    public Facet withFixed(Boolean value) {
        setFixed(value);
        return this;
    }

    @Override
    public Facet withAnnotation(Annotation value) {
        setAnnotation(value);
        return this;
    }

    @Override
    public Facet withId(String value) {
        setId(value);
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
