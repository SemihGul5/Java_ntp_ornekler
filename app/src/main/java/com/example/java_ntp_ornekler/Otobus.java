package com.example.java_ntp_ornekler;


//package otobus;

public class Otobus {
    public enum cinsiyet{erkek,kadın;}
    public enum statu{indirimli,tam,vip;}
    public enum konum{cam,koridor;}



    public static class Yolcu{
        private String ad;
        private String tck;
        private cinsiyet cins;
        private int yas;
        private int para;

        public Yolcu(){
            this.ad="İsimsiz";
            this.tck="00000000000";
            this.cins=cinsiyet.erkek;
            this.yas=0;
            this.para=0;
        }
        public Yolcu(String isim,cinsiyet c,int y){
            this.ad=isim;
            this.tck="00000000000";
            this.yas=y;
            this.cins=c;
            this.para=0;
        }
        public String adinNe(){
            return this.ad;
        }
        public String tckSoyle(){
            return this.tck;
        }
        public int yasinKac(){
            return this.yas;
        }
        public cinsiyet cinsiyetNe(){
            return this.cins;
        }
        public int paranKac(){
            return this.para;
        }

        public void adinBuOlsun(String a){
            this.ad=a;
        }
        public void tckDegis(String tc){
            this.tck=tc;
        }
        public void yasiDegis(int yas){
            this.yas=yas;
        }
        public void cinsiyetDegis(cinsiyet c){
            this.cins=c;
        }

        public void paraKazan(int p){
            this.para+=p;
        }
        public boolean paranVarmi(int para){
            return (this.para>=para);
        }
        public void paraHarca(int para){
            if(paranVarmi(para)) this.para-=para;
        }

    }

    public static class koltuk{


        private int numara;
        private konum yer;
        private int fiyat;
        private Yolcu sahibi;
        private koltuk yanKoltuk;

        public koltuk(int num,konum y,int f){
            this.numara=num;
            this.yer=y;

            this.fiyat=f;
        }

        public int kacLira(){return this.fiyat;}
        public int kacNumara(){return this.numara;}
        public void yanKoltukSec(koltuk k){this.yanKoltuk=k;}
        public Yolcu sahibinKim(){return this.sahibi;}
        public boolean bosMu(){return (this.sahibi==null);}

        public boolean cinsUygunMu(Yolcu k){
            boolean donus=true;
            // if((this.yanKoltuk.sahibinKim()!=null)&&(k.cinsiyetNe()==this.yanKoltuk.sahibinKim().cinsiyetNe()))
            if(this.yanKoltuk!=null)
                if(k.cinsiyetNe()==this.yanKoltuk.sahibinKim().cinsiyetNe())
                    donus=false;
                else
                    donus=true;
            return donus ;
        }
        public void sat(Yolcu kime){

            if(this.bosMu()&&cinsUygunMu(kime))
            {
                this.sahibi=kime;
                this.sahibi.paraHarca(this.fiyat);

            }

        }

    }

    public static void main(String[] args) {
        Yolcu misafir1=new Yolcu();
        misafir1.adinBuOlsun("Hülya");
        misafir1.cinsiyetDegis(cinsiyet.kadın);
        misafir1.yasiDegis(18);
        misafir1.paraKazan(1000);


        Yolcu misafir2=new Yolcu("Ahmet",cinsiyet.erkek,21);
        misafir2.paraKazan(800);


        koltuk k1=new koltuk(1,konum.cam,150);
        koltuk k2=new koltuk(2,konum.koridor,100);
        System.out.println(misafir1.paranKac());

        k1.yanKoltukSec(k2);
        k2.yanKoltukSec(k1);
        k2.sat(misafir2);
        k1.sat(misafir1);
        System.out.println("K1 koltuğunun sahibi: "+k1.sahibinKim().adinNe());
        System.out.println("K2 koltuğunun sahibi: "+k2.sahibinKim().adinNe());



    }

}

