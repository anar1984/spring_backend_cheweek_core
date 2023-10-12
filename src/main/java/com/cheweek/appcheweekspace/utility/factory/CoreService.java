package com.cheweek.appcheweekspace.utility.factory;

import com.cheweek.appcheweekspace.utility.Carrier;
import org.springframework.stereotype.Service;

@Service
public interface CoreService {
    public Carrier run(Carrier carrier);
}
