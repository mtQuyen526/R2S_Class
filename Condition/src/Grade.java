package Condition.src;
public enum Grade {
    A("cap A"),
    B("cap B"),
    other("others");
    private String msg;

    Grade() {
    }

    Grade (String msg){
        this.msg = msg;
    }
    public String Des(){
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
