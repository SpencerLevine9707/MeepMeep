

//import com.noahbres.meepmeep.roadrunner;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;


//import com.noahbres.meepmeep.core.entity.*

//import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity

public class rightSideCycleHighJunction {
    public static double servoOffset = 0;

    //public static double armServoResetPos = 0.15 + servoOffset;

    public static double armServoPlacePos1 = 0.31 + servoOffset;

    public static double armServoPlacePos2 = 1;

    //public static double armServoOverPos = 0.96 + servoOffset;

    public static double armUpPos = 0.67 + servoOffset;

    public static double armBeforePlace = 0.8 + servoOffset;

    /*public static double armServoPlacePos2Cone2 = 0.25 + servoOffset;

    public static double armServoPlacePos2Cone3 = 0.22 + servoOffset;

    public static double armServoPlacePos2Cone4 = 0.21 + servoOffset;

    public static double armServoPlacePos2Cone5 = 0.195 + servoOffset;

    public static double armServoPlacePos2Cone6 = 0.165 + servoOffset;*/

    public static double offsetXCones = 0;

    public static double offsetYCones = 0;

    public static double offsetXPlace = 0;

//    public static double distanceBeforeColor = 18.4;

    public static double offsetYPlace = 0;

    public static double holdSpeed = -0.15;

    public static double grabberClosed1 = 0.6;//change
    public static double grabberOpen1 = 0.4;


    public static double rotatorPosition = 0.22;
    public static double rotatorDist1 = 0.88;

    public static double xDisplacePark2 = 0;

    public static double yDisplacePark2 = 0;


//    int color = 0;

    public static int armMotPos = 0;
    public static int hover = 140;
    public static int h1 = 900;
    public static int h2 = 1150;
    public static int h3 = 2000;

    //public static double signalDisplaceY = 0;

    public static double xDisplaceColor = 0;

    public static double yDisplaceColor = 0;

    public static double xDisplaceCones = -0.5;

    public static double yDisplaceCones = -0.5;

    public static double xDisplaceStart = 0;

    public static double yDisplaceStart = 0;

    public static double xDisplacePlace = .25;

    public static double yDisplacePlace = -.75;

    public static double xDisplacePlace2 = 0;

    public static double yDisplacePlace2 = 0;

    public static int sleepTimeArmDown = 250;

    public static int sleepTimeGrabberOpen = 125;

    public static int sleepTimeGrabberClose = 125;

    public static int sleepTimeColorSensor = 25;

    public static double spencerLikesKidsPosUp = 0.4;
    public static double spencerLikesKidsPosDown = 0.9;


    public static int ch2 = 480;
    public static int ch3 = 360;
    public static int ch4 = 240;
    public static int ch5 = 120;
    public static int ch6 = 0;




    public static double conesTan = Math.toRadians(180);

    public static double conesTan2 = 0;

    public static double placeTan = Math.toRadians(-30);
    public static double distanceBeforeColor = 18.4;



