/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task4threedimensions.draw;

import java.util.Collection;
import kg2019examples_task4threedimensions.third.PolyLine3D;

/**
 * Интерфейс, описывающий в общем виде процесс рисования полилинии
 * @author Alexey
 */
public interface IDrawer {
    public void clear(int color);
    public void draw(Collection<PolyLine3D> polyline);
}
