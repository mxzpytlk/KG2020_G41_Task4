package kg2019examples_task4threedimensions.draw;

import kg2019examples_task4threedimensions.math.Vector3;
import kg2019examples_task4threedimensions.screen.ScreenConverter;
import kg2019examples_task4threedimensions.screen.ScreenCoordinates;
import kg2019examples_task4threedimensions.screen.ScreenPoint;
import kg2019examples_task4threedimensions.third.IModel;
import kg2019examples_task4threedimensions.third.Plane;
import kg2019examples_task4threedimensions.third.PolyLine3D;

import java.awt.*;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;

public class ShadowDrawer extends ScreenGraphicsDrawer {
    private static final float EPSILON = 1e-10f;

    /**
     * Создаёт экземпляр рисвальщика
     *
     * @param sc преобразователь координат
     * @param gr графикс
     */
    public ShadowDrawer(ScreenConverter sc, Graphics2D gr) {
        super(sc, gr);
    }

    public void drawShadows(IModel model, Plane plane, Vector3 light) {
        if (plane.getA() * light.getX() + plane.getB() * light.getY() +
                plane.getC() * light.getZ() + plane.getD() <= EPSILON) {
            return;
        }
        LinkedList<PolyLine3D> lines = (LinkedList<PolyLine3D>) model.getLines();

        for (PolyLine3D line : lines) {
            LinkedList<Vector3> shadowLine = new LinkedList<>();
            for (Vector3 point : line.getPoints()) {
                
            }
        }
    }

    @Override
    protected void oneDraw(PolyLine3D polyline) {
        LinkedList<ScreenPoint> points = new LinkedList<>();
        /*переводим все точки в экранные*/
        for (Vector3 v : polyline.getPoints())
            points.add(getScreenConverter().r2s(v));
        getGraphics().setColor(Color.BLACK);
        /*если точек меньше двух, то рисуем отдельными алгоритмами*/
        if (points.size() < 2) {
            if (points.size() > 0)
                getGraphics().fillRect(points.get(0).getI(), points.get(0).getJ(), 1, 1);
            return;
        }
        /*создаём хранилище этих точек в виде двух массивов*/
        ScreenCoordinates crds = new ScreenCoordinates(points);
        /*если линия замкнута - рисем полиго, иначе - полилинию*/
        getGraphics().fillPolygon(crds.getXx(), crds.getYy(), crds.size());
    }

    @Override
    protected IFilter<PolyLine3D> getFilter() {
        return new IFilter<PolyLine3D>() {
            @Override
            public boolean permit(PolyLine3D value) {
                return true;
            }
        };
    }

    @Override
    protected Comparator<PolyLine3D> getComparator() {
        return new Comparator<PolyLine3D>() {
            @Override
            public int compare(PolyLine3D polyLine3D, PolyLine3D t1) {
                return 0;
            }
        };
    }
}
