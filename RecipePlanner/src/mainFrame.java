
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin
 */
public class mainFrame extends javax.swing.JFrame {
    List<javax.swing.JLabel> ingredientLabelList;
    List<javax.swing.JComboBox> ingredientBoxList;
    List<javax.swing.JLabel> stepLabelList;
    List<javax.swing.JTextField> stepTextFieldList;
    /**
     * Creates new form mainFrame
     */
    public mainFrame() {
        ingredientLabelList = new ArrayList<>();
        ingredientBoxList = new ArrayList<>();
        stepLabelList = new ArrayList<>();
        stepTextFieldList = new ArrayList<>();
        initComponents();
        java.awt.GridBagConstraints gridBagConstraints;
        //create and add first ingredient label
        ingredientLabelList.add(new javax.swing.JLabel("Ingredient 1:"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        addIngredientPanel.add(ingredientLabelList.get(0), gridBagConstraints);

        //create and add first ingredient combo box
        ingredientBoxList.add(new javax.swing.JComboBox<>());
        ingredientBoxList.get(0).setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        addIngredientPanel.add(ingredientBoxList.get(0), gridBagConstraints);
        
        //create first step label
        //int stepLabelNum = stepLabelList.size();
        stepLabelList.add(new javax.swing.JLabel("Step 1:"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        addStepPanel.add(stepLabelList.get(0), gridBagConstraints);
        
        //create first step text field
        //int stepTextFieldNum = stepTextFieldList.size();
        stepTextFieldList.add(new javax.swing.JTextField());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        addStepPanel.add(stepTextFieldList.get(0), gridBagConstraints);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogAddItem = new javax.swing.JDialog();
        lblItemName_AddItem = new javax.swing.JLabel();
        txtboxItemName_AddItem = new javax.swing.JTextField();
        lblItemAmount_AddItem = new javax.swing.JLabel();
        txtboxItemAmount_AddItem = new javax.swing.JTextField();
        lblItemUnit_AddItem = new javax.swing.JLabel();
        cmbboxtemUnit_AddItem = new javax.swing.JComboBox<>();
        lblItemLocation_AddItem = new javax.swing.JLabel();
        txtboxItemLocation_AddItem = new javax.swing.JTextField();
        btnOk_AddItem = new javax.swing.JButton();
        btnCancel_AddItem = new javax.swing.JButton();
        dialogEditItem = new javax.swing.JDialog();
        lblItemName_EditItem = new javax.swing.JLabel();
        txtboxItemName_EditItem = new javax.swing.JTextField();
        lblItemAmount_EditItem = new javax.swing.JLabel();
        txtboxItemAmount_EditItem = new javax.swing.JTextField();
        lblItemUnit_EditItem = new javax.swing.JLabel();
        cmbboxtemUnit_EditItem = new javax.swing.JComboBox<>();
        lblItemLocation_EditItem = new javax.swing.JLabel();
        txtboxItemLocation_EditItem = new javax.swing.JTextField();
        btnOk_EditItem = new javax.swing.JButton();
        btnCancel_EditItem = new javax.swing.JButton();
        addRecipeDialog = new javax.swing.JDialog();
        addIngredientPanel = new javax.swing.JPanel();
        recipeNameLabel = new javax.swing.JLabel();
        recipeNameTextField = new javax.swing.JTextField();
        addIngredientButton = new javax.swing.JButton();
        addStepButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        addStepPanel = new javax.swing.JPanel();
        pnlTabbed = new javax.swing.JTabbedPane();
        pnlInventory = new javax.swing.JPanel();
        pnlSortby = new javax.swing.JPanel();
        cmbboxSortby = new javax.swing.JComboBox<>();
        lblSortby = new javax.swing.JLabel();
        btnAddItem = new javax.swing.JButton();
        btnEditItem = new javax.swing.JButton();
        paneInventory = new javax.swing.JScrollPane();
        tableInventory = new javax.swing.JTable();
        pnlRecipe = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recipesTable = new javax.swing.JTable();
        addRecipeButton = new javax.swing.JButton();

        dialogAddItem.setTitle("Add Item");

        lblItemName_AddItem.setText("Item Name:");

        lblItemAmount_AddItem.setText("Item Amount:");

        lblItemUnit_AddItem.setText("Item Unit:");

        cmbboxtemUnit_AddItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Teaspoon", "Tablespoon", "Fluid Ounce", "Cup", "Pint", "Quart", "Gallon", "Pound", "Ounce", "Gram", " ", " ", " " }));

        lblItemLocation_AddItem.setText("Item Location:");

        btnOk_AddItem.setText("Ok");

        btnCancel_AddItem.setText("Cancel");

        javax.swing.GroupLayout dialogAddItemLayout = new javax.swing.GroupLayout(dialogAddItem.getContentPane());
        dialogAddItem.getContentPane().setLayout(dialogAddItemLayout);
        dialogAddItemLayout.setHorizontalGroup(
            dialogAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogAddItemLayout.createSequentialGroup()
                .addGroup(dialogAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogAddItemLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(dialogAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dialogAddItemLayout.createSequentialGroup()
                                .addComponent(lblItemLocation_AddItem)
                                .addGap(18, 18, 18)
                                .addComponent(txtboxItemLocation_AddItem))
                            .addGroup(dialogAddItemLayout.createSequentialGroup()
                                .addGroup(dialogAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblItemName_AddItem)
                                    .addComponent(lblItemAmount_AddItem)
                                    .addComponent(lblItemUnit_AddItem))
                                .addGap(23, 23, 23)
                                .addGroup(dialogAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtboxItemName_AddItem)
                                    .addComponent(txtboxItemAmount_AddItem)
                                    .addGroup(dialogAddItemLayout.createSequentialGroup()
                                        .addComponent(cmbboxtemUnit_AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(dialogAddItemLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnOk_AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnCancel_AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)))
                .addContainerGap())
        );
        dialogAddItemLayout.setVerticalGroup(
            dialogAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogAddItemLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(dialogAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemName_AddItem)
                    .addComponent(txtboxItemName_AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemAmount_AddItem)
                    .addComponent(txtboxItemAmount_AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemUnit_AddItem)
                    .addComponent(cmbboxtemUnit_AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemLocation_AddItem)
                    .addComponent(txtboxItemLocation_AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk_AddItem)
                    .addComponent(btnCancel_AddItem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dialogEditItem.setTitle("Edit Item");

        lblItemName_EditItem.setText("Item Name:");

        lblItemAmount_EditItem.setText("Item Amount:");

        lblItemUnit_EditItem.setText("Item Unit:");

        cmbboxtemUnit_EditItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Teaspoon", "Tablespoon", "Fluid Ounce", "Cup", "Pint", "Quart", "Gallon", "Pound", "Ounce", "Gram", " ", " ", " " }));

        lblItemLocation_EditItem.setText("Item Location:");

        btnOk_EditItem.setText("Ok");

        btnCancel_EditItem.setText("Cancel");

        javax.swing.GroupLayout dialogEditItemLayout = new javax.swing.GroupLayout(dialogEditItem.getContentPane());
        dialogEditItem.getContentPane().setLayout(dialogEditItemLayout);
        dialogEditItemLayout.setHorizontalGroup(
            dialogEditItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogEditItemLayout.createSequentialGroup()
                .addGroup(dialogEditItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogEditItemLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(dialogEditItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dialogEditItemLayout.createSequentialGroup()
                                .addComponent(lblItemLocation_EditItem)
                                .addGap(18, 18, 18)
                                .addComponent(txtboxItemLocation_EditItem))
                            .addGroup(dialogEditItemLayout.createSequentialGroup()
                                .addGroup(dialogEditItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblItemName_EditItem)
                                    .addComponent(lblItemAmount_EditItem)
                                    .addComponent(lblItemUnit_EditItem))
                                .addGap(23, 23, 23)
                                .addGroup(dialogEditItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtboxItemName_EditItem)
                                    .addComponent(txtboxItemAmount_EditItem)
                                    .addGroup(dialogEditItemLayout.createSequentialGroup()
                                        .addComponent(cmbboxtemUnit_EditItem, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(dialogEditItemLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnOk_EditItem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnCancel_EditItem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)))
                .addContainerGap())
        );
        dialogEditItemLayout.setVerticalGroup(
            dialogEditItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogEditItemLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(dialogEditItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemName_EditItem)
                    .addComponent(txtboxItemName_EditItem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogEditItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemAmount_EditItem)
                    .addComponent(txtboxItemAmount_EditItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogEditItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemUnit_EditItem)
                    .addComponent(cmbboxtemUnit_EditItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogEditItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemLocation_EditItem)
                    .addComponent(txtboxItemLocation_EditItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogEditItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk_EditItem)
                    .addComponent(btnCancel_EditItem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addIngredientPanel.setLayout(new java.awt.GridBagLayout());

        recipeNameLabel.setText("Name:");

        addIngredientButton.setText("Add Additional Ingredient");
        addIngredientButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addIngredientButtonMouseClicked(evt);
            }
        });

        addStepButton.setText("Add Additional Step");
        addStepButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addStepButtonMouseClicked(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        addStepPanel.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout addRecipeDialogLayout = new javax.swing.GroupLayout(addRecipeDialog.getContentPane());
        addRecipeDialog.getContentPane().setLayout(addRecipeDialogLayout);
        addRecipeDialogLayout.setHorizontalGroup(
            addRecipeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRecipeDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addRecipeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addRecipeDialogLayout.createSequentialGroup()
                        .addComponent(recipeNameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(recipeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addRecipeDialogLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(addIngredientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                    .addComponent(addIngredientButton))
                .addGap(77, 77, 77)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(addRecipeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addStepButton)
                    .addComponent(addStepPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        addRecipeDialogLayout.setVerticalGroup(
            addRecipeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRecipeDialogLayout.createSequentialGroup()
                .addGroup(addRecipeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addRecipeDialogLayout.createSequentialGroup()
                        .addGroup(addRecipeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addRecipeDialogLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(addRecipeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(recipeNameLabel)
                                    .addComponent(recipeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addComponent(addIngredientButton))
                            .addGroup(addRecipeDialogLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(addStepButton)))
                        .addGroup(addRecipeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addRecipeDialogLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addIngredientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addRecipeDialogLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(addStepPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(addRecipeDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 470, 470));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 470, 470));
        setMaximumSize(new java.awt.Dimension(470, 470));
        setResizable(false);

        pnlTabbed.setRequestFocusEnabled(false);

        pnlSortby.setBackground(new java.awt.Color(255, 255, 255));
        pnlSortby.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cmbboxSortby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alphabetical A-Z", "Alphabetical Z-A", "Location", " " }));
        cmbboxSortby.setActionCommand("");

        lblSortby.setText("Sort By");

        javax.swing.GroupLayout pnlSortbyLayout = new javax.swing.GroupLayout(pnlSortby);
        pnlSortby.setLayout(pnlSortbyLayout);
        pnlSortbyLayout.setHorizontalGroup(
            pnlSortbyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSortbyLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(lblSortby)
                .addGap(94, 94, 94))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSortbyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbboxSortby, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSortbyLayout.setVerticalGroup(
            pnlSortbyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSortbyLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(lblSortby)
                .addGap(2, 2, 2)
                .addComponent(cmbboxSortby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        btnAddItem.setText("Add Item");

        btnEditItem.setText("Edit Item");

        tableInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item", "Amount", "Unit", "Location"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        paneInventory.setViewportView(tableInventory);

        javax.swing.GroupLayout pnlInventoryLayout = new javax.swing.GroupLayout(pnlInventory);
        pnlInventory.setLayout(pnlInventoryLayout);
        pnlInventoryLayout.setHorizontalGroup(
            pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInventoryLayout.createSequentialGroup()
                        .addComponent(pnlSortby, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnEditItem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(paneInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        pnlInventoryLayout.setVerticalGroup(
            pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSortby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEditItem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pnlTabbed.addTab("Inventory", pnlInventory);
        pnlInventory.getAccessibleContext().setAccessibleName("");
        pnlInventory.getAccessibleContext().setAccessibleDescription("");

        pnlRecipe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        recipesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Instructions", "Time", "Uses"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(recipesTable);

        addRecipeButton.setText("Add Recipe");
        addRecipeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addRecipeButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlRecipeLayout = new javax.swing.GroupLayout(pnlRecipe);
        pnlRecipe.setLayout(pnlRecipeLayout);
        pnlRecipeLayout.setHorizontalGroup(
            pnlRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRecipeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addRecipeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRecipeLayout.setVerticalGroup(
            pnlRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRecipeLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(addRecipeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pnlTabbed.addTab("Recipes", pnlRecipe);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTabbed, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTabbed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pnlTabbed.getAccessibleContext().setAccessibleName("");
        pnlTabbed.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addIngredientButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addIngredientButtonMouseClicked
        java.awt.GridBagConstraints gridBagConstraints;
        int ingredientLabelNum = ingredientLabelList.size();
        ingredientLabelList.add(new javax.swing.JLabel("Ingredient " + (ingredientLabelNum+1) + ":"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = ingredientLabelNum;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        addIngredientPanel.add(ingredientLabelList.get(ingredientLabelNum), gridBagConstraints);

        int ingredientBoxNum = ingredientBoxList.size();
        ingredientBoxList.add(new javax.swing.JComboBox<>());
        ingredientBoxList.get(ingredientBoxNum).setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 5", "Item 6", "Item 7", "Item 8" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = ingredientBoxNum;
        addIngredientPanel.add(ingredientBoxList.get(ingredientBoxNum), gridBagConstraints);
    }//GEN-LAST:event_addIngredientButtonMouseClicked

    private void addRecipeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addRecipeButtonMouseClicked
        addRecipeDialog.setVisible(true);
        addRecipeDialog.pack();
    }//GEN-LAST:event_addRecipeButtonMouseClicked

    private void addStepButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStepButtonMouseClicked
        //System.out.println("test");
        
        java.awt.GridBagConstraints gridBagConstraints;

        //create another step label
        int stepLabelNum = stepLabelList.size();
        System.out.println("Label: " + stepLabelNum);
        stepLabelList.add(new javax.swing.JLabel("Step " + (stepLabelNum+1) + ":"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = stepLabelNum;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        addStepPanel.add(stepLabelList.get(stepLabelNum), gridBagConstraints);
        
        //create first step text field
        int stepTextFieldNum = stepTextFieldList.size();
        System.out.println("Field: " + stepTextFieldNum);
        stepTextFieldList.add(new javax.swing.JTextField());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = stepTextFieldNum;
        addStepPanel.add(stepTextFieldList.get(stepTextFieldNum), gridBagConstraints);
    }//GEN-LAST:event_addStepButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addIngredientButton;
    private javax.swing.JPanel addIngredientPanel;
    private javax.swing.JButton addRecipeButton;
    private javax.swing.JDialog addRecipeDialog;
    private javax.swing.JButton addStepButton;
    private javax.swing.JPanel addStepPanel;
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnCancel_AddItem;
    private javax.swing.JButton btnCancel_EditItem;
    private javax.swing.JButton btnEditItem;
    private javax.swing.JButton btnOk_AddItem;
    private javax.swing.JButton btnOk_EditItem;
    private javax.swing.JComboBox<String> cmbboxSortby;
    private javax.swing.JComboBox<String> cmbboxtemUnit_AddItem;
    private javax.swing.JComboBox<String> cmbboxtemUnit_EditItem;
    private javax.swing.JDialog dialogAddItem;
    private javax.swing.JDialog dialogEditItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblItemAmount_AddItem;
    private javax.swing.JLabel lblItemAmount_EditItem;
    private javax.swing.JLabel lblItemLocation_AddItem;
    private javax.swing.JLabel lblItemLocation_EditItem;
    private javax.swing.JLabel lblItemName_AddItem;
    private javax.swing.JLabel lblItemName_EditItem;
    private javax.swing.JLabel lblItemUnit_AddItem;
    private javax.swing.JLabel lblItemUnit_EditItem;
    private javax.swing.JLabel lblSortby;
    private javax.swing.JScrollPane paneInventory;
    private javax.swing.JPanel pnlInventory;
    private javax.swing.JPanel pnlRecipe;
    private javax.swing.JPanel pnlSortby;
    private javax.swing.JTabbedPane pnlTabbed;
    private javax.swing.JLabel recipeNameLabel;
    private javax.swing.JTextField recipeNameTextField;
    private javax.swing.JTable recipesTable;
    private javax.swing.JTable tableInventory;
    private javax.swing.JTextField txtboxItemAmount_AddItem;
    private javax.swing.JTextField txtboxItemAmount_EditItem;
    private javax.swing.JTextField txtboxItemLocation_AddItem;
    private javax.swing.JTextField txtboxItemLocation_EditItem;
    private javax.swing.JTextField txtboxItemName_AddItem;
    private javax.swing.JTextField txtboxItemName_EditItem;
    // End of variables declaration//GEN-END:variables
}
