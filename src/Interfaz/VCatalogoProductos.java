package Interfaz;

import control.Control;
import interfaces.Observer;
import java.awt.Color;
import java.util.LinkedList;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.productos.Producto;

public class VCatalogoProductos extends javax.swing.JFrame implements Observer{
    

    public VCatalogoProductos(Control c) {
        initComponents();
        mainInit();
        ctrl = c;
    }
    @Override
    public void update() {
        updateTable(table1);
        updateTable(table2);
    }
    
    public void mainInit() {
        addActions();
        initInclusion();
        initModificacion();
        initBorrar();
        setBlankBuscar();
    }
    private void initModificacion() {
        initButtons(btnTrue2, btnFalse2);
        setBlankModificacion();
    }
    private void setBlankModificacion() {
        txtFieldCodi.setText("");
        txtFieldCodi.setEditable(false);
        txtFieldDesc2.setText("");
        txtFieldPrecio2.setText("");
        txtFieldUM2.setText("");
        txtFieldBusqueda.setText("");
    }
    
    private void initInclusion() {
        initButtons(btnTrue, btnFalse);
        setBlankInclusion();
    }    
    
    private void setBlankInclusion() {
        lblExistencia.setText("");
        txtFieldCodigo.setText("");
        txtFieldDescripcion.setText("");
        txtFieldPrecioUnitario.setText("0.0");
        txtFieldUnidadMedida.setText("");
    }
    private void initButtons(javax.swing.JRadioButton btnTrue, javax.swing.JRadioButton btnFalse) {
        ButtonGroup group = new ButtonGroup();
        group.add(btnTrue);
        group.add(btnFalse);
        btnFalse.setSelected(true);
    }
    private void initBorrar() {
        setBlankBorrar();
    }
    private void setBlankBorrar() {
        txtFieldCodBorrar.setText("");
        txtFieldDetBorrar.setText("");
        lblExistencia1.setText("");
    }
    private void setBlankBuscar() {
        txtFieldBusqueda1.setText("");
    }
    
