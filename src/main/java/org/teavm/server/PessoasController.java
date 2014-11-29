/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.teavm.server;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import static br.com.caelum.vraptor.view.Results.json;
import java.util.ArrayList;
import java.util.List;
import org.teavm.domain.Pessoa;

/**
 *
 * @author alan
 */
@Resource
public class PessoasController {

    private final Result result;

    public PessoasController(Result result) {
        this.result = result;
    }

    @Get("/pessoas")
    public void pessoas() {
        Pessoa p1 = new Pessoa("alan", "alan@email.com");
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(p1);
        result.use(json()).withoutRoot().from(pessoas).serialize();
    }
}
