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

class PrototypeExample {
    public static void main(String[] args) {
        Bird bird1 = new Bird("Chicken");
        System.out.println("Bird 1: " + bird1);
        Bird bird2 = (Bird) bird1.clone();
        System.out.println("Bird 2: " + bird2);
    }
}