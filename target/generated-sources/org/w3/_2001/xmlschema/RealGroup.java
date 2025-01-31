
package org.w3._2001.xmlschema;

import java.math.BigInteger;
import java.util.Collection;
import javax.xml.namespace.QName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * <p>Java class for realGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="realGroup"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}group"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.w3.org/2001/XMLSchema}annotation" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element ref="{http://www.w3.org/2001/XMLSchema}all"/&gt;
 *           &lt;element ref="{http://www.w3.org/2001/XMLSchema}choice"/&gt;
 *           &lt;element ref="{http://www.w3.org/2001/XMLSchema}sequence"/&gt;
 *         &lt;/choice&gt;
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
@XmlType(name = "realGroup")
@XmlSeeAlso({
    NamedGroup.class,
    GroupRef.class
})
public class RealGroup
    extends Group
{


    @Override
    public RealGroup withParticle(Object... values) {
        if (values!= null) {
            for (Object value: values) {
                getParticle().add(value);
            }
        }
        return this;
    }

    @Override
    public RealGroup withParticle(Collection<Object> values) {
        if (values!= null) {
            getParticle().addAll(values);
        }
        return this;
    }

    @Override
    public RealGroup withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public RealGroup withRef(QName value) {
        setRef(value);
        return this;
    }

    @Override
    public RealGroup withMinOccurs(BigInteger value) {
        setMinOccurs(value);
        return this;
    }

    @Override
    public RealGroup withMaxOccurs(String value) {
        setMaxOccurs(value);
        return this;
    }

    @Override
    public RealGroup withAnnotation(Annotation value) {
        setAnnotation(value);
        return this;
    }

    @Override
    public RealGroup withId(String value) {
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
