package com.example.java_ntp_ornekler;

public class Disk {
    public enum sistem{Windows,Linux;}
    private String label;
    private double sektorBasinaBit=512;
    private double sektorBasinaBitLinux=256;
    private double clusterBasinaSektor;
    private double trackBasinaCluster;
    private double yuzeyBasinaTrack;
    private double plakaBasinaYuzey;
    private double plakaSayisi;
    private sistem s;
    private double rpm;
    private double DiskKafasınınUzerindeBulunduğuIzNo;
    private double DiskkKafasınınAltındakiClusterınNumarası;
    private double DiskKafasınınBirTrackAtlamaSüresi;
    private double timeRead;
    private double kapasite;
    private double trackkKapasite;
    private double clusterKapasite;
    private double aclusterKapasite;
    private double yuzeyKapasite;
    private double kb;
    private double mb;
    private  double dosyab;
    public Disk(String isim,sistem s,double clusterBasinaSektor,double trackBasinaCluster, double yuzeyBasinaTrack, double plakaBasinaYuzey, double plakasayisi)
    {
        this.label=isim;
        this.s=s;
        this.clusterBasinaSektor=clusterBasinaSektor;
        this.trackBasinaCluster=trackBasinaCluster;
        this.yuzeyBasinaTrack=yuzeyBasinaTrack;
        this.plakaBasinaYuzey=plakaBasinaYuzey;
        this.plakaSayisi=plakasayisi;
    }

    public String getLabel() {return label;}
    public double getSektorBasinaBit() {return sektorBasinaBit;}
    public double getSektorBasinaBitLinux() {return sektorBasinaBitLinux;}
    public double getClusterBasinaSektor() {return clusterBasinaSektor;}
    public double getTrackBasinaCluster() {return trackBasinaCluster;}
    public double getYuzeyBasinaTrack() {return yuzeyBasinaTrack;}
    public double getPlakaBasinaYuzey() {return plakaBasinaYuzey;}
    public double getPlakaSayisi() {return plakaSayisi;}
    public sistem getS() {return s;}
    public double getRpm() {return rpm;}
    public double getDiskKafasınınUzerindeBulunduğuIzNo() {return DiskKafasınınUzerindeBulunduğuIzNo;}
    public double getDiskkKafasınınAltındakiClusterınNumarası() {return DiskkKafasınınAltındakiClusterınNumarası;}
    public double getDiskKafasınınBirTrackAtlamaSüresi() {return DiskKafasınınBirTrackAtlamaSüresi;}
    public double getTimeRead() {return timeRead;}
    public double getKapasite() {return kapasite;}
    public double getKb() {return kb;}
    public double getMb() {return mb;}
    public double getDosyab() {return dosyab;}

    public void setLabel(String label) {this.label = label;}
    public void setSektorBasinaBit(double sektorBasinaBit) {this.sektorBasinaBit = sektorBasinaBit;}
    public void setSektorBasinaBitLinux(double sektorBasinaBitLinux) {this.sektorBasinaBitLinux = sektorBasinaBitLinux;}
    public void setClusterBasinaSektor(double clusterBasinaSektor) {this.clusterBasinaSektor = clusterBasinaSektor;}
    public void setTrackBasinaCluster(double trackBasinaCluster) {this.trackBasinaCluster = trackBasinaCluster;}
    public void setYuzeyBasinaTrack(double yuzeyBasinaTrack) {this.yuzeyBasinaTrack = yuzeyBasinaTrack;}
    public void setPlakaBasinaYuzey(double plakaBasinaYuzey) {this.plakaBasinaYuzey = plakaBasinaYuzey;}
    public void setPlakaSayisi(double plakaSayisi) {this.plakaSayisi = plakaSayisi;}
    public void setS(sistem s) {this.s = s;}
    public void setRpm(double rpm) {this.rpm = rpm;}
    public void setDiskKafasınınUzerindeBulunduğuIzNo(double DiskKafasınınUzerindeBulunduğuIzNo) {this.DiskKafasınınUzerindeBulunduğuIzNo = DiskKafasınınUzerindeBulunduğuIzNo;}
    public void setDiskkKafasınınAltındakiClusterınNumarası(double DiskkKafasınınAltındakiClusterınNumarası) {this.DiskkKafasınınAltındakiClusterınNumarası = DiskkKafasınınAltındakiClusterınNumarası;}
    public void setDiskKafasınınBirTrackAtlamaSüresi(double DiskKafasınınBirTrackAtlamaSüresi) {this.DiskKafasınınBirTrackAtlamaSüresi = DiskKafasınınBirTrackAtlamaSüresi;}
    public void setTimeRead(double timeRead) {this.timeRead = timeRead;}
    public void setKapasite(double kapasite) {this.kapasite = kapasite;}
    public void setKb(double kb) {this.kb = kb;}
    public void setMb(double mb) {this.mb = mb;}
    public void setDosyab(double dosyab) {this.dosyab = dosyab;}



