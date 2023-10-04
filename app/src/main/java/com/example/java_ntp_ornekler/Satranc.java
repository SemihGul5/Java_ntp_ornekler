package com.example.java_ntp_ornekler;

//package satranc;

public class Satranc {
    public enum Takim {siyah, beyaz}
    private int puanSiyah;
    private int puanBeyaz;

    public Satranc() {
        puanSiyah = 0;
        puanBeyaz = 0;
    }

    public void puanAl(Tas yutulan) {
        if(yutulan.takim==Takim.beyaz)
            puanBeyaz += yutulan.puan;
        else
            puanSiyah += yutulan.puan;
    }

    public static class Tahta {
        Tas[][] tahta = new Tas[8][8];

        public Tahta() {
            for(int i=0; i<8; i++)
                for(int k=0; k<8; k++)
                    this.tahta[i][k]=null;
        }

        public boolean bosMu(int x, int y) { return (this.tahta[x][y]==null);}

        public boolean rakipMi(Tas gelen, int hx, int hy) {
            boolean yanit = false;
            if(!bosMu(hx,hy) && gelen.takim != tahta[hx][hy].takim)
                yanit = true;
            return yanit;
        }

        public void yut(Tas gelen, int hx, int hy){
            tahta[hx][hy]= gelen;

        }

        public void tasi(Tas t, int x, int y) {
            if (bosMu(x,y)) {
                this.tahta[t.x][t.y] = null;
                t.setX(x);
                t.setY(y);
                this.tahta[x][y] = t;
            }
        }

    }


    public static class Tas {
        Takim takim;
        int x; //tahtadaki koordinatlar
        int y;
        Tahta tahta;
        int puan;

        public Tas(Takim takim, int x, int y) {
            this.takim = takim;
            this.x = 0;
            this.y = 0;
            this.tahta.tasi(this, x, y);
            this.puan = 1;
        }

        public void secTahta(Tahta t) { this.tahta = t;}

        public Takim getTakim() {
            return takim;
        }

        public void setTakim(Takim takim) {
            this.takim = takim;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void ilerle(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static class Piyon extends Tas {

        public Piyon(Takim takim, int x, int y) {
            super(takim, x, y);
        }

        public boolean gidebilirMi(int hx, int hy) {
            boolean gider = false;
//bir piyon için
            if(((hx==x+1)|| (hx==x-1)) && (hy==y+1))
                gider = true;
            return gider;
        }

        @Override
        public void ilerle(int x, int y) {
            if (gidebilirMi(x,y))
                tahta.tasi(this, x, y);
        }

    }


    public static void main(String[] args) {
    }

}
