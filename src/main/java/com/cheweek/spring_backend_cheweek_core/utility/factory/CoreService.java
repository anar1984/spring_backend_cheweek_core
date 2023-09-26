package com.cheweek.spring_backend_cheweek_core.utility.factory;


import com.cheweek.spring_backend_cheweek_core.utility.Carrier;
import org.springframework.stereotype.Service;

@Service
public interface CoreService {
    public Carrier run(Carrier carrier);
}
