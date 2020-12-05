package models;

import kg2019examples_task4threedimensions.math.Vector3;
import kg2019examples_task4threedimensions.third.IModel;
import kg2019examples_task4threedimensions.third.PolyLine3D;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.sqrt;

public class Tetrahedron implements IModel {
    private final Vector3 top;
    private final float length;

    public Tetrahedron(Vector3 top, float length) {
        this.top = top;
        this.length = length;
    }

    @Override
    public List<PolyLine3D> getLines() {
        LinkedList<PolyLine3D> lines = new LinkedList<>();
        /* Основание */
        lines.add(new PolyLine3D(Arrays.asList(
            new Vector3(top.getX(), top.getY() - length * (float) sqrt(3) / 2, top.getZ() + length / (float) sqrt(3)),
            new Vector3(top.getX() - length / 2, top.getY() - length * (float) sqrt(3) / 2,
                    top.getZ() - length / (2 * (float) sqrt(3))),
            new Vector3(top.getX() + length / 2, top.getY() - length * (float) sqrt(3) / 2,
                    top.getZ() - length / (2 * (float) sqrt(3)))
        ), true));


        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(top.getX(), top.getY() - length * (float) sqrt(3) / 2, top.getZ() + length / (float) sqrt(3)),
                top,
                new Vector3(top.getX() + length / 2, top.getY() - length * (float) sqrt(3) / 2,
                        top.getZ() - length / (2 * (float) sqrt(3)))
        ), false));

        lines.add(new PolyLine3D(Arrays.asList(
                top,
                new Vector3(top.getX() - length / 2, top.getY() - length * (float) sqrt(3) / 2,
                        top.getZ() - length / (2 * (float) sqrt(3)))
        ), false));
        return lines;
    }
}
