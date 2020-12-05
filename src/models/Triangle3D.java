package models;

import kg2019examples_task4threedimensions.math.Vector3;
import kg2019examples_task4threedimensions.math.Vector4;

public class Triangle3D {
    private Vector4 a;
    private Vector4 b;
    private Vector4 c;

    public Triangle3D(Vector3 a, Vector3 b, Vector3 c) {
        this.a = new Vector4(a);
        this.b = new Vector4(b);
        this.c = new Vector4(c);
    }

    public Vector3 getCentre() {
        return a.add(b).add(c).mul(0.5f).asVector3();
    }
}
