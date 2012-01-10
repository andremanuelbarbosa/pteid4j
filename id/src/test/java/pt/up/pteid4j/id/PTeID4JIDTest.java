package pt.up.pteid4j.id;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pteidlib.PteidException;

/**
 * PTeID4J ID Test Class
 * 
 * @author Andre Barbosa (andremanuelbarbosa@gmail.com)
 */
public class PTeID4JIDTest {

  private static Logger logger = Logger.getLogger(PTeID4JIDTest.class);

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

    logger.info("Testing PTeID4JIDTest...");

    PTeID4JID.init();
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {

    PTeID4JID.terminate();

    logger.info("Done Testing PTeID4JIDTest.");
  }

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void getSurname() throws PteidException {

    logger.info("Testing PTeID4JIDTest.getSurname()...");

    Assert.assertNotNull(PTeID4JID.getSurname());

    logger.info("Done Testing PTeID4JIDTest.getSurname().");
  }

  @Test
  public void getForename() throws PteidException {

    logger.info("Testing PTeID4JIDTest.getForename()...");

    Assert.assertNotNull(PTeID4JID.getForename());

    logger.info("Done Testing PTeID4JIDTest.getForename().");
  }
}
