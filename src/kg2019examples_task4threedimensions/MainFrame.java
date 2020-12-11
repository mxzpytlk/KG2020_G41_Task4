package kg2019examples_task4threedimensions;

import kg2019examples_task4threedimensions.math.Vector3;
import kg2019examples_task4threedimensions.third.Plane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel contentPane;
    private JButton tetrahedronBtn;
    private JButton parallelepipedBtn;
    private JButton octahedronBtn;
    private JButton icosahedronBtn;
    private JButton dodecahedronBtn;
    private DrawPanel dp;
    private JSpinner planeASpinner;
    private JSpinner planeBSpinner;
    private JSpinner planeCSpinner;
    private JSpinner planeDSpinner;
    private JButton setPlaneBtn;
    private JSpinner lightXSpinner;
    private JSpinner lightYSpinner;
    private JSpinner lightZSpinner;
    private JButton setLightBtn;

    public MainFrame() {
        setContentPane(contentPane);
        planeASpinner.setValue(15);
        planeBSpinner.setValue(-40);
        planeCSpinner.setValue(-14);
        planeDSpinner.setValue(-40);
        lightZSpinner.setValue(-200);
        tetrahedronBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dp.setTetrahedron();
            }
        });
        parallelepipedBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dp.setCube();
            }
        });
        octahedronBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dp.setOctahedron();
            }
        });
        icosahedronBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dp.setIcosahedron();
            }
        });
        dodecahedronBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dp.setDodecahedron();
            }
        });
        setPlaneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dp.setPlane(new Plane(((Integer) planeASpinner.getValue()).floatValue(),
                        ((Integer) planeBSpinner.getValue()).floatValue(),
                        ((Integer) planeCSpinner.getValue()).floatValue(),
                        ((Integer) planeDSpinner.getValue()).floatValue()));
            }
        });
        setLightBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dp.setLight(new Vector3(
                        ((Integer) lightXSpinner.getValue()).floatValue(),
                        ((Integer) lightYSpinner.getValue()).floatValue(),
                        ((Integer) lightZSpinner.getValue()).floatValue()
                ));
            }
        });
    }
}
