package pt.up.pteid4j.pkcs;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test class for {@link pt.up.pteid4j.pkcs.PTeID4JPKCSException}
 * 
 * @author Andre Barbosa (andremanuelbarbosa@gmail.com)
 */
public class PTeID4JPKCSExceptionTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(PTeID4JPKCSExceptionTest.class);

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

    LOGGER.info("Testing PTeID4JPKCSException...");
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {

    LOGGER.info("Done Testing PTeID4JPKCSException.");
  }

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  /**
   * Test method for
   * {@link pt.up.pteid4j.pkcs.PTeID4JPKCSException#PTeID4JPKCSException(java.lang.String)}
   */
  @Test
  public void testNewWithMessage() {

    LOGGER.info("Testing PTeID4JPKCSException#PTeID4JPKCSException(java.lang.String)...");

    PTeID4JPKCSException pteid4jPKCSException = new PTeID4JPKCSException("JUnit Test.");
    Assert.assertNotNull(pteid4jPKCSException);
    Assert.assertEquals("JUnit Test.", pteid4jPKCSException.getMessage());

    LOGGER.info("Done Testing PTeID4JPKCSException#PTeID4JPKCSException(java.lang.String).");
  }

  /**
   * Test method for
   * {@link pt.up.pteid4j.pkcs.PTeID4JPKCSException#PTeID4JPKCSException(java.lang.Exception)}
   */
  @Test
  public void testNewWithException() {

    LOGGER.info("Testing PTeID4JPKCSException#PTeID4JPKCSException(java.lang.Exception)...");

    PTeID4JPKCSException pteid4jPKCSException = new PTeID4JPKCSException(new Exception(
        "JUnit Test."));
    Assert.assertNotNull(pteid4jPKCSException);
    Assert.assertEquals("JUnit Test.", pteid4jPKCSException.getMessage());

    LOGGER.info("Done Testing PTeID4JPKCSException#PTeID4JPKCSException(java.lang.Exception).");
  }
}
