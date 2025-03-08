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

* Ketika pembuatan objek mahal atau perlu dibuat secara dinamis pada *runtime*. <br/>
Contohnya, jika sebuah objek memiliki proses inisialisasi yang berat, seperti membaca data dari *database* atau melakukan perhitungan kompleks, maka lebih efisien untuk menduplikasi objek yang sudah ada daripada membuat objek baru dari nol. Hal ini memberi efek positif pada saat program dijalankan (*runtime*), yakni dapat meringankan beban kerja program.

* Ketika objek memiliki banyak konfigurasi yang kompleks. <br/>
Jika ada banyak variasi dari suatu objek, seperti perbedaan warna, ukuran, atau fitur tambahan lainnya, kita bisa menggunakan satu *prototype* dasar dan melakukan *cloning* dengan sedikit modifikasi daripada membuat banyak *subclass* atau *constructor* yang berbeda.

* Ketika ingin mengurangi ketergantungan pada *subclass* dan *constructor*.<br/> 
Dengan menggunakan *prototype pattern*, kita tidak perlu bergantung pada *subclass* untuk membuat variasi objek, seperti dalam sistem kendaraan di mana mobil sport, mobil keluarga, dan mobil listrik dapat dibuat dari satu *prototype* dasar dan dimodifikasi sesuai kebutuhan. Hal ini juga berguna dalam *e-commerce*, di mana produk dapat memiliki variasi warna dan ukuran tanpa memerlukan kelas terpisah untuk setiap kombinasi.[^4]

</details>

<details>
<summary>

### 3.  Kelebihan dan Kekurangan *prototype Pattern*</summary>

Kelebihan *prototype pattern*:
* Bisa membuat salinan objek tanpa harus mengetahui kelasnya secara konkret. <br/>
Contoh: Ada boneka bernama Lala dengan baju merah. lalu kamu ingin boneka lain yang mirip, tapi dengan baju biru dan nama Lili. Daripada membuat boneka baru dari awal, kamu cukup menyalin Lala lalu mengubah namanya dan bajunya. Inilah yang dilakukan Prototype Pattern, yaitu menyalin objek tanpa perlu membuatnya dari nol.
* Menghindari duplikasi  proses inisialisasi objek. <br/>
Jika kita ingin membuat beberapa objek yang serupa, lebih baik menggunakan prototype pattern sehingga memungkinkan untuk menduplikasi objek secara langsung, daripada harus menginisiasi dari awal dengan constructor. Dengan demikian juga memudahkan pembuatan objek kompleks dengan banyak konfigurasi.
* Alternatif yang lebih fleksibel dibandingkan pewarisan dalam kasus tertentu.<br/>
Contoh: Jika kita ingin membuat berbagai variasi mobil dengan sedikit perubahan fitur (misalnya warna atau jenis mesin), kita bisa menggandakan satu mobil dasar daripada membuat banyak *subclass*.

Kekurangan *prototype pattern*:
* *Cloning* bisa menjadi rumit jika objek memiliki referensi silang atau siklus dependensi. <br/>
Contoh: Jika sebuah objek berisi referensi ke objek lain yang juga memiliki referensi kembali ke objek pertama, proses *cloning* bisa menyebabkan *loop* yang tidak diinginkan.
* Memerlukan pemahaman mendalam tentang bagaimana objek dibuat dan dikloning. <br/>
* Jika tidak dikelola dengan baik, bisa menyebabkan konsumsi memori yang tidak efisien. <br/>
Contoh: Jika terlalu banyak objek yang dikloning tanpa pengelolaan yang baik, bisa terjadi pemborosan memori dan menurunkan performa aplikasi. [^3]


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

Kelas `Bird` memiliki atribut `species` dan mengimplementasikan `Cloneable`, yang memungkinkan objek untuk diduplikasi melalui metode `clone()`. Metode `clone()` menggunakan `super.clone()` untuk membuat salinan objek. Karena `super.clone()` bisa melempar `CloneNotSupportedException`, maka digunakan blok `try-catch` untuk menangani kemungkinan error. Jika cloning gagal, metode akan menangkap *exception* dan mengembalikan `null` agar program tetap berjalan tanpa error.

Dalam kelas `PrototypeExample`, objek `Bird` pertama (`bird1`) dibuat dengan *species* "Chicken", lalu duplikasi menjadi `bird2` menggunakan `clone()`. Kedua objek kemudian ditampilkan, menunjukkan bahwa `bird2` adalah salinan dari `bird1` dengan atribut yang sama.[^1]

Adapun output yang diberikan setelah program dijalankan sebagai berikut.

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