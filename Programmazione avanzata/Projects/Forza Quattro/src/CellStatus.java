
    public enum CellStatus{
        empty,
        full,
        red,
        yellow;

        public String toString() {
            switch ( this ) {
            case empty: return " "; 
            case full: return "+";
            }
            return "";
        }
    }
