package proyecto.android.ingesis.uniquindio.edu.co.campusuq.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import proyecto.android.ingesis.uniquindio.edu.co.campusuq.R;
import proyecto.android.ingesis.uniquindio.edu.co.campusuq.fragment.ListaDeNoticiasFragment;

public class NoticiasActualesActivity extends AppCompatActivity implements ListaDeNoticiasFragment.OnNoticiaSeleccionadaListener {


    @Override
    public void onNoticiaSeleccionada(int position) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias_actuales);
    }
}
