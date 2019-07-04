package trickycorejava;

public class InnerClass {
    int id;
    oneClass oneClass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public trickycorejava.oneClass getOneClass() {
        return oneClass;
    }

    public void setOneClass(trickycorejava.oneClass oneClass) {
        this.oneClass = oneClass;
    }

    public InnerClass(int id, trickycorejava.oneClass oneClass) {
        this.id = id;
        this.oneClass = oneClass;
    }
    public InnerClass(int id){
        this.id = id;
    }
}

class oneClass{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}