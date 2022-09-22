package com.redmuud;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.Random;

public class Main {
    public static final int SEVEN_SECONDS = 5000;
    public static final int MAX_Y = 100;
    public static final int MAX_X = 100;
    private static int hour = 18, minute = 0;


    public static void main(String[] args) throws Exception {
        validateAndAssignParams(args);
        System.out.println("scheduled hour => " + hour + ":" + minute);

        Robot robot = new Robot();
        Random random = new Random();
        while (getScheduledDatetime().isAfter(LocalDateTime.now())) {
            robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
            Thread.sleep(SEVEN_SECONDS);
        }
        System.exit(0);
    }

    private static LocalDateTime getScheduledDatetime(){
        LocalDateTime now = LocalDateTime.now();
        return LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), hour, minute);
    }

    private static void validateAndAssignParams(String[] args){
        if (args.length > 0) {
            if (args.length == 2) {
                try {
                    hour = Integer.parseInt(args[0]);
                    minute = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Please pass {hour} and {minute} as integer");
                    System.exit(0);
                }
            } else {
                System.out.println("Please pass {hour} and {minute}");
                System.exit(0);
            }
        }
    }
}
