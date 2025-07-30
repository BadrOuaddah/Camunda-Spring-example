package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.connect.Connectors;
import org.camunda.connect.httpclient.HttpConnector;
import org.camunda.connect.httpclient.HttpRequest;
import org.camunda.connect.httpclient.HttpResponse;

import java.util.logging.Logger;

public class ValidateDelegate implements JavaDelegate {

    private final Logger LOGGER = Logger.getLogger(ValidateDelegate.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        HttpConnector http = Connectors.getConnector(HttpConnector.ID);
        HttpRequest request = http.createRequest();
        request.get().url("https://jsonplaceholder.typicode.com/posts").header("Accept","application/json");
        HttpResponse response = request.execute();
        LOGGER.info("POST Method is >>> "+ response.getResponse());

    }

}
