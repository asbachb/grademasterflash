package de.asbach.nmaster.core;

import de.asbach.nmaster.model.Module;
import de.asbach.nmaster.model.Semester;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author Benjamin Asbach <my.name at gmail.com>
 */
public class SemesterLoader {
    /*private File defaultFile = new File(System.getProperty("user.dir") + 
    File.separator + ".grademasterflash" +
    File.separator + "last.obj");
     */

    public static List<Semester> load(File f) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        List<Semester> semesterList = (List<Semester>) ois.readObject();

        if (semesterList != null) {
            return semesterList;
        } else {
            return new ArrayList<Semester>();
        }
    }

    public static void save(File f, List<Semester> semesterList) throws IOException {
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdir();
        }

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        oos.writeObject(semesterList);
        oos.flush();
        oos.close();
    }

    public static void saveAsTemplate(File f, List<Semester> list) throws JDOMException, IOException {
        XMLOutputter xmlout = new XMLOutputter(Format.getPrettyFormat());
        Namespace xmlns = Namespace.getNamespace("http://foo.bluebug.de/grademasterflash/template");

        Element rootElement = new Element("template", xmlns);

        Namespace xsi = Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        rootElement.addNamespaceDeclaration(xsi);

        Attribute attSchema = new Attribute("schemaLocation",
                "http://foo.bluebug.de/grademasterflash/template" +
                " http://foo.bluebug.de/grademasterflash/template.xsd",
                xsi);
        rootElement.setAttribute(attSchema);

        for (Semester s : list) {
            Element semester = new Element("semester", xmlns);
            semester.setAttribute("name", s.getSemesterAlias());

            for (Module m : s.getModules()) {
                Element module = new Element("module", xmlns);
                Element moduleID = new Element("moduleID", xmlns);
                moduleID.setText(m.getModulNumber());
                Element name = new Element("name", xmlns);
                name.setText(m.getModuleName());
                Element creditPoints = new Element("creditPoints", xmlns);
                creditPoints.setText(String.valueOf(m.getCreditPoints()));

                module.addContent(moduleID);
                module.addContent(name);
                module.addContent(creditPoints);

                semester.addContent(module);
            }

            rootElement.addContent(semester);
        }

        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(f.getAbsolutePath()), "UTF-8");
        out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
        xmlout.output(rootElement, out);
        out.close();
    }

    public static List<Semester> loadTemplate(File f) throws JDOMException, IOException {
        List<Semester> list = new ArrayList<Semester>();

        Namespace xmlns = Namespace.getNamespace("http://foo.bluebug.de/grademasterflash/template");
        Document doc = new SAXBuilder().build(f);
        Element rootElement = doc.getRootElement();

        Iterator it = rootElement.getChildren("semester", xmlns).iterator();
        while (it.hasNext()) {
            Element e = (Element) it.next();
            Semester s = new Semester(e.getAttributeValue("name"));

            Iterator it2 = e.getChildren("module", xmlns).iterator();
            while (it2.hasNext()) {
                Element e2 = (Element) it2.next();
                Module m = new Module(e2.getChildText("name", xmlns), e2.getChildText("moduleID", xmlns), Integer.parseInt(e2.getChildText("creditPoints", xmlns)));

                s.addModule(m);
            }

            list.add(s);
        }

        return list;
    }
}
