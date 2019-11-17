/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task4threedimensions.third;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kg2019examples_task4threedimensions.draw.IDrawer;
import kg2019examples_task4threedimensions.math.Vector3;

/**
 * Описывает трёхмерную со всеми объектами на ней
 * @author Alexey
 */
public class Scene {
    private List<IModel> models = new ArrayList<>();

    public List<IModel> getModelsList() {
        return models;
    }
    
    private int backgroundColor;

    public Scene(int backgroundColorRGB) {
        this.backgroundColor = backgroundColorRGB;
    }
    
    
    public void drawScene(IDrawer drawer, Camera cam) {
        List<PolyLine3D> lines = new LinkedList<>();
        for (IModel m : models) {
            for (PolyLine3D pl : m.getLines()) {
                List<Vector3> points = new LinkedList<>();
                for (Vector3 v : points) {
                    points.add(cam.w2s(v));
                }
                lines.add(new PolyLine3D(points, pl.isClosed()));
            }
        }
        drawer.clear(backgroundColor);
        drawer.draw(lines);
    }
}
