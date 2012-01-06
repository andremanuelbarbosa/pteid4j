package pt.up.pteid4j.pdf;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

import pt.up.pteid4j.PTeID4J;
import pt.up.pteid4j.PTeID4JUtils;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfPKCS7;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfString;

/**
 * PTeID4J PDF Class
 * 
 * @author Andre Barbosa (andremanuelbarbosa@gmail.com)
 */
public final class PTeID4JPDF {

  public PTeID4JPDF() throws Exception {

    CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");

    Certificate[] certificates = new Certificate[4];
    
    certificates[3] = certificateFactory.generateCertificate(new FileInputStream(
        "src/main/resources/certificates/ECRaizEstado.crt"));
    certificates[2] = certificateFactory.generateCertificate(new FileInputStream(
        "src/main/resources/certificates/Cartao de Cidadao 001.cer"));
    certificates[1] = certificateFactory
        .generateCertificate(PTeID4JUtils.toInputStream(PTeID4J.getSignatureCertificateCA().certif));
    certificates[0] = certificateFactory.generateCertificate(PTeID4JUtils.toInputStream(PTeID4J.getSignatureCertificate().certif));

    PdfReader pdfReader = new PdfReader("src/test/resources/pdf/PTeID4J.pdf");
    FileOutputStream fout = new FileOutputStream("signed.pdf");
    PdfStamper stp = PdfStamper.createSignature(pdfReader, fout, '\0');

    PdfSignatureAppearance sap = stp.getSignatureAppearance();
    sap.setCrypto(null, certificates, null, PdfSignatureAppearance.SELF_SIGNED);
    sap.setReason("I'm the author");
    sap.setLocation("Lisbon");
    sap.setVisibleSignature(new Rectangle(100, 100, 200, 200), 1, null);
    sap.setExternalDigest(new byte[128], null, "RSA");
    sap.preClose();
    
    PdfPKCS7 sig = sap.getSigStandard().getSigner();

    byte[] content = PTeID4JUtils.toByteArray(sap.getRangeStream());
    byte[] signatureBytes = PTeID4J.sign(content);

    sig.setExternalDigest(signatureBytes, null, "RSA");
    PdfDictionary dic = new PdfDictionary();
    dic.put(PdfName.CONTENTS, new PdfString(sig.getEncodedPKCS1()).setHexWriting(true));
    sap.close(dic);
  }

  /**
   * @param args
   * @throws Exception
   * @throws KeyStoreException
   */
  public static void main(String[] args) throws Exception {

    new PTeID4JPDF();
  }
}
