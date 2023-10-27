
package proyectofinali;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComponent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class PruebaEmpleados extends JPanel {

    private DefaultTableModel tableModel;

    private JTextField nameField;
    private JTextField curpField;
    private JTextField pesoField;
    private JTextField estaturaField;

    private JPanel fechaNacimientoPanel;
    private JPanel fechaNacimientoPanel2;
    private JPanel fechaIngresoPanel;
    private JPanel buttonPanel;
    private JPanel Norte;

    private JTextField dayFieldNacimiento;
    private JTextField monthFieldNacimiento;
    private JTextField yearFieldNacimiento;

    private JTextField dayFieldIngreso;
    private JTextField monthFieldIngreso;
    private JTextField yearFieldIngreso;
    private JTextField salarioField;

    private JComboBox<String> puestoComboBox;
    private JComboBox<String> departamentoComboBox;

    private JLabel nameLabel;
    private JLabel curpLabel;
    private JLabel pesoLabel;
    private JLabel estaturaLabel;
    private JLabel fechaNacimientoLabel;
    private JLabel fechaIngresoLabel;
    private JLabel puestoLabel;
    private JLabel departamentoLabel;
    private JLabel salarioLabel;
    private JLabel lbl_imagen;
    
    
    private JLabel lbl_dayFieldNacimiento;
    private JLabel lbl_monthFieldNacimiento;
    private JLabel lbl_yearFieldNacimiento;
    
    private JLabel lbl_dayFieldIngreso;
    private JLabel lbl_monthFieldIngreso;
    private JLabel lbl_yearFieldIngreso;
    
    private JButton saveButton;
    private JButton showTableButton;
    private JButton clearButton;
     private ImageIcon imagen;
    
     
     
    public PruebaEmpleados() {

        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(21, 86, 214, 60));
        GridBagConstraints gridBagConstraints = new GridBagConstraints(); //esta es necesaria para que se vea la ventana
        JPanel panel = new JPanel(new GridBagLayout()); 
        
        Font font_labels_txt_txt = new Font ("arial", Font.BOLD, 15);
        Color color_labels = new Color(0, 0, 255, 100);
        
        
        lbl_imagen = new JLabel();
        lbl_imagen.setSize(50, 10);
        String pathImagen ="/imagen/ico.png";
        ImageIcon imagen = new ImageIcon(getClass().getResource(pathImagen));
        lbl_imagen.setIcon (imagen);
        panel.add(lbl_imagen, gridBagConstraints);
       // panel.repaint();
        
        this.add(panel, gridBagConstraints);
        
        nameLabel = new JLabel("NOMBRE:");
        curpLabel = new JLabel("CURP:");
        pesoLabel = new JLabel("PESO:");
        estaturaLabel = new JLabel("ESTATURA:");
        fechaNacimientoLabel = new JLabel("FECHA DE NACIMIENTO:");
        lbl_dayFieldNacimiento = new JLabel("DIA:");
        lbl_monthFieldNacimiento = new JLabel("MES:");
        lbl_yearFieldNacimiento = new JLabel("AÑO:");
        fechaIngresoLabel = new JLabel("FECHA DE INGRESO:");
        lbl_dayFieldIngreso = new JLabel("DIA:");
        lbl_monthFieldIngreso = new JLabel("MES:");
        lbl_yearFieldIngreso = new JLabel("AÑO:");
        puestoLabel = new JLabel("PUESTO:");
        departamentoLabel = new JLabel("DEPARTAMENTO:");
        salarioLabel = new JLabel("SALARIO:");
        
        nameLabel.setFont(font_labels_txt_txt);
        curpLabel.setFont(font_labels_txt_txt);
        pesoLabel.setFont(font_labels_txt_txt);
        salarioLabel.setFont(font_labels_txt_txt);
        puestoLabel.setFont(font_labels_txt_txt);
        departamentoLabel.setFont(font_labels_txt_txt);
        estaturaLabel.setFont(font_labels_txt_txt);
        fechaIngresoLabel.setFont(font_labels_txt_txt);
        fechaNacimientoLabel.setFont(font_labels_txt_txt);
        lbl_dayFieldIngreso.setFont(font_labels_txt_txt);
        lbl_dayFieldNacimiento.setFont(font_labels_txt_txt);
        lbl_monthFieldIngreso.setFont(font_labels_txt_txt);
        lbl_monthFieldNacimiento.setFont(font_labels_txt_txt);
        lbl_yearFieldIngreso.setFont(font_labels_txt_txt);
        lbl_yearFieldNacimiento.setFont(font_labels_txt_txt);
        
        nameLabel.setForeground(color_labels);
        curpLabel.setForeground(color_labels);
        pesoLabel.setForeground(color_labels);
        salarioLabel.setForeground(color_labels);
        puestoLabel.setForeground(color_labels);
        departamentoLabel.setForeground(color_labels);
        estaturaLabel.setForeground(color_labels);
        fechaIngresoLabel.setForeground(color_labels);
        fechaNacimientoLabel.setForeground(color_labels);
        lbl_dayFieldIngreso.setForeground(color_labels);
        lbl_dayFieldNacimiento.setForeground(color_labels);
        lbl_monthFieldIngreso.setForeground(color_labels);
        lbl_monthFieldNacimiento.setForeground(color_labels);
        lbl_yearFieldIngreso.setForeground(color_labels);
        lbl_yearFieldNacimiento.setForeground(color_labels);
        
        
        nameField = new JTextField(20);
        curpField = new JTextField(20);
        pesoField = new JTextField(20);
        pesoField.setHorizontalAlignment(JTextField.RIGHT);
        estaturaField = new JTextField(20);
        estaturaField.setHorizontalAlignment(JTextField.RIGHT);
        dayFieldNacimiento = new JTextField(20);
        dayFieldNacimiento.setHorizontalAlignment(JTextField.CENTER);
        monthFieldNacimiento = new JTextField(20);
        monthFieldNacimiento.setHorizontalAlignment(JTextField.CENTER);
        yearFieldNacimiento = new JTextField(20);
        yearFieldNacimiento.setHorizontalAlignment(JTextField.CENTER);
        puestoComboBox = new JComboBox<>(new String[]{"Ingeniero", "Abogado", "Licenciado", "Médico"});
        salarioField = new JTextField(20);
        salarioField.setHorizontalAlignment(JTextField.RIGHT);
        departamentoComboBox = new JComboBox<>(new String[]{"Departamento1", "Departamento2", "Departamento3"});
        dayFieldIngreso = new JTextField(20);
        dayFieldIngreso.setHorizontalAlignment(JTextField.CENTER);
        monthFieldIngreso = new JTextField(20);
        monthFieldIngreso.setHorizontalAlignment(JTextField.CENTER);
        yearFieldIngreso = new JTextField(20);
        yearFieldIngreso.setHorizontalAlignment(JTextField.CENTER);
        
        saveButton = new JButton("Guardar");
        clearButton = new JButton("Limpiar");
        showTableButton = new JButton("Tabla");
        
        fechaNacimientoPanel = new JPanel();
        fechaNacimientoPanel.setLayout(new GridBagLayout());
        fechaIngresoPanel = new JPanel();
        fechaIngresoPanel.setLayout(new GridBagLayout());
        fechaIngresoPanel.setBackground(new Color(21, 86, 214, 60));
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        
        fechaNacimientoPanel2 = new JPanel();
        fechaNacimientoPanel2.setLayout(new GridBagLayout());
      
        Norte = new JPanel();
        Norte.setLayout(new GridBagLayout());
        Norte.setBackground(new Color(21, 86, 214, 60));
       configurarComponentes();
        //BOTONES
        buttonPanel.add(saveButton);
        buttonPanel.add(showTableButton);
        buttonPanel.add(clearButton);
        buttonPanel.setBackground(new Color(21, 86, 214, 60));

        
       fechaNacimientoPanel2.add(dayFieldNacimiento);
       fechaNacimientoPanel2.add(monthFieldNacimiento);
       fechaNacimientoPanel2.add(yearFieldNacimiento);
       fechaNacimientoPanel2.setBackground(new Color(21, 86, 214, 60));

       
        fechaIngresoPanel.add(dayFieldIngreso);
        fechaIngresoPanel.add(monthFieldIngreso);
        fechaIngresoPanel.add(yearFieldIngreso);
        fechaIngresoPanel.setBackground(new Color(21, 86, 214, 2));

        
        buttonPanel.add(saveButton);
        buttonPanel.add(showTableButton);
        buttonPanel.add(clearButton);
        buttonPanel.setBackground(new Color(21, 86, 214, 2));


     //Aqui abajo deben de ir metodos de KeyListener
     
        
        
      this.add(panel);
      
      this.repaint();
      this.revalidate();
     
        
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

        
        showTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTableWindow();
            }
        });

        
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        //GridBagConstraints del Panel de Botones
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 25;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        add(buttonPanel, gridBagConstraints);
        

        //Creacion de la Tabla
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
      
     private void configurarComponentes(){
      Insets insets =new Insets(2,2,2,2);
      int fill;
   fill= GridBagConstraints.BOTH;
      agregarComponentes( Norte, lbl_imagen,
              0, 0, 3, 1, 2, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.BOTH;
      agregarComponentes(this, lbl_imagen, 
              2, 0, 1, 1, 2, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.BOTH;
      agregarComponentes(this, nameLabel, 
              0, 1, 1, 1, 2, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.BOTH;
      agregarComponentes(this, nameField, 
              1, 1, 1, 1, 2, 0, fill, insets, 10, 10);
     
      fill= GridBagConstraints.BOTH;
      agregarComponentes(this, curpLabel, 
              2, 1, 1, 1, 0, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.BOTH;
      agregarComponentes(this, curpField, 
              3, 1, 1, 1, 1, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.BOTH;
      agregarComponentes(this, pesoLabel, 
              0, 2, 1, 1, 0, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.BOTH;
      agregarComponentes(this, pesoField, 
              1, 2, 1, 1, 1, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.BOTH;
      agregarComponentes(this, estaturaLabel, 
              2, 2, 1, 1, 0, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.BOTH;
      agregarComponentes(this, estaturaField, 
              3, 2, 1, 1, 1, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.BOTH;
      agregarComponentes(this, fechaNacimientoLabel, 
              0, 3, 1, 2, 0, 0, fill, insets, 10, 10); 
      
      fill= GridBagConstraints.BOTH;
      agregarComponentes(this, fechaNacimientoPanel, 
              1, 3, 3, 2, 1, 0, fill, insets, 10, 10);
      //fechaNacimientoPanel.setBackground(Color.red);
      
     fill= GridBagConstraints.BOTH;
      agregarComponentes(this, fechaNacimientoPanel2, 
           1, 4, 3, 2, 1, 0, fill, insets, 10, 10);
      fechaNacimientoPanel2.setBackground(Color.red);
      
      fill= GridBagConstraints.VERTICAL;
      agregarComponentes(fechaNacimientoPanel, lbl_dayFieldNacimiento, 
              0, 0, 3, 2, 1, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.VERTICAL;
      agregarComponentes(fechaNacimientoPanel, lbl_monthFieldNacimiento, 
              1, 0, 3, 2, 1, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.VERTICAL;
      agregarComponentes(fechaNacimientoPanel, lbl_yearFieldNacimiento, 
              2, 0, 3, 2, 1, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.BOTH;
      agregarComponentes(fechaNacimientoPanel2, dayFieldNacimiento, 
            0, 0, 1, 2, 1, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.BOTH;
      agregarComponentes(fechaNacimientoPanel2, monthFieldNacimiento, 
            1, 0, 1, 2, 1, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.BOTH;
      agregarComponentes(fechaNacimientoPanel2, yearFieldNacimiento, 
              2, 0, 1, 2, 1, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.BOTH;
      agregarComponentes(this, puestoLabel, 
              0, 7, 1, 1, 0, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.BOTH;
      agregarComponentes(this, puestoComboBox, 
              1, 7, 1, 1, 1, 0, fill, insets, 10, 10);
      
     fill= GridBagConstraints.BOTH;
      agregarComponentes(this, departamentoLabel, 
              0, 8, 1, 1, 0, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.BOTH;
      agregarComponentes(this, departamentoComboBox, 
              1, 8, 1, 1, 1, 0, fill, insets, 10, 10);
      
     fill= GridBagConstraints.BOTH;
      agregarComponentes(this, salarioLabel, 
              0, 9, 1, 1, 0, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.BOTH;
      agregarComponentes(this, salarioField, 
              1, 9, 1, 1, 1, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.BOTH;
      agregarComponentes(this, fechaIngresoLabel, 
              0, 8, 1, 0, 0, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.BOTH;
    agregarComponentes(this, fechaIngresoPanel, 
            1, 10, 3, 6, 1, 0, fill, insets, 10, 10);
    
      fill= GridBagConstraints.VERTICAL;
      agregarComponentes(fechaIngresoPanel, lbl_dayFieldIngreso, 
              0, 0, 1, 7, 1, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.VERTICAL;
      agregarComponentes(fechaIngresoPanel, lbl_monthFieldIngreso, 
              1, 0, 1, 7, 1, 0, fill, insets, 10, 10);
      
     fill= GridBagConstraints.VERTICAL;
      agregarComponentes(fechaIngresoPanel, lbl_yearFieldIngreso, 
              2, 0, 1, 7, 1, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.BOTH;
      agregarComponentes(fechaIngresoPanel, dayFieldIngreso, 
              0, 1, 1, 7, 1, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.BOTH;
      agregarComponentes(fechaIngresoPanel, monthFieldIngreso, 
              1, 1, 1, 7, 1, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.BOTH;
      agregarComponentes(fechaIngresoPanel, yearFieldIngreso, 
                2, 1, 1, 7, 1, 0, fill, insets, 10, 10);
      
      fill= GridBagConstraints.BOTH;
      agregarComponentes(this, buttonPanel, 
                1, 13, 0, 0, 3, 0, fill, insets, 10, 10);
      
}
     
 private void agregarComponentes (JComponent contenedor,
       JComponent componente,
       int gridX,      int gridY,       
       int gridWidth,  int gridHeight,
       double weightX, double weightY,
       int fill,       Insets inSets,
       int ipadX,      int ipadY){
   
       GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx       =gridX;
        constraints.gridy       =gridY;
        constraints.gridwidth   =gridWidth;
        constraints.gridheight  =gridHeight;        
        constraints.weightx     =weightX;
        constraints.weighty     =weightY;        
        constraints.fill        =fill;
        constraints.insets      =inSets;        
        constraints.ipadx       =ipadX;
        constraints.ipady       =ipadY;
        
       contenedor.add(componente, constraints);
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
