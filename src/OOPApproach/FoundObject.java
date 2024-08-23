package OOPApproach;

public class FoundObject {
    private int start;
    private int end;

    public void setStart(int start){
        this.start=start;
    }
    public int getStart(){
        return this.start;
    }

    public void setEnd(int end){
        this.end=end;
    }

    public int getEnd(){
        return this.end;
    }

    @Override
    public String toString() {
        return "FoundObject{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
