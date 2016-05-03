package proyecto.android.ingesis.uniquindio.edu.co.campusuq.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.GpsStatus;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

import proyecto.android.ingesis.uniquindio.edu.co.campusuq.R;
import proyecto.android.ingesis.uniquindio.edu.co.campusuq.activity.NoticiasActualesActivity;
import proyecto.android.ingesis.uniquindio.edu.co.campusuq.util.AdaptadorDeNoticias;
import proyecto.android.ingesis.uniquindio.edu.co.campusuq.util.Utilidades;
import proyecto.android.ingesis.uniquindio.edu.co.campusuq.vo.Noticia;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaDeNoticiasFragment extends Fragment implements AdaptadorDeNoticias.OnClickAdaptadorDeNoticia {



    private RecyclerView listadoDeNoticias ;
    private ArrayList<Noticia> noticias;
    private AdaptadorDeNoticias adaptador;
    private OnNoticiaSeleccionadaListener listener;


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
        noticias = new ArrayList();
        noticias.add(new Noticia("Interestelar", "2015"));
        noticias.add(new Noticia("El Padrino", "2015"));
        noticias.add(new Noticia("Regreso al futuro", "2015"));
        noticias.add(new Noticia("Titanic", "2014"));
        noticias.add(new Noticia("Star Wars", "2014"));
        noticias.add(new Noticia("El bueno, el malo y el feo", "2014"));
        noticias.add(new Noticia("La Pantera Rosa", "2015"));
        noticias.add(new Noticia("Interestelar", "2015"));
        noticias.add(new Noticia("El Padrino", "2015"));
        noticias.add(new Noticia("Regreso al futuro", "2015"));
        noticias.add(new Noticia("Titanic", "2014"));
        noticias.add(new Noticia("Star Wars", "2014"));
        noticias.add(new Noticia("El bueno, el malo y el feo", "2014"));
        noticias.add(new Noticia("La Pantera Rosa", "2015"));
        listadoDeNoticias= (RecyclerView) getView().findViewById(R.id.RecView);

        adaptador = new AdaptadorDeNoticias(noticias,this);

        listadoDeNoticias.setAdapter(adaptador);
        listadoDeNoticias.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_de_noticia, container, false);
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
        int id = item.getItemId();

      if(id == R.id.Lenguaje) {
          Utilidades.cambiarIdioma(getContext());
            Intent intent = getActivity().getIntent();
          getActivity().finish();
          startActivity(intent);
          return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClickPosition(int pos) {
        listener.onNoticiaSeleccionada(pos);
    }


    public interface OnNoticiaSeleccionadaListener
    {
        void onNoticiaSeleccionada(int position);
    }









}
