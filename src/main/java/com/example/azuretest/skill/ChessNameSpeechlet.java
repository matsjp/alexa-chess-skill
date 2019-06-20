package com.example.azuretest.skill;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.*;
import org.springframework.stereotype.Service;

@Service
public class ChessNameSpeechlet implements Speechlet {
    @Override
    public void onSessionStarted(SessionStartedRequest request, Session session) throws SpeechletException {
    }

    @Override
    public SpeechletResponse onLaunch(LaunchRequest request, Session session) throws SpeechletException {
        return WelcomeHandler.getWelcomeResponse();
    }

    @Override
    public SpeechletResponse onIntent(IntentRequest request, Session session) throws SpeechletException {

        Intent intent = request.getIntent();
        if (intent == null)
            throw new SpeechletException("Unrecognized intent");

        String intentName = intent.getName();

        if ("playerBio".equals(intentName)) {
            PlayerBioHandler dodi = new PlayerBioHandler(intent, session);
            return dodi.handleIntent();
        } else if ("AMAZON.HelpIntent".equals(intentName)) {
            HelpIntentHandler hi = new HelpIntentHandler(intent, session);
            return hi.handleIntent();
        } else if ("AMAZON.StopIntent".equals(intentName)) {
            StopIntentHandler si = new StopIntentHandler(intent, session);
            return si.handleIntent();
        } else if ("AMAZON.CancelIntent".equals(intentName)) {
            CancelIntentHandler ci = new CancelIntentHandler(intent, session);
            return ci.handleIntent();
        } else {
            throw new SpeechletException("Unknown intent...");
        }
    }

    @Override
    public void onSessionEnded(SessionEndedRequest request, Session session) throws SpeechletException {

    }
}
