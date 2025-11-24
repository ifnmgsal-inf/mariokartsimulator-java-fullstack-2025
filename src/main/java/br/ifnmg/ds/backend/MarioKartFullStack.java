/*
 * Classe com a API backend
 */

package br.ifnmg.ds.backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**´5
 *
 * @author leonardosilva
 */
public class MarioKartFullStack {

    public static List<Character> csvToList(String csvFileName) throws FileNotFoundException {
        List<Character> myList = new ArrayList<>();
        File csvfile = new File(csvFileName);
        try (Scanner sc = new Scanner(csvfile)) {
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] data = line.split(";");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int speed = Integer.parseInt(data[2]);
                int maneuverability = Integer.parseInt(data[3]);
                int power = Integer.parseInt(data[4]);
                String image = data[5];

                Character c = new Character(id, name, speed, maneuverability, power, image);
                myList.add(c);
                //System.out.println(quiz);
            }
        }
        return myList;
    }
}
