

//import com.noahbres.meepmeep.roadrunner;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;
import javax.swing.*;
import java.awt.event.*;



//import com.noahbres.meepmeep.core.entity.*

//import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity

public class wStrat {
    public static double servoOffset = 0;

    public static double armServoResetPos = 0.15 + servoOffset;

    public static double armServoPlacePos1 = 0.31 + servoOffset;

    public static double armServoPlacePos2 = 1;

    public static double armServoOverPos = 0.96 + servoOffset;

    public static double armUpPos = 0.67 + servoOffset;

    public static double armBeforePlace = 0.8 + servoOffset;

    public static double armServoPlacePos2Cone2 = 0.25 + servoOffset;

    public static double armServoPlacePos2Cone3 = 0.22 + servoOffset;

    public static double armServoPlacePos2Cone4 = 0.21 + servoOffset;

    public static double armServoPlacePos2Cone5 = 0.195 + servoOffset;

    public static double armServoPlacePos2Cone6 = 0.165 + servoOffset;

    public static double offsetXCones = 4.9;

    public static double offsetYCones = 0.25;

    public static double offsetXPlace = 4.7;

    public static double distanceBeforeColor = 18.4;

    public static double offsetYPlace = 1.5;

    public static double holdSpeed = -0.15;

    public static double grabberClosed1 = 0.6;//change
    public static double grabberOpen1 = 0.4;


    public static double rotatorPosition = 0.91;
    public static double rotatorDist1 = 0.25;

    public static double xDisplacePark2 = 0;

    public static double yDisplacePark2 = 0;


    int color = 0;

    public static int armMotPos = 0;
    public static int hover = 140;
    public static int h1 = 900;
    public static int h2 = 1900;
    public static int h3 = 2000;

    public static double signalDisplaceY = 0;

    public static double xDisplaceColor = 0;

    public static double yDisplaceColor = 0;

    public static double xDisplaceCones = 0;

    public static double yDisplaceCones = 0.25;

    public static double xDisplaceStart = 0;

    public static double yDisplaceStart = 0;

    public static double xDisplacePlace = -1;

    public static double yDisplacePlace = -1;

    public static double xDisplaceLineUpStrat = 0;

    public static double yDisplaceLineUpStrat = 0;

    public static double xDisplaceRunThatShit = 0;

    public static double yDisplaceRunThatShit = 0;

    public static int sleepTimeArmDown = 250;

    public static int sleepTimeArmDownGround = 500;

    public static int sleepTimeGrabberOpen = 125;

    public static int sleepTimeGrabberClose = 125;

    public static int sleepTimeColorSensor = 25;


    public static int ch2 = 480;
    public static int ch3 = 360;
    public static int ch4 = 240;
    public static int ch5 = 120;
    public static int ch6 = 0;




    public static double conesTan = 0;

    public static double placeTan = -2.53;

    public static int numConesPlace = 0;


