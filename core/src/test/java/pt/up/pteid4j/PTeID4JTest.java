package pt.up.pteid4j;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pteidlib.PteidException;

/**
 * PTeID4J Test Class
 * 
 * @author Andre Barbosa (andremanuelbarbosa@gmail.com)
 */
public class PTeID4JTest {

  private static Logger logger = Logger.getLogger(PTeID4J.class);

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

    logger.info("Testing PTeID4J...");
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {

    logger.info("Done Testing PTeID4J.");
  }

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testGetAddress() throws PteidException {

    logger.info("Testing PTeID4J.getAddress()...");

    PTeID4J.getAddress();

    logger.info("Done Testing PTeID4J.getAddress().");
  }
}
