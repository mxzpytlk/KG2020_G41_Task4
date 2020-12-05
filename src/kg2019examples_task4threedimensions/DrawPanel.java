/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task4threedimensions;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import kg2019examples_task4threedimensions.draw.IDrawer;
import kg2019examples_task4threedimensions.draw.SimpleEdgeDrawer;
import kg2019examples_task4threedimensions.math.Vector3;
import kg2019examples_task4threedimensions.screen.ScreenConverter;
import kg2019examples_task4threedimensions.third.Camera;
import kg2019examples_task4threedimensions.third.Scene;
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
    
    public DrawPanel() {
        super();
        sc = new ScreenConverter(-1, 1, 2, 2, 1, 1);
        cam = new Camera();
        camController = new CameraController(cam, sc);
        scene = new Scene(Color.WHITE.getRGB());
        scene.hideAxes();
        scene.getModelsList().add(new Parallelepiped(new Vector3(-0.5f, 0.5f, -0.5f),
                new Vector3(0.5f, -0.5f, 0.5f)));
        camController.addRepaintListener(this);
        addMouseListener(camController);
        addMouseMotionListener(camController);
        addMouseWheelListener(camController);
    }

    public void setTetrahedron() {
        scene.getModelsList().remove(0);
        scene.getModelsList().add(new Tetrahedron(new Vector3(0, 1, 0), (float) sqrt(1.5)));
        repaint();
    }

    public void setCube() {
        scene.getModelsList().remove(0);
        scene.getModelsList().add(new Parallelepiped(new Vector3(-0.5f, 0.5f, -0.5f),
                new Vector3(0.5f, -0.5f, 0.5f)));
        repaint();
    }

    public void setOctahedron() {
        scene.getModelsList().remove(0);
        scene.getModelsList().add(new Octahedron(new Vector3(0, 0, 0), 1f));
        repaint();
    }

    public void setIcosahedron() {
        scene.getModelsList().remove(0);
        scene.getModelsList().add(new Icosahedron(new Vector3(0, 0, 0), 0.5f));
        repaint();
    }

    public void setDodecahedron() {
        scene.getModelsList().remove(0);
        scene.getModelsList().add(new Dodecahedron(new Vector3(0, 0, 0), 0.5f));
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        sc.setScreenSize(getWidth(), getHeight());
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D)bi.getGraphics();
        IDrawer dr = new SimpleEdgeDrawer(sc, graphics);
        scene.drawScene(dr, cam);
        g.drawImage(bi, 0, 0, null);
        graphics.dispose();
    }

    @Override
    public void shouldRepaint() {
        repaint();
    }
}
