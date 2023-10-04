package com.example.java_ntp_ornekler;

public class Karma {
/*    kesim= cluster
            iz= track
    yüzey=side



    public double clusterSayisi()
    {
        return this.a/clusterKapasite()+1;
    }
    public double gercekboyut()
    {
        return(int) clusterSayisi()*this.yuzeyBasinaClusterSayisi();
    }
    public double isgalyer()
    {
        return(int) gercekboyut()-this.a;
    }












    DERSİMİZDE YAPTIĞIMIZ BAĞIMSIZ KOD ÖRNEKLERİNDEN BAZILARI:


            //haftanın günleri dizi ile tanımla kullanıcı sıcaklık gırecek
            //ort ya göre 5 aşağısı soğuk 15 asağısı serin yukarısı sıcak
            //haftanın en yüksek ve en düşük dereceleri yaz

            //Soru-2: Rastgele üretilen iki basamaklı 100 adet sayının içerisinde
            //en büyük ve en küçük sayının toplamını ve farkını bulan programın eksik

            **************************************************************************

    // dizi içeriğinin en büyüğünü buldurma
    int[] dizi = {5, 8, 33, 22, 11, 83, 29, 65, -91, 63};
    int enb = dizi[0];

for(int k=1; k<dizi.length; k++) {
        enb = (sayi>enb) ? sayi : enb;
    }

System.out.println(enb);

**************************************************************************

    // Büyük harfe dönüştürme
    String bilgi = "bugun hava hafif yagmurlu ama guzel";
    String buyuk = "";

for(int y=0; y<bilgi.length();y++) {
        if(bilgi.charAt(y)==' ')
        {
            buyuk += bilgi.charAt(y);
        }
        else
        {
            buyuk += (char) (((int) bilgi.charAt(y))-32);
        }


****************************************************************************

//Metin kriptolama
        String bilgi = "Sabaha karsi saat 3:30'da operasyon baslasin";
        String kripto ="";

        for(int w=0; w<bilgi.length(); w++) {
            kripto += (char) (bilgi.charAt(w)+3);
        }

        System.out.println("Metnin orjinal hali = " + bilgi);
        System.out.println("Metnin kriptolu hali = " + kripto);

****************************************************************************

// Kullanıcıdan diziye alınan notların ortalaması
        Scanner okuma=new Scanner(System.in);

        int[] notlar = {0, 0, 0, 0, 0};
        int top = 0;


        System.out.println("Lütfen notlarınızı giriniz:");
        System.out.println("--------------------------------");

        for(int k=0; k<notlar.length; k++) {
            System.out.print(k+1+". notunuz: ");
            notlar[k] = okuma.nextInt();
            top += notlar[k]; // top = tp + notlar[k] işleme girenlerden biri float. Type cast gereksiz
        }

        System.out.println("Not ortalamanız = " + top/ notlar.length);

*******************************************************************************

//random örnekleri
        int kura = (int) (Math.random()*100+1);
        char rastchar = (char) (65+Math.random()*27);
        System.out.println("Üretilen 0-100 arası rastgele tamsayı = "+kura);
        System.out.println("Üretilen A-Z arası rastgele harf = "+rastchar);

********************************************************************************

//Haftalık hava durumu analizi
        int[] derece = new int[7];

        System.out.println("HAFTALIK HAVA RAPORU");
        System.out.println("--------------------");
        String[] gunler = {"Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar"};
        float ort = 0;


        Scanner oku = new Scanner(System.in);
        for(int k=0; k<7; k++) {
            System.out.print(gunler[k]+" gününün sıcaklığını giriniz: ");
            derece[k] = oku.nextInt();
            ort += derece[k];
        }

        ort/=derece.length;
        System.out.println("Haftalık sıcaklık ortamalaması= "+ort+" derece");
        System.out.println("Bu değerlere göre hava "+ ((ort<=5)? "SOĞUK":(ort<15)? "SERİN":(ort<=25)?"ILIK":"SICAK"));

        float enb = derece[0], enk = derece[0];
        int enbi = 0, enki = 0;

        for(int x=1; x<7; x++) {
            if(derece[x]<enk) {
                enk = derece[x];
                enki = x;
            }
            if(derece[x]>enb) {
                enb = derece[x];
                enbi = x;
            }

        }

        System.out.println("Haftanın en soğuk günü = "+ gunler[enki]+" sıcaklığı = "+enk+" derece");
        System.out.println("Haftanın en sıcak günü = "+ gunler[enbi]+" sıcaklığı = "+enb+" derece");

************************************************************************************

***********************************************************************************************

//en büyük sayı buldurma
        int[] dizi = {5, 7, 2, 9, 4, 11, 80, 32, 1, 8};

        int enb = dizi[0];

        for(int k=1; k<dizi.length;k++) {
            enb = (dizi[k]>enb)? dizi[k]x : enb;
        }


        System.out.println("en büyük sayı = " +enb);

***************************************************************************************************

//Dört harften rastgele seçmek
        char[] gen = {'A','C', 'G', 'T'};
        String DNA ="";
        for(int k=0; k<100; k++)
            DNA += gen[(int)(Math.random()*4)];
        System.out.println("DNA = "+ DNA);

// Veya aşağıdaki yönteme bakınız
        int x;
        String DNA ="";
        for(int k=0; k<100; k++) {
            x = (int) (Math.random()*4);
            DNA += ((x==0)?'A':(x==1)?'C':(x==2)?'G':'T');
        }

**************************************************************************************************

// Kelime bulma oyunu

        String harfler ="";
        String kelime = "";
        int puan = 0;

// Aşama-1: Rastgele harfleri üretmek
        for(int i=0; i<8; i++) harfler += (char)(int)(65+Math.random()*25);

// Aşama-2: Kullanıcıdan kelime almak
        System.out.println("Üretilen harfler = "+harfler);

        Scanner oku = new Scanner(System.in);
        System.out.print("Kelimenizi söyleyin = ");
        kelime = oku.next();
        kelime = kelime.toUpperCase();

// Aşama-3: Puan hesaplamak

        for(int w=0; w<kelime.length(); w++) {
            int yer = harfler.indexOf(kelime.charAt(w));
            if(yer>-1) {
                puan += 1;
                harfler = harfler.substring(0, yer)+harfler.substring(yer+1);
                System.out.print(kelime.charAt(w)+" harfi VAR. BRAVO! ");
            }
            else
            {
                puan -=1;
                System.out.print(kelime.charAt(w)+" harfi YOK. CEZA! ");
            }
            System.out.println("Puanınız= "+puan+" Kalan harfler= "+harfler);
        }

****************************************************************************************

// Rastgele telefon numarası üretme
        int[] kod = {532, 530, 538, 535, 542, 541, 544, 555, 554, 212, 216};
        String telefon = "0("+kod[(int)(Math.random()*11)]+") ";
        for(int i=0; i<7; i++)
        {
            telefon += (int) (Math.random()*9);
            if(i==2 || i==4) telefon+=" ";
        }
        System.out.println("Talihli telefon: "+ telefon);
    }

*****************************************************************************************

    // Rastgele düğüm eşleştirme
    String[] talihli = {"Ayşe", "Oya", "Emel", "Filiz", "Ali", "Mehmet"};
    String[] tesis = {"Antalya", "Kemer", "Datça", "Kapadokya", "Maldivler", "Münih"};
    int tesisAdet = tesis.length;

for(String kisi:talihli) {
        int yer = (int) (Math.random()*tesisAdet);
        System.out.println(kisi + " talihlisi " + tesis[yer] + "tatili kazandı!");

        for(int k=yer; k<tesisAdet-1; k++)
            tesis[k] = tesis[k+1];
        tesisAdet -=1;
    }

*******************************************************************************************

    // Üçlü operatör
    Scanner oku = new Scanner(System.in);
System.out.print("Notunuzu giriniz:");
    int nt = oku.nextInt();
System.out.println( (nt<50)?"Kaldın!":(nt<70)?"Geçtin":"Aferin!");

*******************************************************************************************

    // Enum örneği
    public enum Ulkeler {
        Turkiye("Ankara","TL", 1000,50),
        Rusya("Moskova","RUBLE", 200,20),
        Amerika("Washington","USD", 5000,100),
        Fransa("Paris","EUR", 3000, 80),
        Çin("Pekin","YEN", 10000, 30),
        İngiltere("Londra","STR", 2500, 70),
        Irak("Bağdat", "DİNAR", 500, 5);


        private final String baskent;
        private final String para;
        private final int nufus;
        private final int kbgelir;

        private Ulkeler(String baskent, String para, int nufus, int kbg) {
            this.baskent = baskent;
            this.para = para;
            this.nufus = nufus;
            this.kbgelir = kbg;
        }

        public String getirBaskent() {
            return this.baskent;
        }

        public String getirUlke() {
            return this.name();
        }

        public String paraBirimi() {
            return this.para;
        }

        public int nufus() {
            return this.nufus;
        }

        public int kbGelir() {
            return this.kbgelir;
        }

        public int ulkeGelir() {
            return nufus()*kbGelir();
        }
    }

    Ulkeler[] dizi = Ulkeler.values();
for(Ulkeler a:dizi)
            System.out.println(a.getirUlke() + " "+ a.getirBaskent()+" "+a.paraBirimi()+" "+a.nufus()+ " "+ a.kbGelir()+" üg= "+a.ulkeGelir());

*************************************************************************************************

// Enum örneği

    public enum Ulkeler {
        Turkiye("Türk"),
        Çin("Çin"),
        Amerika("Amerikan"),
        Meksika("Meksika"),
        Tayland("Tay");

        private final String milliyet;

        private Ulkeler(String mil) {
            this.milliyet = mil;
        }

        public String ulkeAd() {
            return this.name();
        }

        public String milliyet() {
            return this.milliyet;
        }
    }

    public enum Gunler {
        Pazartesi("Köfte ve makarna", 20, Ulkeler.Turkiye),
        Salı("Ispanak ve Salata", 15, Ulkeler.Tayland),
        Çarşamba("Patates ve cacık", 10, Ulkeler.Meksika),
        Perşembe("Fasulye ve pilav", 5, Ulkeler.Turkiye),
        Cuma("Suşi ve ahtapot", 50, Ulkeler.Çin),
        Cumartesi("İskender ve künefe", 40, Ulkeler.Turkiye),
        Pazar ("Büftek ve püre", 70, Ulkeler.Amerika);

        private final String menu;
        private final int fiyat;
        private final Ulkeler ulk;

        private Gunler(String menu, int fiyat, Ulkeler ulk) {
            this.menu = menu;
            this.fiyat = fiyat;
            this.ulk = ulk;
        }

        public String gununMenusu() {
            return this.menu;
        }

        public int getirFiyat() {
            return this.fiyat;
        }

        public Ulkeler mensei() {
            return this.ulk;
        }
    };

    Gunler[] gun = Gunler.values();
for(Gunler g:gun)
            System.out.println(g.ordinal()+" "+g+" Günün menüsü= "+g.gununMenusu()+" Fiyatı="+g.getirFiyat()+" Menşei= "+g.ulk.ulkeAd()+" Mutfağı= "+g.ulk.milliyet());
}

******************************************************************************************

// Enum örneği
public enum Sehirler {
    İstanbul("34","212",10000,1000,70,450),
    Ankara("06","312",1000,6000,170,500),
    Malatya("44","111",6000,6000,700,80),
    Balıkesir("10","222",2000,7000,170,90),
    Zonguldak("67","333",5000,8000,200,50),
    Sinop("57","368",4000,9000,60,350),
    Samsun("55","362",5000,1000,400,500),
    Adana("01","444",7000,1000,100,350),
    Sivas("58","346",500,1000,50,150);

    private final String trKod;
    private final String telKod;
    private final int nufus;
    private final int yuzolcum;
    private final int koordX, koordY;

    private Sehirler(String trKod, String telKod, int nufus, int yuzolcum, int koordX, int koordY) {
        this.trKod = trKod;
        this.telKod = telKod;
        this.nufus = nufus;
        this.yuzolcum = yuzolcum;
        this.koordX = koordX;
        this.koordY = koordY;
    }

    public String plakaGetir() {
        return this.trKod;
    }

    public String telAlanGetir() {
        return this.telKod;
    }

    public Sehirler enyakinSehir() {
        return null;
    }
}

    Sehirler[] sehir = Sehirler.values();

for(Sehirler sh:sehir) {
        String plaka = sh.plakaGetir();
        String telefon = sh.telAlanGetir();
        System.out.println(sh.ordinal()+" - "+sh+" Plaka kodu= "+plaka+" Telefon kodu="+telefon);

        }

        ************************************************************************************************

// Rastgele 100 şehir üretmek
        String[] sehir = {
        "İstanbul",
        "İzmir",
        "Ankara",
        "Samsun",
        "Sivas",
        "Bayburt",
        "Sinop",
        "Kayseri",
        "Yozgat",
        "Muş"
        };

        for(int i=0; i<100; i++)
        {
        int rast = (int) (Math.random()*10);

        System.out.println(sehir[rast]);
        }

        *************************************************************************************

// Öğrencileri rastgele gruplara dağıtma
        String[] ogrenci = {"Ali", "Oya", "Zerrin", "Sevinç", "Oktay", "Görkem", "Ata", "Batuhan"};
        char[] grup = {'A','B'};
        int adet = ogrenci.length/grup.length;
        int say = ogrenci.length;

        for (int i=0; i<grup.length; i++) {
        System.out.println(grup[i]+" GRUBUNA SEÇİLEN ÖĞRENCİLER");
        for(int k=0; k<adet; k++) {
        int yer = (int) (Math.random()*say);
        System.out.println(ogrenci[yer]);
        for(int j=yer; j<ogrenci.length-1; j++)

        ogrenci[j] = ogrenci[j+1];
        say -=1;
        }
        }
        *****************************************************************************/

}