    public static void main(String args[]){

        MeepMeep meepMeep = new MeepMeep(700, false);

        Pose2d startingPosition = new Pose2d(36, 63.6, Math.toRadians(90));

        Pose2d CONES = new Pose2d(61.2 + xDisplaceCones, 11.75+ yDisplaceCones, Math.toRadians(0));
        Pose2d CONES2 = new Pose2d(61.2+(offsetXCones*0) + xDisplaceCones, 11.75 + (offsetYCones*0)+ yDisplaceCones, Math.toRadians(0));
        Pose2d CONES3 = new Pose2d(61.2+(offsetXCones*1)+ xDisplaceCones, 11.75 + (offsetYCones*1)+ yDisplaceCones, Math.toRadians(0));
        Pose2d CONES4 = new Pose2d(61.2+(offsetXCones*2)+ xDisplaceCones, 11.75 + (offsetYCones*2)+ yDisplaceCones, Math.toRadians(0));
        Pose2d CONES5 = new Pose2d(61.2+(offsetXCones*3)+ xDisplaceCones, 11.75 + (offsetYCones*3)+ yDisplaceCones, Math.toRadians(0));

        Pose2d park1 = new Pose2d(62 + (offsetXCones*numConesPlace), 11.75 + (offsetYCones*numConesPlace), Math.toRadians(0));
        Pose2d park2 = new Pose2d(38 + xDisplacePark2 + (offsetXCones*numConesPlace), 11.75 + yDisplacePark2 + (offsetYCones*numConesPlace), Math.toRadians(0));
        Pose2d park3 = new Pose2d(14 + (offsetXCones*numConesPlace), 11.75 + (offsetYCones*numConesPlace), Math.toRadians(0));

        Pose2d colorPosition = new Pose2d(36.5, 46, Math.toRadians(90));

        Pose2d lineUpCones2and3and4 = new Pose2d(36, 11.75, Math.toRadians(45));

        Pose2d afterPlacingAllCones = new Pose2d(36, 11.75, Math.toRadians(45));

        Pose2d pushSignalConeAcross = new Pose2d(36, 11.75, Math.toRadians(90));

        Pose2d lineUpStrat = new Pose2d(13 + xDisplaceLineUpStrat, 11.75 + yDisplaceLineUpStrat, Math.toRadians(180));

        Pose2d lineUpStrat2 = new Pose2d(15, -35, Math.toRadians(-90));

        Pose2d runThatShit = new Pose2d(13 + xDisplaceRunThatShit, -47 + yDisplaceRunThatShit, Math.toRadians(180));

        Pose2d lineUpCone1 = new Pose2d(36, 12.5, Math.toRadians(90));

        Pose2d placePosCone1 = new Pose2d(34 + xDisplacePlace, 6.9, Math.toRadians(45));
        Pose2d placePosCone2 = new Pose2d(34+(offsetXPlace*0)+ xDisplacePlace, 6.9 +(offsetYPlace*0)+ yDisplacePlace, Math.toRadians(45));
        Pose2d placePosCone3 = new Pose2d(34+(offsetXPlace*1)+ xDisplacePlace, 6.9 +(offsetYPlace*1)+ yDisplacePlace, Math.toRadians(45));
        Pose2d placePosCone4 = new Pose2d(34+(offsetXPlace*2)+ xDisplacePlace, 6.9 +(offsetYPlace*2)+ yDisplacePlace, Math.toRadians(45));
        Pose2d placePosCone5 = new Pose2d(34+(offsetXPlace*3)+ xDisplacePlace, 6.9 +(offsetYPlace*3)+ yDisplacePlace, Math.toRadians(45));
        Pose2d placePosCone6 = new Pose2d(34+(offsetXPlace*4)+ xDisplacePlace, 6.9 +(offsetYPlace*4)+ yDisplacePlace, Math.toRadians(45));

        Pose2d afterPlacingAllCone = new Pose2d(40, 11.75, Math.toRadians(0));




        //14, 16.6
        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep, 14, 16)

                .setColorScheme(new ColorSchemeRedDark())
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 50, Math.toRadians(150), Math.toRadians(180), 18.75)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(startingPosition)
                                //.lineToLinearHeading(new Pose2d(23.5, (53+a), Math.toRadians(-90)))
                                //go up cone
                                .lineToLinearHeading(colorPosition)
                                .lineToLinearHeading(pushSignalConeAcross)
                                .lineToLinearHeading(lineUpStrat)
                                .lineToLinearHeading(runThatShit)
                                .lineToLinearHeading(lineUpStrat)
                                .turn(Math.toRadians(180))
                                .lineToLinearHeading(CONES)
                                .setReversed(true)
                                .splineToLinearHeading(placePosCone1, placeTan)
                                .setReversed(false)
                                .splineToLinearHeading(CONES, Math.toRadians(conesTan))
                                .setReversed(true)
                                .splineToLinearHeading(placePosCone1, placeTan)
                                .setReversed(false)
                                .splineToLinearHeading(CONES, Math.toRadians(conesTan))
                                .setReversed(true)
                                .splineToLinearHeading(placePosCone1, placeTan)

                                .lineToLinearHeading(park2)
                                //.lineToLinearHeading(CONES)
                                .lineToLinearHeading(park3)





                                .build()
                );

        RoadRunnerBotEntity arm = new DefaultBotBuilder(meepMeep, 10, 25)

                .setColorScheme(new ColorSchemeBlueDark())
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 50, Math.toRadians(150), Math.toRadians(180), 18.75)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(startingPosition)
                                //.lineToLinearHeading(new Pose2d(23.5, (53+a), Math.toRadians(-90)))
                                //go up cone
                                .lineToLinearHeading(colorPosition)
                                .lineToLinearHeading(pushSignalConeAcross)
                                .lineToLinearHeading(lineUpStrat)
                                .lineToLinearHeading(runThatShit)
                                .lineToLinearHeading(lineUpStrat)
                                .turn(Math.toRadians(180))
                                .lineToLinearHeading(CONES)
                                .setReversed(true)
                                .splineToLinearHeading(placePosCone1, placeTan)
                                .setReversed(false)
                                .splineToLinearHeading(CONES, Math.toRadians(conesTan))
                                .setReversed(true)
                                .splineToLinearHeading(placePosCone1, placeTan)
                                .setReversed(false)
                                .splineToLinearHeading(CONES, Math.toRadians(conesTan))
                                .setReversed(true)
                                .splineToLinearHeading(placePosCone1, placeTan)

                                .lineToLinearHeading(park2)
                                //.lineToLinearHeading(CONES)
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