    private void addActions() {
        jTabbedPane2.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
            int index = tabbedPane.getSelectedIndex();
            switch(tabbedPane.getTitleAt(index)) {
                case MODIFICACION:  updateTable(table1); break;
                case BUSCAR:        updateTable(table2); break;
            }
        }
        });
        addDocumentListener(txtFieldBusqueda, table1);
        table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                tableAction();
            }
        });
        addDocumentListener(txtFieldBusqueda1, table2);
    }
    private void addDocumentListener(javax.swing.JTextField txtField, javax.swing.JTable table) {
        
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        txtField.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txtField.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtField.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

        });
    }    
    private void updateTable(javax.swing.JTable table) {
        LinkedList<Producto> list = ctrl.getAllProductos();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        Object o[];
        
        for(Producto p : list) {
            o = new Object[]{p.getCodigo(), p.getDescripcion(), p.getUnidadMedida(), p.getPrecio(), p.isActivo()};
            model.addRow(o);
        }
    }
    
    private void home() {
        this.dispose();
        ctrl.mostrarMenu();
    }
    
    private void tableAction() {
        int row = table1.getSelectedRow();
        int column = 0;
        
        String value = table1.getModel().getValueAt(row, column++).toString();
        txtFieldCodi.setText(value);
        value = table1.getModel().getValueAt(row, column++).toString();
        txtFieldDesc2.setText(value);

        value = table1.getModel().getValueAt(row, column++).toString();
        txtFieldUM2.setText(value);

        value = table1.getModel().getValueAt(row, column++).toString();
        txtFieldPrecio2.setText(value);

        value = table1.getModel().getValueAt(row, column++).toString();
        if(value == "true")
            btnTrue2.setSelected(true);
        else
            btnFalse2.setSelected(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JTabbedPane jTabbedPane1 = new javax.swing.JTabbedPane();
        jFrame1 = new javax.swing.JFrame();
        btnGroup2 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        javax.swing.ButtonGroup buttonGroup3 = new javax.swing.ButtonGroup();
        javax.swing.ButtonGroup buttonGroup4 = new javax.swing.ButtonGroup();
        javax.swing.ButtonGroup buttonGroup5 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFieldCodigo = new javax.swing.JTextField();
        txtFieldDescripcion = new javax.swing.JTextField();
        txtFieldUnidadMedida = new javax.swing.JTextField();
        txtFieldPrecioUnitario = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        lblExistencia = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnTrue = new javax.swing.JRadioButton();
        btnFalse = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        txtFieldCosto = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        txtFieldBusqueda = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtFieldDesc2 = new javax.swing.JTextField();
        txtFieldUM2 = new javax.swing.JTextField();
        txtFieldPrecio2 = new javax.swing.JTextField();
        btnTrue2 = new javax.swing.JRadioButton();
        btnFalse2 = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        txtFieldCodi = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtFieldCost = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtFieldCodBorrar = new javax.swing.JTextField();
        btnConfirmarBorrar = new javax.swing.JButton();
        lblExistencia1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtFieldDetBorrar = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtFieldBusqueda1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mantenimiento del Catálogo de Productos");

        jLabel2.setText("Codigo de Producto: ");

        jLabel3.setText("Descripción: ");

        jLabel4.setText("Unidad de Medida:");

        jLabel5.setText("Precio Unitario: ");

        txtFieldCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldCodigoFocusLost(evt);
            }
        });
        txtFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldCodigoActionPerformed(evt);
            }
        });
        txtFieldCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldCodigoKeyTyped(evt);
            }
        });

        txtFieldDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldDescripcionKeyTyped(evt);
            }
        });

        txtFieldUnidadMedida.setPreferredSize(new java.awt.Dimension(160, 24));
        txtFieldUnidadMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldUnidadMedidaActionPerformed(evt);
            }
        });
        txtFieldUnidadMedida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldUnidadMedidaKeyTyped(evt);
            }
        });

        txtFieldPrecioUnitario.setScrollOffset(82);
        txtFieldPrecioUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldPrecioUnitarioActionPerformed(evt);
            }
        });
        txtFieldPrecioUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldPrecioUnitarioKeyTyped(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblExistencia.setText("<Existencia de producto>");

        jLabel6.setText("Activo:");

        btnTrue.setText("Si");

        btnFalse.setText("No");

        jLabel17.setText("Costo");

        txtFieldCosto.setScrollOffset(82);
        txtFieldCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldCostoActionPerformed(evt);
            }
        });
        txtFieldCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldCostoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(btnAgregar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnTrue)
                                .addGap(18, 18, 18)
                                .addComponent(btnFalse))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtFieldCosto, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFieldCodigo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFieldUnidadMedida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFieldDescripcion, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFieldPrecioUnitario, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addComponent(lblExistencia)))))
                .addContainerGap(293, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblExistencia))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFieldUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFieldPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnTrue)
                    .addComponent(btnFalse))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtFieldCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addGap(27, 27, 27))
        );

        jTabbedPane2.addTab("Inclusion de Productos", jPanel2);

        btnModificar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Des", "Medida", "Precio", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setColumnSelectionAllowed(true);
        table1.getTableHeader().setReorderingAllowed(false);
        table1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                table1FocusGained(evt);
            }
        });
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);
        table1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        txtFieldBusqueda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFieldBusquedaFocusGained(evt);
            }
        });
        txtFieldBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldBusquedaActionPerformed(evt);
            }
        });
        txtFieldBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldBusquedaKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Descripcion:");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Unidad de Medida: ");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Precio: ");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Activo: ");

        txtFieldDesc2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldDesc2KeyTyped(evt);
            }
        });

        txtFieldUM2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldUM2KeyTyped(evt);
            }
        });

        txtFieldPrecio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldPrecio2ActionPerformed(evt);
            }
        });
        txtFieldPrecio2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldPrecio2KeyTyped(evt);
            }
        });

        btnTrue2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnTrue2.setText("Si");
        btnTrue2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrue2ActionPerformed(evt);
            }
        });

        btnFalse2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnFalse2.setText("No");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Codigo: ");

        txtFieldCodi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldCodiActionPerformed(evt);
            }
        });
        txtFieldCodi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldCodiKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Ingrese el dato que deseas buscar:");

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Costo");

        txtFieldCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldCostActionPerformed(evt);
            }
        });
        txtFieldCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldCostKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel11)))
                                    .addComponent(jLabel10))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtFieldDesc2)
                                            .addComponent(txtFieldPrecio2)
                                            .addComponent(txtFieldCodi)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFieldUM2, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnFalse2)
                                        .addGap(105, 105, 105))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(88, 88, 88)
                                .addComponent(txtFieldCost)
                                .addGap(9, 9, 9))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTrue2)
                    .addComponent(btnModificar))
                .addGap(136, 136, 136))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtFieldCodi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtFieldDesc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtFieldUM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFieldPrecio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(btnFalse2)
                            .addComponent(btnTrue2)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtFieldCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btnModificar)
                .addGap(28, 28, 28))
        );

        jTabbedPane2.addTab("Modificacion de productos", jPanel3);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Ingrese el codigo del producto que deseas borrar:");

        txtFieldCodBorrar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldCodBorrarFocusLost(evt);
            }
        });
        txtFieldCodBorrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldCodBorrarKeyTyped(evt);
            }
        });

        btnConfirmarBorrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConfirmarBorrar.setText("Confirmar");
        btnConfirmarBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarBorrarActionPerformed(evt);
            }
        });

        lblExistencia1.setText("<Existencia de producto>");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Ingrese la descripcion del producto que deseas borrar:");

        txtFieldDetBorrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldDetBorrarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(btnConfirmarBorrar)
                        .addGap(156, 156, 156))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFieldDetBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFieldCodBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(lblExistencia1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtFieldCodBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblExistencia1))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtFieldDetBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btnConfirmarBorrar)
                .addContainerGap(196, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Borrar Productos", jPanel4);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Ingrese el dato que deseas buscar:");

        txtFieldBusqueda1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFieldBusqueda1FocusGained(evt);
            }
        });
        txtFieldBusqueda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldBusqueda1ActionPerformed(evt);
            }
        });
        txtFieldBusqueda1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldBusqueda1KeyTyped(evt);
            }
        });

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Des", "Medida", "Precio", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.getTableHeader().setReorderingAllowed(false);
        table2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                table2FocusGained(evt);
            }
        });
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table2);
        table2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFieldBusqueda1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtFieldBusqueda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Buscar Producto", jPanel1);

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setText("Inicio");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(35, 35, 35))
                    .addComponent(jTabbedPane2)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane2))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCodigoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
    String codigo = txtFieldCodigo.getText();
    String descripcion = txtFieldDescripcion.getText();
    String unidadMedida = txtFieldUnidadMedida.getText();
    String costoText = txtFieldCosto.getText();

    boolean activo = btnTrue.isSelected();
    double precioUnitario;
    double costoProducto;

    try {
        precioUnitario = Double.parseDouble(txtFieldPrecioUnitario.getText());
        costoProducto = Double.parseDouble(costoText);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error en el formato de precio o costo", "Error", JOptionPane.ERROR_MESSAGE);
        return; 
    }

    if (precioUnitario != -1.0 && costoProducto != -1.0) {
        if (!codigo.isEmpty() && !descripcion.isEmpty() && !unidadMedida.isEmpty()) {
            if (lblExistencia.getText().equals("✔")) {
                if (precioUnitario < costoProducto) {
                    JOptionPane.showMessageDialog(this, "El precio de venta está por debajo del costo del producto.", "Alerta", JOptionPane.WARNING_MESSAGE);
                } else {
                    ctrl.addProducto(codigo, descripcion, unidadMedida, precioUnitario, activo, costoProducto);
                    setBlankInclusion();
                }
            }
        }
    }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtFieldCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldCodigoFocusLost
        if (!txtFieldCodigo.getText().equalsIgnoreCase("")) {
            if (!ctrl.verificarExistenciaProducto(txtFieldCodigo.getText())) {
                lblExistencia.setForeground(Color.GREEN);
                lblExistencia.setText("✔");
            } else {
                lblExistencia.setForeground(Color.RED);
                lblExistencia.setText("✘");
            }
        }
    }//GEN-LAST:event_txtFieldCodigoFocusLost

    private void txtFieldBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldBusquedaKeyTyped
    
    }//GEN-LAST:event_txtFieldBusquedaKeyTyped

    private void txtFieldBusquedaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldBusquedaFocusGained
        txtFieldBusqueda.setText("");
    }//GEN-LAST:event_txtFieldBusquedaFocusGained

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        
    }//GEN-LAST:event_table1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        home();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String cod = txtFieldCodi.getText();
        String des = txtFieldDesc2.getText();
        String uni = txtFieldUM2.getText();
        boolean ac = (btnTrue2.isSelected()) ? true : false;
        double costo = Double.parseDouble(txtFieldCost.getText());
        double pre;
        try {
            pre = Double.parseDouble(txtFieldPrecio2.getText());
        } catch (Exception e) {
            pre = -1;
        }
        
        if (!cod.isEmpty() && !des.isEmpty() && !uni.isEmpty()) {
        if(pre < costo){
            JOptionPane.showMessageDialog(this, "El precio de venta está por debajo del costo del producto.", "Alerta", JOptionPane.WARNING_MESSAGE);
        } else {
            ctrl.modificarProducto(cod, des, uni, pre, ac, costo);
            setBlankModificacion();
        }
}       
    }//GEN-LAST:event_btnModificarActionPerformed

    private void table1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_table1FocusGained
        
    }//GEN-LAST:event_table1FocusGained

    private void txtFieldBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldBusquedaActionPerformed

    private void txtFieldCodBorrarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldCodBorrarFocusLost
        if (!txtFieldCodBorrar.getText().equalsIgnoreCase("")) {
            if (ctrl.verificarExistenciaProducto(txtFieldCodBorrar.getText())) {
                lblExistencia1.setForeground(Color.GREEN);
                lblExistencia1.setText("✔");
            } else {
                lblExistencia1.setForeground(Color.RED);
                lblExistencia1.setText("✘");
            }
        }
    }//GEN-LAST:event_txtFieldCodBorrarFocusLost

    private void btnConfirmarBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarBorrarActionPerformed
        String cod = txtFieldCodBorrar.getText();
        ctrl.deleteProducto(cod);
        setBlankBorrar();
    }//GEN-LAST:event_btnConfirmarBorrarActionPerformed

    private void txtFieldBusqueda1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldBusqueda1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldBusqueda1FocusGained

    private void txtFieldBusqueda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldBusqueda1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldBusqueda1ActionPerformed

    private void txtFieldBusqueda1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldBusqueda1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldBusqueda1KeyTyped

    private void table2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_table2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_table2FocusGained

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_table2MouseClicked

    private void txtFieldCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldCodigoKeyTyped
    int tecla = evt.getKeyChar();
      
      boolean num = tecla >= 48 && tecla <=57;
      
      if (!(num))
      {
      evt.consume();
      }
      if(this.txtFieldCodigo.getText().length()== 5)
          evt.consume();
    }//GEN-LAST:event_txtFieldCodigoKeyTyped

    private void txtFieldPrecioUnitarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldPrecioUnitarioKeyTyped
        int tecla = evt.getKeyChar();
      
      boolean num = tecla >= 48 && tecla <=57;
      
      if (!(num))
      {
      evt.consume();
      }
      if(this.txtFieldPrecioUnitario.getText().length()== 6)
          evt.consume();
    }//GEN-LAST:event_txtFieldPrecioUnitarioKeyTyped

    private void txtFieldCodiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldCodiKeyTyped
       int tecla = evt.getKeyChar();
      
      boolean num = tecla >= 48 && tecla <=57;
      
      if (!(num))
      {
      evt.consume();
      }
      if(this.txtFieldCodi.getText().length()== 5)
          evt.consume();
    }//GEN-LAST:event_txtFieldCodiKeyTyped

    private void txtFieldPrecio2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldPrecio2KeyTyped
        int tecla = evt.getKeyChar();
      
      boolean num = tecla >= 48 && tecla <=57;
      
      if (!(num))
      {
      evt.consume();
      }
      if(this.txtFieldPrecio2.getText().length()== 6)
          evt.consume();
    }//GEN-LAST:event_txtFieldPrecio2KeyTyped

    private void txtFieldCodBorrarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldCodBorrarKeyTyped
        int tecla = evt.getKeyChar();
      
      boolean num = tecla >= 48 && tecla <=57;
      
      if (!(num))
      {
      evt.consume();
      }
      if(this.txtFieldCodBorrar.getText().length()== 2)
          evt.consume();
    }//GEN-LAST:event_txtFieldCodBorrarKeyTyped

    private void txtFieldDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldDescripcionKeyTyped
          int tecla = evt.getKeyChar();
        
        boolean may = tecla >= 65 && tecla <= 90;
        boolean min = tecla >= 97 && tecla <= 122;
        boolean espacio = tecla == 32;
        
        if(!(may || min || espacio))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtFieldDescripcionKeyTyped

    private void txtFieldUnidadMedidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldUnidadMedidaKeyTyped
          int tecla = evt.getKeyChar();
        
        boolean may = tecla >= 65 && tecla <= 90;
        boolean min = tecla >= 97 && tecla <= 122;
        boolean espacio = tecla == 32;
        
        if(!(may || min || espacio))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtFieldUnidadMedidaKeyTyped

    private void txtFieldDesc2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldDesc2KeyTyped
          int tecla = evt.getKeyChar();
        
        boolean may = tecla >= 65 && tecla <= 90;
        boolean min = tecla >= 97 && tecla <= 122;
        boolean espacio = tecla == 32;
        
        if(!(may || min || espacio))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtFieldDesc2KeyTyped

    private void txtFieldUM2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldUM2KeyTyped
          int tecla = evt.getKeyChar();
        
        boolean may = tecla >= 65 && tecla <= 90;
        boolean min = tecla >= 97 && tecla <= 122;
        boolean espacio = tecla == 32;
        
        if(!(may || min || espacio))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtFieldUM2KeyTyped

    private void txtFieldDetBorrarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldDetBorrarKeyTyped
          int tecla = evt.getKeyChar();
        
        boolean may = tecla >= 65 && tecla <= 90;
        boolean min = tecla >= 97 && tecla <= 122;
        boolean espacio = tecla == 32;
        
        if(!(may || min || espacio))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtFieldDetBorrarKeyTyped

    private void btnTrue2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrue2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTrue2ActionPerformed

    private void txtFieldCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldCostKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCostKeyTyped

    private void txtFieldCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCostActionPerformed

    private void txtFieldCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldCostoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCostoKeyTyped

    private void txtFieldPrecioUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldPrecioUnitarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldPrecioUnitarioActionPerformed

    private void txtFieldCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCostoActionPerformed

    private void txtFieldUnidadMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldUnidadMedidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldUnidadMedidaActionPerformed

    private void txtFieldPrecio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldPrecio2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldPrecio2ActionPerformed

    private void txtFieldCodiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldCodiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCodiActionPerformed

    private Control ctrl;
    static private final String MODIFICACION = "Modificacion de productos";
    static private final String BUSCAR = "Buscar Producto";
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnConfirmarBorrar;
    private javax.swing.JRadioButton btnFalse;
    private javax.swing.JRadioButton btnFalse2;
    private javax.swing.ButtonGroup btnGroup2;
    private javax.swing.JButton btnModificar;
    private javax.swing.JRadioButton btnTrue;
    private javax.swing.JRadioButton btnTrue2;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblExistencia;
    private javax.swing.JLabel lblExistencia1;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JTextField txtFieldBusqueda;
    private javax.swing.JTextField txtFieldBusqueda1;
    private javax.swing.JTextField txtFieldCodBorrar;
    private javax.swing.JTextField txtFieldCodi;
    private javax.swing.JTextField txtFieldCodigo;
    private javax.swing.JTextField txtFieldCost;
    private javax.swing.JTextField txtFieldCosto;
    private javax.swing.JTextField txtFieldDesc2;
    private javax.swing.JTextField txtFieldDescripcion;
    private javax.swing.JTextField txtFieldDetBorrar;
    private javax.swing.JTextField txtFieldPrecio2;
    private javax.swing.JTextField txtFieldPrecioUnitario;
    private javax.swing.JTextField txtFieldUM2;
    private javax.swing.JTextField txtFieldUnidadMedida;
    // End of variables declaration//GEN-END:variables
}
