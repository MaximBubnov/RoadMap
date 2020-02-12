package max.bubnov.roadmap.utils;

import max.bubnov.roadmap.domain.City;

public final class LengthUtil {

    public static double getPermissibleLength(City first, City second) {
        double x1 = first.getX();
        double y1 = first.getY();

        double x2 = second.getX();
        double y2 = second.getY();

        return Math.sqrt( Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) );
    }
}
