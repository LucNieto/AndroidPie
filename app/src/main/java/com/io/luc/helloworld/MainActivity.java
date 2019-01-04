package com.io.luc.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    int[][] winningLines = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // for (int i=0; i< playerChoice.length; i++) {
           // playerChoice[i] = Player.NO;
        //}
        playerChoice[0] = Player.NO;
        playerChoice[1] = Player.NO;
        playerChoice[2] = Player.NO;
        playerChoice[3] = Player.NO;
        playerChoice[4] = Player.NO;
        playerChoice[5] = Player.NO;
        playerChoice[6] = Player.NO;
        playerChoice[7] = Player.NO;
        playerChoice[8] = Player.NO;
    }


    public  void  imageViewIsTapped(View tile){
        ImageView tappedTile = (ImageView) tile;
        tappedTile.setTranslationX(-2000);
        if(currentPlayer == Player.ONE){
            tappedTile.setImageResource(R.drawable.lion);
            currentPlayer = Player.TWO;
        }else {
            tappedTile.setImageResource(R.drawable.tiger);
            currentPlayer = Player.ONE;
        }

        tappedTile.animate().translationXBy(2000).alpha(1).rotation(3600).setDuration(1000);

        for (int[] winnerLine : winningLines) {
           // if(playerChoice[winnerLine[0]] != Player.NO){
                if (    playerChoice[winnerLine[0]] == playerChoice[winnerLine[1]]
                        && playerChoice[winnerLine[1]] == playerChoice[winnerLine[2]]
                        && playerChoice[winnerLine[0]] != Player.NO) {
                    Toast.makeText(this, "Winner Winner \nchicken dinner", Toast.LENGTH_SHORT).show();
                }
            //}

        }

    }
}
