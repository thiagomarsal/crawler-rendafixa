package br.com.clubedoporquinho.service;

import br.com.clubedoporquinho.crawler.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebScraping {

    private static final Logger log = LoggerFactory.getLogger(WebScraping.class);

    @Autowired
    private TesouroNacional tesouroNacional;

    @Autowired
    private CDB cdb;

    @Autowired
    private CRA cra;

    @Autowired
    private CRI cri;

    @Autowired
    private Debendure debendure;

    @Autowired
    private DPGE dpge;

    @Autowired
    private FIDC fidc;

    @Autowired
    private LC lc;

    @Autowired
    private LCA lca;

    @Autowired
    private LCI lci;

    @Autowired
    private LF lf;

    @Autowired
    private RDB rdb;

    public void start() {
//        cdb.process();
//        cra.process();
//        cri.process();
//        debendure.process();
//        dpge.process();
//        fidc.process();
//        lc.process();
//        lca.process();
//        lci.process();
//        lf.process();
//        rdb.process();
        tesouroNacional.process();
    }
}
