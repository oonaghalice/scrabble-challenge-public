import java.util.HashMap;

public class Scrabble {
    String word;
    int points = 0;
    private HashMap<Character, Integer> tilePoints = new HashMap<Character, Integer>();
    boolean doubleWord;
    boolean tripleWord;
    Character[] doubleLetters;
    Character[] tripleLetters;

    Scrabble(String word) {
        this.word = word;
        setPoints();
    }

    Scrabble(String word, Character[] doubleLetters, Character[] tripleLetters, boolean doubleWord, boolean tripleWord) {
        this.word = word;
        this.doubleLetters = doubleLetters;
        this.tripleLetters = tripleLetters;
        this.doubleWord = doubleWord;
        this.tripleWord = tripleWord;
        setPoints();
        multiLetter();
    }

    private void setPoints() {
        tilePoints.put('a', 1);
        tilePoints.put('e', 1);
        tilePoints.put('i', 1);
        tilePoints.put('o', 1);
        tilePoints.put('u', 1);
        tilePoints.put('l', 1);
        tilePoints.put('n', 1);
        tilePoints.put('r', 1);
        tilePoints.put('s', 1);
        tilePoints.put('t', 1);
        tilePoints.put('d', 2);
        tilePoints.put('g', 2);
        tilePoints.put('b', 3);
        tilePoints.put('c', 3);
        tilePoints.put('m', 3);
        tilePoints.put('p', 3);
        tilePoints.put('f', 4);
        tilePoints.put('h', 4);
        tilePoints.put('v', 4);
        tilePoints.put('w', 4);
        tilePoints.put('y', 4);
        tilePoints.put('k', 5);
        tilePoints.put('j', 8);
        tilePoints.put('x', 8);
        tilePoints.put('q', 10);
        tilePoints.put('z', 10);
    }

    public int score() {
        if (this.word == null){
            this.points = 0;
        } else{
        for (int i = 0; i < this.word.length(); i++) {
            this.points += this.tilePoints.get(Character.toLowerCase(word.charAt(i)));
        }
        if (doubleWord == true){
            this.points = this.points * 2;
        }
        if (tripleWord == true){
            this.points = this.points * 3;
        }
    }
        return this.points;
}

    private int multiLetter() {
        if (doubleLetters.length != 0 || tripleLetters.length != 0) {
            for (char i : doubleLetters) {
                this.points += this.tilePoints.get(Character.toLowerCase(i));
            }
            for (char i : tripleLetters) {
                this.points += (this.tilePoints.get(Character.toLowerCase(i))) * 2;
            }
        }
        return this.points;
    }
}

