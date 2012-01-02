package pt.up.pteid4j.pkcs11;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import sun.security.pkcs11.wrapper.PKCS11Exception;

/**
 * PTeID4J PKCS#11 Test Class
 * 
 * @author Andre Barbosa (andremanuelbarbosa@gmail.com)
 */
public class PTeID4JPKCS11Test {

  private static Logger logger = Logger.getLogger(PTeID4JPKCS11Test.class);

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

    logger.info("Testing PTeID4JPKCS11...");
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {

    logger.info("Done Testing PTeID4JPKCS11.");
  }

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testInit() throws IOException, PKCS11Exception {

    logger.info("Testing PTeID4JPKCS11.init()...");

    PTeID4JPKCS11 pteid4jPKCS11 = new PTeID4JPKCS11();
    Assert.assertNotNull(pteid4jPKCS11);
    Assert.assertNotNull(pteid4jPKCS11.getPKCS11());

    logger.info("Done Testing PTeID4JPKCS11.init().");
  }
}
