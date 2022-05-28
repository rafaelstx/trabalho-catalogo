package models;

public class Band extends Artist {

    private int membersNumb;

    public Band() {

    }

    public Band(int membersNumb) {
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
        return super.toString();
    }
}
