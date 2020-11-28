package es.studium.myavatar;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements InterfaceAvanzar, View.OnClickListener{
    Random rand = new Random();
    private Typeface script;
    private Typeface txtPrincipal;
    DialogoNombreAvatar nombreDialogo;
    DialogoSexo sexoDialogo;
    DialogoEspecie especieDialogo;
    DialogoProfesion profesionDialogo;
    ImageView imgAvatar;
    ImageView imgProfesion;


     Button   btn_crear;
     Button   btn_limpiar;
     EditText campoTextVida;
     EditText campoTextMagia;
     EditText campoTextFuerza;
     EditText campoTextVelocidad;
     EditText campoNombre;
     EditText campoSexo;
     String   fuente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //le asignamos a la variable el path donde se encuentra nuestra fuente
        fuente = "fuentes/sixty.ttf";
        //le asignamos a la instancia de Typeface la fuente
        this.script = Typeface.createFromAsset(getAssets(), fuente);
        //Botónes
        btn_crear = findViewById(R.id.btn_crearAvatar);
        btn_crear.setOnClickListener(this);
        btn_limpiar = findViewById(R.id.btn_limpiarAvatar);
        btn_limpiar.setOnClickListener(this);
        //Campos texto avatar
        campoNombre = findViewById(R.id.textAvatar);
        campoSexo = findViewById(R.id.textSexo);
        campoTextVida = findViewById(R.id.editTextNumberVida);
        campoTextMagia = findViewById(R.id.editTextNumberMagia);
        campoTextFuerza = findViewById(R.id.editTextNumberFuerza);
        campoTextVelocidad = findViewById(R.id.editTextNumberVelocidad);
        //Campos de imágenes
        imgAvatar = findViewById(R.id.imageAvatar);
        imgProfesion = findViewById(R.id.imageProfesion);
        //Implementacion de fuentes en campos de texto
        campoNombre.setTypeface(script);
        campoTextVida.setTypeface(script);
        campoTextMagia.setTypeface(script);
        campoTextFuerza.setTypeface(script);
        campoTextVelocidad.setTypeface(script);
        btn_crear.setTypeface(script);
        btn_limpiar.setTypeface(script);

    }

    public void clickCrear (View v){

        nombreDialogo = new DialogoNombreAvatar();
        nombreDialogo.setCancelable(false);
        nombreDialogo.show(getSupportFragmentManager(), "Diálogo Nombre");

    }
    public void clickLimpiar (View v){

        campoNombre.setText("");
        campoSexo.setText("");
        campoTextVida.setText("");
        campoTextMagia.setText("");
        campoTextFuerza.setText("");
        campoTextVelocidad.setText("");
        imgAvatar.setImageResource(R.drawable.ic_ninja_katana_warrior_sword_japan_japanese_asian_assassin_icon_127297__1_);
        imgProfesion.setImageResource(R.drawable.icons8_escudo_de_pregunta_64);


    }
    @Override
    public void onClick(View v) {
        if(v.equals(btn_crear)){
            clickCrear(btn_crear);
        }else if (v.equals(btn_limpiar)){
            clickLimpiar(btn_limpiar);
        }
    }


    @Override
    public void setDatosDialogoNombre(String nombre)
    {
        campoNombre.setText(nombre);
    }

    @Override
    public void setDatosDialogoEspecie(String especie) {

        if(campoSexo.getText().toString().equals("Hombre")) {
            if (especie.equals("Elfo")) {
                imgAvatar.setImageResource(R.drawable.icons8_man_elf_96);
            } else if (especie.equals("Enano")) {
                imgAvatar.setImageResource(R.drawable.icons8_fairy_emoji_96);
            } else if (especie.equals("Humano")) {
                imgAvatar.setImageResource(R.drawable.icons8_morfeo_96);
            } else if (especie.equals("Hobbit")) {
                imgAvatar.setImageResource(R.drawable.icons8_frodo_96);
            }
        }else if (campoSexo.getText().toString().equals("Mujer")) {
            if (especie.equals("Elfo")) {
                imgAvatar.setImageResource(R.drawable.icons8_woman_elf_96);
            } else if (especie.equals("Enano")) {
                imgAvatar.setImageResource(R.drawable.icons8_woman_fairy_96);
            } else if (especie.equals("Humano")) {
                imgAvatar.setImageResource(R.drawable.icons8_mujer_maravilla_96);
            } else if (especie.equals("Hobbit")) {
                imgAvatar.setImageResource(R.drawable.icons8_frodo_mujer);
            }
        }
    }

    @Override
    public void setDatosDialogoSexo(String sexo) {
        campoSexo.setText(sexo);
    }

    @Override
    public void setDatosDialogoProfesion(String profesion) {

        if (profesion.equals("Arquero")){
            imgProfesion.setImageResource(R.drawable.icons8_arco_de_arqueros_96);
        }else if (profesion.equals("Guerrero")){
            imgProfesion.setImageResource(R.drawable.icons8_espada_80);
        }else if (profesion.equals("Mago")){
            imgProfesion.setImageResource(R.drawable.icons8_mago_personal_100);
        }else if (profesion.equals("Herrero")){
            imgProfesion.setImageResource(R.drawable.icons8_martillo_y_yunque_100);
        }else if (profesion.equals("Minero")){
            imgProfesion.setImageResource(R.drawable.icons8_fiebre_dorada_128);
        }
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
        especieDialogo.setCancelable(false);
        especieDialogo.show(getSupportFragmentManager(), "Diálogo Especie");
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
        campoTextMagia.setText("   "+magia+" puntos de MAGICA");
        int fuerza = rand.nextInt(20)+1;
        campoTextFuerza.setText("   "+fuerza+" puntos de POWER");
        int velocidad = rand.nextInt(5)+1;
        campoTextVelocidad.setText("   "+velocidad+" puntos de SPEED");
    }


}