import java.awt.*;

public class Main {
    public static void main(String[] args) {
        awtTest();
    }

    private static void awtTest() {
        Frame frame = new Frame("Login");
        frame.setSize(300, 200);
        frame.setLayout(null);

        Button button = new Button("check");
        button.setSize(100, 30);
        button.setLocation(100, 50);

        Panel panel = new Panel();


        frame.add(panel);
        frame.add(button);
        frame.setVisible(true);

    }
}
