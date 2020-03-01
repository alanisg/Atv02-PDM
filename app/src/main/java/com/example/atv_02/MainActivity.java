package com.example.atv_02;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static final NumberFormat currencyFormat= NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentFormat= NumberFormat.getPercentInstance();

    private TextView gasolinaTextView;
    private TextView etanolTextView ;
    private TextView resultadoTextView;
    private ImageView imageCombustivel;

    private double percentg = 0;
    private double percente = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gasolinaTextView = findViewById(R.id.gasolinaTextView);
        etanolTextView = findViewById(R.id.etanolTextView);



        SeekBar gasolinaSeekBar = findViewById(R.id.gasolinaSeekBar);
        SeekBar etanolSeekBar = findViewById(R.id.etanolSeekBar);

        gasolinaSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percentg = progress / 100d;
                melhor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        etanolSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percente = progress / 100d;
                melhor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });






    }

    private void melhor (){

        if (percente / percentg >= 0.7){
            resultadoTextView.setText(getString(R.string.result_gasolina));
            imageCombustivel.setImageSource(getDrawable(R.drawable.image));
        }
        else{
            resultadoTextView.setText(getString(R.string.result_etanol));
            imageCombustivel.setImageDrawable(getDrawable(R.drawable.image1));
        }
    }
    Toast.makeText(this, "Versão final", Toast.LENGTH_SHORT).show();
}
