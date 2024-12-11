import java.util.*;
class Board {
    private int size;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;

    public Board(int size) {
        this.size = size;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
    }

    public int getSize() {
        return size;
    }

    public Map<Integer, Integer> getSnakes() {
        return snakes;
    }

    public Map<Integer, Integer> getLadders() {
        return ladders;
    }

    public void addSnake(int start, int end) {
        snakes.put(start, end);
    }

    public void addLadder(int start, int end) {
        ladders.put(start, end);
    }

    public int getNewPosition(int currentPosition) {
        if (snakes.containsKey(currentPosition)) {
            return snakes.get(currentPosition);
        } else if (ladders.containsKey(currentPosition)) {
            return ladders.get(currentPosition);
        }
        return currentPosition;
    }
}
class Dice {
    private int numFaces;
    private Random random;

    public Dice(int numFaces) {
        this.numFaces = numFaces;
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(numFaces) + 1;
    }
}

class Game {
    private Board board;
    private Dice dice;
    private List<Player> players;
    private int currentPlayerIndex;

    public Game(int boardSize, int numDiceFaces) {
        this.board = new Board(boardSize);
        this.dice = new Dice(numDiceFaces);
        this.players = new ArrayList<>();
        this.currentPlayerIndex = 0;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void initializeGame() {
        board.addSnake(16, 6);
        board.addSnake(47, 26);
        board.addLadder(2, 38);
        board.addLadder(7, 14);
    }

    public void playTurn() {
        Player currentPlayer = players.get(currentPlayerIndex);
        int diceRoll = dice.roll();
        int newPosition = currentPlayer.getPosition() + diceRoll;

        if (newPosition <= board.getSize()) {
            newPosition = board.getNewPosition(newPosition);
            currentPlayer.setPosition(newPosition);
            System.out.println(currentPlayer.getName() + " moved to " + newPosition);
        }

        if (isGameOver()) {
            System.out.println(currentPlayer.getName() + " wins!");
        } else {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }

    public boolean isGameOver() {
        return players.stream().anyMatch(player -> player.getPosition() == board.getSize());
    }

    public void start() {
        initializeGame();
        while (!isGameOver()) {
            playTurn();
        }
    }
}

class Player {
    private String name;
    private int position;

    public Player(String name) {
        this.name = name;
        this.position = 0; 
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int newPosition) {
        this.position = newPosition;
    }
}

public class SnakeAndLadder {
    public static void main(String[] args) {
        Game game = new Game(100, 6);
        game.addPlayer(new Player("Alice"));
        game.addPlayer(new Player("Bob"));
        game.start();
    }
}
