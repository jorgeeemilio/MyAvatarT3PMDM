package es.studium.myavatar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements InterfaceAvanzar, View.OnClickListener{
    Random rand = new Random();
    DialogFragment nombreDialogo;
    DialogFragment sexoDialogo;
    DialogFragment especieDialogo;
    DialogFragment profesionDialogo;

    private Button   btn_crear;
    private EditText campoTextVida;
    private EditText campoTextMagia;
    private EditText campoTextFuerza;
    private EditText campoTextVelocidad;
    private EditText campoNombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_crear = findViewById(R.id.btn_crearAvatar);
        btn_crear.setOnClickListener(this);
        campoNombre = findViewById(R.id.textAvatar);
        campoTextVida = findViewById(R.id.editTextNumberVida);
        campoTextMagia = findViewById(R.id.editTextNumberMagia);
        campoTextFuerza = findViewById(R.id.editTextNumberFuerza);
        campoTextVelocidad = findViewById(R.id.editTextNumberVelocidad);

    }

    public void clickCrear (View v){

        nombreDialogo = new DialogoNombreAvatar();
        nombreDialogo.setCancelable(false);
        nombreDialogo.show(getSupportFragmentManager(), "Diálogo Nombre");

    }
    @Override
    public void onClick(View v) {
        if(v.equals(btn_crear)){
            clickCrear(btn_crear);
}
    }


    @Override
    public void setDatosDialogoNombre(String nombre) {
        campoNombre.setText(nombre);
    }

    @Override
    public void setDatosDialogoEspecie(String especie) {

    }

    @Override
    public void setDatosDialogoSexo(String sexo) {

    }

    @Override
    public void setDatosDialogoProfesion(String profesion) {

    }

    @Override
    public void ejecutarSegundoDialogo() {

        sexoDialogo = new DialogoSexo();
        sexoDialogo.setCancelable(false);
        sexoDialogo.show(getSupportFragmentManager(), "Diálogo Sexo");

    }

    @Override
    public void ejecutarTercerDialogo() {

        especieDialogo = new DialogoEspecie();
        sexoDialogo.setCancelable(false);
        sexoDialogo.show(getSupportFragmentManager(), "Diálogo Especie");
    }

    @Override
    public void ejecutarCuartoDialogo() {
        profesionDialogo = new DialogoProfesion();
        profesionDialogo.setCancelable(false);
        profesionDialogo.show(getSupportFragmentManager(), "Diálogo Profesión");
    }

    @Override
    public void randomStats() {

        int vida = rand.nextInt(100 - 1)+1;
        campoTextVida.setText("   "+vida+" puntos de HP");
        int magia = rand.nextInt(10 - 1)+1;
        campoTextMagia.setText("   "+magia+" puntos de MG");
        int fuerza = rand.nextInt(20 - 1)+1;
        campoTextFuerza.setText("   "+fuerza+" puntos de PW");
        int velocidad = rand.nextInt(5 - 1)+1;
        campoTextVelocidad.setText("   "+velocidad+" puntos de SP");
    }


}