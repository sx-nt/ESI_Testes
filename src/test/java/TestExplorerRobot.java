import ESI.ExplorerRobot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TestExplorerRobot {
    private ExplorerRobot robot;
    private final double TOLERANCE = 0.000000000;

    @BeforeEach
    public void setUp(){
        robot = new ExplorerRobot("Vrde", 0.0, 0.0, 0, 10);
    }

    @Test
    void setName(){
        assertEquals("Joao", robot.getName());
        robot.setName("Jose");
        assertEquals("Jose", robot.getName());
    }

    @Test
    void setX(){

        //delta define uma constante para tolerância --> Comparação de float
        assertEquals(0, robot.getX(), TOLERANCE);
        robot.setX(10);
        assertEquals(10, robot.getX(), TOLERANCE);
    }
}
