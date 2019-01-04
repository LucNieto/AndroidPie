package com.io.luc.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * @author Lucio Nieto Bautista
 * CEO at Nieto Industries
 */

public class MainActivity extends AppCompatActivity {
    enum Player { ONE, TWO, NO }
    Player currentPlayer = Player.ONE;
    Player[] playerChoice = new Player[9];
    private boolean gameOver = false;

    private Button btnReset;

    private GridLayout gridLayout;

    int[][] winningLines = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PlayerChoices();
        btnReset = findViewById(R.id.btnReset);
        gridLayout = findViewById(R.id.gridLayout);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resetTheGame();
            }
        });

    }


    public  void  imageViewIsTapped(View tile){
        ImageView tappedTile = (ImageView) tile;

        int tiTag = Integer.parseInt(tappedTile.getTag().toString() );
        if (playerChoice[tiTag] == Player.NO && gameOver == false) {
            playerChoice[tiTag] = currentPlayer;
            tappedTile.setTranslationX(-2000);
            if (currentPlayer == Player.ONE) {
                tappedTile.setImageResource(R.drawable.lion);
                currentPlayer = Player.TWO;
            } else {
                tappedTile.setImageResource(R.drawable.tiger);
                currentPlayer = Player.ONE;
            }

            tappedTile.animate().translationXBy(2000).alpha(1).rotation(3600).setDuration(1000);

            for (int[] winnerLine : winningLines) {
                 if(playerChoice[winnerLine[0]] != Player.NO){
                if (playerChoice[winnerLine[0]] == playerChoice[winnerLine[1]]
                        && playerChoice[winnerLine[1]] == playerChoice[winnerLine[2]]
                        /*&& playerChoice[winnerLine[0]] != Player.NO*/) {
                    btnReset.setVisibility(View.VISIBLE);
                    gameOver = true;
                    String winnerOfGame = "";

                    if (currentPlayer == Player.ONE) {

                        winnerOfGame = "Player Two ";

                    } else if (currentPlayer == Player.TWO) {

                        winnerOfGame = "Player One ";


                    }
                    Toast.makeText(this, winnerOfGame + "is the Winner",
                            Toast.LENGTH_LONG).show();
                }
                }

            }
        }

    }
    private void resetTheGame() {

        for (int index = 0; index < gridLayout.getChildCount(); index++) {

            ImageView imageView = (ImageView) gridLayout.getChildAt(index);
            imageView.setImageDrawable(null);
            imageView.setAlpha(0.5f);
        }

        currentPlayer = Player.ONE;
        PlayerChoices();


        gameOver = false;
        btnReset.setVisibility(View.INVISIBLE);

    }

    private void PlayerChoices(){
        for (int i=0; i< playerChoice.length; i++) {
            playerChoice[i] = Player.NO;
        }
    }
}
