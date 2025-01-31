
package org.w3._2001.xmlschema;

import javax.xml.namespace.QName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * <p>Java class for topLevelAttribute complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="topLevelAttribute"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}attribute"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.w3.org/2001/XMLSchema}annotation" minOccurs="0"/&gt;
 *         &lt;element name="simpleType" type="{http://www.w3.org/2001/XMLSchema}localSimpleType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "topLevelAttribute")
public class TopLevelAttribute
    extends Attribute
{


    @Override
    public TopLevelAttribute withSimpleType(LocalSimpleType value) {
        setSimpleType(value);
        return this;
    }

    @Override
    public TopLevelAttribute withType(QName value) {
        setType(value);
        return this;
    }

    @Override
    public TopLevelAttribute withUse(String value) {
        setUse(value);
        return this;
    }

    @Override
    public TopLevelAttribute withDefault(String value) {
        setDefault(value);
        return this;
    }

    @Override
    public TopLevelAttribute withFixed(String value) {
        setFixed(value);
        return this;
    }

    @Override
    public TopLevelAttribute withForm(FormChoice value) {
        setForm(value);
        return this;
    }

    @Override
    public TopLevelAttribute withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public TopLevelAttribute withRef(QName value) {
        setRef(value);
        return this;
    }

    @Override
    public TopLevelAttribute withAnnotation(Annotation value) {
        setAnnotation(value);
        return this;
    }

    @Override
    public TopLevelAttribute withId(String value) {
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
