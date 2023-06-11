public class Gimnasio {
    private final int id;
    private String nombre;
    private int numeroMaquinas;
    private boolean incluyeCrossfit;
    private int clientesPorMes;
    
    // Método Constructor
    public Gimnasio(int id, String nombre, int numeroMaquinas, boolean incluyeCrossfit, int clientesPorMes) {
        this.id = id;
        this.nombre = nombre;
        this.numeroMaquinas = numeroMaquinas;
        this.incluyeCrossfit = incluyeCrossfit;
        this.clientesPorMes = clientesPorMes;
    }
    
    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroMaquinas() {
        return numeroMaquinas;
    }

    public boolean getIncluyeCrossfit() {
        return incluyeCrossfit;
    }

    public int getClientesPorMes() {
        return clientesPorMes;
    }
    
    // Setters
        public void setGymName(String nombre) {
        this.nombre = nombre;
    }

    public void setNumberOfMachines(int numeroMaquinas) {
        this.numeroMaquinas = numeroMaquinas;
    }

    public void setIncludesCrossfit(boolean incluyeCrossfit) {
        this.incluyeCrossfit = incluyeCrossfit;
    }

    public void setAverageClientsPerMonth(int clientesPorMes) {
        this.clientesPorMes = clientesPorMes;
    }
}
