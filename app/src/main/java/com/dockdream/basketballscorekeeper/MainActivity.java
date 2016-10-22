package com.dockdream.basketballscorekeeper;

import android.graphics.PorterDuff;
import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int homescore = 0;
    int awayscore = 0;
    int homefg = 0, homefga = 0, homethree = 0, homethreea = 0, homeft = 0, homefta = 0;
    int awayfg = 0, awayfga = 0, awaythree = 0, awaythreea = 0, awayft = 0, awayfta = 0;
    int homeorb = 0, homedrb = 0, homeblock = 0, homesteal = 0, homeassist = 0, hometurnover = 0;
    int awayorb = 0, awaydrb = 0, awayblock = 0, awaysteal = 0, awayassist = 0, awayturnover = 0;
    int homefoul = 0, awayfoul = 0;

    String scoreString = homescore + " - " + awayscore;
    String statUpdate;
    String teamToast = "Select a team";
    String minusWarning = "Select a stat";

    TextView score;
    TextView hor, hdr, hb, hs, ha, ht, hfgma, hthreema, hftma, hfouls, hfgp, hthreep, hftp;
    TextView vor, vdr, vb, vs, va, vt, vfgma, vthreema, vftma, vfouls, vfgp, vthreep, vftp;
    Button home, away;
    Button fgmade, threeptmade, ftmade;
    Button fgattempt, threeattempt, ftattempt;
    Button oreb, dreb, block;
    Button steal, assist, turnover;
    Button foul, minusstat, enter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        score = (TextView) findViewById(R.id.score);

        hor = (TextView) findViewById(R.id.hor);
        hdr = (TextView) findViewById(R.id.hdr);
        hb = (TextView) findViewById(R.id.hb);
        hs = (TextView) findViewById(R.id.hs);
        ha = (TextView) findViewById(R.id.ha);
        ht = (TextView) findViewById(R.id.ht);
        hfgma = (TextView) findViewById(R.id.hfgma);
        hthreema = (TextView) findViewById(R.id.hthreema);
        hftma = (TextView) findViewById(R.id.hftma);
        hfouls = (TextView) findViewById(R.id.hfouls);
        hfgp = (TextView) findViewById(R.id.hfgp);
        hthreep = (TextView) findViewById(R.id.hthreep);
        hftp = (TextView) findViewById(R.id.hftp);

        vor = (TextView) findViewById(R.id.vor);
        vdr = (TextView) findViewById(R.id.vdr);
        vb = (TextView) findViewById(R.id.vb);
        vs = (TextView) findViewById(R.id.vs);
        va = (TextView) findViewById(R.id.va);
        vt = (TextView) findViewById(R.id.vt);
        vfgma = (TextView) findViewById(R.id.vfgma);
        vthreema = (TextView) findViewById(R.id.vthreema);
        vftma = (TextView) findViewById(R.id.vftma);
        vfouls = (TextView) findViewById(R.id.vfouls);
        vfgp = (TextView) findViewById(R.id.vfgp);
        vthreep = (TextView) findViewById(R.id.vthreep);
        vftp = (TextView) findViewById(R.id.vftp);

        home = (Button) findViewById(R.id.home);
        home.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        away = (Button) findViewById(R.id.away);
        away.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        fgmade = (Button) findViewById(R.id.fgmade);
        fgmade.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        threeptmade = (Button) findViewById(R.id.threeptmade);
        threeptmade.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        ftmade = (Button) findViewById(R.id.ftmade);
        ftmade.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        fgattempt = (Button) findViewById(R.id.fgattempt);
        fgattempt.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        threeattempt = (Button) findViewById(R.id.threeattempt);
        threeattempt.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        ftattempt = (Button) findViewById(R.id.ftattempt);
        ftattempt.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        oreb = (Button) findViewById(R.id.oreb);
        oreb.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        dreb = (Button) findViewById(R.id.dreb);
        dreb.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        block = (Button) findViewById(R.id.block);
        block.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        steal = (Button) findViewById(R.id.steal);
        steal.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        assist = (Button) findViewById(R.id.assist);
        assist.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        turnover = (Button) findViewById(R.id.turnover);
        turnover.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        foul = (Button) findViewById(R.id.foul);
        foul.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        minusstat = (Button) findViewById(R.id.minusstat);
        minusstat.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        enter = (Button) findViewById(R.id.enter);
        enter.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);


        score.setText(scoreString);

    }// end onCreate


    public void buttonPushed (View v){
        if(v.isSelected()){
            v.setSelected(false);
            v.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        } // end if selected
        else {
            v.setSelected(true);
            v.getBackground().setColorFilter(0xFFFFFF33, PorterDuff.Mode.MULTIPLY);
        } // end else
    } // end buttonPushed

    public void homePushed (View v){
        if(v.isSelected()){
            v.setSelected(false);
            v.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        } // end if selected
        else {
            v.setSelected(true);
            v.getBackground().setColorFilter(0xFFFFFF33, PorterDuff.Mode.MULTIPLY);
            away.setSelected(false);
            away.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        } // end else
    } // end homePushed

    public void awayPushed (View v){
        if(v.isSelected()){
            v.setSelected(false);
            v.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        } // end if selected
        else {
            v.setSelected(true);
            v.getBackground().setColorFilter(0xFFFFFF33, PorterDuff.Mode.MULTIPLY);
            home.setSelected(false);
            home.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        } // end else
    } // end awayPushed


    /*
    * When enter button is pushed, all buttons will be checked for state.
    * Buttons that have been selected will cause their respective stats to increment.
    * All buttons set to unselected at the end of the loop.
    * */
    public void enterStats(View v){
        /*
        * Flash animation code found on StackOverflow
        * Posted by user sany in response to question from user David Prun
        * Post dated Aug 10, 2010
        * http://stackoverflow.com/questions/3450839/blinking-text-in-android-view
        * */
        Animation flashText = new AlphaAnimation(0.0f, 1.0f);
        flashText.setDuration(250);
        flashText.setStartOffset(20);
        flashText.setRepeatMode(Animation.REVERSE);
        flashText.setRepeatCount(8);

        Animation flashScore = new AlphaAnimation(0.0f, 1.0f);
        flashScore.setDuration(250);
        flashScore.setStartOffset(20);
        flashScore.setRepeatMode(Animation.REVERSE);
        flashScore.setRepeatCount(1);

        // home selected WITHOUT minus stat selected
        if(home.isSelected() && !minusstat.isSelected()){
            if(!fgmade.isSelected() && !fgattempt.isSelected() && !threeptmade.isSelected() && !threeattempt.isSelected() && !ftmade.isSelected()
                    && !ftattempt.isSelected() && !oreb.isSelected() && !dreb.isSelected() && !block.isSelected() && !steal.isSelected()
                    && !assist.isSelected() && !turnover.isSelected() && !foul.isSelected()){
                Toast.makeText(getApplicationContext(), minusWarning, Toast.LENGTH_SHORT).show();
            } // end if no stat selected
            if (fgmade.isSelected()) {
                homescore = homescore + 2;
                scoreString = homescore + " - " + awayscore;
                score.setText(scoreString);
                score.startAnimation(flashScore);
                homefg++;
                homefga++;
                statUpdate = homefg + "/" + homefga;
                hfgma.setText(statUpdate);
                hfgma.startAnimation(flashText);
                statUpdate = ((homefg * 100) / homefga) + "%";
                hfgp.setText(statUpdate);
                hfgp.startAnimation(flashText);
                fgmade.setSelected(false);
                fgmade.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end fgmade selected
            if(fgattempt.isSelected()){
                homefga++;
                statUpdate = homefg + "/" + homefga;
                hfgma.setText(statUpdate);
                hfgma.startAnimation(flashText);
                statUpdate = ((homefg * 100) / homefga) + "%";
                hfgp.setText(statUpdate);
                hfgp.startAnimation(flashText);
                fgattempt.setSelected(false);
                fgattempt.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end fgattempt selected
            if (threeptmade.isSelected()) {
                homescore = homescore + 3;
                scoreString = homescore + " - " + awayscore;
                score.setText(scoreString);
                score.startAnimation(flashScore);
                homethree++;
                homethreea++;
                statUpdate = homethree + "/" + homethreea;
                hthreema.setText(statUpdate);
                hthreema.startAnimation(flashText);
                statUpdate = ((homethree * 100) / homethreea) + "%";
                hthreep.setText(statUpdate);
                hthreep.startAnimation(flashText);
                threeptmade.setSelected(false);
                threeptmade.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end threeptmade selected
            if(threeattempt.isSelected()){
                homethreea++;
                statUpdate = homethree + "/" + homethreea;
                hthreema.setText(statUpdate);
                hthreema.startAnimation(flashText);
                statUpdate = ((homethree * 100) / homethreea) + "%";
                hthreep.setText(statUpdate);
                hthreep.startAnimation(flashText);
                threeattempt.setSelected(false);
                threeattempt.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end threeattempt selected
            if (ftmade.isSelected()) {
                homescore = homescore + 1;
                scoreString = homescore + " - " + awayscore;
                score.setText(scoreString);
                score.startAnimation(flashScore);
                homeft++;
                homefta++;
                statUpdate = homeft + "/" + homefta;
                hftma.setText(statUpdate);
                hftma.startAnimation(flashText);
                statUpdate = ((homeft * 100) / homefta) + "%";
                hftp.setText(statUpdate);
                hftp.startAnimation(flashText);
                ftmade.setSelected(false);
                ftmade.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end ftmade selected
            if(ftattempt.isSelected()){
                homefta++;
                statUpdate = homeft + "/" + homefta;
                hftma.setText(statUpdate);
                hftma.startAnimation(flashText);
                statUpdate = ((homeft * 100) / homefta) + "%";
                hftp.setText(statUpdate);
                hftp.startAnimation(flashText);
                ftattempt.setSelected(false);
                ftattempt.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end ftattempt selected
            if(oreb.isSelected()){
                homeorb++;
                statUpdate = homeorb + "";
                hor.setText(statUpdate);
                hor.startAnimation(flashText);
                oreb.setSelected(false);
                oreb.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end oreb selected
            if(dreb.isSelected()){
                homedrb++;
                statUpdate = homedrb + "";
                hdr.setText(statUpdate);
                hdr.startAnimation(flashText);
                dreb.setSelected(false);
                dreb.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end dreb selected
            if(block.isSelected()){
                homeblock++;
                statUpdate = homeblock + "";
                hb.setText(statUpdate);
                hb.startAnimation(flashText);
                block.setSelected(false);
                block.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end block selected
            if(steal.isSelected()){
                homesteal++;
                statUpdate = homesteal + "";
                hs.setText(statUpdate);
                hs.startAnimation(flashText);
                steal.setSelected(false);
                steal.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end steal selected
            if(assist.isSelected()){
                homeassist++;
                statUpdate = homeassist + "";
                ha.setText(statUpdate);
                ha.startAnimation(flashText);
                assist.setSelected(false);
                assist.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end assist selected
            if(turnover.isSelected()){
                hometurnover++;
                statUpdate = hometurnover + "";
                ht.setText(statUpdate);
                ht.startAnimation(flashText);
                turnover.setSelected(false);
                turnover.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end turnover selected
            if(foul.isSelected()){
                homefoul++;
                statUpdate = homefoul + "";
                hfouls.setText(statUpdate);
                hfouls.startAnimation(flashText);
                foul.setSelected(false);
                foul.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end foul selected

            home.setSelected(false);
            home.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        } // end if home selected and minus stat IS NOT selected

        // home selected AND minus stat selected
        else if(home.isSelected() && minusstat.isSelected()){
            if(!fgmade.isSelected() && !fgattempt.isSelected() && !threeptmade.isSelected() && !threeattempt.isSelected() && !ftmade.isSelected()
                    && !ftattempt.isSelected() && !oreb.isSelected() && !dreb.isSelected() && !block.isSelected() && !steal.isSelected()
                    && !assist.isSelected() && !turnover.isSelected() && !foul.isSelected()){
                Toast.makeText(getApplicationContext(), minusWarning, Toast.LENGTH_SHORT).show();
            } // end if no stat selected
            if (fgmade.isSelected()) {
                homescore = homescore - 2;
                scoreString = homescore + " - " + awayscore;
                score.setText(scoreString);
                score.startAnimation(flashScore);
                homefg--;
                homefga--;
                statUpdate = homefg + "/" + homefga;
                hfgma.setText(statUpdate);
                hfgma.startAnimation(flashText);
                statUpdate = ((homefg * 100) / homefga) + "%";
                hfgp.setText(statUpdate);
                hfgp.startAnimation(flashText);
                fgmade.setSelected(false);
                fgmade.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end fgmade selected
            if(fgattempt.isSelected()){
                homefga--;
                statUpdate = homefg + "/" + homefga;
                hfgma.setText(statUpdate);
                hfgma.startAnimation(flashText);
                statUpdate = ((homefg * 100) / homefga) + "%";
                hfgp.setText(statUpdate);
                hfgp.startAnimation(flashText);
                fgattempt.setSelected(false);
                fgattempt.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end fgattempt selected
            if (threeptmade.isSelected()) {
                homescore = homescore - 3;
                scoreString = homescore + " - " + awayscore;
                score.setText(scoreString);
                score.startAnimation(flashScore);
                homethree--;
                homethreea--;
                statUpdate = homethree + "/" + homethreea;
                hthreema.setText(statUpdate);
                hthreema.startAnimation(flashText);
                statUpdate = ((homethree * 100) / homethreea) + "%";
                hthreep.setText(statUpdate);
                hthreep.startAnimation(flashText);
                threeptmade.setSelected(false);
                threeptmade.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end threeptmade selected
            if(threeattempt.isSelected()){
                homethreea--;
                statUpdate = homethree + "/" + homethreea;
                hthreema.setText(statUpdate);
                hthreema.startAnimation(flashText);
                statUpdate = ((homethree * 100) / homethreea) + "%";
                hthreep.setText(statUpdate);
                hthreep.startAnimation(flashText);
                threeattempt.setSelected(false);
                threeattempt.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end threeattempt selected
            if (ftmade.isSelected()) {
                homescore = homescore - 1;
                scoreString = homescore + " - " + awayscore;
                score.setText(scoreString);
                score.startAnimation(flashScore);
                homeft--;
                homefta--;
                statUpdate = homeft + "/" + homefta;
                hftma.setText(statUpdate);
                hftma.startAnimation(flashText);
                statUpdate = ((homeft * 100) / homefta) + "%";
                hftp.setText(statUpdate);
                hftp.startAnimation(flashText);
                ftmade.setSelected(false);
                ftmade.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end ftmade selected
            if(ftattempt.isSelected()){
                homefta--;
                statUpdate = homeft + "/" + homefta;
                hftma.setText(statUpdate);
                hftma.startAnimation(flashText);
                statUpdate = ((homeft * 100) / homefta) + "%";
                hftp.setText(statUpdate);
                hftp.startAnimation(flashText);
                ftattempt.setSelected(false);
                ftattempt.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end ftattempt selected
            if(oreb.isSelected()){
                homeorb--;
                statUpdate = homeorb + "";
                hor.setText(statUpdate);
                hor.startAnimation(flashText);
                oreb.setSelected(false);
                oreb.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end oreb selected
            if(dreb.isSelected()){
                homedrb--;
                statUpdate = homedrb + "";
                hdr.setText(statUpdate);
                hdr.startAnimation(flashText);
                dreb.setSelected(false);
                dreb.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end dreb selected
            if(block.isSelected()){
                homeblock--;
                statUpdate = homeblock + "";
                hb.setText(statUpdate);
                hb.startAnimation(flashText);
                block.setSelected(false);
                block.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end block selected
            if(steal.isSelected()){
                homesteal--;
                statUpdate = homesteal + "";
                hs.setText(statUpdate);
                hs.startAnimation(flashText);
                steal.setSelected(false);
                steal.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end steal selected
            if(assist.isSelected()){
                homeassist--;
                statUpdate = homeassist + "";
                ha.setText(statUpdate);
                ha.startAnimation(flashText);
                assist.setSelected(false);
                assist.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end assist selected
            if(turnover.isSelected()){
                hometurnover--;
                statUpdate = hometurnover + "";
                ht.setText(statUpdate);
                ht.startAnimation(flashText);
                turnover.setSelected(false);
                turnover.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end turnover selected
            if(foul.isSelected()){
                homefoul--;
                statUpdate = homefoul + "";
                hfouls.setText(statUpdate);
                hfouls.startAnimation(flashText);
                foul.setSelected(false);
                foul.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end foul selected

            home.setSelected(false);
            home.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            minusstat.setSelected(false);
            minusstat.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
        } // end if home selected and minus stat IS selected

        else if(away.isSelected()){
            // away selected WITHOUT minus stat selected
            if(away.isSelected() && !minusstat.isSelected()){
                if(!fgmade.isSelected() && !fgattempt.isSelected() && !threeptmade.isSelected() && !threeattempt.isSelected() && !ftmade.isSelected()
                        && !ftattempt.isSelected() && !oreb.isSelected() && !dreb.isSelected() && !block.isSelected() && !steal.isSelected()
                        && !assist.isSelected() && !turnover.isSelected() && !foul.isSelected()){
                    Toast.makeText(getApplicationContext(), minusWarning, Toast.LENGTH_SHORT).show();
                } // end if no stat selected
                if (fgmade.isSelected()) {
                    awayscore = awayscore + 2;
                    scoreString = homescore + " - " + awayscore;
                    score.setText(scoreString);
                    score.startAnimation(flashScore);
                    awayfg++;
                    awayfga++;
                    statUpdate = awayfg + "/" + awayfga;
                    vfgma.setText(statUpdate);
                    vfgma.startAnimation(flashText);
                    statUpdate = ((awayfg * 100) / awayfga) + "%";
                    vfgp.setText(statUpdate);
                    vfgp.startAnimation(flashText);
                    fgmade.setSelected(false);
                    fgmade.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end fgmade selected
                if(fgattempt.isSelected()){
                    awayfga++;
                    statUpdate = awayfg + "/" + awayfga;
                    vfgma.setText(statUpdate);
                    vfgma.startAnimation(flashText);
                    statUpdate = ((awayfg * 100) / awayfga) + "%";
                    vfgp.setText(statUpdate);
                    vfgp.startAnimation(flashText);
                    fgattempt.setSelected(false);
                    fgattempt.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end fgattempt selected
                if (threeptmade.isSelected()) {
                    awayscore = awayscore + 3;
                    scoreString = homescore + " - " + awayscore;
                    score.setText(scoreString);
                    score.startAnimation(flashScore);
                    awaythree++;
                    awaythreea++;
                    statUpdate = awaythree + "/" + awaythreea;
                    vthreema.setText(statUpdate);
                    vthreema.startAnimation(flashText);
                    statUpdate = ((awaythree * 100) / awaythreea) + "%";
                    vthreep.setText(statUpdate);
                    vthreep.startAnimation(flashText);
                    threeptmade.setSelected(false);
                    threeptmade.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end threeptmade selected
                if(threeattempt.isSelected()){
                    awaythreea++;
                    statUpdate = awaythree + "/" + awaythreea;
                    vthreema.setText(statUpdate);
                    vthreema.startAnimation(flashText);
                    statUpdate = ((awaythree * 100) / awaythreea) + "%";
                    vthreep.setText(statUpdate);
                    vthreep.startAnimation(flashText);
                    threeattempt.setSelected(false);
                    threeattempt.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end threeattempt selected
                if (ftmade.isSelected()) {
                    awayscore = awayscore + 1;
                    scoreString = homescore + " - " + awayscore;
                    score.setText(scoreString);
                    score.startAnimation(flashScore);
                    awayft++;
                    awayfta++;
                    statUpdate = awayft + "/" + awayfta;
                    vftma.setText(statUpdate);
                    vftma.startAnimation(flashText);
                    statUpdate = ((awayft * 100) / awayfta) + "%";
                    vftp.setText(statUpdate);
                    vftp.startAnimation(flashText);
                    ftmade.setSelected(false);
                    ftmade.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end ftmade selected
                if(ftattempt.isSelected()){
                    awayfta++;
                    statUpdate = awayft + "/" + awayfta;
                    vftma.setText(statUpdate);
                    vftma.startAnimation(flashText);
                    statUpdate = ((awayft * 100) / awayfta) + "%";
                    vftp.setText(statUpdate);
                    vftp.startAnimation(flashText);
                    ftattempt.setSelected(false);
                    ftattempt.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end ftattempt selected
                if(oreb.isSelected()){
                    awayorb++;
                    statUpdate = awayorb + "";
                    vor.setText(statUpdate);
                    vor.startAnimation(flashText);
                    oreb.setSelected(false);
                    oreb.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end oreb selected
                if(dreb.isSelected()){
                    awaydrb++;
                    statUpdate = awaydrb + "";
                    vdr.setText(statUpdate);
                    vdr.startAnimation(flashText);
                    dreb.setSelected(false);
                    dreb.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end dreb selected
                if(block.isSelected()){
                    awayblock++;
                    statUpdate = awayblock + "";
                    vb.setText(statUpdate);
                    vb.startAnimation(flashText);
                    block.setSelected(false);
                    block.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end block selected
                if(steal.isSelected()){
                    awaysteal++;
                    statUpdate = awaysteal + "";
                    vs.setText(statUpdate);
                    vs.startAnimation(flashText);
                    steal.setSelected(false);
                    steal.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end steal selected
                if(assist.isSelected()){
                    awayassist++;
                    statUpdate = awayassist + "";
                    va.setText(statUpdate);
                    va.startAnimation(flashText);
                    assist.setSelected(false);
                    assist.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end assist selected
                if(turnover.isSelected()){
                    awayturnover++;
                    statUpdate = awayturnover + "";
                    vt.setText(statUpdate);
                    vt.startAnimation(flashText);
                    turnover.setSelected(false);
                    turnover.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end turnover selected
                if(foul.isSelected()){
                    awayfoul++;
                    statUpdate = awayfoul + "";
                    vfouls.setText(statUpdate);
                    vfouls.startAnimation(flashText);
                    foul.setSelected(false);
                    foul.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end foul selected

                away.setSelected(false);
                away.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end if away selected and minus stat IS NOT selected

            // away selected AND minus stat selected
            else if(away.isSelected() && minusstat.isSelected()){
                if(!fgmade.isSelected() && !fgattempt.isSelected() && !threeptmade.isSelected() && !threeattempt.isSelected() && !ftmade.isSelected()
                        && !ftattempt.isSelected() && !oreb.isSelected() && !dreb.isSelected() && !block.isSelected() && !steal.isSelected()
                        && !assist.isSelected() && !turnover.isSelected() && !foul.isSelected()){
                    Toast.makeText(getApplicationContext(), minusWarning, Toast.LENGTH_SHORT).show();
                } // end if no stat selected
                if (fgmade.isSelected()) {
                    awayscore = awayscore - 2;
                    scoreString = homescore + " - " + awayscore;
                    score.setText(scoreString);
                    score.startAnimation(flashScore);
                    awayfg--;
                    awayfga--;
                    statUpdate = awayfg + "/" + awayfga;
                    vfgma.setText(statUpdate);
                    vfgma.startAnimation(flashText);
                    statUpdate = ((awayfg * 100) / awayfga) + "%";
                    vfgp.setText(statUpdate);
                    vfgp.startAnimation(flashText);
                    fgmade.setSelected(false);
                    fgmade.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end fgmade selected
                if(fgattempt.isSelected()){
                    awayfga--;
                    statUpdate = awayfg + "/" + awayfga;
                    vfgma.setText(statUpdate);
                    vfgma.startAnimation(flashText);
                    statUpdate = ((awayfg * 100) / awayfga) + "%";
                    vfgp.setText(statUpdate);
                    vfgp.startAnimation(flashText);
                    fgattempt.setSelected(false);
                    fgattempt.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end fgattempt selected
                if (threeptmade.isSelected()) {
                    awayscore = awayscore - 3;
                    scoreString = homescore + " - " + awayscore;
                    score.setText(scoreString);
                    score.startAnimation(flashScore);
                    awaythree--;
                    awaythreea--;
                    statUpdate = awaythree + "/" + awaythreea;
                    vthreema.setText(statUpdate);
                    vthreema.startAnimation(flashText);
                    statUpdate = ((awaythree * 100) / awaythreea) + "%";
                    vthreep.setText(statUpdate);
                    vthreep.startAnimation(flashText);
                    threeptmade.setSelected(false);
                    threeptmade.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end threeptmade selected
                if(threeattempt.isSelected()){
                    awaythreea--;
                    statUpdate = awaythree + "/" + awaythreea;
                    vthreema.setText(statUpdate);
                    vthreema.startAnimation(flashText);
                    statUpdate = ((awaythree * 100) / awaythreea) + "%";
                    vthreep.setText(statUpdate);
                    vthreep.startAnimation(flashText);
                    threeattempt.setSelected(false);
                    threeattempt.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end threeattempt selected
                if (ftmade.isSelected()) {
                    awayscore = awayscore - 1;
                    scoreString = homescore + " - " + awayscore;
                    score.setText(scoreString);
                    score.startAnimation(flashScore);
                    awayft--;
                    awayfta--;
                    statUpdate = awayft + "/" + awayfta;
                    vftma.setText(statUpdate);
                    vftma.startAnimation(flashText);
                    statUpdate = ((awayft * 100) / awayfta) + "%";
                    vftp.setText(statUpdate);
                    vftp.startAnimation(flashText);
                    ftmade.setSelected(false);
                    ftmade.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end ftmade selected
                if(ftattempt.isSelected()){
                    awayfta--;
                    statUpdate = awayft + "/" + awayfta;
                    vftma.setText(statUpdate);
                    vftma.startAnimation(flashText);
                    statUpdate = ((awayft * 100) / awayfta) + "%";
                    vftp.setText(statUpdate);
                    vftp.startAnimation(flashText);
                    ftattempt.setSelected(false);
                    ftattempt.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end ftattempt selected
                if(oreb.isSelected()){
                    awayorb--;
                    statUpdate = awayorb + "";
                    vor.setText(statUpdate);
                    vor.startAnimation(flashText);
                    oreb.setSelected(false);
                    oreb.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end oreb selected
                if(dreb.isSelected()){
                    awaydrb--;
                    statUpdate = awaydrb + "";
                    vdr.setText(statUpdate);
                    vdr.startAnimation(flashText);
                    dreb.setSelected(false);
                    dreb.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end dreb selected
                if(block.isSelected()){
                    awayblock--;
                    statUpdate = awayblock + "";
                    vb.setText(statUpdate);
                    vb.startAnimation(flashText);
                    block.setSelected(false);
                    block.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end block selected
                if(steal.isSelected()){
                    awaysteal--;
                    statUpdate = awaysteal + "";
                    vs.setText(statUpdate);
                    vs.startAnimation(flashText);
                    steal.setSelected(false);
                    steal.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end steal selected
                if(assist.isSelected()){
                    awayassist--;
                    statUpdate = awayassist + "";
                    va.setText(statUpdate);
                    va.startAnimation(flashText);
                    assist.setSelected(false);
                    assist.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end assist selected
                if(turnover.isSelected()){
                    awayturnover--;
                    statUpdate = awayturnover + "";
                    vt.setText(statUpdate);
                    vt.startAnimation(flashText);
                    turnover.setSelected(false);
                    turnover.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end turnover selected
                if(foul.isSelected()){
                    awayfoul--;
                    statUpdate = awayfoul + "";
                    vfouls.setText(statUpdate);
                    vfouls.startAnimation(flashText);
                    foul.setSelected(false);
                    foul.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                } // end foul selected

                away.setSelected(false);
                away.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
                minusstat.setSelected(false);
                minusstat.getBackground().setColorFilter(0xFFFF9900, PorterDuff.Mode.MULTIPLY);
            } // end if away selected and minus stat IS selected

        } // end if away selected

        else{
            Toast.makeText(getApplicationContext(), teamToast, Toast.LENGTH_SHORT).show();
        } // end if no team selected

    } // end enterStats

} // end MainActivity
