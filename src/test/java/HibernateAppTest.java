import DAO.ActorDAO;
import io.hypersistence.optimizer.HypersistenceOptimizer;
import io.hypersistence.optimizer.core.config.JpaConfig;
import io.hypersistence.optimizer.core.event.ListEventHandler;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class HibernateAppTest {


    private ActorDAO actorDAO;
    protected final Logger LOGGER = LoggerFactory.getLogger(HypersistenceOptimizer.class);
    private final ListEventHandler listEventHandler = new ListEventHandler();

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    public void init() {
        new HypersistenceOptimizer(
                new JpaConfig(entityManagerFactory)).init();
    }

    @Test
    public void test_if_i_can_fetch_an_actor() {

        actorDAO = new ActorDAO();

        assertEquals("BETTE", actorDAO.find(6).getFirst_name());
    }
}
