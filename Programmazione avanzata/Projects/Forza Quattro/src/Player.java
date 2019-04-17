


public interface Player{

    void Matchstart();
    
    void Win();

    void Lose();

    int Turn(int pid);

    Piece NewPiece(int column, int pid);

    void init(int pid);
}
