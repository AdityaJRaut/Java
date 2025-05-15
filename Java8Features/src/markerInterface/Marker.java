package markerInterface;

public class Marker implements java.io.Serializable {

   transient final int id=20;
    private String name;

    public Marker()
    {

    }

    public Marker(int id, String name)
    {
       // this.id = 1;
        this.name = "";
    }

    public static void test()
    {
        System.out.println("static test");
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Marker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static int sum(int... numbers)
    {
        int sum=0;
        for(int n:numbers)
        {
            sum+=n;
        }
        return sum;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }
}

