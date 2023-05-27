package menu;

public class Player {
    private String name;
    private int gameScore;

    public Player(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getGameScore() {
        return this.gameScore;
    }
    public void setGameScore(int newExperience){
        if (newExperience >= 0){
               this.gameScore = newExperience;
        }
    }
}