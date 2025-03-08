﻿# Persiapan Pertemuan 2

| Kriteria | Keterangan |
|--|--|
| Anggota | Donny Andrian       (23100002) <br/>Michella Anastasya  (23100007) <br/>Wannandy Suwandy    (23100008) |
| Prodi | Sistem dan Informasi Teknologi |
| Mata Kuliah | Pemrograman Berorientasi Objek II |
|  |  |

1.  Jelaskan tentang salah satu design patterns!<br/>Jawaban : Prototype Pattern adalah salah satu pola desain dlm kategori Creational Pattern yang digunakan unk membuat objek baru dengan menduplikasi objek yang sudah ada. Pola ini memungkinkan pembuatan objek tanpa harus bergantung pada kelas spesifiknya.

2.  Jelaskan kapan pattern tersebut perlu digunakan (dalam case seperti apa dan jelaskan rinci)!<br/>Jawaban : Prototype pattern digunakan ketika proses pembuatan objek sangat mahal (misalnya membutuhkan banyak sumber daya / waktu), setelah itu jika objek memiliki banyak konfigurasi yang kompleks dan ingin menghindari inisialisasi ulang dari awal dan pada saat ingin mengurangi ketergantungan pada konstruktor dan subkelas.

3.  Analisis kelebihan dan kekurangan pattern tersebut!<br/>Jawaban : Kelebihan prototype pattern adalah meningkatkan performa dengan menghindari pembuatan objek dari nol, mengurangi kompleksitas kode dengan menghindari inisialisasi berulang dan memungkinkan pembuatan objek baru dengan sedikit modifikasi dari objek yang ada. <br/>
Sedangkan kekurangan dari prototype pattern adalah Mmmbutuhkan implementasi metode clone(), yang bisa menjadi rumit jika objek memiliki referensi ke objek lain dan sulit digunakan jika objek memiliki banyak dependensi atau mengandalkan sumber daya eksternal.


4.  Buatkan contoh kodenya dalam java dan output yang dihasilkan!<br/>Jawaban : Dalam bahasa pemrograman Java, class-class yang ingin mengimplementasikan Prototype Pattern harus mengimplementasikan interface yang bernama **Cloneable** dimana interface tersebut memiliki method **clone()** yang dapat menggandakan seluruh object attribute beserta isinya. Berikut merupakan implementasi Prototype Pattern dalam java:<br/>
```java
public class AModel implements Cloneable {
    @Override
    public AModel clone() {
        Amodel cloned;
        try {
            cloned = (AModel) super.class();
        } catch (CatchNotSupportedException e) {
            cloned = new AModel("//atribut yang ada//");
        }
        return cloned
    }
}
```
<br/> 
Tanpa mengimplementasikan interface Cloneable, class akan otomatis melemparkan exception berupa CloneNotSupportedException karena adanya satu attribute yang tidak mendukung/mengimplementasikan interface Cloneable.

#### Contoh
> Keseluruhan kode yang terdapat pada bagian ini dapat ditemukan pada [Unggas.java](Unggas.java). Kode yang terlampir pada bagian ini merupakan hanya sebagian yang menampilkan informasi penting terkait *prototype pattern*.

````java
class Unggas implements Cloneable {
    String jenis;

    public Unggas(String jenis) {
        this.jenis = jenis;
    }

    @Override
    public Cloneable clone() {
        try {
            return(Unggas) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String toString() {
        return "Jenis unggas ini adalah " + jenis;
    }
}

````
<br/>
Class Unggas memiliki atribut jenis dan mengimplementasikan Cloneable, yang memungkinkan objek untuk diduplikasi melalui metode clone(). Metode clone() menggunakan super.clone() untuk membuat salinan objek. Karena super.clone() bisa melempar CloneNotSupportedException, maka digunakan blok try-catch untuk menangani kemungkinan error. Jika cloning gagal, metode akan menangkap exception dan mengembalikan null agar program tetap berjalan tanpa error.
<br/>
Dalam class ContohPrototype, objek Unggas pertama (unggas1) dibuat dengan jenis "Ayam", lalu duplikasi menjadi unggas2 menggunakan clone(). Kedua objek kemudian ditampilkan, menunjukkan bahwa unggas2 adalah salinan dari unggas1 dengan atribut yang sama.
<br/>

Adapun output yang diberikan setelah dijalankan sebagai berikut.
````java
Unggas 1: Jenis unggas ini adalah Ayam       
Unggas 2: Jenis unggas ini adalah Ayam
````

#### Sumber
https://akmalrusli363.github.io/fla-design-patterns/Creational/Prototype.html