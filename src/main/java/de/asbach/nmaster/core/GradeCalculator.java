package de.asbach.nmaster.core;

import de.asbach.nmaster.model.Module;
import de.asbach.nmaster.model.Semester;
import java.util.List;

/**
 *
 * @author Benjamin Asbach <my.name at gmail.com>
 */
public class GradeCalculator {

    public static double calculateGradeBySemester(Semester s) {
        double tCreditPoints = 0;
        double tGrade = 0;

        for (Module m : s.getModules()) {
            if (m.getGrade() != 0 && m.getGrade() != 5) {
                tCreditPoints += m.getCreditPoints();
                tGrade += (m.getGrade() * m.getCreditPoints());
            }
        }

        if (tCreditPoints != 0) {
            return tGrade / tCreditPoints;
        } else {
            return 0;
        }
    }

    public static double calculateTotalGradeBySemesters(List<Semester> sList) {
        double tCreditPoints = 0;
        double tGrade = 0;

        for (Semester s : sList) {
            for (Module m : s.getModules()) {
                if (m.getGrade() != 0 && m.getGrade() != 5) {
                    tCreditPoints += m.getCreditPoints();
                    tGrade += (m.getGrade() * m.getCreditPoints());
                }
            }
        }

        if (tCreditPoints != 0) {
            return tGrade / tCreditPoints;
        } else {
            return 0;
        }
    }

    public static double percentToDouble(int percent) {
        return 0;
    }
}
