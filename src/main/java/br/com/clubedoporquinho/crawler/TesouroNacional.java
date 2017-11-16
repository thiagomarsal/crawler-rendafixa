package br.com.clubedoporquinho.crawler;

import br.com.clubedoporquinho.entity.TituloRendaFixa;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TesouroNacional extends AbstractRendaFixaCroller {

    @Override
    public void process() {
        try {
            final HtmlPage page = webClient.getPage("http://www.tesouro.fazenda.gov.br/tesouro-direto-precos-e-taxas-dos-titulos");
            processByXPath(page, "//tr[@class='camposTesouroDireto']");
            processByXPath(page, "//tr[@class='camposTesouroDireto ']");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    private void processByXPath(HtmlPage page, String xpath) {
        final List<HtmlTableRow> trs = page.getByXPath(xpath);

        if (CollectionUtils.isEmpty(trs)) {
            log.error("Erro ao executar consulta. {}", trs);
            return;
        }

        log.debug("Processando {} titulos do Tesouro Direto", trs.size());

        trs.forEach(row -> {
            final TituloRendaFixa titulo = new TituloRendaFixa();
            titulo.setNome(row.getCells().get(0).asText());
            titulo.setVendimento(row.getCells().get(1).asText());
            titulo.setTaxa(row.getCells().get(2).asText());
            titulo.setTipo("Tesouro Direto");

            if (row.getCells().size() > 4) {
                titulo.setValor(row.getCells().get(4).asText());
            } else {
                titulo.setValor(row.getCells().get(3).asText());
            }

            if (row.getCells().get(0).asText().contains("Tesouro Prefixado")) {
                titulo.setIndexador("PRÉ");
            } else if (row.getCells().get(0).asText().contains("Tesouro IPCA")) {
                titulo.setIndexador("IPCA");
            } else if (row.getCells().get(0).asText().contains("Tesouro Selic")) {
                titulo.setIndexador("SELIC");
            } else if (row.getCells().get(0).asText().contains("Tesouro IGPM")) {
                titulo.setIndexador("IGPM");
            }

            log.trace(titulo.toString());
            repository.save(titulo);
        });
    }
}
