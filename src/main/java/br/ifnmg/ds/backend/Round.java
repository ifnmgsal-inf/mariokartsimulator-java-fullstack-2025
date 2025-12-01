/**
 * TAD para as informaçoes relativas a uma rodada da partida (corrida).
 */
package br.ifnmg.ds.backend;

import java.time.LocalDateTime;

/**
 *
 * @author leonardo
 */
public class Round {
    private int number;
    private Character player1;
    private Character player2;
    private int scoringPlayer1;
    private int scoringPlayer2;
    private int trackType;
    private LocalDateTime datetime;

    public Round(int number, Character player1, Character player2, int scoringPlayer1, int scoringPlayer2, int trackType) {
        this.number = number;
        this.player1 = player1;
        this.player2 = player2;
        this.scoringPlayer1 = scoringPlayer1;
        this.scoringPlayer2 = scoringPlayer2;
        this.trackType = trackType;
        this.datetime = LocalDateTime.now();
    }

    public int getNumber() {
        return number;
    }

    public Character getPlayer1() {
        return player1;
    }

    public Character getPlayer2() {
        return player2;
    }

    public int getScoringPlayer1() {
        return scoringPlayer1;
    }

    public int getScoringPlayer2() {
        return scoringPlayer2;
    }

    public int getTrackType() {
        return trackType;
    }

    @Override
    public String toString() {
        return "Round{" + "number=" + number + ", idPlayer1=" + player1.getName() + 
                ", idPlayer2=" + player2.getName() + ", scoringPlayer1=" + scoringPlayer1 + 
                ", scoringPlayer2=" + scoringPlayer2 + ", trackType=" + trackType + ", datetime=" + datetime + '}';
    }
  
    
}
