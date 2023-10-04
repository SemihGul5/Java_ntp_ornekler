package com.example.java_ntp_ornekler;

//package siramatik;

import java.util.ArrayList;
import java.util.Date;


public class SiraMatik {
    public enum Islemler{
        bireysel,
        kurumsal,
        vezne,
        diğer;
    }
    public static class Fis{
        int no;
        Date zaman;
        Islemler islem;

        public Fis(int sira,Islemler is) {
            this.islem = is;
            this.zaman=new Date();
            this.no=sira;

        }

        public int getNo() {
            return no;
        }

        public Date getZaman() {
            return zaman;
        }

        public Islemler getIslem() {
            return islem;
        }
    }
    public static class Terminal{
        int islemNo;

        public Terminal(){
            this.islemNo=0;
        }
        public int islemNoGetir(){
            return this.islemNo;
        }
        public int yeniIslemAl(){
            this.islemNo++;
            return this.islemNo;
        }
    }
    public static class Kiosk extends Terminal{
        int sira;
        ArrayList<Fis> fisler=new ArrayList();
        public Kiosk() {

            this.sira = 0;

        }

        public void fisUret(Islemler is){

            Fis f=new Fis(this.numaraAl(),is);
            fisler.add(f);

        }
        public int numaraAl(){
            this.sira++;
            return sira;
        }
        @Override
        public int islemNoGetir(){
            return super.islemNo;

        }
        public int siraNoGetir(){
            return this.sira;
        }

    }
    public static class Vezne extends Terminal{
        Islemler tur;
        Kiosk k;
        public Vezne(Islemler t,Kiosk k){
            this.tur=t;
            this.k=k;

        }
        public void musteriAl(){
            boolean var=false;
            if(k.islemNoGetir()<k.siraNoGetir())
                System.out.println(this.tur+" > "+k.yeniIslemAl());
        }
    }


    public static void main(String[] args) {
        Kiosk k =new Kiosk();
        Vezne v1=new Vezne(Islemler.bireysel,k);
        Vezne v2=new Vezne(Islemler.kurumsal,k);
        k.fisUret(Islemler.diğer);
        k.fisUret(Islemler.bireysel);
        k.fisUret(Islemler.bireysel);
        k.fisUret(Islemler.kurumsal);

        System.out.println(k.sira);

        System.out.println("v1: "+v1.yeniIslemAl());
        System.out.println("v2: "+v2.yeniIslemAl());
    }

}
