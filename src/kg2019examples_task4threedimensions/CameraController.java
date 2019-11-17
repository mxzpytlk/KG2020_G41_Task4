/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task4threedimensions;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.HashSet;
import java.util.Set;
import kg2019examples_task4threedimensions.math.Matrix4Factories;
import kg2019examples_task4threedimensions.third.Camera;

/**
 *
 * @author Alexey
 */
public class CameraController implements MouseListener, MouseMotionListener, MouseWheelListener {
    
    /*=============== Начало паттерна "слушатель" ==================*/
    /* Реализация паттерна слушатель для оповещения всех желающих о каком-либо событии */
    
    /* Для начала требуется объявить интерфейс, в котором будут указаны используемы для оповещения методы.
     * В данном случае будет объявлен один метод, который будет вызываться тогда,
     * когда изменится состояние камеры и надо перерисовать экран
     */
    
    /**
     * Интерфейс, объявляющий набор метод, которые обязан реализовать слушатель
     */
    public static interface RepaintListener {
        /**
         * Метод, вызываемый при изменении
         */
        void shouldRepaint();
    }
    
    
    /* Далее описывается приватная коллекция, в данном случае - Set, 
     * где будет хрнаиться список всех слушателей, подписанных на данное событие.
     */
    private Set<RepaintListener> listeners = new HashSet<>();
    
    /**
     * Метод добавления слушателя
     * @param listener слушатель
     */
    public void addRepaintListener(RepaintListener listener) {
        listeners.add(listener);
    }
    
    /**
     * Метод удаления слушателя
     * @param listener слушатель
     */
    public void removeRepaintListener(RepaintListener listener) {
        listeners.remove(listener);
    }
    
    /**
     * Вспомогательный метод, который оповещает всех слушателей о произошедшем событии.
     */
    protected void onRepaint() {
        for (RepaintListener cl : listeners)
            cl.shouldRepaint();
    }
    
    /*=============== Конец паттерна "слушатель" ==================*/
    
    private Camera camera;

    public CameraController(Camera camera) {
        this.camera = camera;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    Point last;
    @Override
    public void mousePressed(MouseEvent e) {
        last = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        last = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point current = e.getPoint();
        if (last != null) {
            int dx = current.x - last.x;
            int dy = current.y - last.y;
            double da = dx * Math.PI / 180;
            double db = dy * Math.PI / 280;
            camera.modifyRotate(
                    Matrix4Factories.rotationXYZ(da, Matrix4Factories.Axis.Y)
                .mul(
                    Matrix4Factories.rotationXYZ(db, Matrix4Factories.Axis.X)
                )
            );
        }
        last = current;
        onRepaint(); /*Оповещаем всех, что мы изменили камеру и её надо перерисовать*/
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        
    }
    
}
