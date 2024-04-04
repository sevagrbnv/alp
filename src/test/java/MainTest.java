import org.example.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testWithPlusWithoutOtherCharacters() {
        String actual = Main.modifyPhoneNumbers("Павел +79123456789", "+1");
        String expected = "Павел +1 (912) 345-67-89";
        assertEquals(expected, actual);
    }

//    @Test
//    public void testWithoutPlusAndOtherCharacters() {
//        String actual = Main.modifyPhoneNumbers("Олег 9999999999", "+49");
//        String expected = "Олег +49 (999) 999-99-99";
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testPhoneNotFound() {
//        String actual = Main.modifyPhoneNumbers("Я пишу тесты уже 99999+ раз", "+1");
//        String expected = "Я пишу тесты уже 99999+ раз";
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testWithoutPlusWithSpaces() {
//        String actual = Main.modifyPhoneNumbers("Настя 8 800 555 35 35", "+9");
//        String expected = "Настя +9 (800) 555-35-35";
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testWithPlusAndDashes() {
//        String actual = Main.modifyPhoneNumbers("Георгий +4-800-555-35-35", "+1");
//        String expected = "Георгий +1 (800) 555-35-35";
//        assertEquals(expected, actual);
//    }
}
