package proyecto.android.ingesis.uniquindio.edu.co.campusuq.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import proyecto.android.ingesis.uniquindio.edu.co.campusuq.R;
import proyecto.android.ingesis.uniquindio.edu.co.campusuq.fragment.ListaDeNoticiasFragment;
import proyecto.android.ingesis.uniquindio.edu.co.campusuq.vo.Noticia;

/**
 * Created by admin on 03/05/2016.
 */
public class AdaptadorDeNoticias extends RecyclerView.Adapter<AdaptadorDeNoticias.noticiaViewHolder>

{

    private ArrayList<Noticia> noticias;

    private static OnClickAdaptadorDeNoticia listener;


    public AdaptadorDeNoticias(ArrayList<Noticia>Noticias, ListaDeNoticiasFragment listaDeNoticiasFragment) {
        this.noticias= noticias;
        listener= (OnClickAdaptadorDeNoticia) listaDeNoticiasFragment;
    }


    @Override
    public noticiaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resumen_de_noticia, parent, false);
        noticiaViewHolder noticiaVH = new noticiaViewHolder(itemView);
        return noticiaVH;
    }
    /**
     * Metodo que visualizar los datos en la posicion especifica
     * @param holder, la vista a ser visualizada
     * @param position, la posicion de la vista.
     */
    @Override
    public void onBindViewHolder(noticiaViewHolder holder, int position) {
        Noticia n = noticias.get(position);
        holder.binNoticia(n);

    }


    @Override
    public int getItemCount() {
        return noticias.size();
    }

    public static class noticiaViewHolder
            extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txtTitulo;
        private TextView txtAnio;


        public noticiaViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtTitulo = (TextView) itemView.findViewById(R.id.titulo);
            txtAnio = (TextView) itemView.findViewById(R.id.anio);

        }

        public void binNoticia(Noticia n)
        {
            txtTitulo.setText(n.getTitulo());
            txtAnio.setText(n.getAnio());
        }

        @Override
        public void onClick(View v) {
            listener.onClickPosition(getAdapterPosition());
            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. " + txtTitulo.getText());

        }
    }

    public interface OnClickAdaptadorDeNoticia{
        public void onClickPosition(int pos);
    }




}