    public boolean locateHead(double track,double cluster)
    {
        boolean guncelle=false;

        if (track>0&&cluster>0)
        {
            if (track!=this.yuzeyBasinaTrack&&cluster!=this.trackBasinaCluster) {

                guncelle=true;
            }

        }
        else{
            guncelle=false;
        }
        if (guncelle) {
            this.yuzeyBasinaTrack=track;
            this.trackBasinaCluster=cluster;
        }
        return guncelle;

    }
    public double diskKapasitesi()
    {
        if (this.s==s.Windows) {
            kapasite=this.getSektorBasinaBit()*this.getClusterBasinaSektor()*this.getTrackBasinaCluster()*this.getYuzeyBasinaTrack()*this.getPlakaBasinaYuzey()*this.getPlakaSayisi();

        }
        else
        {
            kapasite=this.getSektorBasinaBitLinux()*this.getClusterBasinaSektor()*this.getTrackBasinaCluster()*this.getYuzeyBasinaTrack()*this.getPlakaBasinaYuzey()*this.getPlakaSayisi();


        }
        return kapasite;
    }
    public double trackKapasite()
    {

        if (this.s==s.Windows)
        {
            trackkKapasite=this.getSektorBasinaBit()*this.getClusterBasinaSektor();


        }
        else
        {
            trackkKapasite=this.getSektorBasinaBitLinux()*this.getClusterBasinaSektor();


        }
        return trackkKapasite;
    }
    public double bclusterKapasite()
    {
        if (this.s==s.Windows)
        {
            clusterKapasite=this.getSektorBasinaBit()*this.getClusterBasinaSektor();

        }
        else
        {
            clusterKapasite=this.getSektorBasinaBitLinux()*this.getClusterBasinaSektor();

        }

        return clusterKapasite;
    }
    public double allclusterKapasite()
    {
        if (this.s==s.Windows)
        {
            aclusterKapasite=this.getSektorBasinaBit()*this.getClusterBasinaSektor()*this.getTrackBasinaCluster();

        }
        else
        {
            aclusterKapasite=this.getSektorBasinaBitLinux()*this.getClusterBasinaSektor()*this.getTrackBasinaCluster();

        }

        return aclusterKapasite;
    }
    public double yuzeyKapasitesi()
    {
        if (this.s==s.Windows)
        {
            yuzeyKapasite=this.getSektorBasinaBit()*this.getClusterBasinaSektor()*this.getTrackBasinaCluster()*this.getYuzeyBasinaTrack();

        }
        else
        {
            yuzeyKapasite=this.getSektorBasinaBitLinux()*this.getClusterBasinaSektor()*this.getTrackBasinaCluster()*this.getYuzeyBasinaTrack();

        }

        return yuzeyKapasite;
    }
    public double trackBasinaSektorSayisi(){
        return this.getTrackBasinaCluster()*this.getClusterBasinaSektor();

    }
    public double trackBasinaSektorKapasitesi(){
        double tbsk;
        if (this.s==s.Windows){
            tbsk=this.getTrackBasinaCluster()*this.getClusterBasinaSektor()*this.getSektorBasinaBit();
        }
        else
        {
            tbsk=this.getTrackBasinaCluster()*this.getClusterBasinaSektor()*this.getSektorBasinaBitLinux();
        }
        return tbsk;
    }
    public double yuzeyBasinaSektorSayisi()
    {
        return this.getYuzeyBasinaTrack()*this.getTrackBasinaCluster()*this.getClusterBasinaSektor();

    }
    public double yuzeyBasinaSektorKapasitesi()
    {
        double ybsk;
        if (this.s==s.Windows)
        {
            ybsk=this.getYuzeyBasinaTrack()*this.getTrackBasinaCluster()*this.getClusterBasinaSektor()*this.getSektorBasinaBit();
        }
        else
        {
            ybsk=this.getYuzeyBasinaTrack()*this.getTrackBasinaCluster()*this.getClusterBasinaSektor()*this.getSektorBasinaBitLinux();
        }
        return ybsk;
    }
    public double yuzeyBasinaClusterSayisi()
    {
        return this.getYuzeyBasinaTrack()*this.getTrackBasinaCluster();

    }
    public double disktekiToplamSektorSayisi()
    {
        return this.getYuzeyBasinaTrack()*this.getTrackBasinaCluster()*this.getClusterBasinaSektor()*this.getPlakaBasinaYuzey()*this.getPlakaSayisi();

    }
    public double disktekiToplamClusterSayisi()
    {
        return this.getYuzeyBasinaTrack()*this.getTrackBasinaCluster()*this.getPlakaBasinaYuzey()*this.getPlakaSayisi();

    }
    public double disktekiToplamTrackSayisi()
    {
        return this.getYuzeyBasinaTrack()*this.getPlakaBasinaYuzey()*this.getPlakaSayisi();
    }
    public double dosyaninKapladigiCluster(double dosyaBoyut)
    {
        double a= dosyaBoyut/bclusterKapasite();
        if (a>1&&a%2==0) {
            dosyab= (int) dosyaBoyut/(int)bclusterKapasite();
        }
        else if(a==1)
        {
            dosyab=(int)dosyaBoyut/(int)bclusterKapasite();
        }
        else
        {
            dosyab= (int) dosyaBoyut/(int)bclusterKapasite()+1;
        }
        return dosyab;
    }
    public double gercekDosyaBoyutu(double dosyaBoyut)
    {
        return dosyaninKapladigiCluster(dosyaBoyut)*bclusterKapasite();
    }
    public double ziyanEdilenBoyut(double dosyaBoyut)
    {
        return gercekDosyaBoyutu(dosyaBoyut)-dosyaBoyut;
    }
    public static void main(String[] args) {
        Disk k=new Disk("Disk 1",sistem.Windows,4,16,32,1,1);
        Disk l=new Disk("Disk 2",sistem.Linux,4,16,32,4,1);
        System.out.println(k.getLabel());
        System.out.println("----------------------------------------------");
        System.out.println("Disk kapasitesi: "+k.diskKapasitesi()+" B");
        System.out.println("Track kapasitesi: "+k.trackKapasite()+" B");
        System.out.println("1 Cluster kapasitesi: "+k.bclusterKapasite()+" B");
        System.out.println("Yuzey kapasitesi: "+k.yuzeyKapasitesi()+" B");
        System.out.println("Track basina sektor sayisi: "+k.trackBasinaSektorSayisi());
        System.out.println("Track basina sektor kapasitesi: "+k.trackBasinaSektorKapasitesi()+" B");
        System.out.println("Yuzey basına cluster sayısı: "+k.yuzeyBasinaClusterSayisi());
        System.out.println("Diskteki toplam sektor sayısı: "+k.disktekiToplamSektorSayisi());
        System.out.println("Diskteki toplam cluster sayısı: "+k.disktekiToplamClusterSayisi());
        System.out.println("Diskteki toplam track sayısı: "+k.disktekiToplamTrackSayisi());
        System.out.println("Dosyanın kapladığı cluster sayısı: "+k.dosyaninKapladigiCluster(2500));
        System.out.println("Dosyanın kapladığı cluster sayısı 2: "+k.dosyaninKapladigiCluster(2048));
        System.out.println("Gercek dosya boyutu: "+k.gercekDosyaBoyutu(2500));
        System.out.println("Ziyan edilen boyut: "+k.ziyanEdilenBoyut(2500));
        System.out.println("\n");
        System.out.println(l.getLabel());
        System.out.println("----------------------------------------------");

        System.out.println("Disk kapasitesi: "+l.diskKapasitesi()+" B");
        System.out.println("Track kapasitesi: "+l.trackKapasite()+" B");
        System.out.println("Cluster kapasitesi: "+l.bclusterKapasite()+" B");
        System.out.println("Yuzey kapasitesi: "+l.yuzeyKapasitesi()+" B");
    }

}

