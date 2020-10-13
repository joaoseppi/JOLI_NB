/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import crud.DaoGenerico;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Pessoa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import util.JSONTranslator;

/**
 *
 * @author JGSS
 */
@RestController
public class Controller {
    
    @RequestMapping(value = "/pessoa", method = RequestMethod.GET)
    public ResponseEntity<List<Pessoa>> listPessoa(){
        Map<Long, Pessoa> entity = new HashMap<Long, Pessoa>();
        List<Pessoa> pessoa = new DaoGenerico().selectAllPessoa();
        
        for (int i = 0; i < pessoa.size(); i++) {
            entity.put(pessoa.get(i).getCodigo(), pessoa.get(i));
        }
        return new ResponseEntity<List<Pessoa>>(new ArrayList<Pessoa>(entity.values()), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/pessoa/{nome}", method = RequestMethod.GET)
    public ResponseEntity<List<Pessoa>> buscar(@PathVariable("nome") String nome){
        Map<Long, Pessoa> entity = new HashMap<Long, Pessoa>();
        List<Pessoa> pessoa = new DaoGenerico().selectPessoa(nome);
        
        for (int i = 0; i < pessoa.size(); i++) {
            entity.put(pessoa.get(i).getCodigo(), pessoa.get(i));
        }
        return new ResponseEntity<List<Pessoa>>(new ArrayList<Pessoa>(entity.values()), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/pessoa/{codigo}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> buscar(@PathVariable("codigo") Long codigo){
        Pessoa pessoa = new DaoGenerico().selectPessoa(codigo);
        
        return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletar(@PathVariable("codigo") Long codigo){
        Pessoa pessoa = new Pessoa();
        pessoa.setCodigo(codigo);
        if(new DaoGenerico().delete(pessoa)) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
