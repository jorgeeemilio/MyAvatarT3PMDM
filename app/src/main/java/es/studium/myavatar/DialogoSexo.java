package es.studium.myavatar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import static es.studium.myavatar.R.layout.dlg_sexo;

public class DialogoSexo extends DialogFragment {
    InterfaceAvanzar dlgEscuchar;
    RadioButton rdbHombre;
    RadioButton rdbMujer;
    String txtGenero;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dlg_sexo, null));

        View MiVentanaDialogo = inflater.inflate(R.layout.dlg_sexo, null);

        //Creamos los vínculos con los strings
        rdbHombre = MiVentanaDialogo.findViewById(R.id.radioButtonHombre);
        rdbMujer = MiVentanaDialogo.findViewById(R.id.radioButtonMujer);

        builder.setView(MiVentanaDialogo)
                .setTitle(R.string.txt_dialogSexo)
                .setPositiveButton(R.string.txt_btnAceptarDialog, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //Creamos las condiciones de la selección realizada

                        if (rdbHombre.isChecked()) {
                            txtGenero = "VARÓN";
                            dlgEscuchar.setDatosDialogoSexo(txtGenero);
                            dlgEscuchar.ejecutarTercerDialogo();

                        } else if (rdbMujer.isChecked()) {
                            txtGenero = "HEMBRA";
                            dlgEscuchar.setDatosDialogoSexo(txtGenero);
                            dlgEscuchar.ejecutarTercerDialogo();
                        }else {
                            Toast.makeText(getActivity(), "ERROR SUBSANABLE \n"+"    Debe elegir su Sexo", Toast.LENGTH_SHORT).show();
                        }

                    }
                })
                .setNegativeButton(R.string.txt_btnCancelarDialog, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
    public void onAttach(Context context){

       super.onAttach(context);

       try {
           dlgEscuchar = (InterfaceAvanzar) context;
       }catch(ClassCastException e){

           throw new ClassCastException(context.toString()+ " Se debe implementar un nuevo OnNuevoDialogoListener");
       }
    }
}
