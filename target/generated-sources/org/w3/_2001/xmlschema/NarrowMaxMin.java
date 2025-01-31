
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
 * restricted max/min
 * 
 * <p>Java class for narrowMaxMin complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="narrowMaxMin"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}localElement"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.w3.org/2001/XMLSchema}annotation" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="simpleType" type="{http://www.w3.org/2001/XMLSchema}localSimpleType"/&gt;
 *           &lt;element name="complexType" type="{http://www.w3.org/2001/XMLSchema}localComplexType"/&gt;
 *         &lt;/choice&gt;
 *         &lt;group ref="{http://www.w3.org/2001/XMLSchema}identityConstraint" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
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
 *             &lt;enumeration value="0"/&gt;
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
@XmlType(name = "narrowMaxMin")
public class NarrowMaxMin
    extends LocalElement
{


    @Override
    public NarrowMaxMin withSimpleType(LocalSimpleType value) {
        setSimpleType(value);
        return this;
    }

    @Override
    public NarrowMaxMin withComplexType(LocalComplexType value) {
        setComplexType(value);
        return this;
    }

    @Override
    public NarrowMaxMin withIdentityConstraint(Object... values) {
        if (values!= null) {
            for (Object value: values) {
                getIdentityConstraint().add(value);
            }
        }
        return this;
    }

    @Override
    public NarrowMaxMin withIdentityConstraint(Collection<Object> values) {
        if (values!= null) {
            getIdentityConstraint().addAll(values);
        }
        return this;
    }

    @Override
    public NarrowMaxMin withType(QName value) {
        setType(value);
        return this;
    }

    @Override
    public NarrowMaxMin withSubstitutionGroup(QName value) {
        setSubstitutionGroup(value);
        return this;
    }

    @Override
    public NarrowMaxMin withDefault(String value) {
        setDefault(value);
        return this;
    }

    @Override
    public NarrowMaxMin withFixed(String value) {
        setFixed(value);
        return this;
    }

    @Override
    public NarrowMaxMin withNillable(Boolean value) {
        setNillable(value);
        return this;
    }

    @Override
    public NarrowMaxMin withAbstract(Boolean value) {
        setAbstract(value);
        return this;
    }

    @Override
    public NarrowMaxMin withFinal(String... values) {
        if (values!= null) {
            for (String value: values) {
                getFinal().add(value);
            }
        }
        return this;
    }

    @Override
    public NarrowMaxMin withFinal(Collection<String> values) {
        if (values!= null) {
            getFinal().addAll(values);
        }
        return this;
    }

    @Override
    public NarrowMaxMin withBlock(String... values) {
        if (values!= null) {
            for (String value: values) {
                getBlock().add(value);
            }
        }
        return this;
    }

    @Override
    public NarrowMaxMin withBlock(Collection<String> values) {
        if (values!= null) {
            getBlock().addAll(values);
        }
        return this;
    }

    @Override
    public NarrowMaxMin withForm(FormChoice value) {
        setForm(value);
        return this;
    }

    @Override
    public NarrowMaxMin withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public NarrowMaxMin withRef(QName value) {
        setRef(value);
        return this;
    }

    @Override
    public NarrowMaxMin withMinOccurs(BigInteger value) {
        setMinOccurs(value);
        return this;
    }

    @Override
    public NarrowMaxMin withMaxOccurs(String value) {
        setMaxOccurs(value);
        return this;
    }

    @Override
    public NarrowMaxMin withAnnotation(Annotation value) {
        setAnnotation(value);
        return this;
    }

    @Override
    public NarrowMaxMin withId(String value) {
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
