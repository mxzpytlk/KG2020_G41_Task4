/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task4threedimensions;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Collection;
import javax.swing.JPanel;
import kg2019examples_task4threedimensions.draw.IDrawer;
import kg2019examples_task4threedimensions.draw.ShadowDrawer;
import kg2019examples_task4threedimensions.draw.SimpleEdgeDrawer;
import kg2019examples_task4threedimensions.math.Vector3;
import kg2019examples_task4threedimensions.screen.ScreenConverter;
import kg2019examples_task4threedimensions.third.*;
import models.*;

import static java.lang.Math.sqrt;

/**
 *
 * @author Alexey
 */
public class DrawPanel extends JPanel
        implements CameraController.RepaintListener {
    private final Scene scene;
    private final ScreenConverter sc;
    private final Camera cam;
    private final CameraController camController;
    private Plane plane = new Plane(15, -40, -14, -40);
    private Vector3 light = new Vector3(0, 0, -200);

    public DrawPanel() {
        super();
        sc = new ScreenConverter(-100, 100, 200, 200, 100, 100);
        cam = new Camera();
        camController = new CameraController(cam, sc);
        scene = new Scene(Color.WHITE.getRGB());
        scene.hideAxes();
        scene.getModelsList().add(new Parallelepiped(new Vector3(-50f, 50f, -50f),
                new Vector3(50f, -50f, 50f)));
        camController.addRepaintListener(this);
        addMouseListener(camController);
        addMouseMotionListener(camController);
        addMouseWheelListener(camController);
    }

    public void setTetrahedron() {
        scene.getModelsList().remove(0);
        scene.getModelsList().add(new Tetrahedron(new Vector3(0, 50, 0), (float) sqrt(15000)));
        repaint();
    }

    public void setCube() {
        scene.getModelsList().remove(0);
        scene.getModelsList().add(new Parallelepiped(new Vector3(-50f, 50f, -50f),
                new Vector3(50f, -50f, 50f)));
        repaint();
    }

    public void setOctahedron() {
        scene.getModelsList().remove(0);
        scene.getModelsList().add(new Octahedron(new Vector3(0, 0, 0), 100f));
        repaint();
    }

    public void setIcosahedron() {
        scene.getModelsList().remove(0);
        scene.getModelsList().add(new Icosahedron(new Vector3(0, 0, 0), 50f));
        repaint();
    }

    public void setDodecahedron() {
        scene.getModelsList().remove(0);
        scene.getModelsList().add(new Dodecahedron(new Vector3(0, 0, 0), 50f));
        repaint();
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
        repaint();
    }

    public void setLight(Vector3 light) {
        this.light = light;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        sc.setScreenSize(getWidth(), getHeight());
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D gr = (Graphics2D)bi.getGraphics();
        IDrawer dr = new SimpleEdgeDrawer(sc, gr);
        ShadowDrawer shadowDrawer = new ShadowDrawer(sc, gr);
        scene.drawScene(dr, cam);
        scene.drawScene(cam, plane, light, shadowDrawer);
        g.drawImage(bi, 0, 0, null);
        gr.dispose();
    }

    @Override
    public void shouldRepaint() {
        repaint();
    }
}
