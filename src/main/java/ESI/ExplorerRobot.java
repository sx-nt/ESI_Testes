package ESI;


public class ExplorerRobot {
    private final int DEFAULT_ROTATION = 45;
    private String name;
    private double x, y;
    private int direction;
    private double battery;

    public ExplorerRobot(String name, double x, double y, int direction, double battery) {
        setName(name);
        setX(x);
        setY(y);
        setDirection(direction);
        setBattery(battery);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setDirection(int direction) {
        if (direction < 0 || direction >= 360) {
            direction = 0;
        }
        this.direction = direction;
    }

    public void setBattery(double battery) {
        if (battery < 0 || battery > 30) {
            battery = 10;
        }
        this.battery = battery;
    }
    public boolean useBattery(double used) {
        if (battery >= used) {
            setBattery(battery - used);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public double getBattery() {
        return battery;
    }

    public String getPosition() {
        return String.format("(%f,%f)", x, y);
    }

    public int rotate(int angle) {
        if (useBattery(1)) {
            int g = (getDirection() + angle) % 360;
            if (g < 0) g = 360 + g;
            setDirection(g);
        }

        return getDirection();
    }

    public int rotateLeft() {
        return rotate(-DEFAULT_ROTATION);
    }

    public int rotateRight() {
        return rotate(DEFAULT_ROTATION);
    }

    public boolean move(double distance) {
        if (useBattery(distance)) {
            double distanceX = distance * Math.cos(Math.toRadians(getDirection()));
            double distanceY = distance * Math.sin(Math.toRadians(getDirection()));
            setX(getX() + distanceX);
            setY(getY() + distanceY);
            return true;
        }
        return false;
    }
}
