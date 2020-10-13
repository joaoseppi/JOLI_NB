/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import exception.PessoaNotFoundException;
import java.util.List;
import model.Funcionario;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FuncionarioController {
    private final FuncionarioRepository repo;
    
    FuncionarioController(FuncionarioRepository repo){
        this.repo = repo;
    }
    
    @GetMapping("/funcionario")
    List<Funcionario> all(){
        return repo.findAll();
    }
    
    @PostMapping("/funcionarios")
    Funcionario newFuncionario(@RequestBody Funcionario newFunc){
        return repo.save(newFunc);
    }
    
    @GetMapping("/funcionario/{codigo}")
    Funcionario one(@PathVariable long codigo){
        return repo.findById(codigo).orElseThrow(() -> new PessoaNotFoundException(codigo));
    }
    
    @DeleteMapping("/funcionario/{codigo}")
    void deleteFuncionario(@PathVariable Long codigo){
        repo.deleteById(codigo);
    }
    
}
