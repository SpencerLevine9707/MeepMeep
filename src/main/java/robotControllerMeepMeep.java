import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;
import javax.swing.*;
import java.awt.event.*;

public class robotControllerMeepMeep implements KeyListener {
    private JFrame frame;
    private JLabel label;

    public static double changingX = 0.5;
    public static double changingY = 0.5;

    public static double changingDegrees = -90;

    public static Pose2d startingPosition = new Pose2d(0, 0, Math.toRadians(-90));

    public static Pose2d changingPosition = new Pose2d(changingX, changingY, Math.toRadians(changingDegrees));


    public static boolean started = false;

    public static boolean keyPress = false;

    public robotControllerMeepMeep() {
        /*frame = new JFrame("MeepMeepFrameTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        label = new JLabel("");
        frame.add(label);
        frame.setVisible(true);
        frame.addKeyListener(this);*/




        //14, 16.6

        MeepMeep meepMeep = new MeepMeep(700, true);
        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep, 14, 16)

                .setColorScheme(new ColorSchemeRedDark())
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 40, Math.toRadians(155), Math.toRadians(180), 18.75)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(startingPosition)
                                .lineToLinearHeading(changingPosition)
                                .build()

                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)

                .addEntity(myBot)

                .start();

        started = true;


    }

    public static void main(String[] args) {
        new robotControllerMeepMeep();
        while(started){
            if(keyPress){
                new robotControllerMeepMeep();
                keyPress = false;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            if(changingX > -70){
                changingX -= 0.5;
            }
        }
        else if (keyCode == KeyEvent.VK_RIGHT) {
            if(changingX < 70){
                changingX += 0.5;
            }
        }
        else if (keyCode == KeyEvent.VK_UP) {
            if (changingY < 70) {
                changingY += 0.5;
            }
        }
        else if (keyCode == KeyEvent.VK_DOWN) {
            if (changingY > -70) {
                changingY -= 0.5;
            }
        }
        keyPress = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //label.setText("Key released: " + e.getKeyChar());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //label.setText("Key typed: " + e.getKeyChar());
    }
}
