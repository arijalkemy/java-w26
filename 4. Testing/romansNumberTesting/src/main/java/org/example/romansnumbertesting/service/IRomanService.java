package org.example.romansnumbertesting.service;

import org.example.romansnumbertesting.dto.RomanDto;

public interface IRomanService {
    RomanDto encodeRomanNumber(Integer number);
}
