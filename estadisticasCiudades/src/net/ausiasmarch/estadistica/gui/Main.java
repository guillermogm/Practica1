package net.ausiasmarch.estadistica.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import net.ausiasmarch.common.Convert;
import net.ausiasmarch.estadistica.modelo.Ciudad;
import net.ausiasmarch.estadistica.modelo.GestorCiudades;
import net.ausiasmarch.estadistica.utils.Grid;
import net.ausiasmarch.estadistica.utils.RenderGrid;

/**
 * Main.java
 *
 * @author Administrador
 */
public class Main extends javax.swing.JFrame {

    // Gestor de ciudades
    private final GestorCiudades gc;
    // Lista de ciudades
    private final List<Ciudad> ciudades;
    private final HashMap<String, List<Ciudad>> comunidades=new HashMap<String, List<Ciudad>>();
    // Array de nombres de columnas para los grids
    private final String[] colGridCiudades = {"Comunidad", "Ciudad", "Habitantes"};
    private final String[] colGridComunidades = {"Comunidad", "Total ciudades", "Total Habitates"};

    /**
     * Crea un form Main
     */
    public Main() {
        initComponents();
        ciudades = new ArrayList<Ciudad>();     // creamos la lista de ciudades
        gc = new GestorCiudades(); // creamos Gestor de ciudades
        gc.setCiudades(ciudades);
        iniciaGrids();                         // iniciamos los grids 
    }
    
