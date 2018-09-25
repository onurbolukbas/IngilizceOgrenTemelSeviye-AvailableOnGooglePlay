package c.onurbolukbas.ingilizceogrentemelseviye;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    private static List<String> genelListe,soruListesi,cevapListesi;
    private RelativeLayout soruContainer;
    private int quizTur;
    private int basariOrani;
    private static String dogruCevap;
    private int dogruCevapSayisi=0;
    private int kacinciSoruda=0;
    private int kacinciDenemedeBildi=0;
    private static Random rand;
    private static TextView soruMetni_tv;
    private static TextView soruSayisi_tv;
    private static final int TOPLAM_SORU_SAYISI=10;
    private LinearLayout buttonContainer;
    private View.OnClickListener buttonDinleyici=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button button=(Button)v;
            String tiklananCevapText=button.getText().toString();

                if (tiklananCevapText.equals(dogruCevap)) {

                    kacinciSoruda++;
                   // kacinciDenemedeBildi++;
                  //  tebrikMesaji(kacinciDenemedeBildi);
                    //butonlarUnable();

                    if(kacinciSoruda==TOPLAM_SORU_SAYISI) {
                        basariOrani=basariOraniHesapla(kacinciDenemedeBildi);
                        diyalog();
                    }
                    else{
                        sonrakiSoruyaGec();
                    }

                } else {
                    kacinciDenemedeBildi++;
                    butonUnable(button);
                    Animasyonlar.titremeAnimation(soruMetni_tv);
                }

        }
    }; // onClickListener bitiş


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        genelListe=new ArrayList<String>();
        soruListesi=new ArrayList<String>();
        cevapListesi=new ArrayList<String>();
        soruMetni_tv=(TextView)findViewById(R.id.soru_tv);
        soruSayisi_tv=(TextView)findViewById(R.id.soruSayi_tv);
        buttonContainer=(LinearLayout) findViewById(R.id.button_container);
        soruContainer=(RelativeLayout)findViewById(R.id.duyarlı_layout);

        quizTur=getIntent().getIntExtra(MainActivity.QUIZ_KEY,9);
        switch (quizTur){
            case MainActivity.QUIZ_RENKLER:

                String[] dizi=getResources().getStringArray(R.array.renkler);
                for(String s:dizi){
                    genelListe.add(s);
                }

                break;
            case MainActivity.QUIZ_SAYILAR:
                String[] dizi1=getResources().getStringArray(R.array.sayilar);
                for(String s:dizi1){
                    genelListe.add(s);
                }

                break;
            case MainActivity.QUIZ_HAYVANLAR:
                String[] dizi2=getResources().getStringArray(R.array.hayvanlar);
                for(String s:dizi2){
                    genelListe.add(s);
                }
                break;
            case MainActivity.QUIZ_MESLEKLER:
                String[] dizi3=getResources().getStringArray(R.array.meslekler);
                for(String s:dizi3){
                    genelListe.add(s);
                }
                break;
        }//switch-case bitiş
        soruSayisi_tv.setText((kacinciSoruda+1) + " / "+TOPLAM_SORU_SAYISI);
        setSoruListesi();
        setSoruMetni(kacinciSoruda);
        dogruCevap=getCevap(soruListesi.get(kacinciSoruda));
        setCevapListesi();
        setButonCevap();
        for(int satir=0;satir<buttonContainer.getChildCount();satir++){
            Button button=(Button)buttonContainer.getChildAt(satir);
            button.setOnClickListener(buttonDinleyici);
        }
    }//onCreate Bitiş

    public void setSoruListesi(){ // genel listeden soru listesine random eleman çekiyorum contain ile de aynı değerin gelmemesini kontrol ediyorum
        String soru;
        rand=new Random();

        while(!(soruListesi.size()==10)) {

            int random=rand.nextInt(genelListe.size());
            soru=genelListe.get(random).toString();
            if(!soruListesi.contains(soru))
            {
                soruListesi.add(soru);
            }
        }
    }//setSoruListesi() bitiş

    public void setSoruMetni(int indis){ //soru listesinden gelen indisteki değeri alıp soru metnine atıyorum
        String soru=soruListesi.get(indis);
        String sadeceSoru=getSoru(soru);
        soruMetni_tv.setText(sadeceSoru);
    }//setSoruMetni() bitiş

    public String getSoru(String soru){ //verilen string parametrede - den öncesini çekiyor

        soru=soru.substring(0,soru.indexOf("-"));
        return soru;
    }//getSoru() bitiş

    public String getCevap(String soru){ //verilen string parametrede - den sonrasını çekiyor
        String cevap;
        cevap=soru.substring(soru.indexOf("-")+1,soru.length());
        return cevap;
    }//getCevap() bitiş

    public void setButonCevap(){ //Butonlara önce cevap listesinden seçenekler atadım sonra da dogru cevabı random bir butona atadım
        for(int satir=0;satir<buttonContainer.getChildCount();satir++){
            Button button=(Button)buttonContainer.getChildAt(satir);
            button.setText(cevapListesi.get(satir).toString());
        }
        int random=rand.nextInt(4);
        for(int satir=0;satir<buttonContainer.getChildCount();satir++){
            Button button=(Button)buttonContainer.getChildAt(satir);
            if(satir==random&&(!cevapListesi.contains(dogruCevap))){
                button.setText(dogruCevap);
            }

        }
    }//setButonCevap() bitiş

    public void setCevapListesi(){ // genel listeden cevap listesine random eleman çekiyorum contain ile de aynı değerin gelmemesini kontrol ediyorum
        String cevap;
        rand=new Random();

        while(!(cevapListesi.size()==4)) {

            int random=rand.nextInt(genelListe.size());
            cevap=getCevap((genelListe.get(random).toString()));
            if(!cevapListesi.contains(cevap))
            {
                cevapListesi.add(cevap);
            }
        }
    }//setCevapListesi() bitiş

    private void butonUnable(Button button) {
        button.setEnabled(false);
        button.setTextColor(000000);
    }//butonUnable() bitiş

    private void butonlarUnable() {
        for(int satir=0;satir<buttonContainer.getChildCount();satir++){
            Button button=(Button)buttonContainer.getChildAt(satir);
            button.setEnabled(false);
        }
    }//butonlarUnable() bitiş

    private void sonrakiSoruyaGec(){

        cevapListesi.clear();
        soruSayisi_tv.setText((kacinciSoruda+1) + " / "+TOPLAM_SORU_SAYISI);
        dogruCevap=getCevap(soruListesi.get(kacinciSoruda));
        butonlarEnable();
        setCevapListesi();
        setSoruMetni(kacinciSoruda);
        setButonCevap();
        soruAnimasyon();
    }//sonrakiSoruyaGec() bitiş


    private void butonlarEnable() {
        for(int satir=0;satir<buttonContainer.getChildCount();satir++){
            Button button=(Button)buttonContainer.getChildAt(satir);
            button.setEnabled(true);
            button.setTextColor(Color.WHITE);
        }
    }//butonlarEnable() bitiş

    private void resetQuiz() {

        kacinciDenemedeBildi=1;
        kacinciSoruda=0;
        soruSayisi_tv.setText(kacinciSoruda + " / "+TOPLAM_SORU_SAYISI);
        soruListesi.clear();
        setSoruListesi();
        setSoruMetni(kacinciSoruda);
        cevapListesi.clear();
        setCevapListesi();
        dogruCevap=getCevap(soruListesi.get(kacinciSoruda));
        setButonCevap();
        butonlarEnable();



    }//resetQuiz() bitiş

    private void diyalog(){
        new AlertDialog.Builder(QuizActivity.this)
                .setTitle("Test Bitti!")
                .setMessage("Tebrikler, "+"%"+ basariOrani +" 'lik başarı oranı ile testi tamamladınız.")
                .setCancelable(false)
                .setPositiveButton("Testi Tekrar Başlat", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        resetQuiz();
                        dialog.dismiss();
                    }
                }).setNegativeButton("Ana Ekrana Dön", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                dialog.dismiss();
            }
        }).show();
    }//diyalog() bitiş

    private void soruAnimasyon() {
        rand=new Random();
        List<View> butonlar=new ArrayList<View>();
        for(int satir=0;satir<4;satir++){
            Button button= (Button) buttonContainer.getChildAt(satir);
            butonlar.add(button);

        }
        Animasyonlar.yaziAnimation(soruMetni_tv,rand.nextInt(24));
        Animasyonlar.butonlarAnimation(butonlar);

    }//soruAnimasyon() bitiş

    private void tebrikMesaji(int kacinciDeneme) {
        String tebrikMesaji="";
        switch (kacinciDeneme) {
            case 1:
                tebrikMesaji="Muhteşem";
                break;
            case 2:
                tebrikMesaji="Çok İyi";
                break;
            case 3:
                tebrikMesaji="İyi";
                break;
            case 4:
                tebrikMesaji="Fena Değil";
                break;
        }
        soruMetni_tv.setText(tebrikMesaji);
        soruMetni_tv.setTextColor(Color.WHITE);
        //soruMetni_tv.setTextSize(40);
        Animasyonlar.tebrikAnimation(soruMetni_tv);
    }//tebrikMesaji() bitiş

    private int basariOraniHesapla(int kacinciDeneme){
        return 100-((100*(kacinciDeneme-1))/30);
    }//basariOraniHesapla() bitiş

}//son blok