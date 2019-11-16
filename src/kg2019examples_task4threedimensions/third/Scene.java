/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task4threedimensions.third;

import java.util.ArrayList;
import java.util.List;

/**
 * Описывает трёхмерную со всеми объектами на ней
 * @author Alexey
 */
public class Scene {
    private List<IModel> models = new ArrayList<IModel>();

    public List<IModel> getModelsList() {
        return models;
    }
}
