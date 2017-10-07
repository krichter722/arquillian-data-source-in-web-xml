package richtercloud.arquillian.data.source.in.web.xml.web;

import java.io.Serializable;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import richtercloud.arquillian.data.source.in.web.xml.jar.MyEntity;
import richtercloud.arquillian.data.source.in.web.xml.jar.SaveController;

/**
 *
 * @author richter
 */
@ManagedBean
public class MyManagedBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @EJB
    private SaveController saveController;
    private final Random random = new Random();

    public String save() {
        MyEntity myEntity = new MyEntity(String.valueOf(random.nextInt()));
        saveController.save(myEntity);
        return "";
    }

    public List<MyEntity> getAllMyEntities() {
        List<MyEntity> retValue = saveController.getAllMyEntities();
        return retValue;
    }
}
