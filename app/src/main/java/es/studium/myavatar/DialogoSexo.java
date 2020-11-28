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
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.txt_dialogSexo)
                .setItems(R.array.genero, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        if(which==0){

                            dlgEscuchar.setDatosDialogoSexo("Hombre");
                            dlgEscuchar.ejecutarTercerDialogo();
                        }else{
                            dlgEscuchar.setDatosDialogoSexo("Mujer");
                            dlgEscuchar.ejecutarTercerDialogo();
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
