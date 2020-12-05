package models;

import kg2019examples_task4threedimensions.math.Vector3;
import kg2019examples_task4threedimensions.third.IModel;
import kg2019examples_task4threedimensions.third.PolyLine3D;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.sqrt;

public class Octahedron implements IModel {
    private final Vector3 center;
    private final float length;

    public Octahedron(Vector3 center, float length) {
        this.center = center;
        this.length = length;
    }

    @Override
    public List<PolyLine3D> getLines() {
        LinkedList<PolyLine3D> lines = new LinkedList<>();
        /* Основание */
        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(center.getX() + length / 2, center.getY(), center.getZ() + length / 2),
                new Vector3(center.getX() + length / 2, center.getY(), center.getZ() - length / 2),
                new Vector3(center.getX() - length / 2, center.getY(), center.getZ() - length / 2),
                new Vector3(center.getX() - length / 2, center.getY(), center.getZ() + length / 2)
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(center.getX() + length / 2, center.getY(), center.getZ() + length / 2),
                new Vector3(center.getX(), center.getY() + length / (float) sqrt(2), center.getZ()),
                new Vector3(center.getX() + length / 2, center.getY(), center.getZ() - length / 2),
                new Vector3(center.getX(), center.getY() - length / (float) sqrt(2), center.getZ())
        ), true));

        lines.add(new PolyLine3D(Arrays.asList(
                new Vector3(center.getX() - length / 2, center.getY(), center.getZ() - length / 2),
                new Vector3(center.getX(), center.getY() + length / (float) sqrt(2), center.getZ()),
                new Vector3(center.getX() - length / 2, center.getY(), center.getZ() + length / 2),
                new Vector3(center.getX(), center.getY() - length / (float) sqrt(2), center.getZ())
        ), true));
        return lines;
    }
}
