package org.example.integradorcovid.service;

import java.util.List;

public interface ISymptomRisk <K> {

    public List<K> findRelated();
}
