# Persiapan Pertemuan 2

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


4.  Buatkan contoh kodenya dalam java dan output yang dihasilkan!<br/>Jawaban :
#### Contoh
> Keseluruhan kode yang terdapat pada bagian ini dapat ditemukan pada [PrototypeExample.java](PrototypeExample.java). Kode yang terlampir pada bagian ini merupakan hanya sebagian yang menampilkan informasi penting terkait *prototype pattern*.

````java
class Bird implements Cloneable {
    String species;

    public Bird(String species) {
        this.species = species;
    }

    @Override
    public Cloneable clone() {
        try {
            return(Bird) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String toString() {
        return "This species of bird is " + species;
    }
}

````
<br/>
Class Bird memiliki atribut species dan mengimplementasikan Cloneable, yang memungkinkan objek untuk diduplikasi melalui metode clone(). Metode clone() menggunakan super.clone() untuk membuat salinan objek. Karena super.clone() bisa melempar CloneNotSupportedException, maka digunakan blok try-catch untuk menangani kemungkinan error. Jika cloning gagal, metode akan menangkap exception dan mengembalikan null agar program tetap berjalan tanpa error.
<br/>
<br/>
Dalam class PrototypeExample, objek Bird pertama (bird1) dibuat dengan species "Chicken", lalu duplikasi menjadi bird2 menggunakan clone(). Kedua objek kemudian ditampilkan, menunjukkan bahwa bird2 adalah salinan dari bird1 dengan atribut yang sama.
<br/>
<br/>
Adapun output yang diberikan setelah dijalankan sebagai berikut.

````java
Bird 1: This species of bird is Chicken
Bird 2: This species of bird is Chicken
````

#### Sumber
https://www.avajava.com/tutorials/lessons/prototype-pattern.html