package com.umg;

import com.sun.org.apache.regexp.internal.RE;

import javax.swing.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JTextField nombreRestTXT;
    private JTextField direccionRestTXT;
    private JTextField cantempRestTXT;
    private JTextField cantcomRestTXT;
    private JCheckBox aceptaninosCheck;
    private JSlider catSlider;
    private JLabel catLBL;
    private JButton agregarRestauranteButton;
    private JButton buttonOK;

    Restaurante restaurantes = new Restaurante();

    public MainForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        catLBL.setText(Integer.toString(catSlider.getValue()));

        catSlider.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);

                catLBL.setText(Integer.toString(catSlider.getValue()));
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                super.mousePressed(mouseEvent);

                catLBL.setText(Integer.toString(catSlider.getValue()));
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                super.mouseReleased(mouseEvent);

                catLBL.setText(Integer.toString(catSlider.getValue()));
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
                super.mouseWheelMoved(mouseWheelEvent);

                catLBL.setText(Integer.toString(catSlider.getValue()));
            }

            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                super.mouseDragged(mouseEvent);

                catLBL.setText(Integer.toString(catSlider.getValue()));
            }
        });
        agregarRestauranteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                restaurantes.setNombre(nombreRestTXT.getText());
                nombreRestTXT.setText("");

                restaurantes.setDireccion(direccionRestTXT.getText());
                direccionRestTXT.setText("");

                restaurantes.setCantEmpleados(Integer.parseInt(cantempRestTXT.getText()));
                cantempRestTXT.setText("");

                restaurantes.setCantMaxComenzales(Integer.parseInt(cantcomRestTXT.getText()));
                cantcomRestTXT.setText("");

                restaurantes.setAceptaNinos(aceptaninosCheck.isSelected());
                aceptaninosCheck.setSelected(false);

                restaurantes.setCategoria(catSlider.getValue());
                catSlider.setValue(1);

                System.out.println(restaurantes.getNombre()+" "+
                                              restaurantes.getDireccion()+" "+
                        Integer.toString(restaurantes.getCantEmpleados())+" "+
                                Integer.toString(restaurantes.getCantMaxComenzales())+" "+
                                              Boolean.toString(restaurantes.isAceptaNinos())+" "+
                                              Integer.toString(restaurantes.getCategoria()));

                System.out.println(Float.toString(Impuesto(restaurantes)));
            }
        });
    }

    public float Impuesto(Restaurante tmpR) {
        if(tmpR.isAceptaNinos())
            return (tmpR.getCantMaxComenzales()*tmpR.getCategoria())/3;
        else
            return (tmpR.getCantMaxComenzales()*tmpR.getCategoria());
    }

    public static void main(String[] args) {
        MainForm dialog = new MainForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
