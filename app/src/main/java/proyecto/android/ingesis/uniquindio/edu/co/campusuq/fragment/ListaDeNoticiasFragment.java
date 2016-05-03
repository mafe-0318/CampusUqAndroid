package proyecto.android.ingesis.uniquindio.edu.co.campusuq.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import proyecto.android.ingesis.uniquindio.edu.co.campusuq.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaDeNoticiasFragment extends Fragment implements AdaptadorDeNoticias.OnClickAdaptadorDeNoticias {



    private RecyclerView listadoDePeliculas ;

    private ArrayList<Noticias> peliculas;

    private AdaptadorDePelicula adaptador;

    private OnPeliculaSeleccionadaListener listener;

    public ListaDeNoticiasFragment() {
        // Required empty public constructor
    }
    /**
     * Metodo que permite obtener las peliculas de la lista
     * @return las peliculas del arraylist
     */
    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }
    /**
     * Metodo que permite modificar las peliculas de la lista
     * @param peliculas, arraylist de peliculas a introducir en la lista
     */
    public void setPeliculas(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
    /**
     * Metodo que nos permite realizar las inicializaciones los componentes de la actividad
     * @param savedInstanceState, objeto de tipo Bundle que nos permite compartir datos entre activiades
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }
    /**
     * Metodo que nos permite la inicializacion de los elementos que van a ser agregados al reciclerView
     * @param savedInstanceState, objeto de tipo Bundle que nos permite compartir datos entre activiades
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        peliculas = new ArrayList();
        peliculas.add(new Pelicula("Interestelar", "2015"));
        peliculas.add(new Pelicula("El Padrino", "2015"));
        peliculas.add(new Pelicula("Regreso al futuro", "2015"));
        peliculas.add(new Pelicula("Titanic", "2014"));
        peliculas.add(new Pelicula("Star Wars", "2014"));
        peliculas.add(new Pelicula("El bueno, el malo y el feo", "2014"));
        peliculas.add(new Pelicula("La Pantera Rosa", "2015"));
        peliculas.add(new Pelicula("Interestelar", "2015"));
        peliculas.add(new Pelicula("El Padrino", "2015"));
        peliculas.add(new Pelicula("Regreso al futuro", "2015"));
        peliculas.add(new Pelicula("Titanic", "2014"));
        peliculas.add(new Pelicula("Star Wars", "2014"));
        peliculas.add(new Pelicula("El bueno, el malo y el feo", "2014"));
        peliculas.add(new Pelicula("La Pantera Rosa", "2015"));
        listadoDePeliculas= (RecyclerView) getView().findViewById(R.id.RecView);

        adaptador = new AdaptadorDePelicula(peliculas,this);

        listadoDePeliculas.setAdapter(adaptador);
        listadoDePeliculas.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }
    /**
     * Metodo que nos permite asociar el fragmento con un layout
     * @param inflater, el layout para inflar el fragmento
     * @param container, es la vista padre que contiene el fragmento.
     * @param savedInstanceState, bundle que nos permite guar estados.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_de_noticias, container, false);
    }
    /**
     * Metodo que nos permite asociar el fragmento a una actividad
     * @param context, el contexto del fragmento
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity;

        if(context instanceof Activity){
            activity = (Activity) context;

            try {
                listener= (OnPeliculaSeleccionadaListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnPeliculaSeleccionadaListener");
            }
        }

    }
    /**
     * Metodo que nos inflar  el menu
     * @param menu, el menu a ser inflado
     * @param inflater, el menuInflanter para ser agregado a el menu
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }
    /**
     * Metodo identificar que opcion es seleccionada y
     * relalizar las correspondientes acciones
     * @param item, el item seleccionado
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();if(id == R.id.menu_agregar) {

            Utilidades.mostrarDialigoAgregarPelicula(getActivity().getSupportFragmentManager(), PeliculasActualesActivity.class.getSimpleName());

        } else if(id == R.id.menu_eliminar) {
            peliculas.remove(0);
            adaptador.notifyItemRemoved(0);
        } else if(id == R.id.menu_modificar) {
            Pelicula aux = peliculas.get(1);
            peliculas.set(1, peliculas.get(2));
            peliculas.set(2, aux);
            adaptador.notifyItemMoved(1, 2);
        }else if(id == R.id.cambiar_idioma) {
            Utilidades.cambiarIdioma(getContext());
            Intent intent = getActivity().getIntent();
            getActivity().finish();
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /**
     * Metodo utlizado identificar la pelicula seleccionada
     * @param pos, la posicion presionada
     */
    @Override
    public void onClickPosition(int pos) {
        listener.onPeliculaSeleccionada(pos);
    }
    /**
     * Metodo utlizado para agregar una pelicula
     * @param pelicula, la pelicula que va ser agregada
     */
    public void agregarPelicula(Pelicula pelicula){
        peliculas.add(0, pelicula);
        adaptador.notifyItemInserted(0);
    }

    public interface OnPeliculaSeleccionadaListener {
        void onPeliculaSeleccionada(int position);
    }









}
