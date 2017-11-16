package br.com.clubedoporquinho.crawler;

import br.com.clubedoporquinho.entity.TituloRendaFixa;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class CRI extends AbstractRendaFixaCroller {

    @Override
    public void process() {
        try {
            final ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://rendafixa-lightlemon.rhcloud.com/api/vx/get_investment/cri/", String.class);

            if (responseEntity.getStatusCode().value() != 200) {
                log.error("Erro ao executar consulta. {}", responseEntity.toString());
                return;
            }

            final JsonNode rootNode = objectMapper.readValue(responseEntity.getBody(), JsonNode.class);
            final Iterator<JsonNode> iterator = rootNode.get("resultados").iterator();
            while (iterator.hasNext()) {
                final JsonNode jsonNode = iterator.next();

                log.debug("Processando {} titulos {}", jsonNode.get("titulos").size(), jsonNode.get("tipo"));

                final Iterator<JsonNode> children = jsonNode.get("titulos").iterator();
                while (children.hasNext()) {
                    final JsonNode node = children.next();
                    final TituloRendaFixa titulo = new TituloRendaFixa();
                    titulo.setIndexador(jsonNode.get("tipo").textValue());
                    titulo.setCorretora(node.get("corretora").textValue());
                    titulo.setEmissor(node.get("emissor").textValue());
                    titulo.setTipo(node.get("tipo").textValue());
                    titulo.setTaxa(node.get("taxa").textValue());
                    titulo.setLiquidez(node.get("liquidez").textValue());
                    titulo.setAmortizacao(node.get("amortizacao").textValue());
                    titulo.setVendimento(node.get("vencimento").textValue());
                    titulo.setValor(node.get("preco").asText());
                    titulo.setNome(titulo.getTipo() + " - " + titulo.getEmissor());

                    log.trace(titulo.toString());
                    repository.save(titulo);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
