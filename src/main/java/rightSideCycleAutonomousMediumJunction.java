

//import com.noahbres.meepmeep.roadrunner;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;


//import com.noahbres.meepmeep.core.entity.*

//import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity

public class rightSideCycleAutonomousMediumJunction {
    public static double servoOffset = 0;

    public static double armServoResetPos = 0.15 + servoOffset;

    public static double armServoPlacePos1 = 0.31 + servoOffset;

    public static double armServoPlacePos2 = 1;

    public static double armServoOverPos = 0.96 + servoOffset;

    public static double armUpPos = 0.67 + servoOffset;

    public static double armBeforePlace = 0.7 + servoOffset;

    public static double armServoPlacePos2Cone2 = 0.25 + servoOffset;

    public static double armServoPlacePos2Cone3 = 0.22 + servoOffset;

    public static double armServoPlacePos2Cone4 = 0.21 + servoOffset;

    public static double armServoPlacePos2Cone5 = 0.195 + servoOffset;

    public static double armServoPlacePos2Cone6 = 0.165 + servoOffset;

    public static double armServoPlaceBeforePlace = 0.85 + servoOffset;
    public static double armServoPlaceBeforePlace2 = 0.45 + servoOffset;

    public static double offsetXCones = 0.3;

    public static double offsetYCones = 0;

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

    public static double xDisplaceCones = -0.25;

    public static double yDisplaceCones = 0.5;

    public static double xDisplaceStart = 0;

    public static double yDisplaceStart = 0;

    public static double xDisplacePlace = -1;

    public static double yDisplacePlace = 0;
    public static double xDisplacePlace2 = -3.5;
    public static double yDisplacePlace2 = 0;

    public static int sleepTimeArmDown = 250;

    public static int sleepTimeGrabberOpen = 125;

    public static int sleepTimeGrabberClose = 125;

    public static int sleepTimeColorSensor = 25;

    public static double xDisplacePark2 = 0;

    public static double yDisplacePark2 = 0;



    public static double distanceBeforeColor = 18.4;

    int color = 0;

    public static int ch2 = 480;
    public static int ch3 = 360;
    public static int ch4 = 240;
    public static int ch5 = 120;
    public static int ch6 = 0;

    public static double placeTan = Math.toRadians(25);

    public static double conesTan = Math.toRadians(180);


    public static void main(String args[]){

        Pose2d startingPosition = new Pose2d(-36, 63.6, Math.toRadians(90));

        Pose2d CONES = new Pose2d(-61.2 + xDisplaceCones, 11.75+ yDisplaceCones, Math.toRadians(180));
        Pose2d CONES2 = new Pose2d(-61.2+(offsetXCones*1) + xDisplaceCones, 11.75 + (offsetYCones*1)+ yDisplaceCones, Math.toRadians(180));
        Pose2d CONES3 = new Pose2d(-61.2+(offsetXCones*2)+ xDisplaceCones, 11.75 + (offsetYCones*2)+ yDisplaceCones, Math.toRadians(180));
        Pose2d CONES4 = new Pose2d(-61.2+(offsetXCones*3)+ xDisplaceCones, 11.75 + (offsetYCones*3)+ yDisplaceCones, Math.toRadians(180));
        Pose2d CONES5 = new Pose2d(-61.2+(offsetXCones*4)+ xDisplaceCones, 11.75 + (offsetYCones*4)+ yDisplaceCones, Math.toRadians(180));

        Pose2d park1 = new Pose2d(-62 + (offsetXCones*4), 11.75 + (offsetYCones*4), Math.toRadians(180));
        Pose2d park2 = new Pose2d(-38 + xDisplacePark2 + (offsetXCones*4), 11.75 + yDisplacePark2 + (offsetYCones*4), Math.toRadians(180));
        Pose2d park3 = new Pose2d(-14 + (offsetXCones*4), 11.75 + (offsetYCones*4), Math.toRadians(180));

        Pose2d colorPosition = new Pose2d(-36.5, 46, Math.toRadians(90));

        Pose2d pushSignalConeAcross = new Pose2d(-36 + xDisplaceColor, 11.75 + yDisplaceColor, Math.toRadians(90));//11.75 works

        Pose2d lineUpCone1 = new Pose2d(-36, 12.5, Math.toRadians(90));

        Pose2d placePosCone1 = new Pose2d(-31 + xDisplacePlace, 15 + yDisplacePlace, Math.toRadians(45));
        Pose2d placePosCone2 = new Pose2d(-31+(offsetXPlace*1)+ xDisplacePlace2, 15 +(offsetYPlace*1)+ yDisplacePlace2, Math.toRadians(-135));
        Pose2d placePosCone3 = new Pose2d(-31+(offsetXPlace*2)+ xDisplacePlace2, 15 +(offsetYPlace*2)+ yDisplacePlace2, Math.toRadians(-135));
        Pose2d placePosCone4 = new Pose2d(-31+(offsetXPlace*3)+ xDisplacePlace2, 15 +(offsetYPlace*3)+ yDisplacePlace2, Math.toRadians(-135));
        Pose2d placePosCone5 = new Pose2d(-31+(offsetXPlace*4)+ xDisplacePlace2, 15 +(offsetYPlace*4)+ yDisplacePlace2, Math.toRadians(-135));
        Pose2d placePosCone6 = new Pose2d(-31+(offsetXPlace*5)+ xDisplacePlace2, 15 +(offsetYPlace*5)+ yDisplacePlace2, Math.toRadians(-135));

        MeepMeep meepMeep = new MeepMeep(700, false);



        //14, 16.6
        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep, 14, 16)

