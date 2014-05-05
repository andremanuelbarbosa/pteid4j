package pt.up.pteid4j;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pteidlib.PTEID_ADDR;
import pteidlib.PTEID_ID;
import pteidlib.PteidException;

/**
 * PTeID4J Test Class
 * 
 * @author Andre Barbosa (andremanuelbarbosa@gmail.com)
 */
public class PTeID4JTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(PTeID4J.class);

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

    LOGGER.info("Testing PTeID4J...");
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {

    LOGGER.info("Done Testing PTeID4J.");
  }

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testAddress() throws PteidException {

    LOGGER.info("Testing PTeID4J.getAddress()...");

    PTEID_ADDR address = PTeID4J.getAddress();

    Assert.assertNotNull(address);
    Assert.assertNotNull(address.addrType);

    LOGGER.info("Done Testing PTeID4J.getAddress().");
  }

  @Test
  public void testId() throws PteidException {

    LOGGER.info("Testing PTeID4J.getId()...");

    PTEID_ID id = PTeID4J.getId();

    Assert.assertNotNull(id);
    Assert.assertNotNull(id.name);

    LOGGER.info("Done Testing PTeID4J.getId().");
  }
}
