
import java.awt.Dimension;

/**
 * 
 * Perintah.java
 * <br><br>
 * Class {@code Perintah} merepresentasikan perintah-perintah umum yang 
 * dapat diberikan kepada kura-kura. Termasuk dalam class ini adalah
 * proses untuk membaca input (saat ini baru melalui satu baris perintah)
 * dan memanggil method yang berkesesuaian.
 * Dalam kelas ini juga disediakan method-method yang merupakan kumpulan-kumpulan
 * perintah berurutan yang dapat diterima oleh kurakura dan menghasilkan gambar 
 * tertentu. 
 * <br><br>
 * Tugas anda pada file ini: <br>
 * - Lengkapi javadoc comment pada tiap deklarasi method.<br>
 * - Lengkapi inline comment untuk tiap baris perintah yang penting.<br>
 * - Perbaiki method {@code lakukan} agar tidak menimbulkan error bila input salah<br>
 * - Buat (1) perintah {@code mundur <x>}" agar kura-kura bisa mundur sebanyak x pixel satuan.
 * - Buat (2) perintah {@code hadap kanan} dan {@code hadap kiri} yang akan membuat kura-kura 
 *   menghadap ke kanan (rotasi 90) dan ke kiri (rotasi -90) 
 * - Dapatkah anda membuat (3) kura-kura mengenali perintah 
 *   {@code loop 10 perintah-perintah} <br>
 *   yang artinya melakukan perintah-perintah sebanyak 10 kali? <br>
 *   contoh: "loop 10 rotasi 30 maju 30" <br>
 *           yang artinya akan melakukan perintah "rotasi 30", dilanjutkan <br>
 *           perintah "maju 30", secara berulang-ulang sebanyak 10 kali<br>
 *   contoh: "loop 5 maju 20 hadap kanan maju 30" <br>
 *           yang artinya akan melakukan perintah "maju 20", dilanjutkan <br>
 *           "hadap kanan", kemudian perintah "maju 10", <br> 
 *           secara berulang-ulang sebanyak 5 kali<br>
 * 
 * @author Ade Azurat for DPBO 2008 @ Fasilkom UI
 * @author Ade Azurat for DDP2 2023 @ Fasilkom UI
 */
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
                return "Perintah tidak dipahami."; //handle jika hanya "kotak" saja maka tidak dipahami
            }
        }
        else if (in[0].equalsIgnoreCase("snowflake")){
            if (in.length > 1) {
                snowflake(Integer.parseInt(in[1]));
            } 
            else {
                return "Perintah tidak dipahami."; //handle jika hanya "kotak" saja maka tidak dipahami
            }
        }
        else if (in[0].equalsIgnoreCase("sierpinski")){
            if (in.length > 1) {
                sierpinski(Integer.parseInt(in[1]));
            } 
            else {
                return "Perintah tidak dipahami."; //handle jika hanya "kotak" saja maka tidak dipahami
            }
        }
        else if (in[0].equalsIgnoreCase("sierpinskiRekursif")){
            if (in.length > 1) {
                sierpinskiRekursif(Integer.parseInt(in[1]));
            } 
            else {
                return "Perintah tidak dipahami."; //handle jika hanya "kotak" saja maka tidak dipahami
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

    public void boxes(int ukuran){
        if (ukuran >= 0){
            buatKotak(ukuran);
            kurakuraku.setJejak(false);
            kurakuraku.maju(10);
            kurakuraku.rotasi(90);
            kurakuraku.maju(10);
            kurakuraku.rotasi(-90);
            kurakuraku.setJejak(true);
            boxes(ukuran-20);
        }
    }

    public void sierpinski(int ukuran){
        buatSegitiga(ukuran);
        kurakuraku.maju(ukuran/2);
        sierpinskiRekursif(ukuran/2);
        
    }

    public void sierpinskiRekursif(int ukuran){
        if (ukuran>2){
            //case rekursif
            // kurakuraku.maju(ukuran);
            // kurakuraku.rotasi(-60);
            // buatSegitiga(ukuran);
            // kurakuraku.rotasi(60);
            // sierpinskiRekursif(ukuran/2);
            kurakuraku.rotasi(-60);
            buatSegitiga(ukuran);
            kurakuraku.rotasi(60);
            Dimension pos = kurakuraku.getPosition();
            kurakuraku.maju(ukuran/2);
            sierpinskiRekursif(ukuran/2); //rekursif kanan
            kurakuraku.reset();
            kurakuraku.setPosition(pos);
            kurakuraku.mundur(ukuran/2);
            sierpinskiRekursif(ukuran/2); //rekursif kiri
            kurakuraku.reset();
            kurakuraku.setPosition(pos);
            kurakuraku.rotasi(-60);
            kurakuraku.maju(ukuran);
            kurakuraku.rotasi(-120);
            kurakuraku.maju(ukuran/2);
            kurakuraku.rotasi(180);
            sierpinskiRekursif(ukuran/2); // rekursif atas

        }
    }
    
    public void snowflake(int ukuran){
        // if(ukuran>0){
        //     Dimension pos = kurakuraku.getPosition();
        //     double arah = kurakuraku.getArah();
        //     for(int i=0;i<5;i++){
        //         kurakuraku.setArah(arah);
        //         arah = arah + 10;
        //         kurakuraku.maju(ukuran);
        //         snowflake(ukuran/2-2);
        //         kurakuraku.setPosition(pos);
        //         kurakuraku.rotasi(arah);
        //     }
        // }
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
