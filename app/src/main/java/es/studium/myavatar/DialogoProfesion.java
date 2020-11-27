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

public class DialogoProfesion extends DialogFragment {
    InterfaceAvanzar dlgEscuchar;
    RadioButton rbArquero;
    RadioButton rdGuerrero;
    RadioButton rbMago;
    RadioButton rdHerrero;
    RadioButton rdMinero;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dlg_sexo, null));

        View MiVentanaDialogo = inflater.inflate(R.layout.dlg_sexo, null);

        //Creamos los vínculos con los strings
        rbArquero = MiVentanaDialogo.findViewById(R.id.radioBtnArquero);
        rdGuerrero = MiVentanaDialogo.findViewById(R.id.radioBtnGuerrero);
        rbMago = MiVentanaDialogo.findViewById(R.id.radioBtnMago);
        rdHerrero = MiVentanaDialogo.findViewById(R.id.radioBtnHerrero);
        rdMinero = MiVentanaDialogo.findViewById(R.id.radioBtnMinero);
        builder.setView(MiVentanaDialogo)
                .setTitle(R.string.txt_dialogProfesion)
                .setPositiveButton(R.string.txt_btnAceptarDialog, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //Creamos las condiciones de la selección realizada

                            if (rbArquero.isChecked()) {
                                dlgEscuchar.setDatosDialogoSexo(rbArquero.toString());

                            } else if (rdGuerrero.isChecked()) {
                                dlgEscuchar.setDatosDialogoSexo(rdGuerrero.toString());

                            } else if (rbMago.isChecked()) {
                                dlgEscuchar.setDatosDialogoSexo(rbMago.toString());

                            } else if (rdHerrero.isChecked()) {
                                dlgEscuchar.setDatosDialogoSexo(rdHerrero.toString());

                            } else if (rdMinero.isChecked()) {
                                dlgEscuchar.setDatosDialogoSexo(rdMinero.toString());

                            }else {
                                Toast.makeText(getActivity(), "ERROR SUBSANABLE \n"+"    Debe elegir su Sexo", Toast.LENGTH_SHORT).show();

                        }
                    }
                })
                .setNegativeButton(R.string.txt_btnCancelarDialog, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
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
