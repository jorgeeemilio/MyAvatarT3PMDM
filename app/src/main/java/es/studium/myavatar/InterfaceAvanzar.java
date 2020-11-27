package es.studium.myavatar;

public interface InterfaceAvanzar {

    //Función Random para rellenar las características
    public void randomStats();

    //Métodos para guardar información
    public void setDatosDialogoNombre(String nombre);
    public void setDatosDialogoEspecie(String especie);
    public void setDatosDialogoSexo(String sexo);
    public void setDatosDialogoProfesion(String profesion);

    //Métodos para ejecutar los diálogos
    public void ejecutarSegundoDialogo();
    public void ejecutarTercerDialogo();
    public void ejecutarCuartoDialogo();


}
