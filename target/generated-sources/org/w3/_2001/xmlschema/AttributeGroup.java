
package org.w3._2001.xmlschema;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.namespace.QName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * <p>Java class for attributeGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="attributeGroup"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.w3.org/2001/XMLSchema}annotated"&gt;
 *       &lt;group ref="{http://www.w3.org/2001/XMLSchema}attrDecls"/&gt;
 *       &lt;attGroup ref="{http://www.w3.org/2001/XMLSchema}defRef"/&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "attributeGroup", propOrder = {
    "attributeOrAttributeGroup",
    "anyAttribute"
})
@XmlSeeAlso({
    NamedAttributeGroup.class,
    AttributeGroupRef.class
})
public abstract class AttributeGroup
    extends Annotated
{

    @XmlElements({
        @XmlElement(name = "attribute", type = Attribute.class),
        @XmlElement(name = "attributeGroup", type = AttributeGroupRef.class)
    })
    protected List<Annotated> attributeOrAttributeGroup;
    protected Wildcard anyAttribute;
    @XmlAttribute(name = "name")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String name;
    @XmlAttribute(name = "ref")
    protected QName ref;

    /**
     * Gets the value of the attributeOrAttributeGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the attributeOrAttributeGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttributeOrAttributeGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Attribute }
     * {@link AttributeGroupRef }
     * 
     * 
     */
    public List<Annotated> getAttributeOrAttributeGroup() {
        if (attributeOrAttributeGroup == null) {
            attributeOrAttributeGroup = new ArrayList<Annotated>();
        }
        return this.attributeOrAttributeGroup;
    }

    /**
     * Gets the value of the anyAttribute property.
     * 
     * @return
     *     possible object is
     *     {@link Wildcard }
     *     
     */
    public Wildcard getAnyAttribute() {
        return anyAttribute;
    }

    /**
     * Sets the value of the anyAttribute property.
     * 
     * @param value
     *     allowed object is
     *     {@link Wildcard }
     *     
     */
    public void setAnyAttribute(Wildcard value) {
        this.anyAttribute = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the ref property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getRef() {
        return ref;
    }

    /**
     * Sets the value of the ref property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setRef(QName value) {
        this.ref = value;
    }

    public AttributeGroup withAttributeOrAttributeGroup(Annotated... values) {
        if (values!= null) {
            for (Annotated value: values) {
                getAttributeOrAttributeGroup().add(value);
            }
        }
        return this;
    }

    public AttributeGroup withAttributeOrAttributeGroup(Collection<Annotated> values) {
        if (values!= null) {
            getAttributeOrAttributeGroup().addAll(values);
        }
        return this;
    }

    public AttributeGroup withAnyAttribute(Wildcard value) {
        setAnyAttribute(value);
        return this;
    }

    public AttributeGroup withName(String value) {
        setName(value);
        return this;
    }

    public AttributeGroup withRef(QName value) {
        setRef(value);
        return this;
    }

    @Override
    public AttributeGroup withAnnotation(Annotation value) {
        setAnnotation(value);
        return this;
    }

    @Override
    public AttributeGroup withId(String value) {
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
