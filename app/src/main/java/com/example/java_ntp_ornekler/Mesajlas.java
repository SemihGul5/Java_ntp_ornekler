package com.example.java_ntp_ornekler;


//package ınsan;

import java.util.ArrayList;

public class Mesajlas {
    String ad;
    String mesaj;
    String[]insanGenel=new String[100];
    String[]insanOzel=new String[100];
    int []mesajAdet=new int[100];

    public enum tur{ozel,genel;}

    public Mesajlas()
    {

    }
    public Mesajlas(String ad)
    {
        this.ad=ad;
    }

    public void arkadaslikKur(String ad)
    {

        for (int i = 0; i < insanGenel.length; i++) {
            int e= insanGenel[i].indexOf(ad);
            if (e<0) {
                insanGenel[i]=ad;
                mesajAdet[i]=0;
            }
            else
            {
                System.out.println("bu kişi zaten var");
            }
        }
    }
    public void ekleOzel(String ad)
    {
        this.ad=ad;
        for (int i = 0; i < insanGenel.length; i++) {
            int b= insanGenel[i].indexOf(ad);
            if (b>0) {
                insanOzel[i]=ad;
            }
            else
            {
                System.out.println("bu kişi yok");
            }
        }


    }
    public void cikarOzel(String ad)
    {
        this.ad=ad;
        for (int i = 0; i < insanOzel.length; i++) {
            int a= insanOzel[i].indexOf(ad);
            if (a>0) {
                insanOzel[i]=null;
            }
            else
            {
                System.out.println("Bu kişi yok");
            }
        }

    }
    public void arkadaslikBitir(String ad)
    {
        this.ad=ad;
        for (int i = 0; i < insanGenel.length; i++) {
            int c=insanGenel[i].indexOf(ad);

            if (c>0) {
                insanGenel[i]=null;
                insanOzel[i]=null;
                mesajAdet[i]=0;
            }
            else
            {
                System.out.println("bu kişi yok");
            }
        }
    }
    public void mesajGonder(tur tip,String mesaj)
    {
        if (tip==tur.genel) {
            for (int i = 0; i < insanGenel.length; i++) {
                insanGenel[i]=mesaj;
                mesajAdet[i]+=1;
            }
        }
        else if(tip==tur.ozel){
            for (int i = 0; i < insanOzel.length; i++) {
                insanOzel[i]=mesaj;
                mesajAdet[i]+=1;
            }
        }
        else
        {
            System.out.println("hatalı giriş");
        }
    }
    public void haykir(tur tip,String mesaj)
    {
        if (tip==tur.genel) {
            for (int i = 0; i < insanGenel.length; i++) {
                insanGenel[i]=mesaj.toUpperCase();
                mesajAdet[i]+=1;
            }
        }
        else if(tip==tur.ozel){
            for (int i = 0; i < insanOzel.length; i++) {
                insanOzel[i]=mesaj.toUpperCase();
                mesajAdet[i]+=1;
            }
        }
        else
        {
            System.out.println("hatalı giriş");
        }
    }

    public String enSamimi()
    {
        String goster="";
        int enb=mesajAdet[0];
        for (int i = 0; i < mesajAdet.length; i++) {
            if (mesajAdet[i]>enb) {
                enb=mesajAdet[i];
                insanGenel[i]=goster;
            }
        }
        return goster;
    }
    public String enSeyrek()
    {
        String gosterSeyrek="";
        int enb=mesajAdet[0];
        for (int i = 0; i < mesajAdet.length; i++) {
            if (mesajAdet[i]<enb) {
                enb=mesajAdet[i];
                insanGenel[i]=gosterSeyrek;
            }
        }
        return gosterSeyrek;
    }
    public void unutGitsin()
    {
        for (int i = 0; i < insanGenel.length; i++) {
            insanGenel[i]="";
            insanOzel[i]="";
            mesajAdet[i]=0;
        }
    }
    public void herkeseEsitim()
    {
        for (int i = 0; i < insanOzel.length; i++) {

            insanOzel[i]=null;

        }
    }
    public String arkadaslarim()
    {
        String b="";
        for (String insanGenel1 : insanGenel) {
            b = insanGenel1;

        }
        System.out.println(b);
        return b;
    }
    public static void main(String[] args) {


    }

}

