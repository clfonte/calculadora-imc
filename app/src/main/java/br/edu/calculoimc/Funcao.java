package br.edu.calculoimc;

import android.app.AlertDialog;
import android.content.Context;

public class Funcao {
    public void mensagem(Context context, String sTitulo, String sMensagem) {
        AlertDialog.Builder mensagem = new AlertDialog.Builder(context);
        mensagem.setTitle(sTitulo);
        mensagem.setMessage(sMensagem);
        mensagem.setPositiveButton("Ok", null);
        mensagem.show();
    }
}
