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

public class DialogoEspecie extends DialogFragment {
    InterfaceAvanzar dlgEscuchar;
    RadioButton rbElfo;
    RadioButton rdEnano;
    RadioButton rbHobbit;
    RadioButton rdHumano;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dlg_especie, null));

        View MiVentanaDialogo = inflater.inflate(R.layout.dlg_especie, null);

        //Creamos los vínculos con los strings
        rbElfo = MiVentanaDialogo.findViewById(R.id.radioBtnElfo);
        rdEnano = MiVentanaDialogo.findViewById(R.id.radioBtnEnano);
        rbHobbit = MiVentanaDialogo.findViewById(R.id.radioBtnHoobit);
        rdHumano = MiVentanaDialogo.findViewById(R.id.radioBtnHumano);
        builder.setView(MiVentanaDialogo)
                .setTitle(R.string.txt_dialogSexo)
                .setPositiveButton(R.string.txt_btnAceptarDialog, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //Creamos las condiciones de la selección realizada

                            if (rbElfo.isChecked()) {
                                dlgEscuchar.setDatosDialogoSexo(rbElfo.toString());

                            } else if (rdEnano.isChecked()) {
                                dlgEscuchar.setDatosDialogoSexo(rdEnano.toString());

                            }else if (rdHumano.isChecked()) {
                                dlgEscuchar.setDatosDialogoSexo(rdHumano.toString());

                            }else if (rbHobbit.isChecked()) {
                                dlgEscuchar.setDatosDialogoSexo(rbHobbit.toString());

                            }else {
                                Toast.makeText(getActivity(), "ERROR SUBSANABLE \n"+"    Debe elegir su Raza/Especie", Toast.LENGTH_SHORT).show();
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
