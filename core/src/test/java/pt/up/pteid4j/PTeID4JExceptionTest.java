package pt.up.pteid4j;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * PTeID4J Exception Test Class
 * 
 * @author Andre Barbosa (andremanuelbarbosa@gmail.com)
 */
public class PTeID4JExceptionTest {

  private static Logger logger = Logger.getLogger(PTeID4JExceptionTest.class);

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

    logger.info("Testing PTeID4JException...");
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {

    logger.info("Done Testing PTeID4JException.");
  }

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testNewWithMessage() {

    logger.info("Testing PTeID4JException.PTeID4JException(Message)...");

    PTeID4JException pteid4jException = new PTeID4JException("JUnit Test.");
    Assert.assertNotNull(pteid4jException);
    Assert.assertEquals("JUnit Test.", pteid4jException.getMessage());

    logger.info("Done Testing PTeID4JException.PTeID4JException(Message).");
  }

  @Test
  public void testNewWithException() {

    logger.info("Testing PTeID4JException.PTeID4JException(Exception)...");

    PTeID4JException pteid4jException = new PTeID4JException(new Exception("JUnit Test."));
    Assert.assertNotNull(pteid4jException);
    Assert.assertEquals("JUnit Test.", pteid4jException.getMessage());

    logger.info("Done Testing PTeID4JException.PTeID4JException(Exception).");
  }
}