    /**
     * Metodo Main
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main main = new Main();
                main.getContentPane().setBackground(Color.WHITE);
                main.setSize(1080, 780);
                main.setLocationRelativeTo(null);
                main.setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldCiudad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonAgregar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldBusqueda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNumHabitantes = new javax.swing.JTextField();
        jButtonBuscarCiudad = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPaneDatosComunidad = new javax.swing.JTabbedPane();
        jPanelTotales = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldCiudadMayorHab = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldMayorHabitantes = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldTotal = new javax.swing.JTextField();
        jTextFieldNumCiudades = new javax.swing.JTextField();
        jPanelDatosComunidades = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gridComunidades = new net.ausiasmarch.estadistica.utils.Grid();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldHabitantes = new javax.swing.JTextField();
        jButtonCalcular = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gridCiudades = new net.ausiasmarch.estadistica.utils.Grid();
        jButtonBorrarCiudad = new javax.swing.JButton();
        jComboBoxOrdenar = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxComunidad = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ciudades");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldCiudad.setToolTipText("Nombre de la ciudad");
        getContentPane().add(jTextFieldCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 150, 20));

        jLabel1.setText("Ciudad");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 50, 20));

        jButtonAgregar.setBackground(new java.awt.Color(200, 230, 220));
        jButtonAgregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonAgregar.setForeground(new java.awt.Color(102, 102, 102));
        jButtonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/ausiasmarch/estadistica/res/Add.png"))); // NOI18N
        jButtonAgregar.setText("Añadir");
        jButtonAgregar.setToolTipText("");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 110, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar"));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Ciudad");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 23, -1, -1));
        jPanel1.add(jTextFieldBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 20, 140, -1));

        jLabel4.setText("Habitantes");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, -1, -1));

        jTextFieldNumHabitantes.setEditable(false);
        jTextFieldNumHabitantes.setBackground(new java.awt.Color(204, 204, 255));
        jTextFieldNumHabitantes.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(jTextFieldNumHabitantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 220, -1));

        jButtonBuscarCiudad.setBackground(new java.awt.Color(200, 230, 220));
        jButtonBuscarCiudad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonBuscarCiudad.setForeground(new java.awt.Color(102, 102, 102));
        jButtonBuscarCiudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/ausiasmarch/estadistica/res/Find.png"))); // NOI18N
        jButtonBuscarCiudad.setText(" Buscar");
        jButtonBuscarCiudad.setToolTipText("");
        jButtonBuscarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarCiudadActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBuscarCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 150, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 1050, 80));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados estad�sticos"));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPaneDatosComunidad.setBackground(new java.awt.Color(255, 255, 255));

        jPanelTotales.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTotales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("N� de Ciudades");
        jPanelTotales.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 150, -1));

        jLabel11.setText("Ciudad con mayor habitantes");
        jPanelTotales.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 240, -1));

        jTextFieldCiudadMayorHab.setEditable(false);
        jTextFieldCiudadMayorHab.setBackground(new java.awt.Color(204, 204, 255));
        jTextFieldCiudadMayorHab.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanelTotales.add(jTextFieldCiudadMayorHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 260, -1));

        jLabel13.setText("Habitantes");
        jPanelTotales.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, -1, -1));

        jTextFieldMayorHabitantes.setEditable(false);
        jTextFieldMayorHabitantes.setBackground(new java.awt.Color(204, 204, 255));
        jTextFieldMayorHabitantes.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanelTotales.add(jTextFieldMayorHabitantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 100, -1));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Total Habitantes");
        jPanelTotales.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 150, -1));

        jTextFieldTotal.setEditable(false);
        jTextFieldTotal.setBackground(new java.awt.Color(204, 204, 255));
        jTextFieldTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanelTotales.add(jTextFieldTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 110, -1));

        jTextFieldNumCiudades.setEditable(false);
        jTextFieldNumCiudades.setBackground(new java.awt.Color(204, 204, 255));
        jTextFieldNumCiudades.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanelTotales.add(jTextFieldNumCiudades, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 110, -1));

        jTabbedPaneDatosComunidad.addTab("Datos Totales", jPanelTotales);

        jPanelDatosComunidades.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setViewportView(gridComunidades);

        javax.swing.GroupLayout jPanelDatosComunidadesLayout = new javax.swing.GroupLayout(jPanelDatosComunidades);
        jPanelDatosComunidades.setLayout(jPanelDatosComunidadesLayout);
        jPanelDatosComunidadesLayout.setHorizontalGroup(
            jPanelDatosComunidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosComunidadesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelDatosComunidadesLayout.setVerticalGroup(
            jPanelDatosComunidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosComunidadesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneDatosComunidad.addTab("Datos Comunidades por habitantes", jPanelDatosComunidades);

        jPanel2.add(jTabbedPaneDatosComunidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1030, 170));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 1050, 220));

        jLabel6.setText("Habitantes");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, 20));

        jTextFieldHabitantes.setToolTipText("N�mero de habitantes");
        getContentPane().add(jTextFieldHabitantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 110, 20));

        jButtonCalcular.setBackground(new java.awt.Color(200, 230, 220));
        jButtonCalcular.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonCalcular.setForeground(new java.awt.Color(102, 102, 102));
        jButtonCalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/ausiasmarch/estadistica/res/Sum.png"))); // NOI18N
        jButtonCalcular.setText(" Calcular");
        jButtonCalcular.setToolTipText("");
        jButtonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalcularActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 300, 180, 40));

        jButtonLimpiar.setBackground(new java.awt.Color(255, 204, 204));
        jButtonLimpiar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonLimpiar.setForeground(new java.awt.Color(102, 102, 102));
        jButtonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/ausiasmarch/estadistica/res/clear.png"))); // NOI18N
        jButtonLimpiar.setText(" Limpiar");
        jButtonLimpiar.setToolTipText("");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 690, 140, 40));

        jButtonSalir.setBackground(new java.awt.Color(255, 204, 204));
        jButtonSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(102, 102, 102));
        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/ausiasmarch/estadistica/res/exit.png"))); // NOI18N
        jButtonSalir.setText("Salir");
        jButtonSalir.setToolTipText("");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 690, 120, 40));

        jScrollPane1.setViewportView(gridCiudades);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 121, 1050, 150));

        jButtonBorrarCiudad.setBackground(new java.awt.Color(200, 230, 220));
        jButtonBorrarCiudad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonBorrarCiudad.setForeground(new java.awt.Color(102, 102, 102));
        jButtonBorrarCiudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/ausiasmarch/estadistica/res/Remove.gif"))); // NOI18N
        jButtonBorrarCiudad.setText("Borrar ciudad");
        jButtonBorrarCiudad.setToolTipText("");
        jButtonBorrarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarCiudadActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBorrarCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 70, 180, 40));

        jComboBoxOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Comunidad y Ciudad", "Mayor a menor Habitantes" }));
        jComboBoxOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOrdenarActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 240, -1));

        jLabel3.setText("Ordenar por");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 90, 20));

        jComboBoxComunidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Andalucia", "Asturias", "Arag�n", "Canarias", "Castilla la Mancha", "Castilla y Le�n", "Catalu�a", "Comunidad de Madrid", "Comunidad Valenciana", "Extremadura", "Galicia", "La Rioja", "Navarra", "Pa�s Vasco", "Regi�n de Murcia", "Ceuta", "Melilla" }));
        getContentPane().add(jComboBoxComunidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 270, -1));

        jLabel10.setText("Comunidad aut�noma");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Agrega ciudades
     *
     * @param evt
     */
    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
    	GestorCiudades gc=new GestorCiudades();
        // Datos de una ciudad
        String sComunidad, sCiudad, sHabitantes;
        
       
        // Obtenemos los datos de entrada
        sCiudad = jTextFieldCiudad.getText();
        sHabitantes = jTextFieldHabitantes.getText();
        sComunidad = jComboBoxComunidad.getSelectedItem().toString().toUpperCase();
        
