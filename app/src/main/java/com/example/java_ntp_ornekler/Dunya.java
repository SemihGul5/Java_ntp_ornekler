package com.example.java_ntp_ornekler;

//PRATİK ÇALIŞMA: DÜNYANIN GENETİĞİ

//package dunya;

import java.util.ArrayList;

public class Dunya {
    public enum Diller { İngilizce, Almanca, Rusca, Türkçe}
    public enum Yonetim {demokratik, sosyalist, krallık, monarşik}
    private ArrayList<Ulke> ulkeler = new ArrayList();

    public Dunya() {
    }

    public void ulkeEkle(Ulke u) { this.ulkeler.add(u);}
    public void ulkeCikar(Ulke u) { this.ulkeler.remove(u);}
    public int yillikGelir() {
        int top = 0;
        for(Ulke u: ulkeler) { top += u.getGelir();}
        return top;
    }

    public int toplamNufus() {
        int top = 0;
        for(Ulke u: ulkeler) { top+=u.getNufus();}
        return top;
    }

    public int kabileSayisi(Ulke u) {
        return u.gruplar.size();
    }

    public int konusanUlke(Diller d) {
        int top = 0;
        for(Ulke u: ulkeler) {
            for(Kabile k: u.getGruplar())
                if(k.getDil()==d) {
                    top++;
                    break;
                }
        }
        return top;
    }


    public static class Kabile {
        private String lider;
        private String adi;
        private int nufus;
        private Diller dil;

        public Kabile(String ad) { this.adi = ad;
            this.lider = "";
            this.nufus = 0;
            this.dil = Diller.Türkçe;
        }

        public String getLider() {
            return lider;
        }

        public void setLider(String lider) {
            this.lider = lider;
        }

        // standart setter ve getter'lar
        public String getAdi() { return adi; }
        public void setAdi(String adi) { this.adi = adi; }
        public int getNufus() { return nufus; }
        public void setNufus(int nufus) { this.nufus = nufus;}
        public void setDil(Diller dil) { this.dil = dil;}
        public Diller getDil() { return this.dil;}
    }


    public static class Ulke extends Kabile {
        private String baskent;
        private Yonetim rejim;
        private int gelir;
        private ArrayList<Kabile> gruplar = new ArrayList();

        public Ulke(String baskent, Yonetim rejim, int gelir, String ad) {
            super(ad);
            this.baskent = baskent;
            this.rejim = rejim;
            this.gelir = gelir;
        }

        public String getBaskent() {
            return baskent;
        }

        public void setBaskent(String baskent) {
            this.baskent = baskent;
        }

        public Yonetim getRejim() {
            return rejim;
        }

        public void setRejim(Yonetim rejim) {
            this.rejim = rejim;
        }

        public int getGelir() {
            return gelir;
        }

        public void setGelir(int gelir) {
            this.gelir = gelir;
        }

        public ArrayList<Kabile> getGruplar() {
            return gruplar;
        }

        public void setGruplar(ArrayList<Kabile> gruplar) {
            this.gruplar = gruplar;
        }

        public void kabileEkle(Kabile k) { this.gruplar.add(k); }
        public void kabileCikar(Kabile k) { this.gruplar.remove(k); }


        public int getNufus() {
            int top = 0;
            for(Kabile k: gruplar)
                top += k.getNufus();
            return top;
        }
    }

    public static void main(String[] args) {
        Kabile kizilderili = new Kabile("Yükselen yıldız");
        kizilderili.setDil(Diller.İngilizce);
        kizilderili.setLider("Oturan Boğa");
        kizilderili.setNufus(1900);

        Kabile k2 = new Kabile("Inkalar");
        k2.setDil(Diller.Rusca);
        k2.setLider("Da Da Da");
        k2.setNufus(5000);

        Kabile kayi = new Kabile("Kayı Boyu");
        kayi.setDil(Diller.Türkçe);
        kayi.setLider("Ertuğrul Gazi");
        kayi.setNufus(10000);


        Ulke turkiye = new Ulke("Ankara",Yonetim.demokratik,20000,"Türkiye");
        turkiye.kabileEkle(kayi);
        turkiye.kabileEkle(kizilderili);

        Ulke hindistan = new Ulke("Yeni Delhi",Yonetim.monarşik,200000,"Hindistan");
        hindistan.kabileEkle(k2);
        hindistan.kabileEkle(kizilderili);

        Ulke norvec = new Ulke("Oslo",Yonetim.krallık,5000,"Norveç");
        norvec.kabileEkle(k2);
        norvec.kabileEkle(kayi);
        norvec.kabileEkle(kizilderili);

        Dunya earth = new Dunya();
        earth.ulkeEkle(norvec);
        earth.ulkeEkle(turkiye);
        earth.ulkeEkle(hindistan);

        System.out.println("Dünya nüfusu:" + earth.toplamNufus());
        System.out.println("Dünya geliri:" + earth.yillikGelir());
        System.out.println("Türkçe konuşan ülke sayısı:" + earth.konusanUlke(Diller.Türkçe));


    }
}