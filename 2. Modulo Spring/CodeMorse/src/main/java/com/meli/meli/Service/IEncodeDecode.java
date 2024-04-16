package com.meli.meli.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface IEncodeDecode {
    String encode(String message);
    String decode(String message);
}
