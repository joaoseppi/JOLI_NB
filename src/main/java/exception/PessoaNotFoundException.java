/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author JGSS
 */
public class PessoaNotFoundException extends RuntimeException {

    public PessoaNotFoundException(Long codigo) {
        super("Nao foi possivel encontrar pessoa " + codigo);
    }
    
}
