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
    private int idPlayer1;
    private int idPlayer2;
    private int scoringPlayer1;
    private int scoringPlayer2;
    private int trackType;
    private LocalDateTime datetime;

    public Round(int number, int idPlayer1, int idPlayer2, int scoringPlayer1, int scoringPlayer2, int trackType) {
        this.number = number;
        this.idPlayer1 = idPlayer1;
        this.idPlayer2 = idPlayer2;
        this.scoringPlayer1 = scoringPlayer1;
        this.scoringPlayer2 = scoringPlayer2;
        this.trackType = trackType;
        this.datetime = LocalDateTime.now();
    }

    public int getNumber() {
        return number;
    }

    public int getIdPlayer1() {
        return idPlayer1;
    }

    public int getIdPlayer2() {
        return idPlayer2;
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
        return "Round{" + "number=" + number + ", idPlayer1=" + idPlayer1 + 
                ", idPlayer2=" + idPlayer2 + ", scoringPlayer1=" + scoringPlayer1 + 
                ", scoringPlayer2=" + scoringPlayer2 + ", trackType=" + trackType + ", datetime=" + datetime + '}';
    }
  
    
}
