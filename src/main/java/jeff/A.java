package jeff;

public class A {
    private String name;
    private String value;
    private int height;

    public A() { System.out.println("Call A constructor.");}

    public void setName(String name) {
        System.out.println("Call A.setName: " + name);
        this.name = name;
    }

    public void setValue(String value) {
        System.out.println("Call A.setValue: " + value);
        this.value = value;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void AInit() {
        System.out.println("Call AInit, set height as 170");
        this.height = 170;
    }

    public void ADestroy() {
        System.out.println("Call ADestroy.");
        this.name = "N/A";
        this.value = "N/A";
        this.height = 0;
    }

    public void say() {
        System.out.println("Hello, My name is " + name + ".");
    }

}
