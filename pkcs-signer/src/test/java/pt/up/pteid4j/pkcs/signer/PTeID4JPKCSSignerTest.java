package pt.up.pteid4j.pkcs.signer;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pt.up.pteid4j.PTeID4JUtils;

/**
 * PTeID4J PKCS Signer Test Class
 * 
 * @author Andre Barbosa (andremanuelbarbosa@gmail.com)
 */
public class PTeID4JPKCSSignerTest {

  private static Logger logger = Logger.getLogger(PTeID4JPKCSSignerTest.class);

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

    logger.info("Testing PTeID4JPKCSSigner...");
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {

    logger.info("Done Testing PTeID4JPKCSSigner.");
  }

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testSignWithBytes() throws PTeID4JPKCSSignerException {

    logger.info("Testing PTeID4JPKCSSigner.sign(Bytes)...");

    byte[] signature = PTeID4JPKCSSigner.sign("PTeID4J".getBytes());

    String signatureHex = "DFF1DDECA2E7ABB0231B286D05F76911C0D4F3C4547F90F86CF8CCEBCB4EC855AE8FE5165B32998F729A5A170E76C14C0ECCF7D9DF75DB1A8EDC2EB4EDBD262DBAC5EAB66C44B4129CA0BD3ED5C0004840FD4EA45BB4E40CEC0307D3DB12A5C1583338FFD42271D4134EB33B2CC01A49DB35981FEFFF28A2CFC9F59607820ED9";

    Assert.assertNotNull(signature);
    Assert.assertEquals(128, signature.length);
    Assert.assertEquals(signatureHex, PTeID4JUtils.toHexString(signature));

    logger.info("Done Testing PTeID4JPKCSSigner.sign(Bytes).");
  }

  @Test
  public void testSignWithString() throws PTeID4JPKCSSignerException {

    logger.info("Testing PTeID4JPKCSSigner.sign(String)...");

    byte[] signature = PTeID4JPKCSSigner.sign("PTeID4J");

    String signatureHex = "DFF1DDECA2E7ABB0231B286D05F76911C0D4F3C4547F90F86CF8CCEBCB4EC855AE8FE5165B32998F729A5A170E76C14C0ECCF7D9DF75DB1A8EDC2EB4EDBD262DBAC5EAB66C44B4129CA0BD3ED5C0004840FD4EA45BB4E40CEC0307D3DB12A5C1583338FFD42271D4134EB33B2CC01A49DB35981FEFFF28A2CFC9F59607820ED9";

    Assert.assertNotNull(signature);
    Assert.assertEquals(128, signature.length);
    Assert.assertEquals(signatureHex, PTeID4JUtils.toHexString(signature));

    logger.info("Done Testing PTeID4JPKCSSigner.sign(String).");
  }
}