    public static void main(String args[]){

        Pose2d startingPosition = new Pose2d(-36, 63.6, Math.toRadians(90));

        Pose2d CONES = new Pose2d(-59.7  + xDisplaceCones, 12.25 + yDisplaceCones, Math.toRadians(180));
        /*Pose2d CONES2 = new Pose2d(59.7+(offsetXCones*1) + xDisplaceCones, 12.25+ (offsetYCones*1)+ yDisplaceCones, Math.toRadians(0));
        Pose2d CONES3 = new Pose2d(59.7+(offsetXCones*2)+ xDisplaceCones, 12.25 + (offsetYCones*2)+ yDisplaceCones, Math.toRadians(0));
        Pose2d CONES4 = new Pose2d(59.7+(offsetXCones*3)+ xDisplaceCones, 12.25 + (offsetYCones*3)+ yDisplaceCones, Math.toRadians(0));
        Pose2d CONES5 = new Pose2d(59.7+(offsetXCones*4)+ xDisplaceCones, 12.25 + (offsetYCones*4)+ yDisplaceCones, Math.toRadians(0));*/
//was 61.2 was 13
        Pose2d park1 = new Pose2d(-62 + (offsetXCones*4), 11.75 + (offsetYCones*4), Math.toRadians(180));
        Pose2d park2 = new Pose2d(-38 + xDisplacePark2 + (offsetXCones*4), 11.75 + yDisplacePark2 + (offsetYCones*4), Math.toRadians(180));
        Pose2d park3 = new Pose2d(-14 + (offsetXCones*4), 11.75 + (offsetYCones*4), Math.toRadians(180));

        Pose2d colorPosition = new Pose2d(-36.5, 46, Math.toRadians(90));

        Pose2d pushSignalConeAcross = new Pose2d(-36 + xDisplaceColor, 3.75+ yDisplaceColor, Math.toRadians(90));//11.75 works

        Pose2d lineUpCone1 = new Pose2d(-36, 12.5, Math.toRadians(90));

        Pose2d placePosCone1 = new Pose2d(-34 + xDisplacePlace, 6.9 + yDisplacePlace, Math.toRadians(150));
        /*Pose2d placePosCone2 = new Pose2d(34+(offsetXPlace*1)+ xDisplacePlace2, 6.9 +(offsetYPlace*1)+ yDisplacePlace2, Math.toRadians(45));
        Pose2d placePosCone3 = new Pose2d(34+(offsetXPlace*2)+ xDisplacePlace2, 6.9 +(offsetYPlace*2)+ yDisplacePlace2, Math.toRadians(45));
        Pose2d placePosCone4 = new Pose2d(34+(offsetXPlace*3)+ xDisplacePlace2, 6.9 +(offsetYPlace*3)+ yDisplacePlace2, Math.toRadians(45));
        Pose2d placePosCone5 = new Pose2d(34+(offsetXPlace*4)+ xDisplacePlace2, 6.9 +(offsetYPlace*4)+ yDisplacePlace2, Math.toRadians(45));
        Pose2d placePosCone6 = new Pose2d(34+(offsetXPlace*5)+ xDisplacePlace2, 6.9 +(offsetYPlace*5)+ yDisplacePlace2, Math.toRadians(45));*/
//was 34 and 6.9

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
                                //.setTangent(Math.toRadians(120))
                                .splineToLinearHeading(CONES, conesTan)
                                //.splineToSplineHeading(afterPlacingAllCone, Math.toRadians(afterTan))
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(true)
                                .splineToLinearHeading(placePosCone1, placeTan)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })
                                .setReversed(false)
                                .splineToLinearHeading(CONES, conesTan)

                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(true)
                                .splineToLinearHeading(placePosCone1, placeTan)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })
                                .setReversed(false)
                                .splineToLinearHeading(CONES, conesTan)

                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(true)
                                .splineToLinearHeading(placePosCone1, placeTan)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })
                                .setReversed(false)
                                .splineToLinearHeading(CONES, conesTan)

                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(true)
                                .splineToLinearHeading(placePosCone1, placeTan)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })
                                .setReversed(false)
                                .splineToLinearHeading(CONES, conesTan)

                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(true)
                                .splineToLinearHeading(placePosCone1, placeTan)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })
                                .setReversed(false)

                                .lineToLinearHeading(park2)
                                .lineToLinearHeading(park3)





                                .build()
                );

        RoadRunnerBotEntity arm = new DefaultBotBuilder(meepMeep, 10, 24)

                .setColorScheme(new ColorSchemeBlueDark())
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
                                .splineToLinearHeading(CONES, conesTan)
                                //.splineToSplineHeading(afterPlacingAllCone, Math.toRadians(afterTan))
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(true)
                                .splineToLinearHeading(placePosCone1, placeTan)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })
                                .setReversed(false)
                                .splineToLinearHeading(CONES, conesTan)

                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(true)
                                .splineToLinearHeading(placePosCone1, placeTan)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })
                                .setReversed(false)
                                .splineToLinearHeading(CONES, conesTan)

                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(true)
                                .splineToLinearHeading(placePosCone1, placeTan)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })
                                .setReversed(false)
                                .splineToLinearHeading(CONES, conesTan)

                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(true)
                                .splineToLinearHeading(placePosCone1, placeTan)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })
                                .setReversed(false)
                                .splineToLinearHeading(CONES, conesTan)

                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })

                                .setReversed(true)
                                .splineToLinearHeading(placePosCone1, placeTan)
                                .addDisplacementMarker(() -> {
                                    // Run your action in here!
                                    // Drop servo, start motor, whatever
                                })
                                .setReversed(false)

                                .lineToLinearHeading(park2)
                                .lineToLinearHeading(park3)





                                .build()
                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)

                .addEntity(myBot)
                //.addEntity(arm)

                .start();
    }


}

