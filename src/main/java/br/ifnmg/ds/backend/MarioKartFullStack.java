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

}
