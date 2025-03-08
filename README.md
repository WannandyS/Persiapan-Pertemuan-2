# Persiapan Pertemuan 2

| Kriteria | Keterangan |
|--|--|
| **Anggota** | Donny Andrian       (23100002) <br/>Michella Anastasya  (23100007) <br/>Wannandy Suwandy    (23100008) |
| **Prodi** | Sistem dan Informasi Teknologi |
| **Mata Kuliah** | Pemrograman Berorientasi Objek II |

<details>
<summary>

### 1. *Prototype Design Pattern*</summary>

*Prototype pattern* adalah salah satu pola desain dalam kategori *Creational Pattern* yang digunakan untuk membuat objek baru dengan menduplikasi objek yang sudah ada. Pola ini memungkinkan pembuatan objek tanpa harus bergantung pada kelas spesifiknya.

</details>

<details>
<summary>

### 2.  Penggunaan *Prototype Pattern*</summary>

*Prototype pattern* digunakan ketika proses pembuatan objek sangat mahal (misalnya membutuhkan banyak sumber daya atau waktu), setelah itu jika objek memiliki banyak konfigurasi yang kompleks dan ingin menghindari inisialisasi ulang dari awal dan pada saat ingin mengurangi ketergantungan pada `constructor` dan subkelas.

</details>

<details>
<summary>

### 3.  Kelebihan dan Kekurangan *Prototype Pattern*</summary>

Kelebihan *prototype pattern* adalah meningkatkan performa dengan menghindari pembuatan objek dari nol, mengurangi kompleksitas kode dengan menghindari inisialisasi berulang dan memungkinkan pembuatan objek baru dengan sedikit modifikasi dari objek yang ada.

Sedangkan kekurangan dari *prototype pattern* adalah membutuhkan implementasi metode `clone()`, yang bisa menjadi rumit jika objek memiliki referensi ke objek lain dan sulit digunakan jika objek memiliki banyak dependensi atau mengandalkan sumber daya eksternal.

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

Dalam class ContohPrototype, objek Bird pertama (bird1) dibuat dengan species "Chicken", lalu duplikasi menjadi bird2 menggunakan clone(). Kedua objek kemudian ditampilkan, menunjukkan bahwa bird2 adalah salinan dari bird1 dengan atribut yang sama.

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

Pada kelas utama, `PrototypeExample2`, kita membuat prototipe konkret (`circlePrototype`) yakni lingkaran merah. Kita kemudian membuat `ShapeClient` dan memberikannya prototipe lingkaran merah. *Client* menggunakan prototipe tersebut untuk membuat bentuk baru (`redCircle`) menggunakan metode `createShape()`. Terakhir, kita menggambar lingkaran merah yang baru dibuat menggunakan metode `draw()`.[^1]

Adapun output yang diberikan setelah metode `draw()` dijalankan sebagai berikut.
``` plaintext
Drawing a red circle.
```

</details>

### Daftar Pustaka
[^1]: https://www.geeksforgeeks.org/prototype-design-pattern-in-java#4-complete-code-for-the-above-example
>>>>>>> 49746944b436dc4d48d6bcc056c067c82db8ff05
