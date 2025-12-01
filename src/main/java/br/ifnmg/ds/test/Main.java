/**
 * Alguns metodos para teste
 */
package br.ifnmg.ds.test;

import br.ifnmg.ds.backend.Character;
import br.ifnmg.ds.backend.MarioKartFullStack;
import java.io.FileNotFoundException;
import java.util.List;
import static br.ifnmg.ds.backend.MarioKartFullStack.getAllCharacters;
import br.ifnmg.ds.backend.Round;

/**
 *
 * @author leonardoã
 */
public class Main {
    private static List<Character> characterList;
    
    public static void main(String[] args) {
        getAllCharactersTest();
        getRandomTrackTypeTest();
        getRandomCharacterTest();
        getRandomDiceTest();
        getRoundTest();
    }
    
    private static void getAllCharactersTest() {
        try {
            characterList = getAllCharacters();
            for (Character c : characterList) {
                System.out.println(c);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo CSV nao encontrado!");
        }        
    }
    
    private static void getRandomTrackTypeTest() {
        int trackType = MarioKartFullStack.getRandomNumber(MarioKartFullStack.TRACK_NAME.length);
        
        System.out.println("A pista sorteada foi: " + MarioKartFullStack.TRACK_NAME[trackType]);
    }

    private static void getRandomCharacterTest() {
        Character player1 = MarioKartFullStack.getRandomCharacter(characterList, null);
        Character player2 = MarioKartFullStack.getRandomCharacter(characterList, player1);
        
        System.out.println("Personagens sorteados: " + player1.getName() + " e " + player2.getName());
    }
    
    private static void getRandomDiceTest() {
        int diceNumber = MarioKartFullStack.getRandomNumber(MarioKartFullStack.DICE_SIDES)+1;
        
        System.out.println("O valor dorteado no dado foi: " + diceNumber);
    }

    private static void getRoundTest() {
        Character player1 = MarioKartFullStack.getRandomCharacter(characterList, null);
        Character player2 = MarioKartFullStack.getRandomCharacter(characterList, player1);    
        int trackType = MarioKartFullStack.getRandomNumber(MarioKartFullStack.TRACK_NAME.length);
        int dicePlayer1 = MarioKartFullStack.getRandomNumber(MarioKartFullStack.DICE_SIDES)+1;
        int dicePlayer2 = MarioKartFullStack.getRandomNumber(MarioKartFullStack.DICE_SIDES)+1;
        
        System.out.println("Rodada numero X:");
        System.out.println("Personagens sorteados: " + player1.getName() + " e " + player2.getName());
        System.out.println("Tipo de pista: " + MarioKartFullStack.TRACK_NAME[trackType]);
        Round testRound = MarioKartFullStack.getRound(1, player1, player2, dicePlayer1, dicePlayer1, trackType);
        System.out.println("Historico da RODADA: " + testRound);
    }

}
