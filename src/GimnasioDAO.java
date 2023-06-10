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
    
    public void ActualizarGimnasio(Gimnasio gimnasio) {
        for (int i = 0; i < gimnasios.size(); i++) {
            if (gimnasios.get(i).getId() == gimnasio.getId()) {
                gimnasios.set(i, gimnasio);
                break;
            }
        }
    }
    
    public ArrayList<Gimnasio> FiltrarPorPromedio(int promedio) {
        ArrayList<Gimnasio> listaCoincidencias = new ArrayList<>();

        for (Gimnasio gimnasio : gimnasios) {
            if (gimnasio.getClientesPorMes() >= promedio) {
                listaCoincidencias.add(gimnasio);
            }
        }
        return listaCoincidencias;
    }

    public static ArrayList<Gimnasio> ordenaGimnasiosNombreMS(ArrayList<Gimnasio> lista) {
        int tamano = lista.size();
        for (int i = 1; i < tamano; ++i) {
            Gimnasio key = lista.get(i);
            int j = i - 1;

            while (j >= 0 && lista.get(j).getNombre().compareTo(key.getNombre()) > 0) {
                lista.set(j + 1, lista.get(j));
                j = j - 1;
            }

            lista.set(j + 1, key);
        }
        return lista;
    }
    
        public static ArrayList<Gimnasio> ordenaGimnasiosMaquinasMS(ArrayList<Gimnasio> lista) {
        int tamano = lista.size();
        for (int i = 1; i < tamano; ++i) {
            Gimnasio key = lista.get(i);
            int j = i - 1;

            while (j >= 0 && lista.get(j).getNumeroMaquinas() >= key.getNumeroMaquinas()) {
                lista.set(j + 1, lista.get(j));
                j = j - 1;
            }

            lista.set(j + 1, key);
        }
        return lista;
    }
}