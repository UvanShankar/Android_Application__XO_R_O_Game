package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView a;
GridLayout g;
int choiceint[]=new int[9];
int win[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};


    enum Player{
    one,two,no
}
Button button;
Player currentPlayer=Player.one;
boolean over=false;
Player choice[]= new Player[9];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        g=(GridLayout)findViewById(R.id.gridlayout);
        choice[0]=Player.no;
        choice[1]=Player.no;
        choice[2]=Player.no;
        choice[3]=Player.no;
        choice[4]=Player.no;
        choice[5]=Player.no;
        choice[6]=Player.no;
        choice[7]=Player.no;
        choice[8]=Player.no;
///over=false;

    }

    public void imageViewIsTapped(View view) {
        ImageView tappedview = (ImageView) view;
        int tagid = Integer.parseInt(tappedview.getTag().toString());
        if(choice[tagid]==Player.no&&over==false) {
            if (currentPlayer == Player.one) {

                tappedview.setTranslationX(-2000);
                tappedview.setImageResource(R.drawable.lion);
                tappedview.animate().translationXBy(2000).alpha(1).rotation(3600).setDuration(1000);


                choice[tagid] = currentPlayer;
                currentPlayer = Player.two;
            } else {


                tappedview.setTranslationX(-2000);
                tappedview.setImageResource(R.drawable.tiger);
                tappedview.animate().translationXBy(2000).alpha(1).rotation(3600).setDuration(1000);

                choice[tagid] = currentPlayer;
                currentPlayer = Player.one;
            }
            for (int[] aa : win) {
                if (choice[aa[0]] == choice[aa[1]] && choice[aa[0]] == choice[aa[2]] && choice[aa[0]] != Player.no) {
                    String winner;
                    over=true;
                    if (currentPlayer == Player.two)
                        winner = "Player 1";
                    else
                        winner = "player 2";
                    Toast.makeText(this, "Winner is " + winner, Toast.LENGTH_SHORT).show();
                    button.setAlpha(1);
                    button.setClickable(true);


                }
            }
        }
        else
        {
            Toast.makeText(this, "Invalid choice", Toast.LENGTH_SHORT).show();
        }
    }
    public void buttonclick(View view) {
for(int i=0;i<g.getChildCount();i++)
{
    ImageView temp=(ImageView)(g.getChildAt(i));
temp.setImageDrawable(null);
temp.setAlpha(0.2f);
    choice[0]=Player.no;
    choice[1]=Player.no;
    choice[2]=Player.no;
    choice[3]=Player.no;
    choice[4]=Player.no;
    choice[5]=Player.no;
    choice[6]=Player.no;
    choice[7]=Player.no;
    choice[8]=Player.no;
    over=false;
    currentPlayer=Player.one;
}
    }

}
