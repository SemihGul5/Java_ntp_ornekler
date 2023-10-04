package com.example.java_ntp_ornekler;

//package emlak;


public class Emlak {

    public enum yon{
        kuzey,
        güney,
        doğu,
        batı;
    }
    public static class Insan
    {
        private String isim;
        private int para;

        public Insan(String isim, int para) {
            this.isim = isim;
            this.para = para;
        }

        public String getIsim() {
            return isim;
        }

        public void setIsim(String isim) {
            this.isim = isim;
        }

        public int getPara() {
            return para;
        }

        public void setPara(int para) {
            this.para = para;
        }

    }
    //Her türlü gayrimenkulün atası
    public static class Mulk{
        private String adres;
        private int fiyat;
        private int alan;

        public Mulk(String adres, int fiyat, int alan) {
            this.adres = adres;
            this.fiyat = fiyat;
            this.alan = alan;
        }


        public String getAdres() {
            return adres;
        }

        public void setAdres(String adres) {
            this.adres = adres;
        }

        public int getFiyat() {
            return fiyat;
        }

        public void setFiyat(int fiyat) {
            this.fiyat = fiyat;
        }

        public int getAlan() {
            return alan;
        }

        public void setAlan(int alan) {
            this.alan = alan;
        }

    }
    public static class Ev extends Mulk{
        private int odaSayisi;
        private int kat;
        private yon cephe;

        public Ev(int odaSayisi, int kat, yon cephe, String adres, int fiyat, int alan) {
            super(adres, fiyat, alan);
            this.odaSayisi = odaSayisi;
            this.kat = kat;
            this.cephe = cephe;
        }

        public Ev(int odaSayisi, String adres, int fiyat, int alan) {
            super(adres, fiyat, alan);
            this.odaSayisi = odaSayisi;
        }


        public int getOdaSayisi() {
            return odaSayisi;
        }

        public void setOdaSayisi(int odaSayisi) {
            this.odaSayisi = odaSayisi;
        }

        public int getKat() {
            return kat;
        }

        public void setKat(int kat) {
            this.kat = kat;
        }

        public yon getCephe() {
            return cephe;
        }

        public void setCephe(yon cephe) {
            this.cephe = cephe;
        }
        public int getFiyat(){
            return (int)(super.getFiyat()*1.1);
        }

    }
    public static class AliciSatici extends Insan{
        private Mulk gayriMenkul;

        public AliciSatici(Mulk gayriMenkul, String isim, int para) {
            super(isim, para);
            this.gayriMenkul = gayriMenkul;
        }

        public Mulk getGayriMenkul() {
            return gayriMenkul;
        }

        public void setGayriMenkul(Mulk gayriMenkul) {
            this.gayriMenkul = gayriMenkul;
        }

        public boolean paranVarmi(int p){
            return (super.getPara()>=p);
        }

        public void alMulk(AliciSatici kimden,Mulk m){
            if(kimden.getGayriMenkul()==m)
                if(this.paranVarmi(m.getFiyat())){
                    this.setGayriMenkul(m);
                    kimden.setGayriMenkul(null);
                    kimden.setPara(kimden.getPara()+m.getFiyat());
                    this.setPara(this.getPara()-m.getFiyat());
                }
        }
        public void satMulk(AliciSatici kime){
            if(this.getGayriMenkul()!=null)
                if(kime.paranVarmi(this.getGayriMenkul().getFiyat())){
                    kime.setGayriMenkul(this.getGayriMenkul());
                    this.setGayriMenkul(null);
                    this.setPara(this.getPara()+kime.getGayriMenkul().getFiyat());
                    kime.setPara(kime.getPara()-kime.getGayriMenkul().getFiyat());
                }
        }
        public String kendiniTanit(){
            String tanit="";
            tanit="Adım "+super.getIsim()+" Sahip olduğum para: "+this.getPara();
            if (this.getGayriMenkul()!=null) {
                tanit+=this.getGayriMenkul().getAdres()+" mülküm var. ";
            }
            return tanit;
        }

    }

    public static void main(String[] args) {
        Ev konut=new Ev(3,"Sıraselviler Cad. ",800000,100);
        AliciSatici emrah=new AliciSatici(konut,"Emrah",10000);
        AliciSatici cafer=new AliciSatici(null,"Cafer",900000);

        System.out.println(emrah.kendiniTanit());
        System.out.println(cafer.kendiniTanit());

        cafer.alMulk(emrah, konut);
        System.out.println(emrah.kendiniTanit());
        System.out.println(cafer.kendiniTanit());
    }

}