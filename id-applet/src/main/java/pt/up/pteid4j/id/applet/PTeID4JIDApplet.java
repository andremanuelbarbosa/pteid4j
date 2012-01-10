package pt.up.pteid4j.id.applet;

import java.awt.Graphics;
import java.lang.reflect.Constructor;
import java.security.Permission;

import javax.swing.JApplet;

import pt.up.pteid4j.id.PTeID4JID;
import pteidlib.PteidException;

/**
 * PTeID4J ID Applet Class
 * 
 * @author Andre Barbosa (andremanuelbarbosa@gmail.com)
 */
public class PTeID4JIDApplet extends JApplet {

  private static final long serialVersionUID = -6042565559792013278L;

  public String getName() {

    try {

      return PTeID4JID.getForename() + " " + PTeID4JID.getSurname();

    } catch (PteidException e) {

      e.printStackTrace();

      return null;
    }
  }

  @Override
  public void start() {

    SecurityManager securityManager = System.getSecurityManager();

    if ( securityManager != null ) {

      try {

        Object securityContext = securityManager.getSecurityContext();

        Class<?> cardPermissionClass = Class.forName("javax.smartcardio.CardPermission");
        Constructor<?> cardPermissionConstructor = cardPermissionClass.getConstructor(String.class, String.class);
        Permission permission = (Permission) cardPermissionConstructor.newInstance("*", "*");
        securityManager.checkPermission(permission, securityContext);

        PTeID4JID.init();

      } catch (Exception e) {

        e.printStackTrace();
      }
    }
  }

  @Override
  public void paint(Graphics graphics) {

  }

  @Override
  public void stop() {

    try {

      PTeID4JID.terminate();

    } catch (PteidException e) {

      e.printStackTrace();
    }
  }
}
