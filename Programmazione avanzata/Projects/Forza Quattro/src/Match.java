

public class Match {
private static final int player1 = 0;
private static final int player2 = 1;
private Player[] players;
private Field field;
private int CurrentPlayer=player1;
private int pid;
private MatchStatus matchStatus = MatchStatus.ARRANGE;


    public Match(Player p1, Player p2) {
    this.players=new Player[]{p1,p2};
    this.field=new Field();
    }

    public MatchStatus getStatus(){
    return this.matchStatus;
    }

    public void setStatus(MatchStatus status){
    this.matchStatus=status;
    }

    private static int otherPlayer(int pid) {
    return (pid+1)%2;
    }


    private void win(int pid) {
    this.players[pid].Win();
    this.players[otherPlayer(pid)].Lose();
    }

    private void Lose(){
    this.players[pid].Lose();
    this.players[otherPlayer(pid)].Win();
    }

    private void fight() {
    this.players[player1].Matchstart();
    this.players[player2].Matchstart();
    while (Action());
    }

    private boolean Action() {
        int column = this.players[this.CurrentPlayer].Turn(pid);
        Piece pezzo = this.players[this.CurrentPlayer].NewPiece(column, pid);
        
        if (field.WinCondition(pezzo)) {
            win(this.CurrentPlayer);
            this.setStatus(matchStatus.END);
            return false;
        }
    this.CurrentPlayer = otherPlayer(this.CurrentPlayer);
    return true;
    }

    public void play(){
        if (!init(player1)) {
        return ;
        }
        if (!init(player2)) {
        return ;
        }
    this.setStatus(matchStatus.FIGHTING);
    fight();
    }

    private boolean init(int pid) {
        try {
        this.players[pid].init(pid);
        return true;
        } catch (Throwable e) {
        return false;
        }
    }

}
