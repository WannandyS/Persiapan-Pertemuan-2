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

Dalam bahasa pemrograman *Java*, *class-class* yang ingin mengimplementasikan *Prototype Pattern* harus mengimplementasikan interface yang bernama `Cloneable` dimana *interface* tersebut memiliki method `clone()` yang dapat menggandakan seluruh *object attribute* beserta isinya.

Berikut merupakan sebagian contoh implementasi *Prototype Pattern* dalam *Java*:

``` java
public class AModel implements Cloneable {
    @Override
    public AModel clone() throws CloneNotSupportedException {
        return (AModel) super.clone();
    }
}
```
Tanpa mengimplementasikan *interface* `Cloneable`, *class* `AModel` akan otomatis melemparkan *exception* berupa `CloneNotSupportedException` karena adanya satu *attribute* yang tidak mendukung/mengimplementasikan *interface* `Cloneable`.

</details>

<br/>
