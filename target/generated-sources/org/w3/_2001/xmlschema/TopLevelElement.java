
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
 * <p>Java class for topLevelElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="topLevelElement"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}element"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.w3.org/2001/XMLSchema}annotation" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="simpleType" type="{http://www.w3.org/2001/XMLSchema}localSimpleType"/&gt;
 *           &lt;element name="complexType" type="{http://www.w3.org/2001/XMLSchema}localComplexType"/&gt;
 *         &lt;/choice&gt;
 *         &lt;group ref="{http://www.w3.org/2001/XMLSchema}identityConstraint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "topLevelElement")
public class TopLevelElement
    extends Element
{


    @Override
    public TopLevelElement withSimpleType(LocalSimpleType value) {
        setSimpleType(value);
        return this;
    }

    @Override
    public TopLevelElement withComplexType(LocalComplexType value) {
        setComplexType(value);
        return this;
    }

    @Override
    public TopLevelElement withIdentityConstraint(Object... values) {
        if (values!= null) {
            for (Object value: values) {
                getIdentityConstraint().add(value);
            }
        }
        return this;
    }

    @Override
    public TopLevelElement withIdentityConstraint(Collection<Object> values) {
        if (values!= null) {
            getIdentityConstraint().addAll(values);
        }
        return this;
    }

    @Override
    public TopLevelElement withType(QName value) {
        setType(value);
        return this;
    }

    @Override
    public TopLevelElement withSubstitutionGroup(QName value) {
        setSubstitutionGroup(value);
        return this;
    }

    @Override
    public TopLevelElement withDefault(String value) {
        setDefault(value);
        return this;
    }

    @Override
    public TopLevelElement withFixed(String value) {
        setFixed(value);
        return this;
    }

    @Override
    public TopLevelElement withNillable(Boolean value) {
        setNillable(value);
        return this;
    }

    @Override
    public TopLevelElement withAbstract(Boolean value) {
        setAbstract(value);
        return this;
    }

    @Override
    public TopLevelElement withFinal(String... values) {
        if (values!= null) {
            for (String value: values) {
                getFinal().add(value);
            }
        }
        return this;
    }

    @Override
    public TopLevelElement withFinal(Collection<String> values) {
        if (values!= null) {
            getFinal().addAll(values);
        }
        return this;
    }

    @Override
    public TopLevelElement withBlock(String... values) {
        if (values!= null) {
            for (String value: values) {
                getBlock().add(value);
            }
        }
        return this;
    }

    @Override
    public TopLevelElement withBlock(Collection<String> values) {
        if (values!= null) {
            getBlock().addAll(values);
        }
        return this;
    }

    @Override
    public TopLevelElement withForm(FormChoice value) {
        setForm(value);
        return this;
    }

    @Override
    public TopLevelElement withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public TopLevelElement withRef(QName value) {
        setRef(value);
        return this;
    }

    @Override
    public TopLevelElement withMinOccurs(BigInteger value) {
        setMinOccurs(value);
        return this;
    }

    @Override
    public TopLevelElement withMaxOccurs(String value) {
        setMaxOccurs(value);
        return this;
    }

    @Override
    public TopLevelElement withAnnotation(Annotation value) {
        setAnnotation(value);
        return this;
    }

    @Override
    public TopLevelElement withId(String value) {
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
