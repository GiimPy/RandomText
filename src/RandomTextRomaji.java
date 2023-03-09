import java.util.Random;

public class RandomTextRomaji {
    private final String[] JAPANESE_ROMAJI = {
        "a", "i", "u", "e", "o", "ka", "ki", "ku", "ke", "ko", "sa", "shi", "su", "se", "so", "ta", "chi", "tsu", "te", "to", "na", "ni", "nu", "ne", "no", "ha", "hi", "fu", "he", "ho", "ma", "mi", "mu", "me", "mo", "ya", "yu", "yo", "ra", "ri", "ru", "re", "ro", "wa", "wo", "n", "ga", "gi", "gu", "ge", "go", "za", "ji[zi]", "zu", "ze", "zo", "da", "ji[dzi]", "zu[dzu]", "de", "do", "ba", "bi", "bu", "be", "bo", "pa", "pi", "pu", "pe", "po", "[double]"
    };

    private final int MAX_WORD_LENGTH = 6;
    private final int MIN_WORD_LENGTH = 1;
    private final int MAX_WORDS_PER_SENTENCE = 8;
    private final int MIN_WORD_PER_SENTENCE = 1;
    private final int MAX_SENTENCES_PER_PARAGRAPH = 15;
    private final int MIN_SENTENCES_PER_PARAGRAPH = 5;
    
    public String createRandomText(int paragraphCount) {
        String out = "";
        for (int i = 0; i < paragraphCount; i++) {
            out += createRandomParagraph(getRandomOfRange(MIN_SENTENCES_PER_PARAGRAPH,MAX_SENTENCES_PER_PARAGRAPH)) + "\n\n";
        }
        return out;
    }

    public String createRandomParagraph() {
        return createRandomParagraph(getRandomOfRange(MIN_SENTENCES_PER_PARAGRAPH,MAX_SENTENCES_PER_PARAGRAPH));
    }

    public String createRandomParagraph(int sentenceCount) {
        String out = "";
        for (int i = 0; i < sentenceCount; i++) {
            out += createRandomSentence(getRandomOfRange(MIN_WORD_PER_SENTENCE,MAX_WORDS_PER_SENTENCE));
        }
        return out;
    }

    public String createRandomSentence() {
        return createRandomSentence(getRandomOfRange(MIN_WORD_PER_SENTENCE,MAX_WORDS_PER_SENTENCE));
    }
    public String createRandomSentence(int wordCount) {
        String out = "";
        for (int i = 0; i < wordCount; i++) {
            out += createRandomWord(getRandomOfRange(MIN_WORD_LENGTH,MAX_WORD_LENGTH));
            if (i + 1 != wordCount) out += " ";
        }
        return out + ". ";
    }

    public String createRandomWord() {
        return createRandomWord(getRandomOfRange(MIN_WORD_LENGTH,MAX_WORD_LENGTH));
    }

    public String createRandomWord(int vocalAmount) {
        String out = "";
        for (int i = 0; i < vocalAmount; i++) {
            String nextVocal = JAPANESE_ROMAJI[getRandomOfRange(0,JAPANESE_ROMAJI.length - 1)];
            if (nextVocal.equals("[double]") && i + 1 >= vocalAmount) continue; //prevents that last char of word is a small tsu which refers to next character
            out += nextVocal;
        }
        return out;
    }

    private int getRandomOfRange(int lb, int ub)  {//lower-, upper- bound
        Random r = new Random();
        return lb + r.nextInt(ub+1);
    } 
} 
