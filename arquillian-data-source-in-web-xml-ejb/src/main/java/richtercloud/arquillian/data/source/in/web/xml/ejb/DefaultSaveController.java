package richtercloud.arquillian.data.source.in.web.xml.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import richtercloud.arquillian.data.source.in.web.xml.jar.MyEntity;
import richtercloud.arquillian.data.source.in.web.xml.jar.SaveController;

/**
 *
 * @author richter
 */
@Stateless
public class DefaultSaveController implements SaveController {
    @PersistenceContext(unitName = "richtercloud_project1-ifaces_jar_1.0-SNAPSHOTPU")
    private EntityManager entityManager;

    public DefaultSaveController() {
    }

    @Override
    public void save(MyEntity myEntity) {
        entityManager.persist(myEntity);
    }

    @Override
    public List<MyEntity> getAllMyEntities() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<MyEntity> cq = cb.createQuery(MyEntity.class);
        Root<MyEntity> qr = cq.from(MyEntity.class);
        cq.select(qr);
        TypedQuery<MyEntity> tq = entityManager.createQuery(cq);
        List<MyEntity> retValue = tq.getResultList();
        return retValue;
    }
}
