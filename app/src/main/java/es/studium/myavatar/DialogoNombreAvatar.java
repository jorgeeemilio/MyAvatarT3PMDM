package es.studium.myavatar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class DialogoNombreAvatar extends DialogFragment {
    InterfaceAvanzar dlgEscuchar;
    EditText nomAvatar;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dlg_nombre, null));

        View MiVentanaDialogo = inflater.inflate(R.layout.dlg_nombre,null);
        nomAvatar = MiVentanaDialogo.findViewById(R.id.editTextDlgNombreAvatar);
        builder.setView(MiVentanaDialogo)
                .setTitle(R.string.txt_dialogNombreAvatar)
                .setPositiveButton(R.string.txt_btnAceptarDialog, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (!nomAvatar.getText().toString().equals("")){

                            //Si se cumple que no esta vacío el campo texto entonces escuchara al método de nuestro MainActivity
                            dlgEscuchar.setDatosDialogoNombre(nomAvatar.getText().toString());
                            //Una vez capturado el dato nombre llamamos a la función  para ejecutar el siguiente dialogo
                            dlgEscuchar.ejecutarSegundoDialogo();


                        }else {

                            Toast.makeText(getActivity(), "   Error de Creación \n"+"Faltan campos por rellenar", Toast.LENGTH_SHORT).show();
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
