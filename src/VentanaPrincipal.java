import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    private JPanel panel1;
    private JTextField Matricula;
    private JTextField Edad;
    private JRadioButton Hombre;
    private JRadioButton Mujer;
    private JTextField Nombre;
    private JLabel NombreLabel;
    private JLabel MatriculaLabel;
    private JLabel EdadLabel;
    private JCheckBox BecaActiva;
    private JCheckBox Transporte;
    private JComboBox Carreras;
    private JButton Datos;
    private JButton Limpiar;
    private JButton Salir;
    private JTextArea Observaciones;
    private ButtonGroup Generos;

    //constructor
    public VentanaPrincipal () {
        setContentPane(panel1);
        setTitle("Registro alumno");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,1000);
        setLocationRelativeTo(null);

        //Botones
        Datos.addActionListener(e -> Datos());
        Limpiar.addActionListener(e -> Limpiar());
        Salir.addActionListener(e -> Salir());

        Generos = new ButtonGroup();
        Generos.add(Hombre);
        Generos.add(Mujer);

        setVisible(true);
    }

    private void Datos() {
        String nombreTexto = Nombre.getText();
        String matriculaTexto = Matricula.getText();
        String edadTexto = Edad.getText();
        String ObsTexto = Observaciones.getText();
        String sexoTexto;
        String becaTexto;
        String transporteTexto;

        //Validaciones

        if (Hombre.isSelected()) {
             sexoTexto = "Hombre";
        } else if (Mujer.isSelected()) {
             sexoTexto = "Mujer";
        } else {
            sexoTexto = "Ninguno";
        JOptionPane.showMessageDialog(null,"ERROR.Selecciona tu sexo");
        return;
        }

        if  (nombreTexto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR. Introduce tu nombre");
            return;
        }

        // poner return aqui es importante ya que brindara la alerta del error, y no mostrara los datos, en caso de que
        // no haya return, mostrara la alerta de error y mostrara los datos mal
        if (matriculaTexto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR. Introduce tu Matricula");
            return;
        }

        if (edadTexto.isEmpty()) {
            JOptionPane.showMessageDialog(null,"ERROR. Introduce tu edad.");
            return;
        }

        if (BecaActiva.isSelected()) {
            becaTexto = "ACTIVA";
        } else {
            becaTexto = "NO ACTIVA";
        }

        if (Transporte.isSelected()) {
            transporteTexto = "Cuenta con transporte";
        } else {
            transporteTexto = "NO cuenta con transporte";
        }

        JOptionPane.showMessageDialog(this,"Nombre: " + nombreTexto +
                "\n Matricula: " + matriculaTexto +
                "\n Edad: " + edadTexto +
                "\n Sexo: " + sexoTexto +
                "\n Beca Activa: " + becaTexto +
                "\n Transporte: " + transporteTexto +
                "\n Observaciones: " + ObsTexto);
    }

    private void Limpiar() {

        Matricula.setText("");
        Nombre.setText("");
        Edad.setText("");
        BecaActiva.setSelected(false);
        Transporte.setSelected(false);
        Generos.clearSelection();
        Carreras.setSelectedIndex(0);
        Observaciones.setText("");
    }

    private void Salir() {
    System.exit(0);
    }

    public static void main(String[] args) {
        new VentanaPrincipal();
    }
}

