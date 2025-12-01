/*
 * Classe com a API backend
 */

package br.ifnmg.ds.backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**´5
 *
 * @author leonardosilva
 */
public class MarioKartFullStack {
    private static final String FILE_NAME = "data/characters.csv";
    public static final int DICE_SIDES = 6;

    public static final String[] TRACK_NAME = {"RETA", "CURVA", "CONFRONTO"};
    private static final int STRAIGHT_LINE = 0;
    private static final int TURN = 1;
    private static final int CONFRONTATION = 2;

    private static Random localRandom = null;

    /**
     * 4a - Um método que retorna uma lista com todos os personagens.
     * @return List<Character>
     * @throws FileNotFoundException 
     */
    public static List<Character> getAllCharacters() throws FileNotFoundException {
        List<Character> myList = new ArrayList<>();
        File csvfile = new File(FILE_NAME);
        try (Scanner sc = new Scanner(csvfile)) {
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int speed = Integer.parseInt(data[2]);
                int maneuverability = Integer.parseInt(data[3]);
                int power = Integer.parseInt(data[4]);
                String image = data[5];

                Character c = new Character(id, name, speed, maneuverability, power, image);
                myList.add(c);
            }
        }
        return myList;
    }
    
    /**
     * 4b - Um método que retorna um inteiro sorteado aleatoriamente, pode ser um tipo de pista
     * ou o lado de um dado, por exemplo
     * @param length
     * @return int
     */
    public static int getRandomNumber(int length) {
        return getRandomInstance().nextInt(length);
    }

    /**
     * 4c - Um método que retorna um personagem (objeto) sorteado aleatoriamente. 
     * Existe uma validacao para nao permitir que seja selecionado um personagem que ja foi 
     * escolhido para player1 (alreadyChosenCharacter).
     * @param list
     * @param alreadyChosenCharacter
     * @return Character
     */
    public static Character getRandomCharacter(List<Character> list, Character alreadyChosenCharacter) {
        int index = getRandomNumber(list.size());
        if (list.get(index) == alreadyChosenCharacter)
            return getRandomCharacter(list, alreadyChosenCharacter);
        return list.get(index);
    }
    
    private static Random getRandomInstance() {
        if (MarioKartFullStack.localRandom == null) MarioKartFullStack.localRandom = new Random();
        return MarioKartFullStack.localRandom;
    }

    /**
     * 4e - Um método que recebe como entrada 6 parâmetros, que são: número da rodada, 
     * tipo de pista; player1; player2; valor tirado no dado pelo player1; valor tirado no dado pelo player2. 
     * @param number
     * @param player1
     * @param player2
     * @param dicePlayer1
     * @param dicePlayer2
     * @param trackType
     * @return Esse método deve retornar (saída) uma instância do TAD que representa uma rodada (Round).
     */
    public static Round getRound(int number, Character player1, Character player2, int dicePlayer1, int dicePlayer2, int trackType) {
        int sumPlayer1 = abilityNeeded(trackType, player1) + dicePlayer1;
        int sumPlayer2 = abilityNeeded(trackType, player2) + dicePlayer2;
            
        return new Round(number, player1, player2, sumPlayer1, sumPlayer2, trackType);
    }
    
    private static int abilityNeeded(int trackType, Character player) {
        return switch (trackType) {
            case STRAIGHT_LINE -> player.getSpeed();
            case TURN -> player.getManeuverability();
            default -> player.getPower();
        };
    }
    
    /**
     * 4f - método que recebe como entrada uma instância do TAD que representa uma 
     * rodada e atualiza o score dos jogadores, conforme as regras da partida.
     * @param roundData 
     */
    public static void setGlobalScore(Round roundData) {
        if (roundData.getTrackType() == CONFRONTATION) {
            manageScoreLoss(roundData.getPlayer1(), roundData.getScoringPlayer1(), 
                    roundData.getPlayer2(), roundData.getScoringPlayer2());
        } else {
            manageScoreIncrease(roundData.getPlayer1(), roundData.getScoringPlayer1(), 
                    roundData.getPlayer2(), roundData.getScoringPlayer2());
        }
        
    }
    
    private static void manageScoreLoss(Character player1, int sumPlayer1, Character player2, int sumPlayer2) {
        if ((sumPlayer1 > sumPlayer2) && (player2.getScore() > 0)) {
            player2.setScore(player2.getScore() - 1);
        } else if ((sumPlayer1 < sumPlayer2) && (player1.getScore() > 0)) {
            player1.setScore(player1.getScore() - 1);
        }
    }

    private static void manageScoreIncrease(Character player1, int sumPlayer1, Character player2, int sumPlayer2) {
        if (sumPlayer1 > sumPlayer2) {
            player1.setScore(player1.getScore() + 1);
        } else if (sumPlayer1 < sumPlayer2) {
            player2.setScore(player2.getScore() + 1);
        }
    }

}
