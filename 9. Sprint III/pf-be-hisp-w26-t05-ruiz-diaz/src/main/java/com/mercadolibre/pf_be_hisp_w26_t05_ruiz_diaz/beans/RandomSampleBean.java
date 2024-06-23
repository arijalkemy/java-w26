package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.beans;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.SampleDTO;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Component;

/**
 * Sample Bean class.
 */
@Component
public class RandomSampleBean {

  /**
   * @return new instance of SampleDTO.
   */
  public SampleDTO random() {
    return new SampleDTO(ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE));
  }
}
