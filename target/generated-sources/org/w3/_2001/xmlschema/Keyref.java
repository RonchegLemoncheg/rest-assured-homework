
package org.w3._2001.xmlschema;

import java.util.Collection;
import javax.xml.namespace.QName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.w3.org/2001/XMLSchema}keybase"&gt;
 *       &lt;attribute name="refer" use="required" type="{http://www.w3.org/2001/XMLSchema}QName" /&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "keyref")
public class Keyref
    extends Keybase
{

    @XmlAttribute(name = "refer", required = true)
    protected QName refer;

    /**
     * Gets the value of the refer property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getRefer() {
        return refer;
    }

    /**
     * Sets the value of the refer property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setRefer(QName value) {
        this.refer = value;
    }

    public Keyref withRefer(QName value) {
        setRefer(value);
        return this;
    }

    @Override
    public Keyref withSelector(Selector value) {
        setSelector(value);
        return this;
    }

    @Override
    public Keyref withField(Field... values) {
        if (values!= null) {
            for (Field value: values) {
                getField().add(value);
            }
        }
        return this;
    }

    @Override
    public Keyref withField(Collection<Field> values) {
        if (values!= null) {
            getField().addAll(values);
        }
        return this;
    }

    @Override
    public Keyref withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public Keyref withAnnotation(Annotation value) {
        setAnnotation(value);
        return this;
    }

    @Override
    public Keyref withId(String value) {
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
