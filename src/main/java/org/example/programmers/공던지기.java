package org.example.programmers;

public class 공던지기 {
    public static void main(String[] args) {
        BallThrowingSolution ballThrowingSolution = new BallThrowingSolution();
        int solution = ballThrowingSolution.solution(new int[]{1, 2, 3, 4, 5, 6}, 5);
        System.out.println(solution);
    }
}

class BallThrowingSolution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        Player players = new Player();
        for (int i = 0; i < numbers.length; i++) {
            players = players.add(numbers[i]);
        }

        players = players.getHead();

        for (int i = 1; i < k; i++) {
            players = players.skipSearch(2);
        }

        return players.getPlayerName();
    }
}

class Player {
    private int playerName;
    private Player nextPlayer;
    private Player priviousPlayer;
    private static int playerLength = 0;
    private int playerIndex = 0;


    public Player() {}

    public Player(int playerName, Player priviousPlayer) {
        this.playerName = playerName;
        this.priviousPlayer = priviousPlayer;

        if (priviousPlayer == null) {

            playerIndex = 0;
        }
        if (priviousPlayer != null) {
            playerIndex = priviousPlayer.getIndex() + 1;
        }
    }

    public Player add(int playerName) {
        nextPlayer = new Player(playerName, this);
        playerLength++;
        return nextPlayer;
    }


    public Player getHead() {
        if (playerIndex == 1) {
            priviousPlayer = getTail();
            return this;
        }
        return priviousPlayer.getHead();
    }

    public Player getTail() {
        if (playerIndex == playerLength) {
            return this;
        }
        return nextPlayer.getTail();
    }

    public int getIndex() {
        return playerIndex;
    }

    public int getPlayerName() {
        return playerName;
    }

    public Player skipSearch(int index) {
        Player player = this;
        for (int i = 0; i < index; i++) {
            player = player.nextPlayer;
            if (player == null) {
                player = getHead();
            }
        }

        return player;
    }

    public Player findIndex(int index) {
        if (playerIndex == index) {
            return this;
        }
        return nextPlayer.findIndex(index);
    }
}
