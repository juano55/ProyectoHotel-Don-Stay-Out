
package proyectofinali;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Residentes extends JPanel {
      
   private DefaultTableModel tableModel;

   
   private JPanel lbl_fechaLlegada;
   private JPanel lbl_fechaSalida;
   private JPanel norte_panel_Imagen;

   private JLabel lbl_Nombre;
   private JLabel lbl_Edad;
   private JLabel lbl_NumTel;
   private JLabel lbl_MetodoPago;
   private JLabel lbl_Correo;
   private JLabel lbl_InfoAdd;
   private JLabel lbl_Image;
   private JLabel JLabel1;
   private JLabel lbl_imagen;


   
   private JTextField txt_fechaLlegada;
   private JTextField txt_fechaSalida;
   private JTextField txt_Nombre;
   private JTextField txt_Edad;
   private JTextField txt_NumTel;
   private JTextField txt_Correo;

   private JTextArea txta_InfoAdd;

   
   private JComboBox<String> AdultosComboBox;
   private JComboBox<String> NiñosComboBox;
   private JComboBox<String> NumRoomsComboBox;
   private JComboBox<String> Box_MetodoPago;

   public Image imagenfondo;
      public Image imagen;

   public URL fondo;
   

   private JButton btn_Reservar;
   
   public Residentes() {
       
     
      setLayout(new GridBagLayout());

      fondo=this.getClass().getResource("/imagen/fondo.jpg");
       imagenfondo= new ImageIcon (fondo).getImage();
       
       JPanel panel = new JPanel(new GridBagLayout());
       GridBagConstraints gridBagConstraints = new GridBagConstraints();
       gridBagConstraints.insets = new Insets(8, 50, 20, 150);
       gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
       panel.setBackground(new Color(238, 238, 238,180));//Color transparente
       
      
        
        this.add(panel, gridBagConstraints);
       //panel  = new JPanel();
       //panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
       add(panel);
       //add(panel);
     
        /*JLabel1.setIcon(new ImageIcon("imagen/persona.png"));
        panel.add(JLabel1, gridBagConstraints);*/
      
        
        panel.add(new JLabel("NOMBRE:"), gridBagConstraints);
        //panel.add(new JLabel("Nombre del Huésped:"), gridBagConstraints); PARA SOLO FONDO EN UN LABEL
        //nombreHuespedField = new JTextField(20);
        //panel.add(nombreHuespedField, gridBagConstraints);

        //JLabel JLabel1 = new JLabel("");
        
        JLabel lbl_Edad = new JLabel("EDAD:");
        panel.add(txt_Edad = new JTextField(20));
        
        JLabel lbl_NumTel = new JLabel("NUMERO DE TELEFONO:");
        panel.add(txt_NumTel = new JTextField(10));
        
        JLabel lbl_Correo = new JLabel("INFO ADICIONAL:");
        panel.add(txt_Correo = new JTextField(10));
        
        JLabel lbl_InfoAdd = new JLabel("CORREO:");
        panel.add(txta_InfoAdd = new JTextArea("Introduce tu correo aqui..."));
        
        JLabel lbl_MetodoPago = new JLabel("METODO DE PAGO:");
        panel.add(Box_MetodoPago = new JComboBox<>(new String[]{"Efectivo", "Tarjeta de Credito/Debito", "Dolares", "Checke"}));
        
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
       // panel.add(lbl_Nombre, gridBagConstraints);
        panel.add(txt_Nombre = new JTextField(20));

        
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
       // panel.add(lbl_Nombre, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panel.add(lbl_Edad, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        panel.add(txt_Edad, gridBagConstraints);
        
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        panel.add(lbl_NumTel, gridBagConstraints);
        
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        panel.add(txt_NumTel, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(lbl_Correo, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        panel.add(txt_Correo, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        panel.add(lbl_MetodoPago, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        panel.add(Box_MetodoPago, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        panel.add(lbl_InfoAdd, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        panel.add(txta_InfoAdd, gridBagConstraints);

        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                

        JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txt_Nombre.getText();
                String edad = txt_Edad.getText();
                String NumTel = txt_NumTel.getText();
                String Correo = txt_Correo.getText();
               // String info = (String) txta_InfoAdd.getSelectedItem();

                String MetodoPag = (String) Box_MetodoPago.getSelectedItem(); 
                JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

                

       tableModel.addRow(new Object[]{nombre, edad, NumTel, Correo, MetodoPag });
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
   }
});
   gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        add(buttonPanel, gridBagConstraints);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Edad");
        tableModel.addColumn("Numero de Telefono");
        tableModel.addColumn("Correo");
        tableModel.addColumn("Metodo de Pago");

    }
 @Override
       public void paint(Graphics g) {
       g.drawImage(imagenfondo,  0, 0, getWidth(), getHeight(), null);

       setOpaque(false);
       super.paint(g);
       }
        
    
       
       
       
    private void clearFields() {
        txt_Nombre.setText("");
        txt_Edad.setText("");
        txt_NumTel.setText("");
        txt_Correo.setText("");
        txta_InfoAdd.setText("");
        Box_MetodoPago.setSelectedIndex(0);
        
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

