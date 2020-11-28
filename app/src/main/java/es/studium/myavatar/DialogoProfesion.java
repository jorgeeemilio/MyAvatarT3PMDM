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
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.txt_dialogProfesion)
                .setItems(R.array.profesion, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        if(which==0){
                            dlgEscuchar.setDatosDialogoProfesion("Guerrero");
                            dlgEscuchar.randomStats();
                        }else if (which==1){
                            dlgEscuchar.setDatosDialogoProfesion("Mago");
                            dlgEscuchar.randomStats();
                        }else if (which==2){
                            dlgEscuchar.setDatosDialogoProfesion("Minero");
                            dlgEscuchar.randomStats();
                        }else if (which==3){
                            dlgEscuchar.setDatosDialogoProfesion("Herrero");
                            dlgEscuchar.randomStats();
                        }else if (which==3){
                            dlgEscuchar.setDatosDialogoProfesion("Arquero");
                            dlgEscuchar.randomStats();
                        }
                    }
                });
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
