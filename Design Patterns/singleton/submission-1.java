static class Singleton {
    static Singleton instance = null;
    String value = null;
    private Singleton() {

    }

    public static Singleton getInstance() {
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