        // Validamos los datos
        if (sCiudad.isEmpty()) {
        	mensaje("La ciudad introducida no puede estar en blanco.");
        }
        if (!Convert.isValidLong(sHabitantes)) {
        	mensaje("El numero de habitantes introducidos es incorrecto.");
        }
       
        // Comprobamos si la ciudad esta la lista
        for (Ciudad c: ciudades) {
        if(c.getCiudad().equalsIgnoreCase(sCiudad)) {	
        mensaje("Esta ciudad ya esta en la lista.");
        return;
        }
        }
        
        // Convertimos habitantes al tipo long 
        
      long habitantes=Convert.parseLong(sHabitantes);

        // Creamos la ciudad
        
        Ciudad ciudad=new Ciudad(sComunidad,sCiudad,habitantes);

        // Agregamos el objeto ciudad a la lista de ciudades
        
        ciudades.add(ciudad);
        
        List<Ciudad> listaCiudades=new ArrayList<Ciudad>();
        
        //Dreparar el HashMap
        if(comunidades.containsKey(sComunidad))
        	listaCiudades=comunidades.get(sComunidad);
        listaCiudades.add(ciudad);
        comunidades.put(sComunidad, listaCiudades);
        
        // Limpiamos los campos de entrada
        jTextFieldCiudad.setText("");
        jTextFieldHabitantes.setText("");
        jComboBoxComunidad.setSelectedIndex(0);
        // Mostramos la lista de ciudades en el grid
        actualizarGrid(ciudades);
        // Ordenamos la lista
        ordenar();
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    /**
     * Limpia los campos de entrada
     */
    private void limpiaCamposEntrada() {
        jTextFieldCiudad.setText("");
        jTextFieldHabitantes.setText("");
    }

    /**
     * Actualiza el grid usando el list de ciudades
     */
    private void actualizarGrid(List<Ciudad> ciudades) {
        List<List> lista = gc.aslistaCiudades(ciudades);
        gridCiudades.clear();
        gridCiudades.loadFromList(lista, colGridCiudades);
        gridCiudades.firstRow();
    }
    /**
     * Actuliza el grid de comunidades.
     */
    private void actualizarGridCom() {
        List<List> lista = gc.aslistaComunidad(comunidades);
        gridComunidades.clear();
        gridComunidades.loadFromList(lista, colGridComunidades);
        gridComunidades.firstRow();
    }
    /**
     * Borra una ciudad de la lista
     *
     * @param evt
     */
    
    private void jButtonBorrarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarCiudadActionPerformed
        
        // Obtenemos la fila seleccionada en el grid
        int fila = gridCiudades.getSelectedRow();
        String nombreCiudad = gridCiudades.getValueAt(fila, 1).toString();

        // if fila >= 0 - Si tenemos una fila seleccionada, en este caso siempre tenemos seleccionada la primera
        // dentro del if metemos la sentencia de borrar ciudad
        if (fila >= 0) {
         //Borramos la ciudad
        gc.borrarCiudad(nombreCiudad,comunidades);
   
        	
        }
        
