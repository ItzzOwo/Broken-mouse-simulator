import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.InputEvent;
import java.util.Scanner;
import java.awt.event.MouseEvent;

public class Click implements NativeMouseInputListener {

    public void nativeMouseClicked(NativeMouseEvent e) {
        // dont need
    }

    public void nativeMousePressed(NativeMouseEvent e) {
        int clicks = 0;
            if (e.getButton() == NativeMouseEvent.BUTTON1) {
                clicks++;
                Random random = new Random();
                int clickamount_1 = 1;
                int clickamount_2 = 7;
                int clickamount = random.nextInt(clickamount_2 - clickamount_1 + 1) + clickamount_1;
                if (clicks < clickamount) {
                    double randomNumber = Math.random();
                    clicks = 0;
                    if (randomNumber < 0.5) {
                        int delay = 25;
                        int delay_1 = delay - 15;
                        int sleep = random.nextInt(delay - delay_1 + 1) + delay_1;
                        Robot robot = null;
                        try {
                            robot = new Robot();
                        } catch (AWTException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {
                            Thread.sleep(sleep);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                        int release_1 = 3;
                        int release_2 = 8;
                        int release = random.nextInt(release_2 - release_1 + 1) + release_1;
                        try {
                            Thread.sleep(release);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                        clicks = 0;
                    } else {
                        clicks = 0;
                        }}}}




    public void nativeMouseReleased(NativeMouseEvent e) {
        // dont need
            }



    public void nativeMouseMoved(NativeMouseEvent e) {
        // dont need
    }

    public void nativeMouseDragged(NativeMouseEvent e) {
        // dont need
    }

    public void click() {
        // dont need

    }

    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);

        logger.setUseParentHandlers(false);

        Click clicker = new Click();

        GlobalScreen.addNativeMouseListener(clicker);

    }
}