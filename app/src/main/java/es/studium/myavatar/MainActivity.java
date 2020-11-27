package es.studium.myavatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements InterfaceAvanzar{
    Random rand = new Random();
    EditText campoTextVida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoTextVida = findViewById(R.id.editTextNumberVida);
    }

    @Override
    public void aceptarDialogo() {

    }

    @Override
    public void cancelarDialogo() {

    }

    @Override
    public void seleccionarDialogo() {

    }

    @Override
    public void setDatosDialogoNombre(String nombre) {

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

    }

    @Override
    public void ejecutarTercerDialogo() {

    }

    @Override
    public void ejecutarCuartoDialogo() {

    }

    @Override
    public void randomStats() {


        int vida = rand.nextInt(100 - 1)+1;
        campoTextVida.setText("   "+vida+" puntos de HP");
        int magia = rand.nextInt(10 - 1)+1;
        campoTextVida.setText("   "+magia+" puntos de MG");
        int fuerza = rand.nextInt(20 - 1)+1;
        campoTextVida.setText("   "+fuerza+" puntos de PW");
        int velocidad = rand.nextInt(5 - 1)+1;
        campoTextVida.setText("   "+velocidad+" puntos de SP");
    }
}