package com.example.java_ntp_ornekler;

//package yemek;

import java.util.ArrayList;

public class Yemek {
    public enum olcu{
        adet,
        litre,
        bardak,
        gram,
        kaşık,
        tutam;
    }
    public enum tur{
        etli,
        sebzeli,
        zeytinyağlı,
        arasıcak,
        çorba,
        tatlı;

    }

    private String ad;
    private int pismeSuresi;
    private tur tip;
    private ArrayList<Malzeme> icerik= new ArrayList();

    public Yemek(String ad, int pismeSuresi, tur tip) {
        this.ad = ad;
        this.pismeSuresi = pismeSuresi;
        this.tip = tip;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getPismeSuresi() {
        return pismeSuresi;
    }

    public void setPismeSuresi(int pismeSuresi) {
        this.pismeSuresi = pismeSuresi;
    }

    public tur getTip() {
        return tip;
    }

    public void setTip(tur tip) {
        this.tip = tip;
    }
    public void icerikEkle(Malzeme m){

        if(!icerik.contains(m))
            icerik.add(m);

    }
    public void icerikCikar(Malzeme m){
        if(icerik.contains(m))
            this.icerik.remove(m);
    }
    public int maliyet(){
        int top=0;
        for (int i = 0; i < icerik.size(); i++) {
            top+=icerik.get(i).getBirimFiyat()*icerik.get(i).getMiktar();

        }
        return top;
    }

    public String tarifEt(){
        String tarif="";
        tarif+=this.getAd()+" Tarifi: \n";
        for(Malzeme m:this.icerik)
        {
            tarif+=m.getMiktar()+" "+m.birim+" "+m.getAd()+" ekleyin \n";
        }
        tarif+="Afiyet Olsun! :)";
        return tarif;
    }


    public static class Malzeme{

        private String ad;
        private olcu birim;
        private int miktar;
        private int birimFiyat;

        public Malzeme(String ad, olcu birim, int miktar, int birimFiyat) {
            this.ad = ad;
            this.birim = birim;
            this.miktar = miktar;
            this.birimFiyat = birimFiyat;
        }

        public String getAd() {
            return ad;
        }

        public void setAd(String ad) {
            this.ad = ad;
        }

        public olcu getBirim() {
            return birim;
        }

        public void setBirim(olcu birim) {
            this.birim = birim;
        }

        public int getMiktar() {
            return miktar;
        }

        public void setMiktar(int miktar) {
            this.miktar = miktar;
        }

        public int getBirimFiyat() {
            return birimFiyat;
        }

        public void setBirimFiyat(int birimFiyat) {
            this.birimFiyat = birimFiyat;
        }



    }


    public static void main(String[] args) {
        Malzeme patlican=new Malzeme ("Bostan Patlican",olcu.adet,1,3);
        Malzeme seker=new Malzeme("Toz şeker",olcu.bardak,1,1);
        Malzeme un=new Malzeme("Buğday unu",olcu.bardak,1,1);
        Malzeme yag =new Malzeme("Ayçiçek yağı",olcu.kaşık,2,1);
        Malzeme su=new Malzeme("İçme suyu",olcu.litre,1,1);


        Yemek helva=new Yemek("Un Helvası",20,tur.tatlı);
        helva.icerikEkle(un);
        helva.icerikEkle(su);
        helva.icerikEkle(seker);
        helva.icerikEkle(yag);

        System.out.println(helva.tarifEt());
        System.out.println(helva.maliyet()+"TL");


    }

}
