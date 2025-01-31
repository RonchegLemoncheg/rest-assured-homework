
package org.w3._2001.xmlschema;

import java.util.Collection;
import javax.xml.namespace.QName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * <p>Java class for attributeGroupRef complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="attributeGroupRef"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}attributeGroup"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.w3.org/2001/XMLSchema}annotation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ref" use="required" type="{http://www.w3.org/2001/XMLSchema}QName" /&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "attributeGroupRef")
public class AttributeGroupRef
    extends AttributeGroup
{


    @Override
    public AttributeGroupRef withAttributeOrAttributeGroup(Annotated... values) {
        if (values!= null) {
            for (Annotated value: values) {
                getAttributeOrAttributeGroup().add(value);
            }
        }
        return this;
    }

    @Override
    public AttributeGroupRef withAttributeOrAttributeGroup(Collection<Annotated> values) {
        if (values!= null) {
            getAttributeOrAttributeGroup().addAll(values);
        }
        return this;
    }

    @Override
    public AttributeGroupRef withAnyAttribute(Wildcard value) {
        setAnyAttribute(value);
        return this;
    }

    @Override
    public AttributeGroupRef withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public AttributeGroupRef withRef(QName value) {
        setRef(value);
        return this;
    }

    @Override
    public AttributeGroupRef withAnnotation(Annotation value) {
        setAnnotation(value);
        return this;
    }

    @Override
    public AttributeGroupRef withId(String value) {
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
