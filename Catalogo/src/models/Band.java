package models;
public class Band extends Artist {
    private int membersNumb;

    public int getMembersNumb() {
        return membersNumb;
    }

    public void setMembersNumb(int membersNumb) {
        this.membersNumb = membersNumb;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
