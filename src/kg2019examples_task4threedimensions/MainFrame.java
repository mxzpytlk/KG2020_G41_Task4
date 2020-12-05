package kg2019examples_task4threedimensions;

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

    public MainFrame() {
        setContentPane(contentPane);
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
    }
}
