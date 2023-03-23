

//import com.noahbres.meepmeep.roadrunner;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;


//import com.noahbres.meepmeep.core.entity.*

//import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity

public class FreightFrenzyAuton {

    public static double offsetXFreight = 1;

    public static double offsetYFreight = 0;

    public static double offsetXPlace = 0;

    public static double offsetYPlace = 0;

    public static double holdSpeed = -0.15;

    public static double grabberClosed1 = 0.6;//change
    public static double grabberOpen1 = 0.4;


    public static double rotatorPosition = 0.22;
    public static double rotatorDist1 = 0.88;

    public static int armMotPos = 0;
    public static int hover = 140;
    public static int h1 = 900;
    public static int h2 = 1225;
    public static int h2Preload = 1450;
    public static int h3 = 2000;

    public static double signalDisplaceY = 0;

    public static double xDisplaceColor = 0;

    public static double yDisplaceColor = 0;

    public static double xDisplaceFreight = -8;

    public static double yDisplaceFreight = -4.5;

    public static double xDisplaceStart = 0;

    public static double yDisplaceStart = 0;

    public static double xDisplacePlace = 0;

    public static double yDisplacePlace = -8;
    public static double xDisplacePlace2 = 0;
    public static double yDisplacePlace2 = 0;

    public static int sleepTimeArmDown = 250;

    public static int sleepTimeGrabberOpen = 125;

    public static int sleepTimeGrabberClose = 125;

    public static int sleepTimeColorSensor = 25;

    public static double xDisplacePark2 = 0;

    public static double yDisplacePark2 = 0;

    public static double distanceBeforeColor = 18.4;

    public static int ch2 = 480;
    public static int ch3 = 360;
    public static int ch4 = 240;
    public static int ch5 = 120;
    public static int ch6 = 0;

    public static double placeTan = Math.toRadians(90);

    public static double lineUpTan = Math.toRadians(-90);

    public static double freightTan = Math.toRadians(0);


    public static void main(String args[]){

        Pose2d startingPosition = new Pose2d(11.5 + xDisplaceStart, -62.5 + yDisplaceStart, Math.toRadians(-90));

        Pose2d lineUpFreight = new Pose2d(10, -59 + yDisplaceFreight, Math.toRadians(0));

        Pose2d FREIGHT1 = new Pose2d(47 + xDisplaceFreight + offsetXFreight*1, -59 + yDisplaceFreight + offsetYFreight*1, Math.toRadians(0));
        Pose2d FREIGHT2 = new Pose2d(47 + xDisplaceFreight + offsetXFreight*2, -59 + yDisplaceFreight + offsetYFreight*2, Math.toRadians(0));
        Pose2d FREIGHT3 = new Pose2d(47 + xDisplaceFreight + offsetXFreight*3, -59 + yDisplaceFreight + offsetYFreight*3, Math.toRadians(0));
        Pose2d FREIGHT4 = new Pose2d(47 + xDisplaceFreight + offsetXFreight*4, -59 + yDisplaceFreight + offsetYFreight*4, Math.toRadians(0));
        Pose2d FREIGHT5 = new Pose2d(47 + xDisplaceFreight + offsetXFreight*5, -59 + yDisplaceFreight + offsetYFreight*5, Math.toRadians(0));

        Pose2d placePosFreight1 = new Pose2d(-11.5 + xDisplacePlace, -34 + yDisplacePlace, Math.toRadians(-90));

        MeepMeep meepMeep = new MeepMeep(700, false);



        //14, 16.6
        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep, 12, 16)

                .setColorScheme(new ColorSchemeRedDark())
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(55, 60, Math.toRadians(155), Math.toRadians(180), 14.2)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(startingPosition)

                                .lineToLinearHeading(placePosFreight1)
                                .addDisplacementMarker(() -> {})
                                .waitSeconds(0.25)

                                .splineToSplineHeading(lineUpFreight, freightTan)
                                .lineToSplineHeading(FREIGHT1)
                                .setReversed(true)
                                .addDisplacementMarker(() -> {})

                                .waitSeconds(0.25)
                                .lineToSplineHeading(lineUpFreight)
                                .splineToSplineHeading(placePosFreight1, placeTan)
                                .setReversed(false)
                                .addDisplacementMarker(() -> {})
                                .waitSeconds(0.25)

                                .splineToSplineHeading(lineUpFreight, freightTan)
                                .lineToSplineHeading(FREIGHT2)
                                .setReversed(true)
                                .addDisplacementMarker(() -> {})

                                .waitSeconds(0.25)
                                .lineToSplineHeading(lineUpFreight)
                                .splineToSplineHeading(placePosFreight1, placeTan)
                                .setReversed(false)
                                .addDisplacementMarker(() -> {})
                                .waitSeconds(0.25)

                                .splineToSplineHeading(lineUpFreight, freightTan)
                                .lineToSplineHeading(FREIGHT3)
                                .setReversed(true)
                                .addDisplacementMarker(() -> {})

                                .waitSeconds(0.25)
                                .lineToSplineHeading(lineUpFreight)
                                .splineToSplineHeading(placePosFreight1, placeTan)
                                .setReversed(false)
                                .addDisplacementMarker(() -> {})
                                .waitSeconds(0.25)

                                .splineToSplineHeading(lineUpFreight, freightTan)
                                .lineToSplineHeading(FREIGHT4)
                                .setReversed(true)
                                .addDisplacementMarker(() -> {})

                                .waitSeconds(0.25)
                                .lineToSplineHeading(lineUpFreight)
                                .splineToSplineHeading(placePosFreight1, placeTan)
                                .setReversed(false)
                                .addDisplacementMarker(() -> {})
                                .waitSeconds(0.25)

                                .splineToSplineHeading(lineUpFreight, freightTan)
                                .lineToSplineHeading(FREIGHT5)
                                .setReversed(true)
                                .addDisplacementMarker(() -> {})

                                .waitSeconds(0.25)
                                .lineToSplineHeading(lineUpFreight)
                                .splineToSplineHeading(placePosFreight1, placeTan)
                                .setReversed(false)
                                .addDisplacementMarker(() -> {})
                                .waitSeconds(0.25)

                                .splineToSplineHeading(lineUpFreight, freightTan)
                                .lineToSplineHeading(FREIGHT5)
                                .setReversed(true)
                                .addDisplacementMarker(() -> {})





                                .build()
                );

//        RoadRunnerBotEntity arm = new DefaultBotBuilder(meepMeep, 10, 25)
//
//                .setColorScheme(new ColorSchemeBlueDark())
//                .setConstraints(55, 60, Math.toRadians(155), Math.toRadians(180), 14.2)
//                .followTrajectorySequence(drive ->
//                        drive.trajectorySequenceBuilder(startingPosition)
//                                .build()
//                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_FREIGHTFRENZY_ADI_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)

                .addEntity(myBot)
                //.addEntity(arm)

                .start();
    }


}

