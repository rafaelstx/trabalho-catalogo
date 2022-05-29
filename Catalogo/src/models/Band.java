package models;

public class Band extends Artist {

    private int membersNumb;

    public Band() {

    }

    public Band(int id, String name, int membersNumb) {
        super(id, name);
        this.membersNumb = membersNumb;
    }

    public int getMembersNumb() {
        return membersNumb;
    }

    public void setMembersNumb(int membersNumb) {
        this.membersNumb = membersNumb;
    }


    @Override
    public String toString() {
        return "{" +
            " band= '"+ super.toString() + "'" +
            " membersNumb='" + getMembersNumb() + "'" +
            "}";
    }
    
}
