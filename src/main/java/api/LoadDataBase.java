/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import api.FuncionarioRepository;
import java.util.Calendar;
import model.Funcionario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import util.Apoio;

class LoadDataBase {
    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

  @Bean
  CommandLineRunner initDatabase(FuncionarioRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Funcionario("cargo", Apoio.getDate(), "burglar")));
      log.info("Preloading " + repository.save(new Funcionario("teste", Apoio.getDate(), "thief")));
    };
  }
}
