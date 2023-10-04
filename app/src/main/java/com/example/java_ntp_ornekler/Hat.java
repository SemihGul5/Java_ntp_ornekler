package com.example.java_ntp_ornekler;

//PRATİK ÇALIŞMA: İETT OTOBÜS HATTI


//package hat;

import java.util.ArrayList;

public class Hat {
    private String kod;
    private ArrayList<Durak> istasyon = new ArrayList();

    public Hat(String kod) {
        this.kod = kod;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public void durakEkle(Durak d) { this.istasyon.add(d);}
    public void durakSil(Durak d) { this.istasyon.remove(d);}
    public Durak durakGetir(int sira) {
        return this.istasyon.get(sira);
    }

    public static class Otobus {
        private String plaka;
        private Hat guzergah;
        private int konumX;
        private int konumY;

        public Otobus(String plaka, Hat guzergah, int konumX, int konumY) {
            this.plaka = plaka;
            this.guzergah = guzergah;
            this.konumX = konumX;
            this.konumY = konumY;
        }

        public String getPlaka() {
            return plaka;
        }

        public void setPlaka(String plaka) {
            this.plaka = plaka;
        }

        public Hat getGuzergah() {
            return guzergah;
        }

        public void setGuzergah(Hat guzergah) {
            this.guzergah = guzergah;
        }

        public int getKonumX() {
            return konumX;
        }

        public void setKonumX(int konumX) {
            this.konumX = konumX;
        }

        public int getKonumY() {
            return konumY;
        }

        public void setKonumY(int konumY) {
            this.konumY = konumY;
        }

        public String tabelaGoster() {
            String tabela = "";
            tabela = this.getGuzergah().getKod();
            tabela += " "+this.getGuzergah().durakGetir(0).getAd() + " - "
                    + this.getGuzergah().durakGetir(this.guzergah.istasyon.size()-1).getAd();
            return tabela;
        }

    }


    public static class Durak {
        private String ad;
        private int konumX;
        private int konumY;

        public Durak(String ad, int konumX, int konumY) {
            this.ad = ad;
            this.konumX = konumX;
            this.konumY = konumY;
        }

        public String getAd() {
            return ad;
        }

        public void setAd(String ad) {
            this.ad = ad;
        }

        public int getKonumX() {
            return konumX;
        }

        public void setKonumX(int konumX) {
            this.konumX = konumX;
        }

        public int getKonumY() {
            return konumY;
        }

        public void setKonumY(int konumY) {
            this.konumY = konumY;
        }
    }

    public static void main(String[] args) {
        Durak d1 = new Durak("Mustafa Kemal Paşa",0,300);
        Durak d2 = new Durak("Cihangir Mahallesi",290,670);
        Durak d3 = new Durak("Avcılar",732,840);
        Durak d4 = new Durak("Şükrübey",460,990);
        Durak d5 = new Durak("İBB Sosyal Tesisleri",880,1090);

        Hat ht = new Hat("HT20");
        ht.durakEkle(d1);
        ht.durakEkle(d2);
        ht.durakEkle(d3);
        ht.durakEkle(d4);
        ht.durakEkle(d5);

        Otobus oto = new Otobus("34 KK 673", ht, 0, 300);
        System.out.println(oto.tabelaGoster());
    }
}

