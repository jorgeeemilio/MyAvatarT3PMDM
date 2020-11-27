package es.studium.myavatar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class DialogoProfesion extends DialogFragment {
    InterfaceAvanzar dlgEscuchar;
    RadioButton rdbHombre;
    RadioButton rdbMujer;
    boolean click;
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
                    public void onClick(DialogInterface dialog, int id) {
                        //Creamos las condiciones de la seleccioón realizada
                        click = false;
                        while (click){
                            if (rdbHombre.isChecked()) {
                                dlgEscuchar.setDatosDialogoSexo(rdbHombre.toString());
                                click = false;
                            } else if (rdbMujer.isChecked()) {
                                dlgEscuchar.setDatosDialogoSexo(rdbMujer.toString());
                                click = false;
                            }else {
                                Toast.makeText(getActivity(), "ERROR SUBSANABLE \n"+"    Debe elegir su Sexo", Toast.LENGTH_SHORT).show();
                            }
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
}
