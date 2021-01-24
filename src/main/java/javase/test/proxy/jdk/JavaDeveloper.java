package javase.test.proxy.jdk;

public class JavaDeveloper implements Developer {

    private String name;

    public JavaDeveloper(String name) {
        this.name = name;
    }

    @Override
    public void code() {
        System.out.println(this.name + " is coding java");
    }

    @Override
    public void debug() {
        System.out.println(this.name + " is debugging java");
    }

    @Override
    public int codeCount() {
        return 0;
    }

}
