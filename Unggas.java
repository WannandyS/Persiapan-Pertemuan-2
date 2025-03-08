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

class ContohPrototype {
    public static void main(String[] args) {
        Unggas unggas1 = new Unggas("Ayam");
        System.out.println("Unggas 1: " + unggas1);
        Unggas unggas2 = (Unggas) unggas1.clone();
        System.out.println("Unggas 2: " + unggas2);
    }
}