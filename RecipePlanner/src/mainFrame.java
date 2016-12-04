
import java.awt.GridBagConstraints;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

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
    Recipe currentRecipe;
//    java.awt.GridBagLayout viewRecipeInfoBagLayout;
//    java.awt.GridBagConstraints viewRecipeInfoConstraints;
    static List<Recipe> recipes;
    DefaultTableModel model;
    DefaultTableCellRenderer centerRenderer;
    private int selectedRecipeTableRowIndex;
    /**
     * Creates new form mainFrame
     */
    public mainFrame() {
        
        ingredientLabelList = new ArrayList<>();
        ingredientBoxList = new ArrayList<>();
        stepLabelList = new ArrayList<>();
        stepTextFieldList = new ArrayList<>();
        initComponents();
        this.setLocationRelativeTo(null);
//        viewRecipeInfoBagLayout = new java.awt.GridBagLayout();
//        viewRecipeInfoConstraints = new java.awt.GridBagConstraints();
        
        
        
        
        
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
        
        
        loadRecipes();
        model = (DefaultTableModel) viewRecipesTable.getModel();
        
    }

    private GridBagConstraints createInfoGbc(int col,int row){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = col;
        gbc.gridy = row;
        switch(col){
                case 0:
                    gbc.anchor = GridBagConstraints.WEST;
                    gbc.insets = new java.awt.Insets(0,0,0,20);
                    break;
                case 1:
                    gbc.anchor = GridBagConstraints.EAST;
                    gbc.insets = new java.awt.Insets(0,20,0,0);
                    break;
                default:
                    break;
        }
        return gbc;
    }
    public void displayRecipe(){
        selectedRecipeTableRowIndex = viewRecipesTable.convertRowIndexToModel(viewRecipesTable.getSelectedRow());
            
        currentRecipe = new Recipe(recipes.get(selectedRecipeTableRowIndex));
        recipeInfoName.setText(currentRecipe.getName());
        recipeInstructionsTextArea.setText(currentRecipe.getPrettyInstructions());
        //convert time to HH:MM:SS
        recipeInfoTime.setText(currentRecipe.getDisplayTime());

        int row = 0;
        //loop through ingredients of current recipe
        for(Ingredient i: currentRecipe.getIngredients()){

            //Add ingredient name in first column at current row
            javax.swing.JLabel ingredientName= new javax.swing.JLabel(i.getName());
            viewRecipeIngredientsPanel.add(ingredientName,createInfoGbc(0,row));

            //Add ingredient amount in second column at current row
            javax.swing.JLabel ingredientAmount= new javax.swing.JLabel(Integer.toString(i.getAmount())+" " +i.getUnitOfMeasure());
            viewRecipeIngredientsPanel.add(ingredientAmount,createInfoGbc(1,row));

            //go to next row
            row++;
        }
        recipeInfoDialog.setVisible(true);
        recipeInfoDialog.pack();
    }
    public static void loadRecipes(){
        recipes = new ArrayList<>();
        try{
            Recipe recipe = null;
            Ingredient tempIngredient = null;
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            InputStream in = new FileInputStream("recipeStorage.xml");
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            String elementName;
            while(eventReader.hasNext()){
                XMLEvent event = eventReader.nextEvent();
                
                if(event.isStartElement()){
                    StartElement startElement = event.asStartElement();
                    elementName = startElement.getName().getLocalPart();
                    switch(elementName){
                        case "Recipe":
                            recipe = new Recipe();
                            break;
                        case "RecipeId":
                            event = eventReader.nextEvent();
                            if(recipe!=null)
                                recipe.setId(Integer.parseInt(event.asCharacters().getData()));
                            break;
                        case "RecipeName":
                            event = eventReader.nextEvent();
                            if(recipe!=null)
                                recipe.setName(event.asCharacters().getData());
                            break;
                        case "Ingredient":
                            tempIngredient = new Ingredient();
                            break;
                        case "IngredientId":
                            event = eventReader.nextEvent();
                            if(tempIngredient!=null)
                                tempIngredient.setId(Integer.parseInt(event.asCharacters().getData()));
                            break;
                        case "IngredientName":
                            event = eventReader.nextEvent();
                            if(tempIngredient!=null)
                                tempIngredient.setName(event.asCharacters().getData());
                            break;
                        case "Amount":
                            event = eventReader.nextEvent();
                            if(tempIngredient != null)
                                tempIngredient.setAmount(Integer.parseInt(event.asCharacters().getData()));
                            break;
                        case "Unit":
                            event = eventReader.nextEvent();
                            if(tempIngredient != null)
                                tempIngredient.setUnitOfMeasure(event.asCharacters().getData());
                            break;
                        case "Instructions":
                            event = eventReader.nextEvent();
                            if(recipe!= null)
                                recipe.setInstructions(event.asCharacters().getData());
                            break;
                        case "Time":
                            event = eventReader.nextEvent();
                            if(recipe!=null)
                                recipe.setTime(Integer.parseInt(event.asCharacters().getData()));
                        default:
                            break;
                    }
                    continue;
                } 
                
                if(event.isEndElement()){
                    EndElement endElement = event.asEndElement();
                    elementName = endElement.getName().getLocalPart();
                    switch(elementName){
                        case "Ingredient":
                            if(recipe!=null&&tempIngredient!=null)
                                recipe.addIngredient(tempIngredient);
                            tempIngredient = null;
                            break;
                        case "Recipe":
                            if(recipe!=null)
                                recipes.add(recipe);
                            recipe = null;
                    }
                }
                
            }
        } catch(FileNotFoundException | XMLStreamException e){}
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addItemDialog = new javax.swing.JDialog();
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
        addRecipeDialog = new javax.swing.JDialog();
        addIngredientPanel = new javax.swing.JPanel();
        recipeNameLabel = new javax.swing.JLabel();
        recipeNameTextField = new javax.swing.JTextField();
        addIngredientButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        recipeInfoDialog = new javax.swing.JDialog();
        recipeInfoIngredients = new javax.swing.JLabel();
        viewRecipeIngredientsScrollPane = new javax.swing.JScrollPane();
        viewRecipeIngredientsPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        recipeInstructionsTextArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        recipeInfoName = new javax.swing.JLabel();
        recipeInfoTime = new javax.swing.JLabel();
        startRecipeButton = new javax.swing.JButton();
        recipeInfoCancel = new javax.swing.JButton();
        recipeStartedDialog = new javax.swing.JDialog();
        timerLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        mainPane = new javax.swing.JTabbedPane();
        pnlInventory = new javax.swing.JPanel();
        btnAddItem = new javax.swing.JButton();
        paneInventory = new javax.swing.JScrollPane();
        tableInventory = new javax.swing.JTable();
        pnlRecipe = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewRecipesTable = new javax.swing.JTable();
        addRecipeButton = new javax.swing.JButton();
        recipeFeedbackLabel = new javax.swing.JLabel();

        addItemDialog.setTitle("Add Item");

        lblItemName_AddItem.setText("Item Name:");

        lblItemAmount_AddItem.setText("Item Amount:");

        lblItemUnit_AddItem.setText("Item Unit:");

        cmbboxtemUnit_AddItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Teaspoon", "Tablespoon", "Fluid Ounce", "Cup", "Pint", "Quart", "Gallon", "Pound", "Ounce", "Gram", " ", " ", " " }));

        lblItemLocation_AddItem.setText("Item Location:");

        btnOk_AddItem.setText("Ok");

        btnCancel_AddItem.setText("Cancel");

        javax.swing.GroupLayout addItemDialogLayout = new javax.swing.GroupLayout(addItemDialog.getContentPane());
        addItemDialog.getContentPane().setLayout(addItemDialogLayout);
        addItemDialogLayout.setHorizontalGroup(
            addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addItemDialogLayout.createSequentialGroup()
                .addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addItemDialogLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addItemDialogLayout.createSequentialGroup()
                                .addComponent(lblItemLocation_AddItem)
                                .addGap(18, 18, 18)
                                .addComponent(txtboxItemLocation_AddItem))
                            .addGroup(addItemDialogLayout.createSequentialGroup()
                                .addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblItemName_AddItem)
                                    .addComponent(lblItemAmount_AddItem)
                                    .addComponent(lblItemUnit_AddItem))
                                .addGap(23, 23, 23)
                                .addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtboxItemName_AddItem)
                                    .addComponent(txtboxItemAmount_AddItem)
                                    .addGroup(addItemDialogLayout.createSequentialGroup()
                                        .addComponent(cmbboxtemUnit_AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(addItemDialogLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnOk_AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnCancel_AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)))
                .addContainerGap())
        );
        addItemDialogLayout.setVerticalGroup(
            addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addItemDialogLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemName_AddItem)
                    .addComponent(txtboxItemName_AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemAmount_AddItem)
                    .addComponent(txtboxItemAmount_AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemUnit_AddItem)
                    .addComponent(cmbboxtemUnit_AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemLocation_AddItem)
                    .addComponent(txtboxItemLocation_AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk_AddItem)
                    .addComponent(btnCancel_AddItem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addRecipeDialog.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        addIngredientPanel.setLayout(new java.awt.GridBagLayout());

        recipeNameLabel.setText("Name:");

        addIngredientButton.setText("Add Additional Ingredient");
        addIngredientButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addIngredientButtonMouseClicked(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel1.setText("Instructions:");

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
                        .addComponent(addIngredientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                    .addComponent(addIngredientButton))
                .addGap(77, 77, 77)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addRecipeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        addRecipeDialogLayout.setVerticalGroup(
            addRecipeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRecipeDialogLayout.createSequentialGroup()
                .addGroup(addRecipeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addRecipeDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addRecipeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(recipeNameLabel)
                            .addComponent(recipeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(addIngredientButton)
                        .addGap(12, 12, 12)
                        .addComponent(addIngredientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addRecipeDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addRecipeDialogLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        recipeInfoIngredients.setText("Ingredients");

        viewRecipeIngredientsPanel.setLayout(new java.awt.GridBagLayout());
        viewRecipeIngredientsScrollPane.setViewportView(viewRecipeIngredientsPanel);

        recipeInstructionsTextArea.setEditable(false);
        recipeInstructionsTextArea.setBackground(new java.awt.Color(238, 238, 238));
        recipeInstructionsTextArea.setColumns(20);
        recipeInstructionsTextArea.setRows(5);
        jScrollPane4.setViewportView(recipeInstructionsTextArea);

        jLabel2.setText("Instructions");

        recipeInfoName.setText("Recipe Name");

        recipeInfoTime.setText("00:00:00");

        startRecipeButton.setText("Start Recipe");
        startRecipeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startRecipeButtonActionPerformed(evt);
            }
        });

        recipeInfoCancel.setText("Cancel");
        recipeInfoCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recipeInfoCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout recipeInfoDialogLayout = new javax.swing.GroupLayout(recipeInfoDialog.getContentPane());
        recipeInfoDialog.getContentPane().setLayout(recipeInfoDialogLayout);
        recipeInfoDialogLayout.setHorizontalGroup(
            recipeInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recipeInfoDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(recipeInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(recipeInfoDialogLayout.createSequentialGroup()
                        .addGroup(recipeInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(viewRecipeIngredientsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(recipeInfoDialogLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(recipeInfoIngredients)))
                        .addGroup(recipeInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(recipeInfoDialogLayout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jLabel2))
                            .addGroup(recipeInfoDialogLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(recipeInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(recipeInfoDialogLayout.createSequentialGroup()
                                        .addComponent(recipeInfoTime)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(startRecipeButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(recipeInfoCancel))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(recipeInfoName))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        recipeInfoDialogLayout.setVerticalGroup(
            recipeInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recipeInfoDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(recipeInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recipeInfoName)
                    .addComponent(recipeInfoTime)
                    .addComponent(startRecipeButton)
                    .addComponent(recipeInfoCancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(recipeInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recipeInfoIngredients)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(recipeInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(viewRecipeIngredientsScrollPane)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                .addContainerGap())
        );

        timerLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        timerLabel.setText("Remaining: 00:00:00");

        jLabel4.setText("The used ingredients have been removed");

        jLabel5.setText("from the system.");

        javax.swing.GroupLayout recipeStartedDialogLayout = new javax.swing.GroupLayout(recipeStartedDialog.getContentPane());
        recipeStartedDialog.getContentPane().setLayout(recipeStartedDialogLayout);
        recipeStartedDialogLayout.setHorizontalGroup(
            recipeStartedDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recipeStartedDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(recipeStartedDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(recipeStartedDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                        .addComponent(timerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        recipeStartedDialogLayout.setVerticalGroup(
            recipeStartedDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, recipeStartedDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 470, 470));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 470, 470));
        setMaximumSize(new java.awt.Dimension(470, 470));
        setResizable(false);

        mainPane.setRequestFocusEnabled(false);
        mainPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                mainPaneStateChanged(evt);
            }
        });

        btnAddItem.setText("Add Item");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

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
                .addComponent(paneInventory, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInventoryLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlInventoryLayout.setVerticalGroup(
            pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddItem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPane.addTab("Inventory", pnlInventory);
        pnlInventory.getAccessibleContext().setAccessibleName("");
        pnlInventory.getAccessibleContext().setAccessibleDescription("");

        pnlRecipe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        viewRecipesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        viewRecipesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewRecipesTableMouseClicked(evt);
            }
        });
        viewRecipesTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                viewRecipesTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(viewRecipesTable);

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
                .addGroup(pnlRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlRecipeLayout.createSequentialGroup()
                        .addComponent(addRecipeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(recipeFeedbackLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        pnlRecipeLayout.setVerticalGroup(
            pnlRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRecipeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addRecipeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlRecipeLayout.createSequentialGroup()
                        .addComponent(recipeFeedbackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        mainPane.addTab("Recipes", pnlRecipe);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPane, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPane, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        mainPane.getAccessibleContext().setAccessibleName("");
        mainPane.getAccessibleContext().setAccessibleDescription("");

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

    private void mainPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mainPaneStateChanged
        switch(mainPane.getSelectedIndex()){
        case 1://view item
                model.setRowCount(0);
                //addRemovePanel.setVisible(false);
                if(recipes.size()>0){
                    for(Recipe r: recipes){
                        model.insertRow(model.getRowCount(),new Object[]{r.getName(),"Short Desc",r.getTime(),r.getNumUses()});
                    
                    }
                                                
                } else {
                    recipeFeedbackLabel.setText("No Recipes added");
                    mainPane.setSelectedIndex(2);
                }
            default:
        }
    }//GEN-LAST:event_mainPaneStateChanged

    private void viewRecipesTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_viewRecipesTableKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP){
            this.displayRecipe();
        }
    }//GEN-LAST:event_viewRecipesTableKeyReleased

    private void viewRecipesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewRecipesTableMouseClicked
        this.displayRecipe();
    }//GEN-LAST:event_viewRecipesTableMouseClicked

    private void recipeInfoCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recipeInfoCancelActionPerformed
        recipeInfoDialog.dispose();
    }//GEN-LAST:event_recipeInfoCancelActionPerformed

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        addItemDialog.setVisible(true);
        addItemDialog.pack();
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void startRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startRecipeButtonActionPerformed
        //an attempt at making a sound. Would add after timer finishes.
//        try{
//                java.applet.AudioClip clip = java.applet.Applet.newAudioClip(new URL("file://C:/Users/Matthew/Documents/NetBeansProjects/Recipe-Planner/RecipePlanner/HotelCalifornia.wav"));
//                clip.play();
//        } catch (java.net.MalformedURLException e){
//                System.out.println(e.toString());
//            }
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int time = currentRecipe.getTime();
            @Override
            public void run() {                
                
                timerLabel.setText("Remaining: " + (time/3600) + ":" + ((time/60)%60) + ":" + (time%60));
                if (time== 0){
                    timerLabel.setText("Timer Finished");
                    timer.cancel();  
                }
                time--;
            }
        }, 0, 1000);
        recipeStartedDialog.setLocationRelativeTo(recipeInfoDialog);
        recipeStartedDialog.setVisible(true);
        recipeStartedDialog.pack();
    }//GEN-LAST:event_startRecipeButtonActionPerformed

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
    private javax.swing.JDialog addItemDialog;
    private javax.swing.JButton addRecipeButton;
    private javax.swing.JDialog addRecipeDialog;
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnCancel_AddItem;
    private javax.swing.JButton btnOk_AddItem;
    private javax.swing.JComboBox<String> cmbboxtemUnit_AddItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblItemAmount_AddItem;
    private javax.swing.JLabel lblItemLocation_AddItem;
    private javax.swing.JLabel lblItemName_AddItem;
    private javax.swing.JLabel lblItemUnit_AddItem;
    private javax.swing.JTabbedPane mainPane;
    private javax.swing.JScrollPane paneInventory;
    private javax.swing.JPanel pnlInventory;
    private javax.swing.JPanel pnlRecipe;
    private javax.swing.JLabel recipeFeedbackLabel;
    private javax.swing.JButton recipeInfoCancel;
    private javax.swing.JDialog recipeInfoDialog;
    private javax.swing.JLabel recipeInfoIngredients;
    private javax.swing.JLabel recipeInfoName;
    private javax.swing.JLabel recipeInfoTime;
    private javax.swing.JTextArea recipeInstructionsTextArea;
    private javax.swing.JLabel recipeNameLabel;
    private javax.swing.JTextField recipeNameTextField;
    private javax.swing.JDialog recipeStartedDialog;
    private javax.swing.JButton startRecipeButton;
    private javax.swing.JTable tableInventory;
    private javax.swing.JLabel timerLabel;
    private javax.swing.JTextField txtboxItemAmount_AddItem;
    private javax.swing.JTextField txtboxItemLocation_AddItem;
    private javax.swing.JTextField txtboxItemName_AddItem;
    private javax.swing.JPanel viewRecipeIngredientsPanel;
    private javax.swing.JScrollPane viewRecipeIngredientsScrollPane;
    private javax.swing.JTable viewRecipesTable;
    // End of variables declaration//GEN-END:variables
}
