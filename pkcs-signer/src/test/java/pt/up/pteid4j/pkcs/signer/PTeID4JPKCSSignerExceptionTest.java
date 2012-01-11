package pt.up.pteid4j.pkcs.signer;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * PTeID4J PKCS Signer Exception Test Class
 * 
 * @author Andre Barbosa (andremanuelbarbosa@gmail.com)
 */
public class PTeID4JPKCSSignerExceptionTest {

  private static Logger logger = Logger.getLogger(PTeID4JPKCSSignerExceptionTest.class);

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

    logger.info("Testing PTeID4JPKCSSignerException...");
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {

    logger.info("Done Testing PTeID4JPKCSSignerException.");
  }

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testNewWithMessage() {

    logger.info("Testing PTeID4JPKCSSignerException.PTeID4JPKCSSignerException(Message)...");

    PTeID4JPKCSSignerException pteid4jPKCSSignerException = new PTeID4JPKCSSignerException("JUnit Test.");
    Assert.assertNotNull(pteid4jPKCSSignerException);
    Assert.assertEquals("JUnit Test.", pteid4jPKCSSignerException.getMessage());

    logger.info("Done Testing PTeID4JPKCSSignerException.PTeID4JPKCSSignerException(Message).");
  }

  @Test
  public void testNewWithException() {

    logger.info("Testing PTeID4JPKCSSignerException.PTeID4JPKCSSignerException(Exception)...");

    PTeID4JPKCSSignerException pteid4jPKCSSignerException = new PTeID4JPKCSSignerException(new Exception("JUnit Test."));
    Assert.assertNotNull(pteid4jPKCSSignerException);
    Assert.assertEquals("JUnit Test.", pteid4jPKCSSignerException.getMessage());

    logger.info("Done Testing PTeID4JPKCSSignerException.PTeID4JPKCSSignerException(Exception).");
  }
}