                .setColorScheme(new ColorSchemeRedDark())
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(55, 60, Math.toRadians(155), Math.toRadians(180), 14.2)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(startingPosition)
                                //.lineToLinearHeading(new Pose2d(23.5, (53+a), Math.toRadians(-90)))
                                //go up cone
                                .lineToLinearHeading(pushSignalConeAcross)
                                .lineToLinearHeading(lineUpCone1)
                                .lineToLinearHeading(placePosCone1)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })
                                .turn(Math.toRadians(135))
                                .splineToLinearHeading(CONES, conesTan)
                                //.splineToSplineHeading(afterPlacingAllCone, Math.toRadians(afterTan))
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(true)
                                .splineToLinearHeading(placePosCone2, placeTan)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })
                                .setReversed(false)
                                .lineToLinearHeading(CONES)

                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(true)
                                .splineToLinearHeading(placePosCone2, placeTan)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })
                                .setReversed(false)
                                .lineToLinearHeading(CONES)

                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(true)
                                .splineToLinearHeading(placePosCone2, placeTan)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(false)
                                .lineToLinearHeading(CONES)

                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(true)
                                .splineToLinearHeading(placePosCone2, placeTan)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(false)
                                .lineToLinearHeading(CONES)

                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(true)
                                .splineToLinearHeading(placePosCone2, placeTan)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(false)
                                .lineToLinearHeading(CONES)

                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(true)
                                .splineToLinearHeading(placePosCone2, placeTan)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .lineToLinearHeading(park2)
                                .lineToLinearHeading(park3)





                                .build()
                );

        RoadRunnerBotEntity arm = new DefaultBotBuilder(meepMeep, 10, 24)

                .setColorScheme(new ColorSchemeBlueDark())
                .setConstraints(55, 60, Math.toRadians(155), Math.toRadians(180), 14.2)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(startingPosition)
                                //.lineToLinearHeading(new Pose2d(23.5, (53+a), Math.toRadians(-90)))
                                //go up cone
                                .lineToLinearHeading(pushSignalConeAcross)
                                .lineToLinearHeading(lineUpCone1)
                                .lineToLinearHeading(placePosCone1)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })
                                .turn(Math.toRadians(135))
                                .splineToLinearHeading(CONES, conesTan)
                                //.splineToSplineHeading(afterPlacingAllCone, Math.toRadians(afterTan))
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(true)
                                .splineToLinearHeading(placePosCone2, placeTan)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })
                                .setReversed(false)
                                .lineToLinearHeading(CONES)

                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(true)
                                .splineToLinearHeading(placePosCone2, placeTan)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })
                                .setReversed(false)
                                .lineToLinearHeading(CONES)

                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(true)
                                .splineToLinearHeading(placePosCone2, placeTan)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(false)
                                .lineToLinearHeading(CONES)

                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(true)
                                .splineToLinearHeading(placePosCone2, placeTan)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(false)
                                .lineToLinearHeading(CONES)

                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(true)
                                .splineToLinearHeading(placePosCone2, placeTan)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(false)
                                .lineToLinearHeading(CONES)

                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(true)
                                .splineToLinearHeading(placePosCone2, placeTan)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .lineToLinearHeading(park2)
                                .lineToLinearHeading(park3)





                                .build()
                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)

                .addEntity(myBot)
                .addEntity(arm)

                .start();
    }


}

