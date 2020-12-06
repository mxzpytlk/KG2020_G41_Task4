package models;

import kg2019examples_task4threedimensions.math.Vector3;
import kg2019examples_task4threedimensions.third.IModel;
import kg2019examples_task4threedimensions.third.PolyLine3D;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.sqrt;

public class Icosahedron implements IModel {
    private final Vector3 center;
    private final float radius;

    public Icosahedron(Vector3 center, float radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public List<PolyLine3D> getLines() {
        LinkedList<PolyLine3D> lines = new LinkedList<>();
        /**
         * Отступ от центра икосаэдра.
         * Для того, чтобы нарисовать икосаэдр нужно воспользоваться алгоритмом описанным по этой ссылке:
         * https://www.kakprosto.ru/kak-27767-kak-sdelat-pravilnyy-ikosaedr.
         * Следоватльно отуп равен половине стороны.
         * Внешни йрадиус икосаэдра находитя по формуле a / 4 * sqrt(2(5 + sqrt5))),
         * выражаем сторону через радиус и получаем отступ.
         */
        float indent = 2 * radius / ( (float) sqrt(10 - 2 * sqrt(5)));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(center.getX(), center.getY() + indent, center.getZ() + radius),
                new Vector3(center.getX() - indent, center.getY() + radius, center.getZ() ),
                new Vector3(center.getX() + indent, center.getY() + radius, center.getZ() )
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(center.getX(), center.getY() + indent, center.getZ() + radius),
                new Vector3(center.getX() - indent, center.getY() + radius, center.getZ() ),
                new Vector3(center.getX() - radius, center.getY(), center.getZ() + indent )
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(center.getX(), center.getY() + indent, center.getZ() + radius),
                new Vector3(center.getX() + indent, center.getY() + radius, center.getZ() ),
                new Vector3(center.getX() + radius, center.getY(), center.getZ() + indent )
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(center.getX(), center.getY() - indent, center.getZ() + radius),
                new Vector3(center.getX() - indent, center.getY() - radius, center.getZ() ),
                new Vector3(center.getX() - radius, center.getY(), center.getZ() + indent )
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(center.getX(), center.getY() - indent, center.getZ() + radius),
                new Vector3(center.getX() + indent, center.getY() - radius, center.getZ() ),
                new Vector3(center.getX() + radius, center.getY(), center.getZ() + indent )
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(center.getX(), center.getY() + indent, center.getZ() - radius),
                new Vector3(center.getX() - indent, center.getY() + radius, center.getZ() ),
                new Vector3(center.getX() - radius, center.getY(), center.getZ() - indent )
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(center.getX(), center.getY() + indent, center.getZ() - radius),
                new Vector3(center.getX() + indent, center.getY() + radius, center.getZ() ),
                new Vector3(center.getX() + radius, center.getY(), center.getZ() - indent )
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(center.getX(), center.getY() - indent, center.getZ() - radius),
                new Vector3(center.getX() - indent, center.getY() - radius, center.getZ() ),
                new Vector3(center.getX() - radius, center.getY(), center.getZ() - indent )
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(center.getX(), center.getY() - indent, center.getZ() - radius),
                new Vector3(center.getX() + indent, center.getY() - radius, center.getZ() ),
                new Vector3(center.getX() + radius, center.getY(), center.getZ() - indent )
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(center.getX(), center.getY() + indent, center.getZ() + radius),
                new Vector3(center.getX(), center.getY() - indent, center.getZ() + radius),
                new Vector3(center.getX() + radius, center.getY(), center.getZ()  + indent)
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(center.getX(), center.getY() - indent, center.getZ() + radius),
                new Vector3(center.getX() - radius, center.getY(), center.getZ()  + indent),
                new Vector3(center.getX(), center.getY() + indent, center.getZ() + radius)
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(center.getX(), center.getY() - indent, center.getZ() + radius),
                new Vector3(center.getX() - indent, center.getY() - radius, center.getZ() ),
                new Vector3(center.getX() + indent, center.getY() - radius, center.getZ() )
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(center.getX() - indent, center.getY() + radius, center.getZ() ),
                new Vector3(center.getX(), center.getY() + indent, center.getZ() - radius),
                new Vector3(center.getX() + indent, center.getY() + radius, center.getZ() )
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(center.getX() - indent, center.getY() - radius, center.getZ() ),
                new Vector3(center.getX(), center.getY() - indent, center.getZ() - radius),
                new Vector3(center.getX() + indent, center.getY() - radius, center.getZ() )
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(center.getX(), center.getY() + indent, center.getZ() - radius),
                new Vector3(center.getX(), center.getY() - indent, center.getZ() - radius),
                new Vector3(center.getX() + radius, center.getY(), center.getZ()  - indent)
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(center.getX(), center.getY() - indent, center.getZ() - radius),
                new Vector3(center.getX() - radius, center.getY(), center.getZ()  - indent),
                new Vector3(center.getX(), center.getY() + indent, center.getZ() - radius)
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(center.getX() + radius, center.getY(), center.getZ() + indent),
                new Vector3(center.getX() + radius, center.getY(), center.getZ()  - indent),
                new Vector3(center.getX() + indent, center.getY() + radius, center.getZ())
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(center.getX() - radius, center.getY(), center.getZ() + indent),
                new Vector3(center.getX() - radius, center.getY(), center.getZ()  - indent),
                new Vector3(center.getX() - indent, center.getY() + radius, center.getZ())
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(center.getX() + radius, center.getY(), center.getZ() + indent),
                new Vector3(center.getX() + indent, center.getY() - radius, center.getZ()),
                new Vector3(center.getX() + radius, center.getY(), center.getZ()  - indent)
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(center.getX() - radius, center.getY(), center.getZ() + indent),
                new Vector3(center.getX() - indent, center.getY() - radius, center.getZ()),
                new Vector3(center.getX() - radius, center.getY(), center.getZ()  - indent)
        ), true));

        return lines;
    }
}
