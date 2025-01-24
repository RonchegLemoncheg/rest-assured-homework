package ge.tbc.testautomation.data.models.PetStore;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@XmlRootElement(name = "Pet")
public class Pet {
    private int id;
    private String name;
    private String status;

    @XmlElement
    public int getId() {
        return id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    @XmlElement
    public String getStatus() {
        return status;
    }

}

