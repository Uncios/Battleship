
public enum Color{
    red,
    yellow;

    public String choseColor(){
        switch (this) {
            case red:return "";
            case yellow: return "#";
        }
        return "";
    }
}
