
package org.w3._2001.xmlschema;

import java.util.Collection;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * <p>Java class for localComplexType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="localComplexType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}complexType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.w3.org/2001/XMLSchema}annotation" minOccurs="0"/&gt;
 *         &lt;group ref="{http://www.w3.org/2001/XMLSchema}complexTypeModel"/&gt;
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
@XmlType(name = "localComplexType")
public class LocalComplexType
    extends ComplexType
{


    @Override
    public LocalComplexType withSimpleContent(SimpleContent value) {
        setSimpleContent(value);
        return this;
    }

    @Override
    public LocalComplexType withComplexContent(ComplexContent value) {
        setComplexContent(value);
        return this;
    }

    @Override
    public LocalComplexType withGroup(GroupRef value) {
        setGroup(value);
        return this;
    }

    @Override
    public LocalComplexType withAll(All value) {
        setAll(value);
        return this;
    }

    @Override
    public LocalComplexType withChoice(ExplicitGroup value) {
        setChoice(value);
        return this;
    }

    @Override
    public LocalComplexType withSequence(ExplicitGroup value) {
        setSequence(value);
        return this;
    }

    @Override
    public LocalComplexType withAttributeOrAttributeGroup(Annotated... values) {
        if (values!= null) {
            for (Annotated value: values) {
                getAttributeOrAttributeGroup().add(value);
            }
        }
        return this;
    }

    @Override
    public LocalComplexType withAttributeOrAttributeGroup(Collection<Annotated> values) {
        if (values!= null) {
            getAttributeOrAttributeGroup().addAll(values);
        }
        return this;
    }

    @Override
    public LocalComplexType withAnyAttribute(Wildcard value) {
        setAnyAttribute(value);
        return this;
    }

    @Override
    public LocalComplexType withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public LocalComplexType withMixed(Boolean value) {
        setMixed(value);
        return this;
    }

    @Override
    public LocalComplexType withAbstract(Boolean value) {
        setAbstract(value);
        return this;
    }

    @Override
    public LocalComplexType withFinal(String... values) {
        if (values!= null) {
            for (String value: values) {
                getFinal().add(value);
            }
        }
        return this;
    }

    @Override
    public LocalComplexType withFinal(Collection<String> values) {
        if (values!= null) {
            getFinal().addAll(values);
        }
        return this;
    }

    @Override
    public LocalComplexType withBlock(String... values) {
        if (values!= null) {
            for (String value: values) {
                getBlock().add(value);
            }
        }
        return this;
    }

    @Override
    public LocalComplexType withBlock(Collection<String> values) {
        if (values!= null) {
            getBlock().addAll(values);
        }
        return this;
    }

    @Override
    public LocalComplexType withAnnotation(Annotation value) {
        setAnnotation(value);
        return this;
    }

    @Override
    public LocalComplexType withId(String value) {
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
