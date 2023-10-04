package com.example.java_ntp_ornekler;

//PRATİK ÇALIŞMA: BİR KARAKOL HİKAYESİ

//package karakol;
public class Karakol {

    public enum cins { kadın, erkek};

    public static class Insan {
        private String isim;
        private int yas;
        private cins cinsiyet;

        public Insan(String isim, int yas, cins cinsiyet) {
            this.isim = isim;
            this.yas = yas;
            this.cinsiyet = cinsiyet;
        }

        public String getIsim() {
            return isim;
        }

        public void setIsim(String isim) {
            this.isim = isim;
        }

        public int getYas() {
            return yas;
        }

        public void setYas(int yas) {
            this.yas = yas;
        }

        public cins getCinsiyet() {
            return cinsiyet;
        }

        public void setCinsiyet(cins cinsiyet) {
            this.cinsiyet = cinsiyet;
        }
    }

    public static class polis extends Insan {
        private String sicilNo;

        public polis(String isim, int yas, cins cinsiyet, String sicil) {
            super(isim, yas, cinsiyet);
            this.sicilNo = sicil;
        }

        public String getSicilNo() {
            return sicilNo;
        }

        public void setSicilNo(String sicilNo) {
            this.sicilNo = sicilNo;
        }

        public String adiniSoyle() {
            return super.getIsim();
        }

        public void yakala(Hirsiz h) {
            h.Yakalan();
        }

        public void serbestBirak(Hirsiz h) {
            h.Serbest();
        }

    }


    public static class Hirsiz extends Insan{
        private boolean sabika;
        private boolean yakalandi;

        public Hirsiz(boolean sabika, String isim, int yas, cins cinsiyet) {
            super(isim, yas, cinsiyet);
            this.sabika = sabika;
            this.yakalandi = false;
        }

        public boolean isSabika() {
            return sabika;
        }

        public void setSabika(boolean sabika) {
            this.sabika = sabika;
        }

        public boolean Yakalandimi() {
            return yakalandi;
        }

        public void Yakalan() {
            this.yakalandi = true;
        }

        public void Serbest() {
            this.yakalandi = false;
        }

    }

    public static void main(String[] args) {
        polis pol = new polis("uğur", 30, cins.erkek, "1111");
        System.out.println( pol.adiniSoyle());

        Hirsiz hir = new Hirsiz(true, "Sebastian", 25, cins.erkek);
        System.out.println("Hırsız hapiste mi: "+hir.Yakalandimi());

        pol.yakala(hir);
        System.out.println("Hırsız hapiste mi: "+hir.Yakalandimi());
    }
}