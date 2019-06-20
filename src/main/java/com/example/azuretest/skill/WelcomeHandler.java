package com.example.azuretest.skill;

import com.amazon.speech.speechlet.SpeechletResponse;
import com.example.azuretest.helper.AskResponseHelper;

public class WelcomeHandler {

    public static SpeechletResponse getWelcomeResponse() {
        String speechOutput = "Hi, welcome to the My Favourite Chess Player Alexa Skill";
        String repromptText = "You want to ask something?";

        return AskResponseHelper.newAskResponse(speechOutput, false, repromptText, false);
    }
}
