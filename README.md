# Persiapan Pertemuan 2

| Kriteria | Keterangan |
|--|--|
| **Anggota** | Donny Andrian       (23100002) <br/>Michella Anastasya  (23100007) <br/>Wannandy Suwandy    (23100008) |
| **Prodi** | Sistem dan Informasi Teknologi |
| **Mata Kuliah** | Pemrograman Berorientasi Objek II |

<details>
<summary>

### 1. *Prototype Design Pattern*</summary>

*Prototype pattern* adalah salah satu pola desain dalam kategori *creational pattern* yang digunakan untuk membuat objek baru dengan menduplikasi objek yang sudah ada. Dengan menggunakan *prototype pattern*, kita dapat membuat objek tanpa bergantung pada kelas spesifiknya.

Pola ini sangat berguna dalam situasi di mana pembuatan objek baru dari awal membutuhkan biaya yang tinggi dalam hal sumber daya atau waktu. Dalam penerapannya, objek yang sudah ada disebut sebagai *prototype*, dan objek baru dibuat dengan menyalin *prototype* tersebut.

Metode `clone()` sering digunakan untuk mengimplementasikan *prototype pattern*, di mana objek baru dibuat dengan menyalin semua properti dari objek yang sudah ada. Dengan cara ini, kita dapat menghindari inisialisasi ulang yang mahal dan mempercepat proses pembuatan objek.[^4]

</details>

<details>
<summary>

### 2.  Penggunaan *prototype Pattern*</summary>

*Prototype pattern* digunakan ketika pembuatan objek baru sangat mahal atau kompleks dan dapat dihindari dengan menduplikasi objek yang sudah ada. Berikut beberapa kasus di mana *prototype pattern* cocok digunakan:

* Ketika proses pembuatan objek sangat mahal atau memakan banyak sumber daya. <br/>
Contohnya, jika sebuah objek memiliki proses inisialisasi yang berat, seperti membaca data dari database atau melakukan perhitungan kompleks, maka lebih efisien untuk menduplikasi objek yang sudah ada daripada membuat objek baru dari nol.

* Ketika objek memiliki banyak konfigurasi yang kompleks. <br/>
Jika ada banyak variasi dari suatu objek, seperti perbedaan warna, ukuran, atau fitur tambahan seperti contoh, tombol dalam aplikasi yang bisa berbeda warna dan bentuk, atau karakter dalam game yang punya atribut unik. Kita bisa menggunakan satu *prototype* dasar dan melakukan *cloning* dengan sedikit modifikasi daripada membuat banyak *subclass* atau *constructor* yang berbeda.

* Ketika ingin mengurangi ketergantungan pada *subclass* dan *constructor*.<br/> 
Dengan menggunakan *prototype pattern*, kita tidak perlu bergantung pada *subclass* untuk membuat variasi objek, seperti dalam sistem kendaraan di mana mobil sport, mobil keluarga, dan mobil listrik dapat dibuat dari satu *prototype* dasar dan dimodifikasi sesuai kebutuhan. Hal ini juga berguna dalam *e-commerce*, di mana produk dapat memiliki variasi warna dan ukuran tanpa memerlukan kelas terpisah untuk setiap kombinasi.

* Ketika objek perlu dibuat secara dinamis pada *runtime*
Dalam beberapa kasus, objek harus dibuat berdasarkan data atau keadaan yang hanya diketahui saat aplikasi berjalan. Jika setiap kali harus membuat objek baru dari nol, prosesnya bisa menjadi lambat dan tidak efisien. Dengan menggunakan *prototype pattern*, kita bisa menggandakan objek yang sudah ada tanpa harus mendefinisikan ulang struktur objek tersebut, yaitu susunan atribut dan metode yang membentuk objek. Dengan cara ini, kita tetap bisa menyesuaikan objek sesuai kebutuhan tanpa harus merancangnya ulang dari awal.[^4]

</details>

<details>
<summary>

### 3.  Kelebihan dan Kekurangan *prototype Pattern*</summary>

Kelebihan *prototype pattern*:
* Bisa membuat salinan objek tanpa harus mengetahui kelasnya secara konkret.
* Menghindari kode duplikasi dalam proses inisialisasi objek.
* Memudahkan pembuatan objek kompleks dengan banyak konfigurasi.
* Alternatif yang lebih fleksibel dibandingkan pewarisan dalam kasus tertentu.

Kekurangan *prototype pattern*:
* *Cloning* bisa menjadi rumit jika objek memiliki referensi silang atau siklus dependensi.
* Memerlukan pemahaman mendalam tentang bagaimana objek dibuat dan dikloning.
* Jika tidak dikelola dengan baik, bisa menyebabkan konsumsi memori yang tidak efisien. [^3]

