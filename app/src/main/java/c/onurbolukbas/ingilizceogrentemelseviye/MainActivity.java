package c.onurbolukbas.ingilizceogrentemelseviye;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String QUIZ_KEY="key";
    public static final int QUIZ_RENKLER=0;
    public static final int QUIZ_SAYILAR=1;
    public static final int QUIZ_HAYVANLAR=2;
    public static final int QUIZ_MESLEKLER=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void turClick(View view){


        Intent intent=new Intent(getApplicationContext(),QuizActivity.class);

        switch (view.getId()){
            case R.id.fab_1:
                intent.putExtra(QUIZ_KEY,QUIZ_RENKLER);
                startActivity(intent);

                break;
            case R.id.fab_2:
                intent.putExtra(QUIZ_KEY,QUIZ_SAYILAR);
                startActivity(intent);

                break;
            case R.id.fab_3:
                intent.putExtra(QUIZ_KEY,QUIZ_HAYVANLAR);
                startActivity(intent);

                break;
            case R.id.fab_4:
                intent.putExtra(QUIZ_KEY,QUIZ_MESLEKLER);
                startActivity(intent);

                break;
        }
    }
}
