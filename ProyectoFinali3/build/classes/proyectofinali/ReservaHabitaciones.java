package proyectofinali;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class ReservaHabitaciones extends JPanel {
    private JTextField correoField, telefonoField;
    private JComboBox<String> estanciaComboBox, checkInComboBox, checkOutComboBox, tipoHabitacionComboBox;
    private JSpinner adultosSpinner, ninosSpinner;
    private JButton reservarButton, mostrarTablaButton;
    private JLabel numeroHuespedLabel;
    private DefaultTableModel tableModel;
    private JTable dataTable;
    private Random random = new Random();
    private JFrame tablaFrame;
    private List<String> fechasReales = new ArrayList<>();

    public ReservaHabitaciones() {
        //setTitle("Reserva de Habitaciones");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(800, 400);
        setLayout(new GridBagLayout());
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(5, 5, 5, 5); // Espaciado entre componentes

        // Datos del Huésped
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel("Correo del Huésped:"), gridBagConstraints);
        correoField = new JTextField(20);
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
        estanciaComboBox = new JComboBox<>(new String[]{"1 noche", "2 noches", "3 noches", "4 noches", "5 noches", "6 noches", "7 noches", "8 noches", "9 noches", "10 noches"});
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panel.add(estanciaComboBox, gridBagConstraints);

        gridBagConstraints.gridy++;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.weightx = 0.0;

        // Generar fechas reales para check-in y check-out
        generarFechas();
        DefaultComboBoxModel<String> checkInComboBoxModel = new DefaultComboBoxModel<>(fechasReales.toArray(new String[0]));
        checkInComboBox = new JComboBox<>(checkInComboBoxModel);

        panel.add(new JLabel("Check-In:"), gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panel.add(checkInComboBox, gridBagConstraints);

        gridBagConstraints.gridy++;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.weightx = 0.0;

        DefaultComboBoxModel<String> checkOutComboBoxModel = new DefaultComboBoxModel<>(fechasReales.toArray(new String[0]));
        checkOutComboBox = new JComboBox<>(checkOutComboBoxModel);

        panel.add(new JLabel("Check-Out:"), gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panel.add(checkOutComboBox, gridBagConstraints);

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
        panel.add(reservarButton, gridBagConstraints);

        // Botón para mostrar la tabla
        gridBagConstraints.gridy++;
        gridBagConstraints.weightx = 1.0;
        mostrarTablaButton = new JButton("Mostrar Tabla");
        panel.add(mostrarTablaButton, gridBagConstraints);

        
      
        //getContentPane().add(panel);

        // Crear una tabla para mostrar los datos registrados
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Número de Reserva");
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
                String correo = correoField.getText();
                String telefono = telefonoField.getText();
                String estancia = estanciaComboBox.getSelectedItem().toString();
                String checkIn = checkInComboBox.getSelectedItem().toString();
                String checkOut = checkOutComboBox.getSelectedItem().toString();
                int adultos = (int) adultosSpinner.getValue();
                int ninos = (int) ninosSpinner.getValue();
                String tipoHabitacion = tipoHabitacionComboBox.getSelectedItem().toString();

                /// Genera dos letras aleatorias de A a Z
                char letra1 = (char) ('A' + random.nextInt(26));
                char letra2 = (char) ('A' + random.nextInt(26));

                // Genera un número aleatorio de 1000 a 9999
                int numeroAleatorio = 1000 + random.nextInt(9000);

                // Combina las letras y el número en una cadena
                String numeroReserva = String.format("%c%c%d", letra1, letra2, numeroAleatorio);
                

                // Agregar los datos a la tabla
                tableModel.addRow(new Object[]{
                        numeroReserva,
                        correo,
                        telefono,
                        estancia,
                        checkIn,
                        checkOut,
                        adultos,
                        ninos,
                        tipoHabitacion
                });

                // Limpiar los campos después de agregar los datos a la tabla
                correoField.setText("");
                telefonoField.setText("");
                estanciaComboBox.setSelectedIndex(0);
                checkInComboBox.setSelectedIndex(0);
                checkOutComboBox.setSelectedIndex(0);
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
       // setLocationRelativeTo(null);
    }
  
    
    private void generarFechas() {
        fechasReales.add("2023-01-01");
        fechasReales.add("2023-01-02");
        fechasReales.add("2023-01-03");
        fechasReales.add("2023-01-04");
        fechasReales.add("2023-01-05");
        // Agrega más fechas según sea necesario
    }
/*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ReservaHabitaciones().setVisible(true);
            }
        });*/
    }


