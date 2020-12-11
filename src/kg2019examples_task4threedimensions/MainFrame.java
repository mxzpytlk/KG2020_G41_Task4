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
    private JTextField inputPlaneA;
    private JTextField inputPlaneB;
    private JTextField inputPlaneC;
    private JTextField inputPlaneD;

    public MainFrame() {
        setContentPane(contentPane);
        inputPlaneA.setText("0");
        inputPlaneB.setText("0");
        inputPlaneC.setText("-1");
        inputPlaneD.setText("300");
        lightZSpinner.setValue(-1000);
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
                dp.setPlane(new Plane(
                        Float.parseFloat(inputPlaneA.getText()),
                        Float.parseFloat(inputPlaneB.getText()),
                        Float.parseFloat(inputPlaneC.getText()),
                        Float.parseFloat(inputPlaneD.getText())
                ));
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
