

package proyectofinali;

/**
 *
 * @author Omar López
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Principal extends JPanel {
    
  JPanel panel_titulo;
  JPanel sur;
 
  JButton uno;
  JButton dos;
  JButton salida;
   
  JPanel panel_imagen;
  JLabel lbl_titulo;
  JLabel lbl_imagen;
  JLabel lbl_chica;
  
  public Image imagenfondo;
    public URL fondo;
  
  public Principal() {
     
     uno = new JButton  ("   CLIENTES ");
     dos = new JButton  (" ADMINISTRATIVO ");
     salida =new JButton("SALIDA");
     sur    = new JPanel();
     sur.setBackground(new Color(20, 10, 51,100));//colocar color al panel "sur"
    panel_titulo = new JPanel();
    panel_titulo.setLayout(new FlowLayout());
    

   // panel_imagen =  new JPanel();
    //panel_imagen.setLayout(new BorderLayout());
   // panel_imagen.setBackground(Color.WHITE);
    
    Font fuente = new Font("Century", Font.BOLD, 32);
    lbl_titulo = new JLabel("¡¡¡BIENVENIDOS!!!");
    lbl_titulo.setOpaque(true);
    lbl_titulo.setBackground(Color.DARK_GRAY);
    lbl_titulo.setFont(fuente);
    lbl_titulo.setForeground(Color.WHITE); //Color de la letra

   fondo=this.getClass().getResource("/imagen/inicio.jpg");
   imagenfondo= new ImageIcon (fondo).getImage();
    
    
    sur.add(dos);
    sur.add(uno);
    setLayout(new BorderLayout());
    
    
     JPanel panel = new JPanel(new GridBagLayout());

    //this.setBackground(Color.GREEN);
     GridBagConstraints gridBagConstraints = new GridBagConstraints();
     gridBagConstraints.insets = new Insets(5, 5, 5, 5);
     panel.setBackground(new Color(238, 238, 238,30));

    gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        lbl_titulo.add(new JLabel("BIENVENIDOS"), gridBagConstraints);
        panel.add(lbl_titulo);
        
        gridBagConstraints.gridy++;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        lbl_chica = new JLabel("Experiencias inolvidable");
        panel.add(lbl_chica, gridBagConstraints);
        //panel.add(new JLabel("Experiencias inolvidables"), gridBagConstraints);
        lbl_chica.setOpaque(true);
        lbl_chica.setBackground(Color.WHITE);
        add(panel);

    //this.add(panel_imagen, BorderLayout.CENTER);
    this.add(sur, BorderLayout.SOUTH);

    }
  @Override
       public void paint(Graphics g) {
       g.drawImage(imagenfondo, 0, 0, getWidth(), getHeight(), null);

       setOpaque(false);
       super.paint(g);
       }
}
