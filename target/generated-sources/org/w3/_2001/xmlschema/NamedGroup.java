
package org.w3._2001.xmlschema;

import java.math.BigInteger;
import java.util.Collection;
import javax.xml.namespace.QName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * <p>Java class for namedGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="namedGroup"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}realGroup"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.w3.org/2001/XMLSchema}annotation" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="all"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}all"&gt;
 *                   &lt;group ref="{http://www.w3.org/2001/XMLSchema}allModel"/&gt;
 *                   &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="choice" type="{http://www.w3.org/2001/XMLSchema}simpleExplicitGroup"/&gt;
 *           &lt;element name="sequence" type="{http://www.w3.org/2001/XMLSchema}simpleExplicitGroup"/&gt;
 *         &lt;/choice&gt;
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
@XmlType(name = "namedGroup")
public class NamedGroup
    extends RealGroup
{


    @Override
    public NamedGroup withParticle(Object... values) {
        if (values!= null) {
            for (Object value: values) {
                getParticle().add(value);
            }
        }
        return this;
    }

    @Override
    public NamedGroup withParticle(Collection<Object> values) {
        if (values!= null) {
            getParticle().addAll(values);
        }
        return this;
    }

    @Override
    public NamedGroup withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public NamedGroup withRef(QName value) {
        setRef(value);
        return this;
    }

    @Override
    public NamedGroup withMinOccurs(BigInteger value) {
        setMinOccurs(value);
        return this;
    }

    @Override
    public NamedGroup withMaxOccurs(String value) {
        setMaxOccurs(value);
        return this;
    }

    @Override
    public NamedGroup withAnnotation(Annotation value) {
        setAnnotation(value);
        return this;
    }

    @Override
    public NamedGroup withId(String value) {
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
