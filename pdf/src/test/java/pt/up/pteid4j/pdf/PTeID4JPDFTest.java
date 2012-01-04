package pt.up.pteid4j.pdf;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pt.up.pteid4j.PTeID4J;
import pteidlib.PteidException;

/**
 * PTeID4J PDF Test Class
 * 
 * @author Andre Barbosa (andremanuelbarbosa@gmail.com)
 */
public class PTeID4JPDFTest {

  private static Logger logger = Logger.getLogger(PTeID4JPDFTest.class);

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {

  }

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void test() throws PteidException {

    logger.info(PTeID4J.getId().name);
  }
}
