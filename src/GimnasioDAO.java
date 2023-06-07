import java.util.ArrayList;

public class GimnasioDAO {
    public ArrayList<Gimnasio> gimnasios;
    public int gymIdsContador = 1;

    //Constructor
    public GimnasioDAO() {
        gimnasios = new ArrayList<>();
    }

    public void anadirGimnasio(int id, String nombre, int numeroMaquinas, boolean incluyeCrossfit, int clientesPorMes) {
        Gimnasio nuevoGimnasio = new Gimnasio(id, nombre, numeroMaquinas, incluyeCrossfit, clientesPorMes);
        gimnasios.add(nuevoGimnasio);
        gymIdsContador++;
    }

    public ArrayList<Gimnasio> obtenerGimnasios() {
        return gimnasios;
    }
    
    public ArrayList<Gimnasio> EncuentraPorNombre(String nombreEntrada) {
        ArrayList<Gimnasio> listaCoincidencias = new ArrayList<>();

        for (Gimnasio gimnasio : gimnasios) {
            if (gimnasio.getNombre().contains(nombreEntrada)) {
                listaCoincidencias.add(gimnasio);
            }
        }
        return listaCoincidencias;
    }

    /*
    public ArrayList<Gimnasio> FiltraPorPromedioClientes(int promedio, Iterator<Gimnasio> iterator) {
        // Devuelve un ArrayList vacío al no haber gimnasios
        if (!iterator.hasNext()) {
            return new ArrayList<>();
        }

        Gimnasio gym = iterator.next();

        // Este método se llama de manera recursiva
        ArrayList<Gimnasio> listaResultado = FiltraPorPromedioClientes(promedio, iterator);

        // añade el gimnasio si el valor obtenido es mayor o igual al ingresado
        if (gym.getClientesPorMes() >= promedio) {
            listaResultado.add(gym);
        }

        return listaResultado;
    };
    

    public void muestraResultadosFiltradosPromedio(int promedio, JTable tabla) {
        ArrayList<Gimnasio> matchingGyms = searchByAverageMonthlyUsers(promedio, gyms.iterator());
        tabla.setModel(new ListaGimnasios(matchingGyms));
    }

    
    public void ActualizarGimnasio(Gimnasio gimnasio) {
        // Assuming ID is the unique identifier for a gym
        for (int i = 0; i < gimnasios.size(); i++) {
            if (gimnasios.get(i).getId() == gimnasio.getId()) {
                gimnasios.set(i, gimnasio);
                break;
            }
        }
    }
    */
}