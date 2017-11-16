package br.com.clubedoporquinho.crawler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;

public abstract class AbstractRendaFixaCroller implements Serializable {

    protected static final Logger log = LoggerFactory.getLogger(CRA.class);

    protected static final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    protected WebClient webClient;

    @Autowired
    protected RestTemplate restTemplate;

    public abstract void process();
}
