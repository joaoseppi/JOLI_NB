/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    
}
