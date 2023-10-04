package com.example.java_ntp_ornekler;

//PRATİK ÇALIŞMA: MAHKEME

//package dava;
public class Dava {
    public enum tarafTur {Davalı, Davacı}
    private String no;
    private String kararTarih;
    private String konu;
    private Hakim hakim;
    private Taraf davaci;
    private Taraf davali;

    public Dava(String no, String konu) {
        this.no = no;
        this.konu = konu;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getKararTarih() {
        return kararTarih;
    }

    public void setKararTarih(String kararTarih) {
        this.kararTarih = kararTarih;
    }

    public String getKonu() {
        return konu;
    }

    public void setKonu(String konu) {
        this.konu = konu;
    }

    public Hakim getHakim() {
        return hakim;
    }

    public void setHakim(Hakim hakim) {
        this.hakim = hakim;
    }

    public Taraf getDavaci() {
        return davaci;
    }

    public void setDavaci(Taraf davaci) {
        this.davaci = davaci;
    }

    public Taraf getDavali() {
        return davali;
    }

    public void setDavali(Taraf davali) {
        this.davali = davali;
    }


    public String kararYaz() {
        String metin = "";
        metin += "Dosya No: "+this.getNo()+"\n";
        metin += "Karar Tarihi: "+this.getKararTarih()+"\n";
        metin += "Hakim: "+this.getHakim().getAd()+"\n";
        metin += "Davacı: "+this.getDavaci().getAd()+" TCK: "+this.getDavaci().getTCK()+"\n";
        metin += "Vekili: "+this.getDavaci().vekil.getAd()+"\n";
        metin += "Adresi: "+this.getDavaci().getAdres()+"\n";

        metin += "Davalı: "+this.getDavali().getAd()+" TCK: "+this.getDavali().getTCK()+"\n";
        metin += "Vekili: "+this.getDavali().vekil.getAd()+"\n";
        metin += "Adresi: "+this.getDavali().getAdres()+"\n";

        metin += "Konu: "+this.getKonu()+"\n";

        return metin;
    }


    public static class Insan {
        private String ad;
        private String TCK;
        private String adres;

        public Insan(String ad, String TCK) {
            this.ad = ad;
            this.TCK = TCK;
        }

        public String getAd() {
            return ad;
        }

        public void setAd(String ad) {
            this.ad = ad;
        }

        public String getTCK() {
            return TCK;
        }

        public void setTCK(String TCK) {
            this.TCK = TCK;
        }

        public String getAdres() {
            return adres;
        }

        public void setAdres(String adres) {
            this.adres = adres;
        }

    }


    public static class Taraf extends Insan {
        private tarafTur tur;
        private Avukat vekil;

        public Taraf(tarafTur tur, String ad, String TCK) {
            super(ad, TCK);
            this.tur = tur;
        }

        public tarafTur getTur() {
            return tur;
        }

        public void setTur(tarafTur tur) {
            this.tur = tur;
        }

        public Avukat getVekil() {
            return vekil;
        }

        public void setVekil(Avukat vekil) {
            this.vekil = vekil;
            vekil.müvekkil =this;
        }
    }

    public static class Hakim extends Insan {
        private String sicilNo;

        public Hakim(String sicilNo, String ad, String TCK) {
            super(ad, TCK);
            this.sicilNo = sicilNo;
        }

        public String getSicilNo() {
            return sicilNo;
        }

        public void setSicilNo(String sicilNo) {
            this.sicilNo = sicilNo;
        }
    }

    public static class Avukat extends Insan {
        private String sicilNo;
        private Taraf müvekkil;

        public Avukat(String sicilNo, String ad, String TCK) {
            super(ad, TCK);
            this.sicilNo = sicilNo;
        }

        public String getSicilNo() {
            return sicilNo;
        }

        public void setSicilNo(String sicilNo) {
            this.sicilNo = sicilNo;
        }

        public Taraf getMüvekkil() {
            return müvekkil;
        }

        public void setMüvekkil(Taraf müvekkil) {
            this.müvekkil = müvekkil;
            müvekkil.setVekil(this);
        }
    }

    public static void main(String[] args) {
        Taraf ali = new Taraf(tarafTur.Davacı,"Ali Maraşlı", "112311");
        Taraf veli = new Taraf(tarafTur.Davalı,"Veli Maraşlı", "143111");
        Hakim serpil = new Hakim("1233","Serpil Maraşlı", "1111551");
        Avukat huseyin = new Avukat("1112","Hüseyin Maraşlı", "331111");
        Avukat hasan = new Avukat("1453","Hasan Maraşlı", "11123311");

        Dava dosya = new Dava("2019/345","Miras Anlaşmazlığı");
        dosya.setDavali(ali);
        dosya.setDavaci(veli);
        dosya.setHakim(serpil);
        huseyin.setMüvekkil(veli);
        ali.setVekil(hasan);

        dosya.setKararTarih("01.01.2019");

        System.out.println(dosya.kararYaz());
    }
}
