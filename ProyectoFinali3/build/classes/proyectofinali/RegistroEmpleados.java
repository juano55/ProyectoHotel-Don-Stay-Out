
package proyectofinali;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class RegistroEmpleados extends JPanel {

    private DefaultTableModel tableModel;

    private JTextField nameField;
    private JTextField curpField;
    private JTextField pesoField;
    private JTextField estaturaField;

    private JPanel fechaNacimientoPanel;
    private JPanel fechaIngresoPanel;
   
    private JTextField dayFieldNacimiento;
    private JTextField monthFieldNacimiento;
    private JTextField yearFieldNacimiento;

    private JTextField dayFieldIngreso;
    private JTextField monthFieldIngreso;
    private JTextField yearFieldIngreso;

    private JComboBox<String> puestoComboBox;
    private JComboBox<String> departamentoComboBox;

    private JTextField salarioField;
    
    public Image imagenfondo;
    public URL fondo;
    
   private JLabel lbl_imagen;


    public RegistroEmpleados() {

        setLayout(new GridBagLayout());

        
        fondo=this.getClass().getResource("/imagen/fondo.jpg");
       imagenfondo= new ImageIcon (fondo).getImage();
        
       JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(5, 5, 5, 5); // Espaciado entre componentes
        panel.setBackground(new Color(238, 238, 238,180));
        
        lbl_imagen = new JLabel();
        lbl_imagen.setSize(50, 10);
        String pathImagen ="/imagen/ico.png";
        ImageIcon imagen = new ImageIcon(getClass().getResource(pathImagen));
        lbl_imagen.setIcon (imagen);
        panel.add(lbl_imagen, gridBagConstraints);
       // panel.repaint();
       
      this.add(panel, gridBagConstraints);

      this.add(panel);
      
      this.repaint();
      this.revalidate();
        
        gridBagConstraints.insets = new Insets(8, 50, 20, 150);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel nameLabel = new JLabel("NOMBRE:");
        nameField = new JTextField(20);

        JLabel curpLabel = new JLabel("CURP:");
        curpField = new JTextField(20);

        JLabel pesoLabel = new JLabel("PESO:");
        pesoField = new JTextField(10);

        JLabel estaturaLabel = new JLabel("ESTATURA:");
        estaturaField = new JTextField(10);

        JLabel fechaNacimientoLabel = new JLabel("FECHA DE NACIMIENTO:");
        fechaNacimientoPanel = new JPanel();
        fechaNacimientoPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
       // fechaNacimientoPanel.setBackground(Color.cyan);
        dayFieldNacimiento = new JTextField(5);
        monthFieldNacimiento = new JTextField(5);
        yearFieldNacimiento = new JTextField(5);
        fechaNacimientoPanel.add(dayFieldNacimiento);
        fechaNacimientoPanel.add(monthFieldNacimiento);
        fechaNacimientoPanel.add(yearFieldNacimiento);

        JLabel fechaIngresoLabel = new JLabel("FECHA DE INGRESO:");
        fechaIngresoPanel = new JPanel();
        fechaIngresoPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        dayFieldIngreso = new JTextField(5);
        monthFieldIngreso = new JTextField(5);
        yearFieldIngreso = new JTextField(5);
        fechaIngresoPanel.add(dayFieldIngreso);
        fechaIngresoPanel.add(monthFieldIngreso);
        fechaIngresoPanel.add(yearFieldIngreso);

        JLabel puestoLabel = new JLabel("PUESTO:");
        puestoComboBox = new JComboBox<>(new String[]{"Ingeniero", "Abogado", "Licenciado", "Médico"});

        JLabel departamentoLabel = new JLabel("DEPARTAMENTO:");
        departamentoComboBox = new JComboBox<>(new String[]{"Departamento1", "Departamento2", "Departamento3"});

        JLabel salarioLabel = new JLabel("SALARIO:");
        salarioField = new JTextField(10);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panel.add(lbl_imagen, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panel.add(nameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        panel.add(nameField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panel.add(curpLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        panel.add(curpField, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        panel.add(pesoLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        panel.add(estaturaLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        panel.add(pesoField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        panel.add(estaturaField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        panel.add(fechaNacimientoLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        panel.add(fechaNacimientoPanel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        panel.add(fechaIngresoLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        panel.add(fechaIngresoPanel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        panel.add(puestoLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        panel.add(puestoComboBox, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        panel.add(departamentoLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        panel.add(departamentoComboBox, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        panel.add(salarioLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        panel.add(salarioField, gridBagConstraints);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nameField.getText();
                String curp = curpField.getText();
                String peso = pesoField.getText();
                String estatura = estaturaField.getText();
                String fechaNacimiento = dayFieldNacimiento.getText() + "/" + monthFieldNacimiento.getText() + "/" + yearFieldNacimiento.getText();
                String fechaIngreso = dayFieldIngreso.getText() + "/" + monthFieldIngreso.getText() + "/" + yearFieldIngreso.getText();

                String puesto = (String) puestoComboBox.getSelectedItem();
                String departamento = (String) departamentoComboBox.getSelectedItem();
                String salario = salarioField.getText();

                tableModel.addRow(new Object[]{nombre, curp, peso, estatura, fechaNacimiento, fechaIngreso, puesto, departamento, salario});
                clearFields();
            }
        });
        buttonPanel.add(saveButton);

        JButton showTableButton = new JButton("Ver Tabla");
        showTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTableWindow();
            }
        });
        buttonPanel.add(showTableButton);

        JButton clearButton = new JButton("Limpiar");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        buttonPanel.add(clearButton);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        add(buttonPanel, gridBagConstraints);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre");
        tableModel.addColumn("CURP");
        tableModel.addColumn("Peso");
        tableModel.addColumn("Estatura");
        tableModel.addColumn("Fecha de Nacimiento");
        tableModel.addColumn("Fecha de Ingreso");
        tableModel.addColumn("Puesto");
        tableModel.addColumn("Departamento");
        tableModel.addColumn("Salario");

    }
    
    @Override
       public void paint(Graphics g) {
       g.drawImage(imagenfondo, 0, 0, getWidth(), getHeight(), null);

       setOpaque(false);
       super.paint(g);
       }
    

    private void clearFields() {
        nameField.setText("");
        curpField.setText("");
        pesoField.setText("");
        estaturaField.setText("");
        dayFieldNacimiento.setText("");
        monthFieldNacimiento.setText("");
        yearFieldNacimiento.setText("");
        dayFieldIngreso.setText("");
        monthFieldIngreso.setText("");
        yearFieldIngreso.setText("");
        puestoComboBox.setSelectedIndex(0);
        departamentoComboBox.setSelectedIndex(0);
        salarioField.setText("");
    }

    private void showTableWindow() {
        JFrame tableFrame = new JFrame("Tabla de Datos");
        tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tableFrame.setSize(800, 400);
        tableFrame.setResizable(true);

        JPanel tablePanel = new JPanel(new BorderLayout());
        JTable table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);
        tablePanel.add(tableScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton backButton = new JButton("Volver");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableFrame.dispose();
            }
        });
        buttonPanel.add(backButton);
        tablePanel.add(buttonPanel, BorderLayout.SOUTH);

        tableFrame.add(tablePanel);
        tableFrame.setVisible(true);
    }

   
}
