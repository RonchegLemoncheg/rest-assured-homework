
package org.w3._2001.xmlschema;

import java.util.Collection;
import javax.xml.namespace.QName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * <p>Java class for simpleRestrictionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="simpleRestrictionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}restrictionType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.w3.org/2001/XMLSchema}annotation" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;group ref="{http://www.w3.org/2001/XMLSchema}simpleRestrictionModel"/&gt;
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
@XmlType(name = "simpleRestrictionType")
public class SimpleRestrictionType
    extends RestrictionType
{


    @Override
    public SimpleRestrictionType withGroup(GroupRef value) {
        setGroup(value);
        return this;
    }

    @Override
    public SimpleRestrictionType withAll(All value) {
        setAll(value);
        return this;
    }

    @Override
    public SimpleRestrictionType withChoice(ExplicitGroup value) {
        setChoice(value);
        return this;
    }

    @Override
    public SimpleRestrictionType withSequence(ExplicitGroup value) {
        setSequence(value);
        return this;
    }

    @Override
    public SimpleRestrictionType withSimpleType(LocalSimpleType value) {
        setSimpleType(value);
        return this;
    }

    @Override
    public SimpleRestrictionType withFacets(Object... values) {
        if (values!= null) {
            for (Object value: values) {
                getFacets().add(value);
            }
        }
        return this;
    }

    @Override
    public SimpleRestrictionType withFacets(Collection<Object> values) {
        if (values!= null) {
            getFacets().addAll(values);
        }
        return this;
    }

    @Override
    public SimpleRestrictionType withAttributeOrAttributeGroup(Annotated... values) {
        if (values!= null) {
            for (Annotated value: values) {
                getAttributeOrAttributeGroup().add(value);
            }
        }
        return this;
    }

    @Override
    public SimpleRestrictionType withAttributeOrAttributeGroup(Collection<Annotated> values) {
        if (values!= null) {
            getAttributeOrAttributeGroup().addAll(values);
        }
        return this;
    }

    @Override
    public SimpleRestrictionType withAnyAttribute(Wildcard value) {
        setAnyAttribute(value);
        return this;
    }

    @Override
    public SimpleRestrictionType withBase(QName value) {
        setBase(value);
        return this;
    }

    @Override
    public SimpleRestrictionType withAnnotation(Annotation value) {
        setAnnotation(value);
        return this;
    }

    @Override
    public SimpleRestrictionType withId(String value) {
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
