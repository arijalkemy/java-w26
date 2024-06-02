package com.mercadolibre.deportes_n;

import com.mercadolibre.deportes_n.repository.RepositorioDeporte;
import com.mercadolibre.deportes_n.repository.RepositorioDeportePersona;
import com.mercadolibre.deportes_n.repository.RepositorioPersona;
import com.mercadolibre.deportes_n.util.ScopeUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/** 
 * Main class for the App.
 */
@SpringBootApplication
public class Application {

  /** 
   * @param args command line arguments for the application.
   */
  public static void main(String[] args) {
    ScopeUtils.calculateScopeSuffix();
    
    RepositorioDeporte.getInstance().load();
    RepositorioPersona.getInstance().load();
    RepositorioDeportePersona.getInstance().load();
    
    new SpringApplicationBuilder(Application.class).registerShutdownHook(true).run(args);
  }

}
