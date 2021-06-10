package br.com.diastecnologia.toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBarHorizontal, getProgressBarCircular;
    private int progresso = 0;
    private SeekBar seekBarEscala;
    private TextView textResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarHorizontal = findViewById(R.id.progressBarHorizontal);
        getProgressBarCircular = findViewById(R.id.progressBarCircular);

        getProgressBarCircular.setVisibility(View.GONE);

        seekBarEscala = findViewById(R.id.seekBarEscala);
        textResultado = findViewById(R.id.textResultado);

        seekBarEscala.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //textResultado.setText("onProgressChanged");
                textResultado.setText("Progesso: " + progress + " / " + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //textResultado.setText("onStartTrackingTouch");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //textResultado.setText("onStopTrackingTouch");

            }
        });

    }

    public void recuperarProgresso(View view){
        textResultado.setText("Escolhido: "  + seekBarEscala.getProgress());

    }

    public void carregarProgressBar(View view){
        //Horizontal

        this.progresso = this.progresso +1;
        progressBarHorizontal.setProgress(this.progresso);



        //Circular
        getProgressBarCircular.setVisibility(View.VISIBLE);
        if(this.progresso >= 10){
            getProgressBarCircular.setVisibility(View.GONE);
        }


    }



    public void abrirDialog(View view){
        //Istanciar AlertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        //Configurar titulo e mensagem
        dialog.setTitle("Título da dialog");
        dialog.setMessage("Mensagem da Dialog");

        //configurar cancelamento
        dialog.setCancelable(false);

        //configurar icone
        dialog.setIcon(android.R.drawable.ic_btn_speak_now);

        //Configurar ções para sim e não
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),
                        "Executar ação ao clicar no botão Sim",
                        Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),
                        "Executar ação ao clicar no botão Não",
                        Toast.LENGTH_LONG).show();
            }
        });

        //Criar e exibir AlertDialog
        dialog.create();
        dialog.show();


    }

    public void abrirToast(View view){

        ImageView imagem = new ImageView(getApplicationContext());
        imagem.setImageResource(android.R.drawable.star_big_off);
        TextView textView = new TextView(getApplicationContext());
        textView.setBackgroundResource(R.color.purple_500);
        textView.setText("Olá Toast");

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(textView);
        //toast.setView(imagem);
        toast.show();
        /*
        Toast.makeText(
                getApplicationContext(),
                "Ação realizada com sucesso!",
                Toast.LENGTH_LONG
        ).show();

         */

    }
}