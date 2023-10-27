
package proyectofinali;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class Reservacion extends JPanel{
    private JTextField nombreHuespedField, correoField, telefonoField;
    private JSpinner adultosSpinner, ninosSpinner;
    private JButton reservarButton, mostrarTablaButton;
    private JLabel numeroHuespedLabel;
    private DefaultTableModel tableModel;
    private JTable dataTable;
    private Random random = new Random();
    private JFrame tablaFrame;
    private int individualesDisponibles = 10;
    private int doblesDisponibles = 7;
    private int suitesDisponibles = 3;

    public Image imagenfondo;
    public URL fondo;
    
    private JComboBox<String> checkInDayComboBox, checkInMonthComboBox, checkInYearComboBox;
    private JComboBox<String> checkOutDayComboBox, checkOutMonthComboBox, checkOutYearComboBox;
    private JComboBox<String> estanciaComboBox, tipoHabitacionComboBox;
   

    public Reservacion() {
     
       fondo=this.getClass().getResource("/imagen/fondo.jpg");
       imagenfondo= new ImageIcon (fondo).getImage();
        
        setLayout(new GridBagLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(5, 5, 5, 5); // Espaciado entre componentes
        panel.setBackground(new Color(238, 238, 238,180));
        
        // Datos del Huésped
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel("Nombre del Huésped:"), gridBagConstraints);
        nombreHuespedField = new JTextField(20);
        // Establecer el fondo del campo de texto en blanco y el borde en negro
        nombreHuespedField.setBackground(Color.WHITE);
        nombreHuespedField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panel.add(nombreHuespedField, gridBagConstraints);

        gridBagConstraints.gridy++;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel("Correo del Huésped:"), gridBagConstraints);
        correoField = new JTextField(20);
        // Establecer el fondo del campo de texto en blanco y el borde en negro
        correoField.setBackground(Color.WHITE);
        correoField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panel.add(correoField, gridBagConstraints);

        gridBagConstraints.gridy++;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.weightx = 0.0;
        panel.add(new JLabel("Número de Teléfono:"), gridBagConstraints);
        telefonoField = new JTextField(20);
        // Establecer el fondo del campo de texto en blanco y el borde en negro
        telefonoField.setBackground(Color.WHITE);
        telefonoField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panel.add(telefonoField, gridBagConstraints);

        // Detalles de la Reserva
        gridBagConstraints.gridy++;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.weightx = 0.0;
        panel.add(new JLabel("Estancia:"), gridBagConstraints);
        estanciaComboBox = new JComboBox<>(new String[]{"1 noche", "2 noches", "3 noches", "4 noches", "5 noches", "6 noches", "7 noches", "8 noches", "9 noches", "10 noches", "11 noches", "12 noches"});
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panel.add(estanciaComboBox, gridBagConstraints);

        gridBagConstraints.gridy++;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.weightx = 0.0;

        // Eliminar fechas predefinidas y mostrar días y meses en dos dígitos
        DefaultComboBoxModel<String> checkInDayModel = new DefaultComboBoxModel<>(getDigitDays());
        checkInDayComboBox = new JComboBox<>(checkInDayModel);
        DefaultComboBoxModel<String> checkInMonthModel = new DefaultComboBoxModel<>(getTwoDigitMonths());
        checkInMonthComboBox = new JComboBox<>(checkInMonthModel);
        DefaultComboBoxModel<String> checkInYearModel = new DefaultComboBoxModel<>(getFourDigitYears());
        checkInYearComboBox = new JComboBox<>(checkInYearModel);

        panel.add(new JLabel("Check-In:"), gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panel.add(checkInDayComboBox, gridBagConstraints);
        gridBagConstraints.gridx = 2;
        panel.add(checkInMonthComboBox, gridBagConstraints);
        gridBagConstraints.gridx = 3;
        panel.add(checkInYearComboBox, gridBagConstraints);

        gridBagConstraints.gridy++;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.weightx = 0.0;

        DefaultComboBoxModel<String> checkOutDayModel = new DefaultComboBoxModel<>(getDigitDays());
        checkOutDayComboBox = new JComboBox<>(checkOutDayModel);
        DefaultComboBoxModel<String> checkOutMonthModel = new DefaultComboBoxModel<>(getTwoDigitMonths());
        checkOutMonthComboBox = new JComboBox<>(checkOutMonthModel);
        DefaultComboBoxModel<String> checkOutYearModel = new DefaultComboBoxModel<>(getFourDigitYears());
        checkOutYearComboBox = new JComboBox<>(checkOutYearModel);

        panel.add(new JLabel("Check-Out:"), gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panel.add(checkOutDayComboBox, gridBagConstraints);
        gridBagConstraints.gridx = 2;
        panel.add(checkOutMonthComboBox, gridBagConstraints);
        gridBagConstraints.gridx = 3;
        panel.add(checkOutYearComboBox, gridBagConstraints);

        // Número de Huéspedes
        gridBagConstraints.gridy++;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.weightx = 0.0;
        panel.add(new JLabel("Adultos:"), gridBagConstraints);
        adultosSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panel.add(adultosSpinner, gridBagConstraints);

        gridBagConstraints.gridy++;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.weightx = 0.0;
        panel.add(new JLabel("Niños (0-17 años):"), gridBagConstraints);
        ninosSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panel.add(ninosSpinner, gridBagConstraints);

        // Tipo de Habitación
        gridBagConstraints.gridy++;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.weightx = 0.0;
        panel.add(new JLabel("Tipo de Habitación:"), gridBagConstraints);
        tipoHabitacionComboBox = new JComboBox<>(new String[]{"Individual", "Doble", "Suite"});
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panel.add(tipoHabitacionComboBox, gridBagConstraints);

        // Botón de Reserva
        gridBagConstraints.gridy++;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.0;
        gridBagConstraints.gridwidth = 2;
        panel.add(new JPanel(), gridBagConstraints);

        gridBagConstraints.gridy++;
        gridBagConstraints.weightx = 1.0;
        reservarButton = new JButton("Reservar");
        // Establecer el fondo del botón en blanco
        reservarButton.setBackground(Color.WHITE);
        // Establecer el borde de foco en negro
        reservarButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // Eliminar el efecto de pintura del botón
        reservarButton.setFocusPainted(false);
        // Establecer el comportamiento de opacidad
        reservarButton.setOpaque(true);
        // Establecer el color de fuente en negro
        reservarButton.setForeground(Color.BLACK);
        panel.add(reservarButton, gridBagConstraints);

        // Botón para mostrar la tabla
        gridBagConstraints.gridy++;
        gridBagConstraints.weightx = 1.0;
        mostrarTablaButton = new JButton("Mostrar Tabla");
        // Establecer el fondo del botón en blanco
        mostrarTablaButton.setBackground(Color.WHITE);
        // Establecer el borde de foco en negro
        mostrarTablaButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // Eliminar el efecto de pintura del botón
        mostrarTablaButton.setFocusPainted(false);
        // Establecer el comportamiento de opacidad
        mostrarTablaButton.setOpaque(true);
        // Establecer el color de fuente en negro
        mostrarTablaButton.setForeground(Color.BLACK);
        panel.add(mostrarTablaButton, gridBagConstraints);

        add(panel);

        // Crear una tabla para mostrar los datos registrados
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Número de Reserva");
        tableModel.addColumn("Nombre del Huésped");
        tableModel.addColumn("Correo");
        tableModel.addColumn("Teléfono");
        tableModel.addColumn("Estancia");
        tableModel.addColumn("Check-In");
        tableModel.addColumn("Check-Out");
        tableModel.addColumn("Adultos");
        tableModel.addColumn("Niños");
        tableModel.addColumn("Tipo de Habitación");

        dataTable = new JTable(tableModel);

        // Acción del botón de reserva
        reservarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos del formulario
                String nombreHuesped = nombreHuespedField.getText();
                String correo = correoField.getText();
                String telefono = telefonoField.getText();
                String estancia = estanciaComboBox.getSelectedItem().toString();
                String checkIn = checkInYearComboBox.getSelectedItem() + "-" +
                        getTwoDigitMonth(checkInMonthComboBox.getSelectedIndex() + 1) + "-" +
                        getTwoDigitDay(checkInDayComboBox.getSelectedIndex() + 1);
                String checkOut = checkOutYearComboBox.getSelectedItem() + "-" +
                        getTwoDigitMonth(checkOutMonthComboBox.getSelectedIndex() + 1) + "-" +
                        getTwoDigitDay(checkOutDayComboBox.getSelectedIndex() + 1);
                int adultos = (int) adultosSpinner.getValue();
                int ninos = (int) ninosSpinner.getValue();
                String tipoHabitacion = tipoHabitacionComboBox.getSelectedItem().toString();

                // Verificar la disponibilidad de habitaciones
                if (!verificarDisponibilidad(tipoHabitacion)) {
                    JOptionPane.showMessageDialog(null, "No hay habitaciones disponibles de este tipo.");
                    return;
                }

                // Genera dos letras aleatorias de A a Z
                char letra1 = (char) ('A' + random.nextInt(26));
                char letra2 = (char) ('A' + random.nextInt(26));

                // Genera un número aleatorio de 1000 a 9999
                int numeroAleatorio = 1000 + random.nextInt(9000);

                // Combina las letras y el número en una cadena
                String numeroReserva = String.format("%c%c%d", letra1, letra2, numeroAleatorio);

                // Agregar los datos a la tabla
                tableModel.addRow(new Object[]{
                        numeroReserva,
                        nombreHuesped,
                        correo,
                        telefono,
                        estancia,
                        checkIn,
                        checkOut,
                        adultos,
                        ninos,
                        tipoHabitacion
                });

                // Reducir la disponibilidad de habitaciones
                reducirDisponibilidad(tipoHabitacion);

                // Limpiar los campos después de agregar los datos a la tabla
                nombreHuespedField.setText("");
                correoField.setText("");
                telefonoField.setText("");
                estanciaComboBox.setSelectedIndex(0);
                checkInDayComboBox.setSelectedIndex(0);
                checkInMonthComboBox.setSelectedIndex(0);
                checkInYearComboBox.setSelectedIndex(0);
                checkOutDayComboBox.setSelectedIndex(0);
                checkOutMonthComboBox.setSelectedIndex(0);
                checkOutYearComboBox.setSelectedIndex(0);
                adultosSpinner.setValue(1);
                ninosSpinner.setValue(0);
                tipoHabitacionComboBox.setSelectedIndex(0);
            }
        });

        // Acción del botón para mostrar la tabla
        mostrarTablaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tablaFrame == null) {
                    tablaFrame = new JFrame("Tabla de Reservas");
                    tablaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    tablaFrame.setSize(800, 200);
                    tablaFrame.add(new JScrollPane(dataTable));
                }
                tablaFrame.setVisible(true);
            }
        });

       // pack();
        //setLocationRelativeTo(null);
    }
