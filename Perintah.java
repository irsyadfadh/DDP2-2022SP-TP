import java.awt.Dimension;

public class Perintah {
    Canvas canvas;
    Kurakura kurakuraku; 
    
    /** Creates a new instance of Perintah */
    public Perintah(Kurakura k, Canvas canvas) {
        kurakuraku = k;
        this.canvas = canvas;
    }

    // Dapatkan anda membuat method ini lebih baik dan lebih mudah ditambahkan
    // atau di ubah?
    // eksekusi perintah dengan memanggil method 
    public String lakukan(String inputPerintah){
        String[] in = inputPerintah.split(" ");
        if (in[0].equalsIgnoreCase("selesai"))
            System.exit(0);
        else if (in[0].equalsIgnoreCase("reset"))
            kurakuraku.reset();
        else if (in[0].equalsIgnoreCase("maju")){
            if(in.length > 1){
                kurakuraku.maju(Integer.parseInt(in[1]));
            }
            else{
                return "perintah tidak dipahami."; //handle jika hanya "maju" saja maka tidak dipahami
            }
        }
        else if (in[0].equalsIgnoreCase("mundur")){
            if (in.length > 1) {
                kurakuraku.mundur(Integer.parseInt(in[1]));
            } 
            else {
                return "Perintah tidak dipahami."; //handle jika hanya "mundur" saja maka tidak dipahami
            }
        }
        else if (in[0].equalsIgnoreCase("rotasi")){
            if (in.length > 1) {
                kurakuraku.rotasi(Integer.parseInt(in[1]));
            } 
            else {
                return "Perintah tidak dipahami."; //handle jika hanya "rotasi" saja maka tidak dipahami
            }
        } 
        else if (in[0].equalsIgnoreCase("kotak")){
            if (in.length > 1) {
                buatKotak(Integer.parseInt(in[1]));
            } 
            else {
                return "Perintah tidak dipahami."; //handle jika hanya "kotak" saja maka tidak dipahami
            }
        }
        else if (in[0].equalsIgnoreCase("boxes")){
            if (in.length > 1) {
                boxes(Integer.parseInt(in[1]));
            } 
            else {
                return "Perintah tidak dipahami."; //handle jika hanya "boxes" saja maka tidak dipahami
            }
        }

        else if (in[0].equalsIgnoreCase("sierpinski")){
            if (in.length > 1) {
                sierpinski(Integer.parseInt(in[1]));
            } 
            else {
                return "Perintah tidak dipahami."; //handle jika hanya "sierpinski" saja maka tidak dipahami
            }
        }
        else if (in[0].equalsIgnoreCase("sierpinskiRekursif")){
            if (in.length > 1) {
                sierpinskiRekursif(Integer.parseInt(in[1]));
            } 
            else {
                return "Perintah tidak dipahami."; //handle jika hanya "sierpinskiRekursif" saja maka tidak dipahami
            }
        }
        else if (in[0].equalsIgnoreCase("segitiga")){
            if (in.length > 1) {
                buatSegitiga(Integer.parseInt(in[1]));
            } 
            else {
                return "Perintah tidak dipahami."; //handle jika hanya "segitiga" saja maka tidak dipahami
            }
        }
        else if (in[0].equalsIgnoreCase("kochsnowflake")){
            if (in.length > 1) {
                kochSnowflake(Integer.parseInt(in[1]));
            } 
            else {
                return "Perintah tidak dipahami."; //handle jika hanya "kochsnowflake" saja maka tidak dipahami
            }
        }
        else if (in[0].equalsIgnoreCase("heksagon")){
            if (in.length > 1) {
                heksagon(Integer.parseInt(in[1]));
            } 
            else {
                return "Perintah tidak dipahami."; //handle jika hanya "heksagon" saja maka tidak dipahami
            }
        }
        else if (in[0].equalsIgnoreCase("segitigasiku")) {
            if (in.length > 2) {
                buatSegitigaSikuSiku(Integer.parseInt(in[1]), Integer.parseInt(in[2]));
            } 
            else {
                return "Perintah tidak dipahami."; //handle jika input <= 2, maka tidak dipahami
            } 
        }
        else if (in[0].equalsIgnoreCase("pohon"))
                buatPohon();        
        else if (in[0].equalsIgnoreCase("persegi")) {
            if (in.length > 2) {
                buatPersegi(Integer.parseInt(in[1]), Integer.parseInt(in[2]));
            } 
            else {
                return "Perintah tidak dipahami.";
            }
        }
        else if (in[0].equalsIgnoreCase("jejak"))
                kurakuraku.setJejak(Boolean.parseBoolean(in[1]));
        else if (in[0].equalsIgnoreCase("pindah"))
                kurakuraku.setPosition(new Dimension(Integer.parseInt(in[1]),Integer.parseInt(in[2])));
        else if (in[0].equalsIgnoreCase("hadap")) {
            if (in[1].equalsIgnoreCase("kanan"))
                kurakuraku.rotasi(90);
            else if (in[1].equalsIgnoreCase("kiri"))
                kurakuraku.rotasi(-90);
            else
                return "Perintah tidak dipahami.";
            } 

        else if (in[0].equalsIgnoreCase("loop")) {
            if (in.length > 2) {
                int loopCount = Integer.parseInt(in[1]); //inisialisasi berapa kali loop harus diulang.
                StringBuilder repeatedCommands = new StringBuilder(); //objek StringBuilder yang disebut repeatCommands untuk menyimpan perintah yang diulang.
                for (int i = 2; i < in.length; i++) {
                    repeatedCommands.append(in[i]).append(" "); //Loop menambahkan setiap perintah ke repeatedCommands stringbuilder, dipisahkan dengan spasi
                }
                String commands = repeatedCommands.toString().trim();//memangkas setiap spasi kosong di depan atau di belakang menggunakan trim() fan hasilnya di assgin ke variabel commands
                for (int i = 0; i < loopCount; i++) { //loop loopcount
                    lakukan(commands); //memanggil method lakukan secara rekursif
                }
            } 
            else {
                return "Perintah tidak dipahami."; //handle jika <= 2
            }
        }
        else{
                canvas.repaint(); 
                return "Perintah tidak dipahami.";
            }
        canvas.repaint();    
        return "Perintah sudah dilaksanakan.";
    }
    
