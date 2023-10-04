package com.example.java_ntp_ornekler;

//PRATİK ÇALIŞMA: TATİL BUDUR

//package tatil;

public class Tatil {
    public enum pansiyon { tam, yarim};

    public class Bina {
        private int kapiNo;
        private int katSayisi;
        private String ad;

        public Bina(int kapiNo, int katSayisi, String ad) {
            this.kapiNo = kapiNo;
            this.katSayisi = katSayisi;
            this.ad = ad;
        }

        public int getKapiNo() {
            return kapiNo;
        }

        public void setKapiNo(int kapiNo) {
            this.kapiNo = kapiNo;
        }

        public int getKatSayisi() {
            return katSayisi;
        }

        public void setKatSayisi(int katSayisi) {
            this.katSayisi = katSayisi;
        }

        public String getAd() {
            return ad;
        }

        public void setAd(String ad) {
            this.ad = ad;
        }

    }


    public class Pansiyon extends Bina {
        private int odaSayisi;
        private int odaFiyat;
        private int kapasite;
        private pansiyon tur;

        public Pansiyon(int odaSayisi, int odaFiyat, int kapasite, int kapiNo, int katSayisi, String ad) {
            super(kapiNo, katSayisi, ad);
            this.odaSayisi = odaSayisi;
            this.odaFiyat = odaFiyat;
            this.kapasite = kapasite;
            this.tur = pansiyon.yarim;
        }

        public int getOdaSayisi() {
            return odaSayisi;
        }

        public void setOdaSayisi(int odaSayisi) {
            this.odaSayisi = odaSayisi;
        }

        public int getOdaFiyat() {
            return odaFiyat;
        }

        public void setOdaFiyat(int odaFiyat) {
            this.odaFiyat = odaFiyat;
        }

        public int getKapasite() {
            return kapasite;
        }

        public void setKapasite(int kapasite) {
            this.kapasite = kapasite;
        }

        public pansiyon getTur() {
            return tur;
        }

        public void setTur(pansiyon tur) {
            this.tur = tur;
        }
    }

    public static void main(String[] args) {
        //Pansiyon pan = new Pansiyon(20,100,40,1,5,"Şen Pansiyon");

        //System.out.println(pan.kapasite);
    }
}