Contoh : <br/>
Misalkan dalam sebuah game, ada berbagai jenis karakter seperti *warrior, archer, dan mage*, yang memiliki atribut dasar yang hampir sama, seperti jumlah *health, attack power*, dan senjata yang digunakan. Namun, setiap karakter memiliki sedikit perbedaan dalam atributnya, seperti jenis senjata dan kekuatan serangan.

Daripada membuat setiap karakter dari nol atau menggunakan banyak *subclass* untuk setiap jenis karakter, kita bisa menerapkan*prototype pattern*. Kita cukup membuat satu karakter dasar, misalnya *warrior*, lalu menggandakannya menggunakan metode *cloning* dan menyesuaikan beberapa atribut sesuai dengan jenis karakter yang diinginkan.

Sebagai contoh, kita membuat objek dasar *warrior* dengan *health* 100, *attack power* 20, dan senjata *sword*. Kemudian, kita menggandakannya untuk membuat karakter *archer* dengan mengubah senjatanya menjadi *bow* dan mengurangi sedikit kekuatan serangannya. Begitu juga dengan karakter *mage*, yang memiliki senjata *staff* dan kekuatan serangan yang lebih tinggi dibandingkan *warrior*.

Dengan cara ini, kita tidak perlu menulis ulang kode atau membuat banyak *subclass*, sehingga proses pembuatan karakter menjadi lebih efisien dan fleksibel.
</details>

<details>
<summary>

### 4.  Contoh Kode *Design Pattern Prototype* dalam *Java* dan Output yang Dihasilkan!
</summary>

#### Contoh 1
> Keseluruhan kode yang terdapat pada bagian ini dapat ditemukan pada [PrototypeExample.java](PrototypeExample.java). Kode yang terlampir pada bagian ini merupakan hanya sebagian yang menampilkan informasi penting terkait *prototype pattern*.

```java
class Bird implements Cloneable {
    String species;

    @Override
    public Cloneable clone() {
        try {
            return(Bird) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
```

Class Bird memiliki atribut species dan mengimplementasikan Cloneable, yang memungkinkan objek untuk diduplikasi melalui metode clone(). Metode clone() menggunakan super.clone() untuk membuat salinan objek. Karena super.clone() bisa melempar CloneNotSupportedException, maka digunakan blok try-catch untuk menangani kemungkinan error. Jika cloning gagal, metode akan menangkap exception dan mengembalikan null agar program tetap berjalan tanpa error.

Dalam class PrototypeExample, objek Bird pertama (bird1) dibuat dengan species "Chicken", lalu duplikasi menjadi bird2 menggunakan clone(). Kedua objek kemudian ditampilkan, menunjukkan bahwa bird2 adalah salinan dari bird1 dengan atribut yang sama.[^1]

Adapun output yang diberikan setelah dijalankan sebagai berikut.

``` plaintext
Bird 1: This species of bird is Chicken
Bird 2: This species of bird is Chicken
```

---------------------------------------------------

#### Contoh 2
> Keseluruhan kode yang terdapat pada bagian ini dapat ditemukan pada [PrototypeExample2.java](PrototypeExample2.java). Kode yang terlampir pada bagian ini merupakan hanya sebagian yang menampilkan informasi penting terkait *prototype pattern*.

```java
// Prototype interface
interface Shape {
    Shape clone();  // Make a copy of itself
    void draw();    // Draw the shape
}


// Concrete prototype
class Circle implements Shape {
    private String color;

    // This creates a copy of the circle.
    @Override
    public Shape clone() {
        return new Circle(this.color);
    }
}


// Client code
class ShapeClient {
    private Shape shapePrototype;

    // This method creates a new shape using the prototype.
    public Shape createShape() {
        return shapePrototype.clone();
    }
}

// Main class: PrototypeExample2
```

Pada kelas utama, `PrototypeExample2`, kita membuat prototipe konkret (`circlePrototype`) yakni lingkaran merah. Kita kemudian membuat `ShapeClient` dan memberikannya prototipe lingkaran merah. *Client* menggunakan prototipe tersebut untuk membuat bentuk baru (`redCircle`) menggunakan metode `createShape()`. Terakhir, kita menggambar lingkaran merah yang baru dibuat menggunakan metode `draw()`.[^2]

Adapun output yang diberikan setelah metode `draw()` dijalankan sebagai berikut.
``` plaintext
Drawing a red circle.
```

</details>

### Daftar Pustaka
[^1]: https://www.avajava.com/tutorials/lessons/prototype-pattern.html
[^2]: https://www.geeksforgeeks.org/prototype-design-pattern-in-java#4-complete-code-for-the-above-example
[^3]: https://refactoring.guru/design-patterns/prototype
[^4]: https://www.geeksforgeeks.org/prototype-design-pattern/