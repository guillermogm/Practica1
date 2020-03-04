package net.ausiasmarch.estadistica.utils;


import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.JTable;
import javax.swing.JToolTip;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class Grid extends JTable {

    private final DefaultTableModel defaultTableModel = new DefaultTableModel();
    private final DefaultTableCellRenderer defaultTableCellRenderer
            = new DefaultTableCellRenderer();

    // Para los toolTip (etiquetas) de columnas del grid
    private Map<Integer, String> mapToolTipColumns;
    private Color toolTipForegroundColor = super.createToolTip().getForeground();
    private Color toolTipBackgroundColor = super.createToolTip().getBackground();

    // Constructor
    public SimpleTableModel getSimpleTableModel() {
        try {
            return (SimpleTableModel) super.getModel();
        } catch (Exception ex) {
            super.setModel(new SimpleTableModel(super.getModel()));
            return (SimpleTableModel) super.getModel();
        }
    }

    // Establece el map de toolTips
    public void setToolTipColumns(Map<Integer, String> mapToolTipColumns) {
        this.mapToolTipColumns = mapToolTipColumns;
    }

    // Establece el color de los toolTips
    public void setColorToolTip(Color foregroundColor, Color backgroundColor) {
        toolTipForegroundColor = foregroundColor;
        toolTipBackgroundColor = backgroundColor;
    }

    @Override
    // Establece el valor de una columna en una fila
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        getSimpleTableModel().setValue(rowIndex, columnIndex, value);
    }

    // Limpia el contenido del grid
    public void clear() {
        getSimpleTableModel().clear();
    }

    // Oculta una columna
    public void hideColumn(int column) {
        this.getColumnModel().removeColumn(this.getColumnModel().getColumn(column));
    }

    // Establece los identificadores de las cabecera de columna
    public void setColumnIdentifiers(String[] columns) {
        defaultTableModel.setColumnIdentifiers(columns);
        this.setModel(defaultTableModel);
    }

    //Establece el numero de filas del grid
    public void setNumRows(int numRows) {
        defaultTableModel.setNumRows(numRows);
        this.setModel(defaultTableModel);
    }

    //Establece el ancho de una columna
    public void widthColumn(int indexColumn, int width) {
        getColumnModel().getColumn(indexColumn).setMinWidth(width);
        getColumnModel().getColumn(indexColumn).setMaxWidth(width);
    }

    //Establece el ancho de las columnas
    public void widthColumns(int[] indexColumn, int[] width) {
        for (int i = 0; i < indexColumn.length; i++) {
            getColumnModel().getColumn(indexColumn[i]).setMinWidth(width[i]);
            getColumnModel().getColumn(indexColumn[i]).setMaxWidth(width[i]);
        }
    }

    // Ordena el grid por la columna en la que se hace click
    public void gridRowSorted(TableModel model) {
        TableRowSorter<TableModel> ordena = new TableRowSorter<>(model);
        setRowSorter(ordena);
    }

    // Se mueve a la fila especificada
    public void moveToRow(int row) {
        Rectangle cellRect = this.getCellRect(row, 0, false);
        if (cellRect != null) {
            scrollRectToVisible(cellRect);
            addRowSelectionInterval(row, row);
        }
    }

    // Se mueve a la primera fila
    public void firstRow() {
        moveToRow(0);
    }

    // Se mueve a la ultima fila
    public void lastRow() {
        moveToRow(getRowCount() - 1);
        System.out.println(getSelectedRow());
    }

    // Se mueve a la siguiente fila
    public void nextRow() {
        int row = this.getSelectedRow() + 1;
        if (row < getRowCount()) {
            moveToRow(row);
        }
    }

    // Se mueve a la siguiente fila
    public void previusRow() {
        int row = getSelectedRow() - 1;
        if (row >= 0) {
            moveToRow(row);
        }
    }

    // Obtiene el indice de la columna de la cabecera sobre la que se hizo click
    public int getColumnHeader(MouseEvent evt) {
        //     JTable table = ((JTableHeader) evt.getSource()).getTable();
        TableColumnModel colModel = getColumnModel();

        // El indice de la columna de cabecera en la que se hizo click
        int vColIndex = colModel.getColumnIndexAtX(evt.getX());

        // Return -1 si no se hizo click en una cabecera de columna
        if (vColIndex != -1) {
            return convertColumnIndexToModel(vColIndex) + 1;
        }
        return vColIndex;
    }

    // Obtiene el numero de fila a partir del valor y el numero de una columna
    public int getRowFromColumnValue(Object value, int column) {
        int fila = -1;
        for (int i = 0; i < getRowCount(); i++) {
            if (getValueAt(i, column).equals(value)) {
                fila = i;
                break;
            }
        }
        return fila;
    }

    // Alinea horizontalmente el contenido de una columna
    public void setHorizontalAlignColumn(int column, int aling) {
        defaultTableCellRenderer.setHorizontalAlignment(aling);
        this.getColumnModel().getColumn(column).setCellRenderer(defaultTableCellRenderer);
    }

    // Alinea verticalmente el contenido de una columna
    public void setVerticalAlignColumn(int column, int aling) {
        defaultTableCellRenderer.setVerticalAlignment(aling);
        this.getColumnModel().getColumn(column).setCellRenderer(defaultTableCellRenderer);
    }

    // Oculta o hace visible el contenido de una columna
    public void setVisibleColumn(int column, boolean flag) {
        defaultTableCellRenderer.setVisible(flag);
        this.getColumnModel().getColumn(column).setCellRenderer(defaultTableCellRenderer);
    }

    // Carga este grid con un List<List> y un array de imagenes
    public void loadFromList(List<List> lista, Object[] images, String[] columnNames) {
        setTypeColumn(lista.get(0), images, columnNames);
        fillFromList(lista, images);
    }

    // Carga este grid con un List<List> 
    public void loadFromList(List<List> lista, String[] columnNames) {
        setTypeColumn(lista.get(0), null, columnNames);
        fillFromList(lista);
    }

    // Rellena este grid con un List<List> y un array de imagenes
    public void fillFromList(List<List> lista, Object[] objects) {
        int i = 0, col = 0, num;

        for (List sLista : lista) {
            num = sLista.size();
            for (int j = 0; j < num; j++) {
                setValueAt(sLista.get(j), i, j);
            }
            col = num - 1;
            // Agregamos imagenes en columnas restantes
            for (int j = 0; j < objects.length; j++) {
                setValueAt(objects[j], i, j + col + 1);
            }
            i++;
        }
    }

    // Rellena este grid con un List<List>
    public void fillFromList(List<List> lista) {
        int i = 0;
        for (List sLista : lista) {
            for (int j = 0; j < sLista.size(); j++) {
                setValueAt(sLista.get(j), i, j);
            }
            i++;
        }
    }

    public void setTypeColumn(List lista, Object[] images, String[] columns) {
        TableModel tb = images != null ? getModeloGridImages(lista, images, columns)
                : getModeloGrid(lista, columns);
        setModel(tb);
    }

    private TableModel getModeloGrid(List lista, String[] columns) {
        List<Class> colClass = new ArrayList<>();
        for (Object o : lista) {
            Class klass = o == null ? Object.class : o.getClass();
            colClass.add(klass);
        }
        return new GridModel(colClass, columns);
    }

    private TableModel getModeloGridImages(List lista, Object[] objects, String[] columns) {
        List<Class> colClass = new ArrayList<>();
        Class klass;
        for (Object o : lista) {
            klass = o == null ? Object.class : o.getClass();
            colClass.add(klass);
        }

        if (objects != null) {
            for (Object o : objects) {
                klass = o == null ? Object.class : o.getClass();
                colClass.add(klass);
            }
        }

        return new GridModel(colClass, columns);
    }

    /**
     * Modelo de datos para el grid que establece el tipo y nombre de cada
     * columna
     */
    private class GridModel extends DefaultTableModel {

        List<Class> colClass = new ArrayList<>();
        String[] colNames;

        public GridModel(List colClass, String[] colNames) {
            this.colClass = colClass;
            this.colNames = colNames;
        }

        @Override
        public Class getColumnClass(int column) {
            return colClass.get(column);
        }

        @Override
        public String getColumnName(int column) {
            return (String) colNames[column];
        }

    }

    // Metodos para poner ToolTipText a las celdas    
    @Override
    public String getToolTipText(MouseEvent e) {
        String tip = null;
        Point p = e.getPoint();
        int colIndex = columnAtPoint(p);
        int realColumnIndex = convertColumnIndexToModel(colIndex);
        if (mapToolTipColumns != null) {
            for (Entry<Integer, String> entry : mapToolTipColumns.entrySet()) {
                if (realColumnIndex == entry.getKey()) {
                    tip = entry.getValue();
                    break;
                } else {
                    tip = super.getToolTipText(e);
                }
            }
        }
        return tip;
    }

    @Override
    public JToolTip createToolTip() {
        JToolTip toolTip = super.createToolTip();
        toolTip.setBackground(toolTipBackgroundColor);
        toolTip.setForeground(toolTipForegroundColor);
        return toolTip;
    }

    // Color de la cabecera
    public void setColorHeader(Color background, Color foreground) {
        getTableHeader().setBackground(background);
        getTableHeader().setForeground(foreground);
    }
   
}
