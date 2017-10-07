package richtercloud.arquillian.data.source.in.web.xml.jar;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author richter
 */
@Local
public interface SaveController {

    void save(MyEntity myEntity);

    List<MyEntity> getAllMyEntities();
}