    public void buatKotak(int ukuran ){        
        for (int i=0;i<4;i++){
            kurakuraku.maju(ukuran);
            kurakuraku.rotasi(90);
        }
    }
    /*method persegi dengan panjang dan lebar custom dari pengguna */
    public void buatPersegi(int panjang, int lebar){
        for (int i = 0; i < 2; i++) {
            kurakuraku.maju(panjang);
            kurakuraku.rotasi(90);
            kurakuraku.maju(lebar);
            kurakuraku.rotasi(90);
        }

    }
    public void buatSegitiga(int ukuran){
        for (int i=0;i<3;i++){
            kurakuraku.maju(ukuran);
            kurakuraku.rotasi(-120); //rotasi agar sana sisi
        }
    }        
    /*method segitiga siku siku */
    public void buatSegitigaSikuSiku(int panjangAlas, int tinggi){ //input alas dan tinggi

        kurakuraku.maju(tinggi);
        kurakuraku.rotasi(-90); // rotasi transisi ke sisi tinggi
        kurakuraku.maju(panjangAlas);
        kurakuraku.rotasi(-135); // rotasi sebelum sisi miring
        kurakuraku.maju(tinggi);
     
    }    
    /*method membuat boxes rekursf */
    public void boxes(int ukuran){
        if (ukuran >= 0){ //jika ukuran >= 0 maka akan terus menjalankan kotak yang lebih kecil
            buatKotak(ukuran); ///
            kurakuraku.setJejak(false); // false sehingga jejak gambar yang dihasilkan tidak terlihat pada iterasi berikutnya
            kurakuraku.maju(10); //mulai pindah posisi
            kurakuraku.rotasi(90);
            kurakuraku.maju(10);
            kurakuraku.rotasi(-90);
            kurakuraku.setJejak(true); //aktifkan jejak lagi
            boxes(ukuran-20); //secara rekursif panggil boxes berikutnya lebih kecil 20 satuan dari ukuran
        }
    }
    /*method membuat sierpinski */
    public void sierpinski(int ukuran){
        buatSegitiga(ukuran); //segitiga awal (cover)
        kurakuraku.maju(ukuran/2); // maju setengah ukuran
        sierpinskiRekursif(ukuran/2); //panggil method segitiga rekursif membuat segitiga lebih kecil
        
    }
    /*method membuat rekursif segitiga sierpinski */
    public void sierpinskiRekursif(int ukuran){
        if (ukuran>2){
            //case rekursif
            kurakuraku.rotasi(-60);
            buatSegitiga(ukuran);
            kurakuraku.rotasi(60);
            Dimension pos = kurakuraku.getPosition();
            kurakuraku.maju(ukuran/2);
            sierpinskiRekursif(ukuran/2); //rekursif untuk menggambar pola sierpinski Triagle pada sisi Kanan
            kurakuraku.reset();
            kurakuraku.setPosition(pos);
            kurakuraku.mundur(ukuran/2);
            sierpinskiRekursif(ukuran/2); //rekursif untuk menggambar pola Sierpinski Triangle pada sisi kiri
            kurakuraku.reset();
            kurakuraku.setPosition(pos);
            kurakuraku.rotasi(-60);
            kurakuraku.maju(ukuran);
            kurakuraku.rotasi(-120);
            kurakuraku.maju(ukuran/2);
            kurakuraku.rotasi(180);
            sierpinskiRekursif(ukuran/2); // rekursif untuk menggambar pola sierpinski Triangle pada sisi atas

        }
    }
    /* bentuk bebas kochsnowflake */
    public void kochSnowflake(int ukuran) {
        kurakuraku.rotasi(-60);
        drawKochSnowflake(ukuran);
        kurakuraku.rotasi(120);
        drawKochSnowflake(ukuran);
        kurakuraku.rotasi(120);
        drawKochSnowflake(ukuran);
    }
    /*method bantuan menggambar snow */
    private void drawKochSnowflake(int ukuran) {
        if (ukuran <= 5) {
            kurakuraku.maju(ukuran);
        } else {
            int newUkuran = ukuran / 3;
            drawKochSnowflake(newUkuran);
            kurakuraku.rotasi(-60);
            drawKochSnowflake(newUkuran);
            kurakuraku.rotasi(120);
            drawKochSnowflake(newUkuran);
            kurakuraku.rotasi(-60);
            drawKochSnowflake(newUkuran);
        }
    }
    public void heksagon(int ukuran){
        if (ukuran <= 0) {
            return;
        } 
        else {
            for (int i = 0; i < 6; i++) {
                kurakuraku.maju(ukuran);
                heksagon(ukuran / 2); // Memanggil rekursif untuk membuat segi enam lebih kecil di dalamnya
                kurakuraku.rotasi(60);
            }
        }
    }
    public void buatPohon(){        
        kurakuraku.setJejak(false);
        kurakuraku.reset();
        kurakuraku.rotasi(90);
        kurakuraku.maju(100);
        kurakuraku.rotasi(180);
        buatPohon(6,50);        
        kurakuraku.reset();
    }
    
    private void buatPohon(int ukuran, int tinggi){
        if (ukuran>0){
            kurakuraku.setJejak(true);
            kurakuraku.maju(tinggi);                        
            kurakuraku.rotasi(-45);
            Dimension posAwal = kurakuraku.getPosition();
            double arah = kurakuraku.getArah();
            double sudut = arah;
            for(int i=0;i<3;i++){  
                buatPohon(ukuran-1,(int)(tinggi/1.5));
                kurakuraku.setJejak(false);
                kurakuraku.setPosition(posAwal);
                kurakuraku.setArah(arah);                
                sudut+=45;
                kurakuraku.rotasi(sudut);  
            }     
        }
        kurakuraku.reset();
    }
}
