package academy.ennate.Entity;

import java.util.UUID;

public class Cust {

    private String id;
    private String name;
    private int amt;

    public Cust() {

        this.id=UUID.randomUUID()
                .toString();
    }


    public Cust(String name, int amt) {
        this.id=UUID.randomUUID()
                .toString();
        this.name = name;
        this.amt = amt;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }






    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





}