        if(ciudades.isEmpty()) {
        	limpiarDatos();
        }
        else
        actualizarGrid(ciudades);
        actualizarGridCom();
    }//GEN-LAST:event_jButtonBorrarCiudadActionPerformed

    /**
     * Obtiene los datos estadisticos
     *
     * @param evt
     */
    private void jButtonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcularActionPerformed
        // Obtenemos los calculos
    	if (ciudades.isEmpty())
    		return;
    	int nCiudades=gc.numCiudades();
    	long tHabitantes=gc.totalHabitantes();
    	String mCiudad=gc.ciudadMayorHabitantes().getCiudad();
    	long mHabitantes=gc.ciudadMayorHabitantes().getHabitantes();
        // Mostramos los calculos
    	jTextFieldTotal.setText(Convert.format(tHabitantes));
    	jTextFieldNumCiudades.setText(Convert.format(nCiudades));
    	jTextFieldCiudadMayorHab.setText(mCiudad);
    	jTextFieldMayorHabitantes.setText(Convert.format(mHabitantes));
    	
    	actualizarGridCom();
    	    	
    }//GEN-LAST:event_jButtonCalcularActionPerformed

    /**
     * Limpia los datos
     *
     * @param evt
     */
    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        limpiarDatos();
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    /**
     * Finaliza la aplicacion
     *
     * @param evt
     */
    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    /**
     * Busca una ciudad en la lista de ciudades
     *
     * @param evt
     */
    private void jButtonBuscarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarCiudadActionPerformed
    	if (ciudades.isEmpty())
    		return;
        
        //Buscamos la ciudad
    	// Obtenemos los habitantes de la ciudad y los mostramos
    	String ciudadb=jTextFieldBusqueda.getText();
  
    	if(gc.buscarCiudad(ciudadb) == null) {
    	mensaje("No se encuentra esa ciudad.");	
    	}
  
    	Long habitantes=gc.buscarCiudad(ciudadb).getHabitantes();
    	jTextFieldNumHabitantes.setText(Convert.format(habitantes));
        
    	
    }//GEN-LAST:event_jButtonBuscarCiudadActionPerformed

    private void jComboBoxOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOrdenarActionPerformed
        ordenar();
    }//GEN-LAST:event_jComboBoxOrdenarActionPerformed

    // Ordena la lista de ciudades 
    private void ordenar() {
        // Si la lista de ciudades no esta vacia
        if (!ciudades.isEmpty()) {
            switch (jComboBoxOrdenar.getSelectedIndex()) {
                case 0:
                    gc.ordenarComunidadCiudad();
                    break;
                case 1:
                    gc.ordenarHabitantesDesc();
                    break;
            }
            actualizarGrid(ciudades);
        }
    }

    /**
     * Limpia todos los datos del form
     */
    private void limpiarDatos() {
        jTextFieldNumCiudades.setText("");
        jTextFieldCiudadMayorHab.setText("");
        jTextFieldMayorHabitantes.setText("");
        jTextFieldBusqueda.setText("");
        jTextFieldNumHabitantes.setText("");
        jTextFieldTotal.setText("");
        jComboBoxComunidad.setSelectedIndex(0);
        jComboBoxOrdenar.setSelectedIndex(0);
        gridCiudades.clear();
        gridComunidades.clear();
        ciudades.clear();
        iniciaGrids();
    }

    /**
     * Muestra un mensaje en un JOptionPane
     *
     * @param mensaje
     */
    private void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    /**
     * Inicia los grids
     */
    private void iniciaGrids() {
        iniciaGrid(gridCiudades, colGridCiudades);
        iniciaGrid(gridComunidades, colGridComunidades);
    }

    /**
     * Inicia cada grid
     *
     * @param grid
     * @param columnas
     */
    private void iniciaGrid(Grid grid, String[] columnas) {
        grid.setColorHeader(Color.WHITE, Color.BLACK);
        grid.setColumnIdentifiers(columnas);  // columnas
        grid.setRowHeight(25);
        grid.setNumRows(5);                   // filas del grid
        grid.setEnabled(false);               // activa el grid 

        grid.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        grid.getTableHeader().setReorderingAllowed(false);

        RenderGrid formato = new RenderGrid();
        formato.setRowColor(new Color(240, 240, 240), Color.BLACK);
        formato.setRowSelectedColor(new Color(150, 150, 150), Color.WHITE);
        grid.setDefaultRenderer(String.class, formato);
        grid.setDefaultRenderer(Integer.class, formato);
        grid.setDefaultRenderer(Long.class, formato);
        grid.setDefaultRenderer(Double.class, formato);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private net.ausiasmarch.estadistica.utils.Grid gridCiudades;
    private net.ausiasmarch.estadistica.utils.Grid gridComunidades;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonBorrarCiudad;
    private javax.swing.JButton jButtonBuscarCiudad;
    private javax.swing.JButton jButtonCalcular;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<String> jComboBoxComunidad;
    private javax.swing.JComboBox<String> jComboBoxOrdenar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelDatosComunidades;
    private javax.swing.JPanel jPanelTotales;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPaneDatosComunidad;
    private javax.swing.JTextField jTextFieldBusqueda;
    private javax.swing.JTextField jTextFieldCiudad;
    private javax.swing.JTextField jTextFieldCiudadMayorHab;
    private javax.swing.JTextField jTextFieldHabitantes;
    private javax.swing.JTextField jTextFieldMayorHabitantes;
    private javax.swing.JTextField jTextFieldNumCiudades;
    private javax.swing.JTextField jTextFieldNumHabitantes;
    private javax.swing.JTextField jTextFieldTotal;
    // End of variables declaration//GEN-END:variables
}
