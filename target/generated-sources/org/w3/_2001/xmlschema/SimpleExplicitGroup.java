
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
 * <p>Java class for simpleExplicitGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="simpleExplicitGroup"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}explicitGroup"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.w3.org/2001/XMLSchema}annotation" minOccurs="0"/&gt;
 *         &lt;group ref="{http://www.w3.org/2001/XMLSchema}nestedParticle" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "simpleExplicitGroup")
public class SimpleExplicitGroup
    extends ExplicitGroup
{


    @Override
    public SimpleExplicitGroup withParticle(Object... values) {
        if (values!= null) {
            for (Object value: values) {
                getParticle().add(value);
            }
        }
        return this;
    }

    @Override
    public SimpleExplicitGroup withParticle(Collection<Object> values) {
        if (values!= null) {
            getParticle().addAll(values);
        }
        return this;
    }

    @Override
    public SimpleExplicitGroup withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public SimpleExplicitGroup withRef(QName value) {
        setRef(value);
        return this;
    }

    @Override
    public SimpleExplicitGroup withMinOccurs(BigInteger value) {
        setMinOccurs(value);
        return this;
    }

    @Override
    public SimpleExplicitGroup withMaxOccurs(String value) {
        setMaxOccurs(value);
        return this;
    }

    @Override
    public SimpleExplicitGroup withAnnotation(Annotation value) {
        setAnnotation(value);
        return this;
    }

    @Override
    public SimpleExplicitGroup withId(String value) {
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
