package pt.up.pteid4j;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PTeID4J Utilities Test Class
 * 
 * @author Andre Barbosa (andremanuelbarbosa@gmail.com)
 */
public class PTeID4JUtilsTest {

  private static Logger LOGGER = LoggerFactory.getLogger(PTeID4JUtilsTest.class);

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

    LOGGER.info("Testing PTeID4JUtils...");
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {

    LOGGER.info("Done Testing PTeID4JUtils.");
  }

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testToHexString() {

    LOGGER.info("Testing PTeID4JUtils.toHexString()...");

    Assert.assertEquals("5054654944344A", PTeID4JUtils.toHexString("PTeID4J".getBytes()));
    Assert.assertEquals("506F72747567616C", PTeID4JUtils.toHexString("Portugal".getBytes()));

    LOGGER.info("Done Testing PTeID4JUtils.toHexString().");
  }
}
