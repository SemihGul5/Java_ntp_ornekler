package com.example.java_ntp_ornekler;

//PRATİK ÇALIŞMA: E-TİCARET


//package eticaret;

import java.util.ArrayList;

public class Eticaret {
    public enum tur{
        gıda,
        elektronik,
        kitap,
        giyim}

    public static class Musteri {
        String ad;
        int para;
        String telefon;
        Sepet siparis;

        public Musteri(String ad, int para, String telefon) {
            this.ad = ad;
            this.para = para;
            this.telefon = telefon;
        }

        public String getAd() {
            return ad;
        }

        public void setAd(String ad) {
            this.ad = ad;
        }

        public int getPara() {
            return para;
        }

        public void setPara(int para) {
            this.para = para;
        }

        public String getTelefon() {
            return telefon;
        }

        public void setTelefon(String telefon) {
            this.telefon = telefon;
        }

        public Sepet getSiparis() {
            return siparis;
        }

        public void setSiparis(Sepet siparis) {
            this.siparis = siparis;
        }

        public void iptalSepet() {
            this.siparis.setSahip(null);
            this.siparis = null;

        }

    }

    public static class Sepet {
        private ArrayList<Urun> urunler = new ArrayList();
        private int no;
        private Musteri sahip;

        public Sepet(int no) {
            this.no = no;
        }

        public Musteri getSahip() {
            return sahip;
        }

        public void setSahip(Musteri sahip) {
            this.sahip = sahip;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public void urunEkle(Urun u) {
            this.urunler.add(u);
            u.setAdet(u.getAdet()-1);
        }

        public void urunKaldir(Urun u) {
            this.urunler.remove(u);
            u.setAdet(u.getAdet()+1);
        }

        public void sifirla() {
            this.urunler.clear();
        }

        public int tutarGetir() {
            int top = 0;
            for(Urun u:this.urunler)
                top += u.getFiyat();
            return top;
        }

        public int adetGetir() {
            return this.urunler.size();
        }
    }

    public static class Urun {
        private String ad;
        private tur tipi;
        private int fiyat;
        private String barkod;
        private int adet;

        public Urun(String ad, tur tip, int fiyat, String barkod, int adet) {
            this.ad = ad;
            this.tipi = tip;
            this.fiyat = fiyat;
            this.barkod = barkod;
            this.adet = adet;
        }

        public String getAd() {
            return ad;
        }

        public void setAd(String ad) {
            this.ad = ad;
        }

        public tur getTipi() {
            return tipi;
        }

        public void setTipi(tur tipi) {
            this.tipi = tipi;
        }

        public int getFiyat() {
            return fiyat;
        }

        public void setFiyat(int fiyat) {
            this.fiyat = fiyat;
        }

        public String getBarkod() {
            return barkod;
        }

        public void setBarkod(String barkod) {
            this.barkod = barkod;
        }

        public int getAdet() {
            return adet;
        }

        public void setAdet(int adet) {
            this.adet = adet;
        }
    }

    public static void main(String[] args) {

        Urun bilgisayar = new Urun("HP Laptop",tur.elektronik,5000,"86934432",50);
        Urun icecek = new Urun("Ice Tea", tur.gıda, 7, "869003344",90);
        Urun giyim = new Urun("Ayakkabı Nike 45", tur.giyim, 200, "14398974", 10);

        Sepet sip = new Sepet(1);
        sip.urunEkle(giyim);
        sip.urunEkle(bilgisayar);
        sip.urunEkle(bilgisayar);
        sip.urunEkle(icecek);

        Musteri tuketici = new Musteri("Şebnem Korcan", 1000, "55544563");
        tuketici.setSiparis(sip);
        tuketici.getSiparis().setSahip(tuketici);

        System.out.println(tuketici.getAd()+ " müşterisinin sepetindeki "+tuketici.getSiparis().adetGetir()
                +" adet ürünün toplam fiyatı "+tuketici.getSiparis().tutarGetir()+" TL");
    }
}
