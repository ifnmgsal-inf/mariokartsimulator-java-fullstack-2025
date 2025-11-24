/**
 * Alguns metodos para teste
 */
package br.ifnmg.ds.test;

import static br.ifnmg.ds.backend.MarioKartFullStack.csvToList;
import br.ifnmg.ds.backend.Character;
import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 * @author leonardoã
 */
public class Main {
    public static void main(String[] args) {
        try {
            List<Character> characterList = csvToList();
            for (Character c : characterList) {
                System.out.println(c);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo CSV n");
        }
    }
}
