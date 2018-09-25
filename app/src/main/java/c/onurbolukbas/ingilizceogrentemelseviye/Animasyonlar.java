package c.onurbolukbas.ingilizceogrentemelseviye;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.List;

/**
 * Created by asus on 17.08.2018.
 */

public class Animasyonlar {
    public static void yaziAnimation(View view, int i) {
        switch (i){
            case 0:
                YoYo.with(Techniques.DropOut)
                        .duration(1500)
                        .playOn(view);
                break;
            case 1:
                YoYo.with(Techniques.Flash)
                        .duration(1500)
                        .playOn(view);
                break;
            case 2:
                YoYo.with(Techniques.RubberBand)
                        .duration(1500)
                        .playOn(view);
                break;
            case 3:
                YoYo.with(Techniques.Wobble)
                        .duration(1500)
                        .playOn(view);
                break;
            case 4:
                YoYo.with(Techniques.Landing)
                        .duration(1500)
                        .playOn(view);
                break;
            case 5:
                YoYo.with(Techniques.Swing)
                        .duration(1500)
                        .playOn(view);
                break;
            case 6:
                YoYo.with(Techniques.ZoomInUp)
                        .duration(1500)
                        .playOn(view);
                break;
            case 7:
                YoYo.with(Techniques.ZoomInLeft)
                        .duration(1500)
                        .playOn(view);
                break;
            case 8:
                YoYo.with(Techniques.ZoomInDown)
                        .duration(1500)
                        .playOn(view);
                break;
            case 9:
                YoYo.with(Techniques.SlideInDown)
                        .duration(1500)
                        .playOn(view);
                break;
            case 10:
                YoYo.with(Techniques.SlideInUp)
                        .duration(1500)
                        .playOn(view);
                break;
            case 11:
                YoYo.with(Techniques.SlideInRight)
                        .duration(1500)
                        .playOn(view);
                break;
            case 12:
                YoYo.with(Techniques.SlideInLeft)
                        .duration(1500)
                        .playOn(view);
                break;
            case 13:
                YoYo.with(Techniques.RotateInUpLeft)
                        .duration(1500)
                        .playOn(view);
                break;
            case 14:
                YoYo.with(Techniques.RotateInDownRight)
                        .duration(1500)
                        .playOn(view);
                break;
            case 15:
                YoYo.with(Techniques.RotateInUpRight)
                        .duration(1500)
                        .playOn(view);
                break;
            case 16:
                YoYo.with(Techniques.FlipInX)
                        .duration(1500)
                        .playOn(view);
                break;
            case 17:
                YoYo.with(Techniques.FadeInUp)
                        .duration(1500)
                        .playOn(view);
                break;
            case 18:
                YoYo.with(Techniques.BounceInUp)
                        .duration(1500)
                        .playOn(view);
                break;
            case 19:
                YoYo.with(Techniques.BounceInRight)
                        .duration(1500)
                        .playOn(view);
                break;
            case 20:
                YoYo.with(Techniques.BounceInLeft)
                        .duration(1500)
                        .playOn(view);
                break;
            case 21:
                YoYo.with(Techniques.Wave)
                        .duration(1500)
                        .playOn(view);
                break;
            case 22:
                YoYo.with(Techniques.Tada)
                        .duration(1500)
                        .playOn(view);
                break;
            case 23:
                YoYo.with(Techniques.StandUp)
                        .duration(1500)
                        .playOn(view);
                break;
            case 24:
                YoYo.with(Techniques.RollIn)
                        .duration(1500)
                        .playOn(view);
                break;

        }
    }

    public static void butonlarAnimation(List<View> butonlar) {
        AnimatorSet animatorSet=new AnimatorSet();

        ObjectAnimator objectAnimator=ObjectAnimator.ofInt(butonlar.get(0),"translationY",500,0);
        ObjectAnimator objectAnimator1=ObjectAnimator.ofInt(butonlar.get(1),"translationY",600,0);
        ObjectAnimator objectAnimator2=ObjectAnimator.ofInt(butonlar.get(2),"translationY",700,0);
        ObjectAnimator objectAnimator3=ObjectAnimator.ofInt(butonlar.get(3),"translationY",800,0);
        objectAnimator.setDuration(1250);
        objectAnimator1.setDuration(1500);
        objectAnimator2.setDuration(1750);
        objectAnimator3.setDuration(2000);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator3.setInterpolator(new AccelerateDecelerateInterpolator());

        animatorSet.playTogether(objectAnimator,objectAnimator1,objectAnimator2,objectAnimator3);
        animatorSet.start();
    }

    public static void tebrikAnimation(TextView soruMetni) {
        YoYo.with(Techniques.ZoomInUp)
                .duration(1000)
                .playOn(soruMetni);
    }

    public static void titremeAnimation(TextView textView) {
        AnimatorSet animatorSet=new AnimatorSet();

        ObjectAnimator animator=ObjectAnimator.ofFloat(textView,"translationX",-40,40,-30,30,-20,20,0);
        animator.setDuration(1500);
        animatorSet.play(animator);
        animatorSet.start();

        // YoYo.with(Techniques.Shake).duration(1500).playOn(soruContainer);
    }
}
