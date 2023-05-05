package menu;

public class Player {
    private String name;
    private int gameExperience;

    public Player(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getGameExperience() {
        return this.gameExperience;
    }
    public void setGameExperience(int newExperience){
        if (newExperience >= 0){
               this.gameExperience = newExperience;
        }
    }
}
