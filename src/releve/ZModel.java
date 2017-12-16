package releve;






import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author barry
 */
class ZModel extends AbstractTableModel {

    private Object[][] data;
    private String[] title;
   

    /**
     * Constructeur
     *
     * @param data
     * @param title
     */
    public ZModel(Object[][] data, String[] title) {
        this.data = data;
        this.title = title;
    }

    /**
     * Retourne le nombre de colonnes
     *
     */
    public int getColumnCount() {
        return this.title.length;
    }

    /**
     * Retourne le nombre de lignes
     *
     */
    public int getRowCount() {
        return this.data.length;
    }

    /**
     * Retourne la valeur à l'emplacement spécifié
     */
    public Object getValueAt(int row, int col) {
        return this.data[row][col];
    }

    public void setValueAt(Object val, int row, int col) {
         
        data[row][col] = val;
    }

    public String getColumnName(int col) {
        return this.title[col];
    }

    public Class getColumnClass(int col) {
//On retourne le type de la cellule à la colonne demandée
//On se moque de la ligne puisque les données sur chaque ligne sont les mêmes
//On choisit donc la première ligne
        return this.data[0][col].getClass();
    }

    public boolean isCellEditable(int row, int col) {
        return true;
    }

}
