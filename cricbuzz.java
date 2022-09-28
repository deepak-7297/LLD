enum PlayerType{
    BATSMAN,
    BOWLER,
    ALLROUNDER
}

enum BallType {
    WIDE,
    NOBALL,
    BOUNCER
}

enum WicketType {
    BOWLED,
    RUNOUT,
    STUMPED
}

class Player{
    public String name;
    private Integer age;

    private PlayerType PlayerType;

}

class Team{
    public Set<Player> teamList;

    private Player captain;
    private Player viceCaptain;
}

class Over {
    public Integer OverNo;
    public Player bowledBy;

    private ArrayList<Ball> balls;

    public void updateBallinOver(Ball ball){
        balls.add(ball);
    }

    public boolean hasOverEnded(){
        return balls.length() == 6;
    }
}

class Ball {
    public Wicket wicket=null;
    public Integer runScored;

    public BallType BallType;
}

class Wicket {
    public Player playerOut;
    public Player runOutBy;
    public Player catchOutBy;
}

abstract class Match {
    public Set<Team> teams;
    public String stadium;

    public Match(Set<Team> teams, String stadium){
        this.teams = teams;
        this.stadium = stadium;
    }

    abstract int totOvers();
    abstract int totInings();

}

class Odi extends Match{
    public Arraylist<ScoreBoard> IningsScore = new ArrayList<ScoreBoard>(2);
    public Integer currentInings = 0;

    public ScoreBoard getCurrentIningsScore() {
        return currentIningsScore;
    }

    private ScoreBoard currentIningsScore;

    @java.lang.Override
    public int totOvers(){
        return 50;
    }

    public Odi(Set<Team> teams, String stadium) {
        super(teams, stadium);
    }

    @java.lang.Override
    int totInings() {
        return 2;
    }

    public void startInings(Integer iningsNo){
       currentInings = new ScoreBoard();
    }

    public void stopInings(){
        IningsScore.add(currentInings);
    }
}

class ScoreBoard {
    public int runs;
    public int wickets;
    public ArrayList<Player> onCrease = new ArrayList<ScoreBoard>(2);

    public ArrayList<Over> over;


    public ScoreBoard(){
        this.runs = 0;
        this.wickets = 0;
    }

    public void increaseRunByBall(Ball ball){

    }

    public void setOverLength(int overLength){
        over = new ArrayList<Over>(overLength);
    }

    public String ScoreBoard(){
        return getRuns().toString() + "/" + getWickets().toString();
    }


    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }


}

Team a = new Team();
Team b = new Team();
Set<Teams> teamsSet = new Set<>(a, b);
Odi odi = new Odi(teamsSet, "");
odi.startInings(1);

odi.getCurrentIningsScore().setOver()
Over over= new Over();
Ball ball = new Ball();
over.updateBallinOver(ball);
