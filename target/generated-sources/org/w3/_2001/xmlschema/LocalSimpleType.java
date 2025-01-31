
package org.w3._2001.xmlschema;

import java.util.Collection;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * <p>Java class for localSimpleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="localSimpleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}simpleType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.w3.org/2001/XMLSchema}annotation" minOccurs="0"/&gt;
 *         &lt;group ref="{http://www.w3.org/2001/XMLSchema}simpleDerivation"/&gt;
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
@XmlType(name = "localSimpleType")
public class LocalSimpleType
    extends SimpleType
{


    @Override
    public LocalSimpleType withRestriction(Restriction value) {
        setRestriction(value);
        return this;
    }

    @Override
    public LocalSimpleType withList(List value) {
        setList(value);
        return this;
    }

    @Override
    public LocalSimpleType withUnion(Union value) {
        setUnion(value);
        return this;
    }

    @Override
    public LocalSimpleType withFinal(String... values) {
        if (values!= null) {
            for (String value: values) {
                getFinal().add(value);
            }
        }
        return this;
    }

    @Override
    public LocalSimpleType withFinal(Collection<String> values) {
        if (values!= null) {
            getFinal().addAll(values);
        }
        return this;
    }

    @Override
    public LocalSimpleType withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public LocalSimpleType withAnnotation(Annotation value) {
        setAnnotation(value);
        return this;
    }

    @Override
    public LocalSimpleType withId(String value) {
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
