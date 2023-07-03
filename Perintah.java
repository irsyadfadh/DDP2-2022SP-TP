
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
                return "perintah tidak dipahami.";
            }
        }
        else if (in[0].equalsIgnoreCase("mundur")){
            if (in.length > 1) {
                kurakuraku.mundur(Integer.parseInt(in[1]));
            } 
            else {
                return "Perintah tidak dipahami.";
            }
        }
        else if (in[0].equalsIgnoreCase("rotasi")){
            if (in.length > 1) {
                kurakuraku.rotasi(Integer.parseInt(in[1]));
            } 
            else {
                return "Perintah tidak dipahami.";
            }
        } 
        else if (in[0].equalsIgnoreCase("kotak")){
            if (in.length > 1) {
                buatKotak(Integer.parseInt(in[1]));
            } 
            else {
                return "Perintah tidak dipahami.";
            }
        }
        else if (in[0].equalsIgnoreCase("segitiga")){
            if (in.length > 1) {
                buatSegitiga(Integer.parseInt(in[1]));
            } 
            else {
                return "Perintah tidak dipahami.";
            }
        }
        else if (in[0].equalsIgnoreCase("segitigaSikuSiku")) {
            if (in.length > 2) {
                buatSegitigaSikuSiku(Integer.parseInt(in[1]), Integer.parseInt(in[2]));
            } 
            else {
                return "Perintah tidak dipahami.";
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
        // else if (in[0].equalsIgnoreCase("loop")) {
        //     int loopCount = Integer.parseInt(in[1]);
        //     StringBuilder repeatedCommands = new StringBuilder();
        //     for (int i = 2; i < in.length; i++) {
        //         repeatedCommands.append(in[i]).append(" ");
        //     }
        //     for (int i = 0; i < loopCount; i++) {
        //         lakukan(repeatedCommands.toString().trim());
        //     }
        // }
        else if (in[0].equalsIgnoreCase("loop")) {
            if (in.length > 2) {
                int loopCount = Integer.parseInt(in[1]);
                StringBuilder repeatedCommands = new StringBuilder();
                for (int i = 2; i < in.length; i++) {
                    repeatedCommands.append(in[i]).append(" ");
                }
                String commands = repeatedCommands.toString().trim();
                for (int i = 0; i < loopCount; i++) {
                    lakukan(commands);
                }
            } 
            else {
                return "Perintah tidak dipahami.";
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
    public void buatPersegi(int panjang, int lebar){
        for (int i = 0; i < 2; i++) {
            kurakuraku.maju(panjang);
            kurakuraku.rotasi(90);
            kurakuraku.maju(lebar);
            kurakuraku.rotasi(90);
        }

    }
    public void buatSegitiga(int ukuran){
        // TODO: Lengkapi isi method ini agar kura-kura bisa membuat segitiga sama sisi
        for (int i=0;i<3;i++){
            kurakuraku.maju(ukuran);
            kurakuraku.rotasi(-120);
        }
    }        
    public void buatSegitigaSikuSiku(int panjangAlas, int tinggi){
        kurakuraku.maju(tinggi);
        kurakuraku.rotasi(-90);
        kurakuraku.maju(panjangAlas);
        kurakuraku.rotasi(-135);
        kurakuraku.maju(tinggi);
     
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
