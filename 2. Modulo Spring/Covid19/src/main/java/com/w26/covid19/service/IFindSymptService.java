package com.w26.covid19.service;

import com.w26.covid19.dto.FindAllSymptResult;
import com.w26.covid19.dto.FindSymptResult;

public interface IFindSymptService {

    FindAllSymptResult findAllSympt();
    FindSymptResult findByName(String name);
}
