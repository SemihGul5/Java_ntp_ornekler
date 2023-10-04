package com.example.java_ntp_ornekler;

//PRATİK ÇALIŞMA: KARAYOLU OGS SİSTEMİ

//package hgs;
public class Hgs {
    public int bakiye;
    public enum Tur {Sınıf1 (7500),
        Sınıf2 (15000),
        Sınıf3 (60000);
        private int ucret;

        private Tur(int ucr) { this.ucret = ucr; }
        public int getirUcret() { return this.ucret;}
    }

    public Hgs(int bakiye) {
        this.bakiye = bakiye;
    }

    public int getBakiye() {
        return bakiye;
    }

    public void setBakiye(int bakiye) {
        this.bakiye = bakiye;
    }

    public void ucretOde(Tasit t) {
        this.bakiye += t.odemeMiktar();
        t.setBakiye(t.getBakiye()-t.odemeMiktar());
    }


    public static class Tasit {
        private String plaka;
        private int bakiye;
        private Tur tip;

        public Tasit(String plaka, Tur tip) {
            this.plaka = plaka;
            this.tip = tip;
            this.bakiye = 0;
        }

        public String getPlaka() {
            return plaka;
        }

        public void setPlaka(String plaka) {
            this.plaka = plaka;
        }

        public int getBakiye() {
            return bakiye;
        }

        public void setBakiye(int bakiye) {
            this.bakiye = bakiye;
        }

        public Tur getTip() {
            return tip;
        }

        public void setTip(Tur tip) {
            this.tip = tip;
        }

        public int odemeMiktar() { return this.getTip().getirUcret();}
    }

    public static class Motosiklet extends Tasit {
        private int gidonBoy;

        public Motosiklet(String plaka, Tur tip) {
            super(plaka, tip);
            this.gidonBoy = 50;
        }

        public int getGidonBoy() {
            return gidonBoy;
        }

        public void setGidonBoy(int gidonBoy) {
            this.gidonBoy = gidonBoy;
        }

    }

    public static class Otomobil extends Tasit {
        private int motorHacmi;

        public Otomobil(String plaka, Tur tip) {
            super(plaka, tip);
            this.motorHacmi = 0;
        }

        public int getmotorHacmi() {
            return motorHacmi;
        }

        public void setmotorHacmi(int gidonBoy) {
            this.motorHacmi = gidonBoy;
        }
    }

    public static void main(String[] args) {
        Otomobil oto = new Otomobil("34 UU 223", Tur.Sınıf2);
        Motosiklet moto = new Motosiklet("43 KK 355", Tur.Sınıf1);

        oto.setBakiye(100);
        moto.setBakiye(200);

        Hgs gise = new Hgs(0);

        gise.ucretOde(oto);
        gise.ucretOde(moto);

        System.out.println("Oto: "+oto.getBakiye());
        System.out.println("Moto: "+moto.getBakiye());
        System.out.println("HGS: "+gise.getBakiye());
    }
}
