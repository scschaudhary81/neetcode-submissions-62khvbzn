static class Singleton {
    static Singleton object = null;
    String value = null;
    private Singleton() {

    }

    public static Singleton getInstance() {
        if(object == null){
            object = new Singleton();
        }
        return object;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
