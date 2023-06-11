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
            if (gimnasio.getNombre().toLowerCase().contains(nombreEntrada)) {
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

    // Métodos de orden por inserción
    public static ArrayList<Gimnasio> ordenaGimnasiosNombreIS(ArrayList<Gimnasio> lista) {
        int tamano = lista.size();
        for (int i = 1; i < tamano; ++i) {
            Gimnasio actualGim = lista.get(i);
            int j = i - 1;

            while (j >= 0 && lista.get(j).getNombre().compareTo(actualGim.getNombre()) > 0) {
                lista.set(j + 1, lista.get(j));
                j = j - 1;
            }

            lista.set(j + 1, actualGim);
        }
        return lista;
    }
    
    public static ArrayList<Gimnasio> ordenaGimnasiosMaquinasIS(ArrayList<Gimnasio> lista) {
        int tamano = lista.size();
        for (int i = 1; i < tamano; ++i) {
            Gimnasio actualGim = lista.get(i);
            int j = i - 1;

            while (j >= 0 && lista.get(j).getNumeroMaquinas() >= actualGim.getNumeroMaquinas()) {
                lista.set(j + 1, lista.get(j));
                j = j - 1;
            }

            lista.set(j + 1, actualGim);
        }
        return lista;
    }
    
    // Métodos de orden por MergeSort
    public static ArrayList<Gimnasio> ordenaGimnasiosNombreMS(ArrayList<Gimnasio> lista) {
        if (lista.size() <= 1) {
            return lista;
        }

        int medio = lista.size() / 2;
        ArrayList<Gimnasio> listaIzq = new ArrayList<>(lista.subList(0, medio));
        ArrayList<Gimnasio> listaDer = new ArrayList<>(lista.subList(medio, lista.size()));

        return unirPorNombre(ordenaGimnasiosNombreMS(listaIzq), ordenaGimnasiosNombreMS(listaDer));
    }

    private static ArrayList<Gimnasio> unirPorNombre(ArrayList<Gimnasio> listaIzq, ArrayList<Gimnasio> listaDer) {
        ArrayList<Gimnasio> listaUnida = new ArrayList<>();
        int indexIzq = 0, indexDer = 0;

        // Merge
        while (indexIzq < listaIzq.size() && indexDer < listaDer.size()) {
            if (listaIzq.get(indexIzq).getNombre().compareTo(listaDer.get(indexDer).getNombre()) < 0) {
                listaUnida.add(listaIzq.get(indexIzq++));
            } else {
                listaUnida.add(listaDer.get(indexDer++));
            }
        }

        // Copy remaining elements of leftList if any
        while (indexIzq < listaIzq.size()) {
            listaUnida.add(listaIzq.get(indexIzq++));
        }

        // Copy remaining elements of rightList if any
        while (indexDer < listaDer.size()) {
            listaUnida.add(listaDer.get(indexDer++));
        }

        return listaUnida;
    }
    
    public static ArrayList<Gimnasio> ordenaGimnasiosMaquinasMS(ArrayList<Gimnasio> lista, int izq, int der) {
        if (izq < der) {
            int medio = (izq + der) / 2;

            // Ordena cada parte
            ordenaGimnasiosMaquinasMS(lista, izq, medio);
            ordenaGimnasiosMaquinasMS(lista, medio + 1, der);

            // Mezcla o hace el merge de ambas
            unirPorMaquinas(lista, izq, medio, der);
        }
        return lista;
    }

    public static void unirPorMaquinas(ArrayList<Gimnasio> lista, int izq, int medio, int der) {
        // Busca los tamaños
        int n1 = medio - izq + 1;
        int n2 = der - medio;

        // Crea los arrayLists temporales
        ArrayList<Gimnasio> L = new ArrayList<>(n1);
        ArrayList<Gimnasio> R = new ArrayList<>(n2);

        for (int i = 0; i < n1; ++i)
            L.add(i, lista.get(izq + i));
        for (int j = 0; j < n2; ++j)
            R.add(j, lista.get(medio + 1 + j));



        // Estos son los índices iniciales de los subarrays
        int i = 0, j = 0;

        int k = izq;
        while (i < n1 && j < n2) {
            if (L.get(i).getNumeroMaquinas() <= R.get(j).getNumeroMaquinas()) {
                lista.set(k, L.get(i));
                i++;
            } else {
                lista.set(k, R.get(j));
                j++;
            }

            k++;
        }

        // Copia los elementos sobrantes de L
        while (i < n1) {
            lista.set(k, L.get(i));
            i++;
            k++;
        }

        // Copia los elementos sobrantes de R
        while (j < n2) {
            lista.set(k, R.get(j));
            j++;
            k++;
        }
    }
}