public class Map {
    private int width;
    private int height;
    private char[][] map;
    final private char EMPTY = '.';
    
    
    public Map(int width, int height){
        this.width = width;
        this.height = height;
        this.map = new char[width][height];
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                map[i][j] = EMPTY;
            }
        } 

    }

    public void placeRoom(Position pos, char symbol){
        map[pos.x][pos.y] = symbol;
    }

    public String display(){
        String mapString = "";
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                mapString += map[j][i];
            }
            mapString += "\n";
        }
        return mapString;
    }
}