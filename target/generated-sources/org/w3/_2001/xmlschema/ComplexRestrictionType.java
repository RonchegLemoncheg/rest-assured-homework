
package org.w3._2001.xmlschema;

import java.util.Collection;
import javax.xml.namespace.QName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * <p>Java class for complexRestrictionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="complexRestrictionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}restrictionType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.w3.org/2001/XMLSchema}annotation" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;group ref="{http://www.w3.org/2001/XMLSchema}typeDefParticle"/&gt;
 *         &lt;/choice&gt;
 *         &lt;group ref="{http://www.w3.org/2001/XMLSchema}attrDecls"/&gt;
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
@XmlType(name = "complexRestrictionType")
public class ComplexRestrictionType
    extends RestrictionType
{


    @Override
    public ComplexRestrictionType withGroup(GroupRef value) {
        setGroup(value);
        return this;
    }

    @Override
    public ComplexRestrictionType withAll(All value) {
        setAll(value);
        return this;
    }

    @Override
    public ComplexRestrictionType withChoice(ExplicitGroup value) {
        setChoice(value);
        return this;
    }

    @Override
    public ComplexRestrictionType withSequence(ExplicitGroup value) {
        setSequence(value);
        return this;
    }

    @Override
    public ComplexRestrictionType withSimpleType(LocalSimpleType value) {
        setSimpleType(value);
        return this;
    }

    @Override
    public ComplexRestrictionType withFacets(Object... values) {
        if (values!= null) {
            for (Object value: values) {
                getFacets().add(value);
            }
        }
        return this;
    }

    @Override
    public ComplexRestrictionType withFacets(Collection<Object> values) {
        if (values!= null) {
            getFacets().addAll(values);
        }
        return this;
    }

    @Override
    public ComplexRestrictionType withAttributeOrAttributeGroup(Annotated... values) {
        if (values!= null) {
            for (Annotated value: values) {
                getAttributeOrAttributeGroup().add(value);
            }
        }
        return this;
    }

    @Override
    public ComplexRestrictionType withAttributeOrAttributeGroup(Collection<Annotated> values) {
        if (values!= null) {
            getAttributeOrAttributeGroup().addAll(values);
        }
        return this;
    }

    @Override
    public ComplexRestrictionType withAnyAttribute(Wildcard value) {
        setAnyAttribute(value);
        return this;
    }

    @Override
    public ComplexRestrictionType withBase(QName value) {
        setBase(value);
        return this;
    }

    @Override
    public ComplexRestrictionType withAnnotation(Annotation value) {
        setAnnotation(value);
        return this;
    }

    @Override
    public ComplexRestrictionType withId(String value) {
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
