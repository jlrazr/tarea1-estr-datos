
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.AbstractTableModel;

class ListaGimnasios extends AbstractTableModel {
    private ArrayList<Gimnasio> gimnasios;
    private final String[] columnNames = {"ID", "Nombre", "Número de máquinas", "Incluye Crossfit", "Promedio de clientes por mes"};

    public ListaGimnasios(Iterator<Gimnasio> gymIterator) {
        this.gimnasios = new ArrayList<>();
        while (gymIterator.hasNext()) {
            this.gimnasios.add(gymIterator.next());
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return gimnasios.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        Gimnasio gym = gimnasios.get(row);
        switch(col) {
            case 0:
                return gym.getId();
            case 1:
                return gym.getNombre();
            case 2:
                return gym.getNumeroMaquinas();
            case 3:
                return gym.getIncluyeCrossfit();
            case 4:
                return gym.getClientesPorMes();
            default:
                return null;
        }
    }

    @Override
    public Class getColumnClass(int col) {
        return getValueAt(0, col).getClass();
    }
}