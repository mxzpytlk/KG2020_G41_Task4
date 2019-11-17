/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task4threedimensions.math;

/**
 * Класс, хранящий методы создания особых матриц.
 * @author Alexey
 */
public final class Matrix4Factories {
    /**
     * Продублированный метод создания нулевой матрицы
     * @return нулевая матрица
     */
    public static Matrix4 zero() {
        return Matrix4.zero();
    }
    
    /**
     * Продублированный метод создания единичной матрицы
     * @return единичная матрица
     */
    public static Matrix4 one() {
        return Matrix4.one();
    }
    
    /**
     * Создаёт матрицу поворота вокруг одной из осей,
     * заданной с помощью индекса на указанный угол в радианах.
     * Индексы осей: X=0, Y=1, Z=2.
     * В случае некорректного индекса, возваращается единичная матрица.
     * !!! надо кидать в этом случае exception !!!
     * @param alpha угол поворота
     * @param axisIndex индекс оси
     * @return Матрица поворота или единичная матрица.
     */
    public static Matrix4 rotationXYZ(double alpha, int axisIndex) {
        Matrix4 m = one();
        if (axisIndex < 0 || axisIndex > 2)
            return m;
        int a1 = (axisIndex + 1) % 3;
        int a2 = (axisIndex + 2) % 3;
        
        m.setAt(a1, a1, (float)Math.cos(alpha));
        m.setAt(a1, a2, (float)Math.sin(alpha));
        m.setAt(a2, a1, -(float)Math.sin(alpha));
        m.setAt(a2, a2, (float)Math.cos(alpha));
        
        return m;
    }
    
    public static enum Axis {X, Y, Z};
    
    /**
     * Создаёт матрицу поворота вокруго одной из осей на заданный угол в радианах
     * @param alpha угол в радианах
     * @param axis название оси, вокруг которой происходит вращение
     * @return матрица поворота
     */
    public static Matrix4 rotationXYZ(double alpha, Axis axis) {
        return rotationXYZ(alpha, axis == Axis.X ? 0 : axis == Axis.Y ? 1 : 2);
    }
}
