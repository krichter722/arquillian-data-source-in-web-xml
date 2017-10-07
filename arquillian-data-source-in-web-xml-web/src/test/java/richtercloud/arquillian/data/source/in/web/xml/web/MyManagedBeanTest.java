package richtercloud.arquillian.data.source.in.web.xml.web;

import java.util.List;
import java.util.stream.Stream;
import javax.ejb.EJB;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import richtercloud.arquillian.data.source.in.web.xml.ejb.DefaultSaveController;
import richtercloud.arquillian.data.source.in.web.xml.jar.MyEntity;
import richtercloud.arquillian.data.source.in.web.xml.jar.SaveController;

/**
 *
 * @author richter
 */
@RunWith(Arquillian.class)
public class MyManagedBeanTest {

    @Deployment
    public static Archive<?> createDeployment() {
        WebArchive retValue = ShrinkWrap.create(WebArchive.class)
                .addClasses(MyManagedBean.class, SaveController.class, DefaultSaveController.class)
                .setWebXML("web.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        Stream.of(Maven.resolver().loadPomFromFile("pom.xml").importRuntimeDependencies().resolve().withTransitivity().as(JavaArchive.class)).forEach(archive -> retValue.addAsLibrary(archive));
        return retValue;
    }

    @EJB
    private SaveController saveController;

    /**
     * Test of save method, of class MyManagedBean.
     */
    @Test
    public void testInject() {
        assertNotNull(saveController);
        MyEntity myEntity = new MyEntity("abcdef");
        saveController.save(myEntity);
        List<MyEntity> allEntities = saveController.getAllMyEntities();
        assertNotNull(allEntities);
        assertFalse(allEntities.isEmpty());
    }
}
