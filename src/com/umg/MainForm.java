package com.umg;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

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
    private JPanel JPanel;
    private JPanel cPanel;
    private JTextField nombreComTXT;
    private JTextField apellidosComTXT;
    private JTextField visitasComTXT;
    private JButton agregarComensalButton;
    private JTable comTBL;
    private JPanel rPanel;
    private JPanel drPanel;
    private JLabel nrLBL;
    private JLabel drLBL;
    private JLabel ceLBL;
    private JLabel ccLBL;
    private JLabel anLBL;
    private JLabel cLBL;
    private JLabel iLBL;
    private JLabel cVIP;
    private JButton salirButton;
    private DefaultTableModel cTModel = new DefaultTableModel();

    Restaurante restaurantes = new Restaurante();

    public MainForm() {
        setContentPane(contentPane);
        setModal(true);

        cPanel.setVisible(false);
        drPanel.setVisible(false);

        cTModel.addColumn("Nombre");
        cTModel.addColumn("Apellidos");
        cTModel.addColumn("Visitas");
        comTBL.setModel(cTModel);

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

                nrLBL.setText("Nombre del restaurante: " +
                        restaurantes.getNombre());
                drLBL.setText("Direccion del restaurante: " +
                        restaurantes.getDireccion());
                ceLBL.setText("Cantidad de empleados: " +
                        Integer.toString(restaurantes.getCantEmpleados()));
                ccLBL.setText("Capacidad máxima: "+
                        Integer.toString(restaurantes.getCantMaxComenzales()));
                anLBL.setText("Acepta niños: " +
                        Boolean.toString(restaurantes.isAceptaNinos()));
                cLBL.setText("Categoria: " +
                        Integer.toString(restaurantes.getCategoria()));
                iLBL.setText("Impuesto: " +
                        Float.toString(restaurantes.calcularImpuesto()));

                rPanel.setVisible(false);
                drPanel.setVisible(true);
                cPanel.setVisible(true);
            }
        });

        catSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                catSlider.setToolTipText(String.valueOf(catSlider.getValue()));
                catLBL.setText(Integer.toString(catSlider.getValue()));
            }
        });
        agregarComensalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Comensal c1 = new Comensal();

                c1.setNombre(nombreComTXT.getText());
                c1.setApellidos(apellidosComTXT.getText());
                c1.setCantVisistas(Integer.parseInt(visitasComTXT.getText()));

                restaurantes.anadirComenzal(c1);

                // limpiar grid
                for (int i = cTModel.getRowCount()-1; i >=0; i--)
                    cTModel.removeRow(i);

                //relenar grid
                for (Comensal ctemp:restaurantes.getComenzales()
                     ) {
                    cTModel.addRow(new Object[]{ctemp.getNombre(),
                                                ctemp.getApellidos(),
                                                ctemp.getCantVisistas()});
                }

                nombreComTXT.setText("");
                apellidosComTXT.setText("");
                visitasComTXT.setText("");

                Comensal VIP = new Comensal();
                VIP = restaurantes.clienteVIP();

                cVIP.setText("Comensal VIP: " +
                             VIP.getNombre() + " " +
                             VIP.getApellidos() + " con " +
                             VIP.getCantVisistas() + " visitas.");
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        MainForm dialog = new MainForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
