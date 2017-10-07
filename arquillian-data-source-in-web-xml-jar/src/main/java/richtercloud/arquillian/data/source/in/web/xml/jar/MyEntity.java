package richtercloud.arquillian.data.source.in.web.xml.jar;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author richter
 */
@Entity
public class MyEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    private String myProperty;

    protected MyEntity() {
    }

    public MyEntity(String myProperty) {
        this.myProperty = myProperty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMyProperty() {
        return myProperty;
    }

    public void setMyProperty(String myProperty) {
        this.myProperty = myProperty;
    }
}
