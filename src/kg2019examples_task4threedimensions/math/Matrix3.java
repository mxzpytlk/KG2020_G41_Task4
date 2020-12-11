package kg2019examples_task4threedimensions.math;

public class Matrix3 {
    private final float[] matrix;
    private static final float EPSILON = 1e-10f;

    public Matrix3(float[][] m) {
        matrix = new float[9];
        for (int i = 0; i < 3; i++)
            System.arraycopy(m[i], 0, matrix, i * 3, 3);
    }

    public Vector3 solveSystem(Vector3 knownPart) throws MatrixException {
        float determinant = getDeterminant();
        if (determinant < EPSILON) {
            throw new MatrixException("Matrix determinant equals 0. Impossible to find single solution");
        }

        Matrix3 xMatrix = new Matrix3(new float[][]{{knownPart.getX(), getAt(0, 1), getAt(0, 2)},
                {knownPart.getY(), getAt(1, 1), getAt(1, 2)},
                {knownPart.getZ(), getAt(2, 1), getAt(2, 2)}});

        Matrix3 yMatrix = new Matrix3(new float[][]{{ getAt(0, 0), knownPart.getX(), getAt(0, 2)},
                {getAt(1, 0), knownPart.getY(), getAt(1, 2)},
                { getAt(2, 0), knownPart.getZ(), getAt(2, 2)}});

        Matrix3 zMatrix = new Matrix3(new float[][]{{ getAt(0, 0), getAt(0, 1) , knownPart.getX()},
                {getAt(1, 0), getAt(1, 1), knownPart.getY()},
                { getAt(2, 0), getAt(2, 1), knownPart.getZ()}});

        return new Vector3(xMatrix.getDeterminant() / determinant,
                yMatrix.getDeterminant() / determinant, zMatrix.getDeterminant() / determinant);
    }

    public float getAt(int row, int col) {
        return matrix[row * 3 + col];
    }

    public float getDeterminant() {
        return getAt(0, 0) * getAt(1, 1) * getAt(2, 2) +
                getAt(0, 1) * getAt(1, 2) * getAt(2, 0) +
                getAt(0, 2) * getAt(1, 0) * getAt(2, 1) -
                getAt(0, 0) * getAt(1, 2) * getAt(2, 1) -
                getAt(0, 1) * getAt(1, 0) * getAt(2, 2) -
                getAt(0, 2) * getAt(1, 1) * getAt(2, 0);
    }

}
