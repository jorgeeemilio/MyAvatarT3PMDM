package es.studium.myavatar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;


import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements InterfaceAvanzar, View.OnClickListener{
    Random rand = new Random();
    DialogoNombreAvatar nombreDialogo;
    DialogoSexo sexoDialogo;
    DialogoEspecie especieDialogo;
    DialogoProfesion profesionDialogo;
    ImageView imgAvatar;
    ImageView imgProfesion;


    Button   btn_crear;
     EditText campoTextVida;
     EditText campoTextMagia;
     EditText campoTextFuerza;
     EditText campoTextVelocidad;
     EditText campoNombre;

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
        imgAvatar = findViewById(R.id.imageAvatar);
        imgProfesion = findViewById(R.id.imageProfesion);
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
    public void setDatosDialogoNombre(String nombre)
    {
        campoNombre.setText(nombre);
    }

    @Override
    public void setDatosDialogoEspecie(String especie) {

        if (especie.equals("Elfo")){

        }else if (especie.equals("Enano")){

        }else if (especie.equals("Humano")){

        }else if (especie.equals("Hobbit")){

        }
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

        int vida = rand.nextInt(100)+1;
        campoTextVida.setText("   "+vida+" puntos de HP");
        int magia = rand.nextInt(10)+1;
        campoTextMagia.setText("   "+magia+" puntos de M");
        int fuerza = rand.nextInt(20)+1;
        campoTextFuerza.setText("   "+fuerza+" puntos de PW");
        int velocidad = rand.nextInt(5)+1;
        campoTextVelocidad.setText("   "+velocidad+" puntos de SP");
    }


}