package de.asbach.nmaster.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author Benjamin Asbach <my.name at gmail.com>
 */
public class Version extends Thread {
    /* singleton */

    private static Version self;
    private boolean wasPOM = false;
    private boolean wasJar = false;

    protected Version() {
    }

    public static Version getInstance() {
        if (self == null) {
            self = new Version();
        }
        return self;
    }
    /* real class */
    private String version;

    public String getVersion() throws VersionNotFoundException {
        if (version == null) {
            wasJar = false;
            wasPOM = false;

            String s;
            try {
                s = getVersionFromPom();
                wasPOM = true;
                version = s;
            } catch (Exception ex) {
                try {
                    s = getVersionFromJar();
                    wasJar = true;
                    version = s;
                } catch (Exception ex1) {
                    throw new VersionNotFoundException();
                }
            }
        }

        return version;
    }

    private String getVersionFromJar() throws IOException{
        InputStream is = null;
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream("META-INF/MANIFEST.MF");
            byte[] bBuffer = new byte[8192];
            StringBuffer sBuffer = new StringBuffer();
            int index;

            while ((index = is.read(bBuffer)) != -1) {
                sBuffer.append(new String(bBuffer, 0, index));
            }

            Pattern p = Pattern.compile("Grademasterflash-Version: (.+)");
            Matcher m = p.matcher(sBuffer);

            if (!m.find()) {
                throw new IOException("did not find version");
            } else {
                return m.group(1);
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    Logger.getLogger(Version.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private String getVersionFromPom() throws IOException, JDOMException {
        Document doc = new SAXBuilder().build(
                new File(System.getProperty("user.dir") +
                File.separator + "pom.xml"));

        Element rootElement = doc.getRootElement();

        Iterator it = rootElement.getContent().iterator();
        while (it.hasNext()) {
            Object o = it.next();
            if (o instanceof Element) {
                if (((Element) o).getName().equals("version")) {
                    return ((Element) o).getText();
                }
            }
        }

        throw new IOException();
    }
    private List<NewVersionListener> listeners = new ArrayList<NewVersionListener>();

    public void addNewVersionListener(NewVersionListener listener) {
        listeners.add(listener);
    }

    public void removeNewVersionListener(NewVersionListener listener) {
        listeners.remove(listener);
    }

    public void checkForNewVersion() {
        start();
    }

    @Override
    public void run() {
        Reader is = null;
        BufferedReader in = null;
        try {
            URL url = new URL("http://foo.bluebug.de/grademasterflash/version");
            is = new InputStreamReader(url.openStream());
            in = new BufferedReader(is);

            if (is != null && in != null) {
                String s = in.readLine();
                if (!s.equals(getVersion()) && !wasPOM && wasJar) {
                    for (NewVersionListener l : listeners) {
                        l.newVersionAvaible(s);
                    }
                }

                in.close();
            }
        } catch (VersionNotFoundException ex) {
            Logger.getLogger(Version.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Version.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Version.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