@Override
       public void paint(Graphics g) {
       g.drawImage(imagenfondo, 0, 0, getWidth(), getHeight(), null);

       setOpaque(false);
       super.paint(g);
       }
       
    private boolean verificarDisponibilidad(String tipoHabitacion) {
        if ("Individual".equals(tipoHabitacion) && individualesDisponibles > 0) {
            return true;
        } else if ("Doble".equals(tipoHabitacion) && doblesDisponibles > 0) {
            return true;
        } else if ("Suite".equals(tipoHabitacion) && suitesDisponibles > 0) {
            return true;
        }
        return false;
    }

    private void reducirDisponibilidad(String tipoHabitacion) {
        if ("Individual".equals(tipoHabitacion)) {
            individualesDisponibles--;
        } else if ("Doble".equals(tipoHabitacion)) {
            doblesDisponibles--;
        } else if ("Suite".equals(tipoHabitacion)) {
            suitesDisponibles--;
        }
    }

    private String getTwoDigitDay(int day) {
        return String.format("%02d", day);
    }

    private String getTwoDigitMonth(int month) {
        return String.format("%02d", month);
    }

    private String[] getDigitDays() {
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = getTwoDigitDay(i);
        }
        return days;
    }

    private String[] getTwoDigitMonths() {
        String[] months = new String[]{
            "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"
        };
        return months;
    }

    private String[] getFourDigitYears() {
        String[] years = new String[10];
        int currentYear = 2023;
        for (int i = 0; i < 10; i++) {
            years[i] = String.valueOf(currentYear + i);
        }
        return years;
    }

   private void PanelTransparente(Color LIGHT_GRAY) {
      throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   }

    }


   

