/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task4threedimensions.draw;

import java.awt.Graphics2D;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import kg2019examples_task4threedimensions.math.Vector3;
import kg2019examples_task4threedimensions.screen.ScreenConverter;
import kg2019examples_task4threedimensions.screen.ScreenCoordinates;
import kg2019examples_task4threedimensions.screen.ScreenPoint;
import kg2019examples_task4threedimensions.third.PolyLine3D;

/**
 * Реализация рисователя полигонов с помощью рёбер.
 * @author Alexey
 */
public class SimpleEdgeDrawer extends ScreenGraphicsDrawer {

    public SimpleEdgeDrawer(ScreenConverter sc, Graphics2D g) {
        super(sc, g);
    }
    
    @Override
    protected void oneDraw(PolyLine3D polyline) {
        LinkedList<ScreenPoint> points = new LinkedList<>();
        for (Vector3 v : polyline.getPoints())
            points.add(getScreenConverter().r2s(v));
        ScreenCoordinates crds = new ScreenCoordinates(points);
        if (polyline.isClosed())
            getGraphics().drawPolygon(crds.getXx(), crds.getYy(), crds.size());
        else
            getGraphics().drawPolyline(crds.getXx(), crds.getYy(), crds.size());
    }

    @Override
    protected IFilter<PolyLine3D> getFilter() {
        return new IFilter<PolyLine3D>() {
            @Override
            public boolean permit(PolyLine3D line) {
                return true;
            }
        };
    }

    @Override
    protected Comparator<PolyLine3D> getComparator() {
        return new Comparator<PolyLine3D>() {
            private static final float EPSILON = 1e-10f;
            @Override
            public int compare(PolyLine3D o1, PolyLine3D o2) {
                float d = o1.avgZ() - o2.avgZ();
                if (-EPSILON < d && d < EPSILON)
                    return 0;
                return d < 0 ? -1 : 1;
            }
        };
    }
    
}
