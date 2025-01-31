
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
 * 
 *    Only elements allowed inside
 * 
 * <p>Java class for all complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="all"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}explicitGroup"&gt;
 *       &lt;group ref="{http://www.w3.org/2001/XMLSchema}allModel"/&gt;
 *       &lt;attribute name="minOccurs" default="1"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
 *             &lt;enumeration value="0"/&gt;
 *             &lt;enumeration value="1"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="maxOccurs" default="1"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}allNNI"&gt;
 *             &lt;enumeration value="1"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "all")
public class All
    extends ExplicitGroup
{


    @Override
    public All withParticle(Object... values) {
        if (values!= null) {
            for (Object value: values) {
                getParticle().add(value);
            }
        }
        return this;
    }

    @Override
    public All withParticle(Collection<Object> values) {
        if (values!= null) {
            getParticle().addAll(values);
        }
        return this;
    }

    @Override
    public All withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public All withRef(QName value) {
        setRef(value);
        return this;
    }

    @Override
    public All withMinOccurs(BigInteger value) {
        setMinOccurs(value);
        return this;
    }

    @Override
    public All withMaxOccurs(String value) {
        setMaxOccurs(value);
        return this;
    }

    @Override
    public All withAnnotation(Annotation value) {
        setAnnotation(value);
        return this;
    }

    @Override
    public All withId(String value) {
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
