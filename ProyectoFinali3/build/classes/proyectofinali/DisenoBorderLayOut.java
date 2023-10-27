
package proyectofinali;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class DisenoBorderLayOut extends JFrame{ 
    JPanel norte;
    JPanel oeste;
    JPanel centro;
    JPanel oeste_inicio;
    JPanel oeste_fibo;
    JPanel oeste_linea;
    JPanel oeste_fecha;
    JPanel oeste_salir;
    
    JLabel titulo;
    JLabel inicio;
    JLabel fibo;
    JLabel linea;
    JLabel fecha;
    JLabel salirlbl;
    

    public DisenoBorderLayOut(){
        super("App Hotel");
        
        norte  = new JPanel();
        norte.setBackground(Color.WHITE);
        oeste  = new JPanel();
        oeste.setBackground(Color.WHITE);
        centro = new JPanel();
        centro.setBackground(Color.WHITE);
        centro.setLayout(new BorderLayout());
        
        Font fTitulo = new Font   ("Bahnschrift", Font.BOLD, 24);
        Font gTitulo = new Font   ("Bahnschrift", Font.BOLD, 16);
        titulo       = new JLabel ( "                      HOTEL DON´T STAY OUT");
        inicio       = new JLabel (          ">>HOME"          );
        fibo         = new JLabel (          ">>EMPLEADOS"         );
        linea        = new JLabel (          ">>RESIDENTE"           );
        fecha        = new JLabel (          ">>RESERVACIONES"           );
        salirlbl     = new JLabel (          ">>SALIR"           );
        titulo.setFont  (fTitulo);
        inicio.setFont  (gTitulo);
        fibo.setFont    (gTitulo);
        linea.setFont   (gTitulo);
        fecha.setFont   (gTitulo);
        salirlbl.setFont(gTitulo);
        
        norte.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        norte.add(titulo);
        norte.setBackground(new Color(20, 10, 51,100));
   
        BoxLayout caja = new BoxLayout (oeste, BoxLayout.Y_AXIS);
        oeste.setLayout(caja);
        oeste.setCursor(new Cursor (Cursor.HAND_CURSOR));
        
        oeste_inicio = new JPanel();
        oeste_inicio.setBackground(Color.WHITE);
        oeste_inicio.setLayout(new BorderLayout(5,5));
        oeste_inicio.add(inicio, BorderLayout.CENTER);
        
        oeste_fibo   =   new JPanel();
        oeste_fibo.setBackground(Color.WHITE);
        oeste_fibo.setLayout(new BorderLayout());
        oeste_fibo.add(fibo, BorderLayout.CENTER);
        
        oeste_linea   =   new JPanel();
        oeste_linea.setBackground(Color.WHITE);
        oeste_linea.setLayout(new BorderLayout());
        oeste_linea.add(linea, BorderLayout.CENTER);
        
        oeste_fecha   =   new JPanel();
        oeste_fecha.setBackground(Color.WHITE);
        oeste_fecha.setLayout(new BorderLayout());
        oeste_fecha.add(fecha, BorderLayout.CENTER);
        
        oeste_salir   =   new JPanel();
        oeste_salir.setBackground(Color.WHITE);
        oeste_salir.setLayout(new BorderLayout());
        oeste_salir.add(salirlbl, BorderLayout.CENTER);
        
        oeste_inicio.addMouseListener(new WrapperMouse() {
            @Override
            public void mouseClicked(MouseEvent c) {
                Principal ppal = new Principal();
                mostrarPanels(ppal);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                coloresOpcionesMenu(oeste_inicio, Color.BLUE, inicio, Color.LIGHT_GRAY);
            }
            
            @Override
            public void mouseExited(MouseEvent c) {
                coloresOpcionesMenu(oeste_inicio, Color.LIGHT_GRAY, inicio, Color.BLUE);
            }
        });
       
        oeste_fibo.addMouseListener(new WrapperMouse() {
            @Override
            public void mouseClicked(MouseEvent c) {
                RegistroEmpleados fbnc = new RegistroEmpleados();
                mostrarPanels(fbnc);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                coloresOpcionesMenu(oeste_fibo, Color.BLUE, fibo, Color.LIGHT_GRAY);
            }
            
            @Override
            public void mouseExited(MouseEvent c) {
                coloresOpcionesMenu(oeste_fibo, Color.LIGHT_GRAY, fibo, Color.BLUE);
            }
        });
         
        oeste_linea.addMouseListener(new WrapperMouse() {
            @Override
            public void mouseClicked(MouseEvent c) {
                Residentes ppal = new Residentes();
                mostrarPanels(ppal);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                coloresOpcionesMenu(oeste_linea, Color.BLUE, linea, Color.LIGHT_GRAY);
            }
            
            @Override
            public void mouseExited(MouseEvent c) {
                coloresOpcionesMenu(oeste_linea, Color.LIGHT_GRAY, linea, Color.BLUE);
            }
        });
       
        oeste_fecha.addMouseListener(new WrapperMouse() {
            @Override
            public void mouseClicked(MouseEvent c) {
                Reservacion res = new Reservacion();
                mostrarPanels(res);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                coloresOpcionesMenu(oeste_fecha, Color.BLUE, fecha, Color.LIGHT_GRAY);
            }
            
            @Override
            public void mouseExited(MouseEvent c) {
                coloresOpcionesMenu(oeste_fecha, Color.LIGHT_GRAY, fecha, Color.BLUE);
            }
        });
        
        oeste_salir.addMouseListener(new WrapperMouse() {
            @Override
            public void mouseClicked(MouseEvent c) {
                System.exit(0);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                coloresOpcionesMenu(oeste_salir, Color.BLUE, salirlbl, Color.LIGHT_GRAY);
            }
            
            @Override
            public void mouseExited(MouseEvent c) {
                coloresOpcionesMenu(oeste_salir, Color.LIGHT_GRAY, salirlbl, Color.BLUE);
            }
        });
        
        oeste.add(oeste_inicio);
        oeste.add(oeste_fibo);
        oeste.add(oeste_linea);
        oeste.add(oeste_fecha);
        oeste.add(oeste_salir);
        
        //inicialmente cargar el panel principal
        centro.add(new Principal(), BorderLayout.CENTER);
        
        //this.setLayout(new BorderLayout());
        
        this.add(norte , BorderLayout.NORTH);
        this.add(oeste , BorderLayout.WEST);
        this.add(centro, BorderLayout.CENTER);
        
        this.setSize(700, 350);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    public static void main(String [] args) {
        new DisenoBorderLayOut().setVisible(true);
    }
    
    private void coloresOpcionesMenu(JPanel panel, Color back, JLabel etiqueta, Color fore) {
        panel.setBackground(back);
        etiqueta.setForeground(fore);
    }
    
    private void mostrarPanels(JPanel ventana){
        centro.removeAll();
        centro.add(ventana);
        centro.revalidate();
        centro.repaint();
    }
}
