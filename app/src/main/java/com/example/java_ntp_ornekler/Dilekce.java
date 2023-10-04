package com.example.java_ntp_ornekler;

import java.util.ArrayList;

// Dilekçe sınıfı
public class Dilekce {

    public enum tur {şikayet("Yukarıdaki konu hakkındaki şikayetimin değerlendirilmesini arz ederim."),
        talep("Yukarıdaki talebimin gereğinin makamınızca yapılmasını arz ederim."),
        dava(" konusunda dava açmak istiyorum. Gereğini arz ederim.");

        private String metin;

        private tur(String met) {
            this.metin = met;
        }

        public String getirGovde() { return this.metin;}
    }


    private String no;
    private String tarih;
    private String konu;
    private String ek;
    private tur tip;
    private Kisi sahibi;
    private Kisi alici;

    public Dilekce( String tarih, String konu, Kisi sahip, Kisi alici) {
        this.tarih = tarih;
        this.konu = konu;
        this.sahibi = sahip;
        this.alici = alici;
        this.no = "0";
        this.ek = null;
        this.tip = tur.talep;
    }

    // Constructor overloading yaptık
    public Dilekce(String konu) {
        this.tarih = "01/01/2019";
        this.konu = konu;
        this.sahibi = null;
        this.alici = null;
        this.no = "0";
        this.ek = null;
        this.tip = tur.talep;
    }

    // Klasik getter'larımız
    public String numaranNe() { return no; }
    public String tarihinNe() { return tarih; }
    public String hangiKonuda() { return konu; }
    public String ekiniGetir() { return ek; }
    public tur turunNe() { return tip; }
    public Kisi yazarinKim() { return sahibi; }
    public Kisi kimeHitaben() { return alici; }

    public String yazdir() {
        String metin = "";
        metin += "Tarih: " + this.tarihinNe() + " Sayı: " + this.numaranNe()+"\n\n";
        metin += "Sayın " + this.kimeHitaben().adinNe()+"; \n\n";
        metin += "Konu: " + this.hangiKonuda()+" \n\n";
        metin += tip.getirGovde()+"\n\n";
        metin += "Saygılarımla, \n\n" + this.yazarinKim().adinNe();

        return metin;
    }

    // Klasik setter'larımız
    public void numaranOlsun(String no) { this.no = no;}
    public void tarihDegis(String tar) { this.tarih = tar;}
    public void konuDegis(String kon) { this.konu = kon;}
    public void ekDegis(String ek) { this.ek = ek;}
    public void turDegis(tur tip) { this.tip = tip;}
    public void yazarinBu(Kisi yz) { this.sahibi = yz;}
    public void bunaHitaben(Kisi al) { this.alici = al;}



    // Kişi atamız
    public static class Kisi {
        private String isim;
        private String adres;
        private String telefon;
        private ArrayList<Dilekce> dilekceler= new ArrayList();

        public Kisi(String ad) {this.adinOlsun(ad);
            this.adresinOlsun("");
            this.telNoDegis("");
            this.dilekcelerTemizle();}

        public String adinNe() { return this.isim;}
        public String adresinNe() { return this.adres;}
        public String telefonuSoyle() { return this.telefon;}

        public void adinOlsun(String ad) {this.isim = ad;}
        public void adresinOlsun(String adr) { this.adres = adr;}
        public void telNoDegis(String no) { this.telefon = no;}
        public void dilekcelerTemizle() { this.dilekceler.clear();}
        public void dilekceEkle(Dilekce dlk) { this.dilekceler.add(dlk);}
        public void dilekceSil(Dilekce dlk) { this.dilekceler.remove(dlk);}

        // ÖZel kişi çocuğumuz
        public static class OzelKisi extends Kisi {
            private String TCK;
            private String dogTar;

            public OzelKisi(String TCK, String ad) {
                super(ad); //Superini de oluşturacak yapılandırıcıya yönlendirme
                this.TCK = TCK;
            }

            // standart getter'larımız
            public String getTCK() { return TCK; }
            public String getDogTar() { return dogTar;}

            // standart setter'larımız
            public void setTCK(String TCK) { this.TCK = TCK; }
            public void setDogTar(String dogTar) { this.dogTar = dogTar;}
        }

        // Tüzel kişi çocuğumuz
        public static class TuzelKisi extends Kisi {
            private String verNo;
            private String verDaire;

            public TuzelKisi(String ad) {
                super(ad); //Superini de oluşturacak yapılandırıcıya yönlendirme
                this.verNo = "";
                this.verDaire = "";
            }

            // standart getter'larımız
            public String getVerNo() { return verNo; }
            public String getVerDaire() { return verDaire;}

            // standart setter'larımız
            public void setVerNo(String vno) { this.verNo = vno; }
            public void setVerDaire(String vdr) { this.verDaire = vdr;}
        }
    }


    public static void main(String[] args) {

        /*OzelKisi taraf1 = new OzelKisi("1111111","Vildan");
        TuzelKisi taraf2 = new TuzelKisi("Çevre Bakanlığı");

        Dilekce arzuhal = new Dilekce("Toplanmayan çöpler hakkında");
        arzuhal.bunaHitaben(taraf2);
        arzuhal.yazarinBu(taraf1);
        taraf1.dilekceEkle(arzuhal);
        taraf2.dilekceEkle(arzuhal);
        arzuhal.turDegis(tur.şikayet);

        System.out.println(arzuhal.yazdir());*/
    }
}

